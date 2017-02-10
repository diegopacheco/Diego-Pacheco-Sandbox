package main

import "net/http"

func main() {
	fileServer := http.FileServer(http.Dir("assets/"))
	http.Handle("/static/", http.StripPrefix("/static/", fileServer))
	http.ListenAndServe(":8080", nil)
}
