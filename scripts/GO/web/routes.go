package main

import (
	"fmt"
	"net/http"
)

func main() {
	userAges := map[string]int{
		"Diego":  32,
		"Dessa":  32,
		"Melina": 3,
	}

	http.HandleFunc("/profile/", func(w http.ResponseWriter, r *http.Request) {
		name := r.URL.Path[len("/profile/"):]
		age := userAges[name]
		fmt.Fprintf(w, "Profile user %s is %d years old!", name, age)
	})

  http.HandleFunc("/profile/all", func(w http.ResponseWriter, r *http.Request) {
    for key, value := range userAges {
      fmt.Fprintf(w, "Profile: %s Age: %d \n", key,value)
    }
	})

	http.ListenAndServe(":8080", nil)
}
