package main

import (
	"fmt"
)

func foo(i *int) {
	fmt.Println(*i)
}

func test() (err error) {
	defer func() {
		if recover() != nil {
			fmt.Println("exception occured")
		}
	}()

	for i := 0; i <= 10; i++ {
		foo(&i)
	}
	foo(nil) // Should be panic
	return

}

func main() {
	test()
}
