package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println(time.Now().Format(time.Kitchen))
	fmt.Println(time.Now().Format("2006-01-02 15:04:05"))
	fmt.Println(time.Now().Format("15:04:05"))
	fmt.Println(time.Now().Unix())
}
