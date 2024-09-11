from dotenv import load_dotenv
from fastapi import FastAPI
from langchain_openai import OpenAIEmbeddings
from langchain.chat_models import ChatOpenAI
import uuid
from langchain_community.vectorstores import FAISS
from langchain_community.vectorstores.utils import DistanceStrategy
from langchain.docstore.document import Document
from typing import Annotated
from fastapi import Form
import os
import shutil
from langchain.memory import VectorStoreRetrieverMemory
from langchain.chains import ConversationChain

# 환경 변수 로드
load_dotenv()

# fastapi app 생성
app = FastAPI()

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# LLM 모델 로드
model = ChatOpenAI(
    model="gpt-4o-mini",
    temperature=0.3
)

@app.post("/init-conversation")
async def init_conversation():
    conversation_session_id = str(uuid.uuid4())

    vectorstore = FAISS.from_documents(
        [Document(page_content="대화를 시작합니다.")],
        embedding = embedding_model,
        distance_strategy = DistanceStrategy.COSINE
    )
    vectorstore.save_local('./db/' + conversation_session_id)

    return conversation_session_id

@app.delete("/remove_conversation")
async def remove_coversation(conversation_session_id: Annotated[str, Form()]):

    index_file_path= './db/' + conversation_session_id

    if os.path.exists(index_file_path):
        shutil.rmtree(index_file_path, ignore_errors=True) # rmtree: 강제적으로 다 삭제 
        print(f"index file {index_file_path} has been removed")
    else:
        print(f"index file {index_file_path} does not exist.")

    return "remove ok"

@app.post("/conversation")
async def conversation(conversation_session_id: Annotated[str, Form()], conversation_text: Annotated[str, Form()]):

    vectorstore = FAISS.load_local(
        "./db/" + conversation_session_id,
        embedding_model,
        allow_dangerous_deserialization=True
    )

    retriever = vectorstore.as_retriever(
        search_type="similarity",
        search_kwargs={"k": 5}
    )

    memory = VectorStoreRetrieverMemory(retriever=retriever)

    conversation_chain = ConversationChain(
        llm=model,
        memory=memory
    )

    conversation_response = conversation_chain.predict(input=conversation_text)

    vectorstore.add_documents(
        [
            Document(page_content="human:" + conversation_text +"\nAI:" + conversation_response)
        ]
    )

    vectorstore.save_local("./db/" + conversation_session_id)

    return conversation_response