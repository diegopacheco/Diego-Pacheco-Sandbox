FROM golang:1.8
RUN mkdir /app
WORKDIR /app
COPY . /app/
RUN go get github.com/go-redis/redis
CMD ["go","run","redis-go-app.go"]

#
# To Run:
# docker-compose up
#
