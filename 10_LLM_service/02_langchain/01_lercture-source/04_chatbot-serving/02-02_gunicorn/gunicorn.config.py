import multiprocessing

workers = multiprocessing.cpu_count() * 2 + 1
print(workers)
worker_class="uvicorn.workers.UvicornWorker"
wsgi_app="main:app"
loglevel="info"
bind="0.0.0.0:8000"
max_requests=1
keepalive=0
