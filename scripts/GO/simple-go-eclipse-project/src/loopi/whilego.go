package main

import "fmt"

func whilego(){
	sum := 1
	for sum < 1000 {
		sum += sum
	}
	fmt.Println(sum)
}