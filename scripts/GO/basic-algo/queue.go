package main

import "fmt"

type Queue struct {
  slice []int
}

func (q *Queue) Enqueue(i int){
   q.slice = append(q.slice, i)
}

func (q *Queue) Dequeue() int {
   if (q.Size() == 0 ){
     return -1
   }
   result := q.slice[0]
   q.slice = q.slice[1:q.Size()]
   return result
}

func (q *Queue) Size() int {
  return len(q.slice)
}

func (q *Queue) String() string {
  return fmt.Sprint(q.slice)
}

func main(){
    var q *Queue = new(Queue)
    q.Enqueue(1)
    q.Enqueue(2)
    q.Enqueue(3)
    fmt.Println("Queue:",q)

    fmt.Println("Dequeue:", q.Dequeue())
    fmt.Println("Dequeue:", q.Dequeue())
    fmt.Println("Dequeue:", q.Dequeue())
    fmt.Println("Dequeue:", q.Dequeue())
}
