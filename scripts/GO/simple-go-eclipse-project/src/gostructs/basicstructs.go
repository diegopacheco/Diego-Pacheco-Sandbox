package main

import "fmt"

type Vertex struct {
    X int
    Y int
}

func arrays_fun(){
	var a [2]string
	a[0] = "Hello"
	a[1] = "World"
	fmt.Println(a[0], a[1])
	fmt.Println(a)
}

func main() {
    
    fmt.Println(Vertex{1, 2})
    
    arrays_fun()
} 