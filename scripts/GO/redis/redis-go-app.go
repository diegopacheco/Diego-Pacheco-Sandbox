package main

import (
	"fmt"
	"net/http"

	"github.com/go-redis/redis"
)

func handle(w http.ResponseWriter, r *http.Request) {
	client := redis.NewClient(&redis.Options{Addr: "localhost:6379"})
	client.Incr("kcount")

	val, err := client.Get("kcount").Result()
	if err != nil {
		panic(err)
	}

	fmt.Fprintf(w, string("key count: "+string(val)))
}

func main() {
	fmt.Print("Serving at localhost:9090... ")
	http.HandleFunc("/", handle)
	http.ListenAndServe(":9090", nil)
}
