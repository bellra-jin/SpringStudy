from langchain.chat_models import ChatOpenAI
from langchain.chains import ConversationChain
from langchain.memory import ConversationBufferMemory
from fastapi import FastAPI
from typing import Annotated
from fastapi import Form

from dotenv import load_dotenv
load_dotenv()

# LLM 로드
model = ChatOpenAI(
    model="gpt-4o-mini",
    temperature=0.3
)

memory = ConversationBufferMemory()
memory.save_context(
    inputs={
        "system": "넌 IT 분야의 최고 직업 상담사야. 진로를 고민하는 취업준비생들에게 현실적이지만 용기를 줄 수 있는 말투로 상담을 해줘, 단 모든 응답은 한국어로 답변해줘"
    },
    outputs={
        "ai": "이해했습니다."
    }
)

# ConversationChain 생성
conversation_chain = ConversationChain(
    llm=model,
    memory=memory
)

app = FastAPI()

@app.post("/chatbot")
async def chatbot(question: Annotated[str, Form]):
    return conversation_chain.predict(input=question)