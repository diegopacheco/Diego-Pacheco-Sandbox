package main

import (
	"fmt"
	"time"
)

func main() {
	// You can use Format argument of http://golang.org/pkg/time/#pkg-constants :
	fmt.Println(time.Now().Format(time.Kitchen))

	// also, you can input directly as string :
	fmt.Println(time.Now().Format("2006-01-02 15:04:05"))
	fmt.Println(time.Now().Format("15:04:05"))
	
	// Timestamp
	fmt.Println(time.Now().Unix()) // Ex: 1257894000
}
