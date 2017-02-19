package main

import (
	"fmt"
	"time"
)

func main() {
	c := make(chan bool, 1)

	go func() {
		select {
		case m := <-c:
			// do something
			handle(m)
		case <-time.After(2 * time.Second):
			fmt.Println("timed out")
		}
	}()

	time.Sleep(3 * time.Second)
}

func handle(m bool) {}
