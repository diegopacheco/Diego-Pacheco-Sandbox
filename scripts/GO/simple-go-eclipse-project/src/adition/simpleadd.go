package main

import "fmt"

var c, python, java bool

func add(x int, y int) int {
	return x + y
}

func main() {
	
	// Calls the function on line 5
	fmt.Println(add(42, 13))
	
	// Test go cool stuff to return multiple things
	a, b := swap("hello", "world")
	fmt.Println(a, b)
	
	// Print vars
	var i int
	fmt.Println(i, c, python, java)
	
}
