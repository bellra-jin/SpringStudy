FROM python:3.12 as python-base

RUN mkdir gunicorn-test
WORKDIR /gunicorn-test
COPY . /gunicorn-test
RUN pip install gunicorn fastapi["all"]


CMD ["gunicorn", "-c", "gunicorn.config.py"]
EXPOSE 8000