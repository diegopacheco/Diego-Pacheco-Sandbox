package main

import (
	"fmt"
	"reflect"
)

type mytype struct {
	field1 int `tag1:"tag1!!" tag2:"-" tag3:'a'`
	field2 int `tag1:"" tag2:200 tag3:"hoge"`
}

func main() {
	v := reflect.ValueOf(mytype{100, 200})
	t := v.Type()
	tags := []string{"tag1", "tag2", "tag3"}
	for i := 0; i < t.NumField(); i++ {
		sf := t.Field(i)
		fmt.Println(sf.Name)
		for _, tagName := range tags {
			fmt.Println(tagName, ":", sf.Tag.Get(tagName))
		}
	}
}
