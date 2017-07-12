package main

import (
	"fmt"
	"net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, "Awesome Go HTTP!")
}

func main() {
	fmt.Print("Serving at http://0.0.0.0:3000")
	http.HandleFunc("/", handler)
	http.ListenAndServe(":3000", nil)
}
