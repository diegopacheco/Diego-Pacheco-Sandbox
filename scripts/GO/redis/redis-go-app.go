package main

import (
	"fmt"

	"github.com/go-redis/redis"
)

func main() {

	client := redis.NewClient(&redis.Options{Addr: "localhost:6379"})

	client.Set("key", "value1", 0)

	val, err := client.Get("key").Result()
	if err != nil {
		panic(err)
	}
	fmt.Println("key", val)

}
