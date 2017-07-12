package main

import(
  "fmt"
  "time"
  "github.com/nats-io/go-nats"
)

func main(){

  var timeout = time.Second * 2

  fmt.Println("Tryng to connect: " , nats.DefaultURL)
  nc, _ := nats.Connect(nats.DefaultURL)

  nc.Subscribe("foo", func(m *nats.Msg) {
    fmt.Printf("Received a message: %s\n", string(m.Data))
  })

  // Simple Publisher
  nc.Publish("foo", []byte("Hello World"))
  fmt.Println("Message sent")
  time.Sleep(timeout)

  nc.Close();

}
