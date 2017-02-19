package main

import (
	"fmt"
	"reflect"
)

type Hoge struct {
	foo int
	bar string
}

type Piyo struct {
	piyopiyo int
}

// Set value of Hoge or Piyo to v.
// v is pointer of Hoge or Piyo and using as output parameter.
func Set(v interface{}) {

	// v must be pointer
	rvp := reflect.ValueOf(v)
	if rvp.Kind() != reflect.Ptr {
		panic("v must be pointer")
	}

	rv := reflect.Indirect(rvp)
	i := rv.Interface()
	switch i.(type) {
	case Hoge:
		hoge := Hoge{100, "bar"}
		rv.Set(reflect.ValueOf(hoge))
	case Piyo:
		piyo := Piyo{200}
		rv.Set(reflect.ValueOf(piyo))
	default:
		panic("v must be pointer of Hoge or Piyo.")
	}
}

func main() {

	var hoge Hoge
	Set(&hoge)
	fmt.Println(hoge)

	var piyo Piyo
	Set(&piyo)
	fmt.Println(piyo)
}
