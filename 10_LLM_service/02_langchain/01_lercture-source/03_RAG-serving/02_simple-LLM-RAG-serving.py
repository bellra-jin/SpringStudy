from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain.chat_models import ChatOllama
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
    search_kwars={"k":5}
)

# print(retriever.batch({"빵"}))

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
        ("system", "당신은 어린 아이에게 아주 친절한 유치원 선생님 입니다. 질문하는 아이의 동심이 파괴되지 않게 잘 답변을 해주세요."),
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

print(chain.invoke("백설공주의 이름이 왜 백설공주야?"))