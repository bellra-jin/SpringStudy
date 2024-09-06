from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough

# 랭스미스 연결
load_dotenv(dotenv_path="../99_env/.env")

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# Local FAISS 로드
vectorstore = FAISS.load_local(
    "./db/faiss",
    embedding_model,
    allow_dangerous_deserialization=True
)

# retriever 생성
retriever = vectorstore.as_retriever(
    search_type="similarity",
    search_kwargs={"k":5}
)

# prompt 생성
message = """
Answer this question using the provided context only.

{question}

Context:
{context}
"""

# 프롬프트 템플릿 생성
prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "당신은 근로기준법에 대해 아주 많이 알고 있습니다. 친절하게 대답해줍니다."),
        ("human", message)
    ]
)

# LLM 모델 로드
model = ChatOllama(
    model = "gemma2:latest",
    temperature=0.3
)

# RAG chain 생성
chain = {"context": retriever, "question" : RunnablePassthrough()} | prompt | model

# print(chain.invoke("근로기준법이란 뭐야?"))

from fastapi import FastAPI, Form
from typing import Annotated

app = FastAPI()

@app.post("/Labor", tags=["근로기준법"])
async def Labor(question: Annotated[str, Form()]):
    return {"answer": chain.invoke(question).content}