//
// $  go get github.com/gorilla/mux
//
package main

import (
	"fmt"
	"net/http"
	"github.com/gorilla/mux"
)

func main() {
	userAges := map[string]int{
		"Diego":  32,
		"Dessa":  32,
		"Melina": 3,
	}

	r := mux.NewRouter()
	r.HandleFunc("/users/{name}", func(w http.ResponseWriter, r *http.Request) {
		vars := mux.Vars(r)
		name := vars["name"]
		age := userAges[name]
		fmt.Fprintf(w, "%s is %d years old!", name, age)
	}).Methods("GET")

	http.ListenAndServe(":8080", r)
}
