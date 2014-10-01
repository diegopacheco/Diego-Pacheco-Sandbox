package com.github.diegopacheco.sandbox.scala.typesystem

object Race extends App {
    
    sealed trait Gender
    case class Male() extends Gender
    case class Female() extends Gender
    
    class Person(name:String)
    trait Professional
    case class Developer(sex:Gender,name:String) extends Person(name) with Professional
    
    type sexo = Gender
    type developers = List[Developer]
    
    val sexo = Male()
    println(sexo)
    
    val devs = List(Developer(Male(),"Diego"), Developer(Male(),"Ordesky"), Developer(Female(),"Marie") )
    
    devs.foreach( _ match {  
          case Developer(sex:Male,_)    => println(" its a guy!")
          case Developer(sex:Female,_)  => println(" its a girl!")
          case _                        => println(" ??? ")
        } 
    ) 
    
    
}