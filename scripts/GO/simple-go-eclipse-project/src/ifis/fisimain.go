package main

import "fmt"
import "math"

func sqrt(x float64) string {
	if x < 0 {
		return sqrt(-x) + "i"
	}
	return fmt.Sprint(math.Sqrt(x))
}

func main() {
	
	// calling a fucntion with ifs
	fmt.Println(sqrt(2), sqrt(-4))
	
	/*
	* Defer
	* 
		A defer statement defers the execution of a function until the surrounding function returns.
		The deferred call's arguments are evaluated immediately, but the function call is not 
		executed until the surrounding function returns.
	*
	*/
	defer fmt.Println("diego 1")
	fmt.Println("diego 2")
	
}