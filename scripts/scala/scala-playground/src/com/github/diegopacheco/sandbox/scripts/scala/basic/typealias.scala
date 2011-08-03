package com.github.diegopacheco.sandbox.scripts.scala.basic
import scala.reflect.BeanProperty

class typealias{
    type R = Double
    
    @BeanProperty var va: R = 1
    @BeanProperty var vb: R = 1

    def sum():R = {
        va + vb
    }
}

object Maintypealias {
    def main(args: Array[String]): Unit = {
        var c:typealias = new typealias()
        println(c.sum())
    }
}