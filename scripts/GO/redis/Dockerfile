FROM golang:1.8

RUN mkdir /app

WORKDIR /app

COPY . /app/

RUN go get github.com/go-redis/redis

CMD ["go","run","redis-go-app.go"]

#
# To build:
# docker build -t go/goredis .
# To Run:
# docker run --publish 39090:9090 --name goredis --rm go/goredis
#
