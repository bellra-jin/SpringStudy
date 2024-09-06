from dotenv import load_dotenv
from langchain_community.document_loaders import PyPDFLoader
from langchain_openai import OpenAIEmbeddings
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import FAISS
from langchain_community.vectorstores.utils import DistanceStrategy

# 랭스미스 연결
load_dotenv(dotenv_path="../99_env/.env")

# PDF 로더 설정 및 초기화
loader = PyPDFLoader("./Labor.pdf")

# 문서 읽기
documents = loader.load()

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# 문서 분할
text_splitter = RecursiveCharacterTextSplitter(chunk_size=100, chunk_overlap=10)
texts = text_splitter.split_documents(documents)

for text in texts :
    print(text)

vectorstore = FAISS.from_documents(
    texts,
    embedding=embedding_model,
    distance_strategy=DistanceStrategy.COSINE
)

vectorstore.save_local('./db/faiss')