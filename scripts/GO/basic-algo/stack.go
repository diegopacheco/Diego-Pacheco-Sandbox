package main

import "fmt"

type Stack struct {
   slice []int
}

func (s *Stack) Push(i int){
  s.slice = append(s.slice, i)
}

func (s *Stack) Peek() int{
  if (s.Size()==0) {
    return -1
  }
  return s.slice[len(s.slice)-1]
}

func (s *Stack) Pop() int {
  if (s.Size()==0){
    return -1
  }
  var result int = s.Peek()
  s.slice = s.slice[0:len(s.slice)-1]
  return result
}

func (s *Stack) Size() int {
  return len(s.slice)
}

func (s *Stack) String () string  {
  return fmt.Sprint(s.slice)
}

func main(){
  var s *Stack = new(Stack)
  s.Push(1)
  s.Push(2)
  s.Push(3)
  fmt.Println("Stack:",s)
  fmt.Println("Peek: ",s.Peek())
  fmt.Println("Stack:",s)
  fmt.Println("Pop:",s.Pop())
  fmt.Println("Stack:",s)
  fmt.Println("Pop:",s.Pop())
  fmt.Println("Pop:",s.Pop())
  fmt.Println("Pop:",s.Pop())
  fmt.Println("Peek:",s.Peek())
}
