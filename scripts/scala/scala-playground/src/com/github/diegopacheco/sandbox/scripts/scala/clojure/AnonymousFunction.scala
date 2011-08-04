package com.github.diegopacheco.sandbox.scripts.scala.clojure

object AnonymousFunctionMain {

    def main(args: Array[String]): Unit = {
        logCall(() =>
            Console.println("Chamada de metodo atual!"))
    }

    def logCall(callback: () => Unit): Unit = {
        Console.print("Log antes de chamar seu metodo... Invocado as : " + System.currentTimeMillis + "\n")
        callback()
    }

}
