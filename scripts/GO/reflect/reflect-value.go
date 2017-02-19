package main

import (
	"fmt"
	"reflect"
)

func printAny(arg interface{}) {
	printValue(reflect.ValueOf(arg))
	fmt.Print("\n")
}

func printValue(v reflect.Value) {
	switch v.Kind() {
	case reflect.Int, reflect.Int8, reflect.Int16, reflect.Int32, reflect.Int64:
		fmt.Printf("int %v", v.Int())
		
	case reflect.Uint, reflect.Uint8, reflect.Uint16, reflect.Uint32, reflect.Uint64, reflect.Uintptr:
		fmt.Printf("uint %v", v.Uint())
		
	case reflect.Float32, reflect.Float64:
		fmt.Printf("float %v", v.Float())
		
	case reflect.String:
		fmt.Printf("string %v", v.String())
		
	case reflect.Bool:
		fmt.Printf("bool %v", v.Bool())
		
	case reflect.Map:
		fmt.Print("map{")
		for i, key := range v.MapKeys() {
			if i > 0 {
				fmt.Print(", ")
			}
			printValue(key)
			fmt.Print(" : ")
			printValue(v.MapIndex(key))
		}
		fmt.Print("}")
		
	case reflect.Interface, reflect.Ptr:
		fmt.Print("pointer ")
		printValue(v.Elem())
	}
}

func main() {
	var i int = 123
	printAny(i)
	
	var u uint = 456
	printAny(u)
	
	var f float32 = 789.123
	printAny(f)
	
	printAny("hello")
	
	printAny(true)
	
	printAny(map[int]string{3: "foo", 7: "bar"})
	
	printAny(&i) // pointer
}
