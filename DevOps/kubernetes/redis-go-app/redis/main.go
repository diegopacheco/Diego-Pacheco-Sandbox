package main

import (
	"fmt"
	"net/http"
	"os"

	"github.com/go-redis/redis"
)

func handle(w http.ResponseWriter, r *http.Request) {
	if "/favicon.ico" == r.URL.Path {
		return
	}
	fmt.Print("request: " + r.URL.Path + " ")

	client := redis.NewClient(&redis.Options{Addr: os.Getenv("REDIS_URL")})
	client.Incr("kcount")

	val, err := client.Get("kcount").Result()
	if err != nil {
		panic(err)
	}
	result := string("key count: " + string(val))

	fmt.Print(result + "\n\r")
	fmt.Fprintf(w, result)
}

func main() {
	fmt.Print("Serving at 0.0.0.0:9090... ")
	http.HandleFunc("/", handle)
	http.ListenAndServe("0.0.0.0:9090", nil)
}
