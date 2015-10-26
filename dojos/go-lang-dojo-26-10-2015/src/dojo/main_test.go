package main

import "testing"

func TestMain(t *testing.T) {
	Assert(t, 100, 0)
}


func TestMain50(t *testing.T){
	Assert(t, 50, 0)
}

func TestMain20(t *testing.T){
	Assert(t, 20, 0)
}

func TestMain10(t *testing.T){
	Assert(t, 10, 0)
}

func TestMainWrong27(t *testing.T){
	Assert(t, 27, 1)
}

func TestMain200(t *testing.T) {
	Assert(t, 200, 0)
}

func TestMain150(t *testing.T) {
	Assert(t, 150, 0)
}

func TestMain40(t *testing.T) {
	Assert(t, 40, 0)
}

func TestMain30(t *testing.T){
	Assert(t,30,0)
}



func Assert(t *testing.T, valor int, expected int) {
	if !(saque(valor) == expected) {
		t.Errorf("Wrong!!")
	}	
}


