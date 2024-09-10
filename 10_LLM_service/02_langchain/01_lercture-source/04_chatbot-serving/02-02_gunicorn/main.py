from fastapi import FastAPI
import time


app = FastAPI()

@app.get("/test")
async def test():

    time.sleep(5)
    print("hello?")

    return "helloworld!"