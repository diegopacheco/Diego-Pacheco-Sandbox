package com.diegopacheco.github.sandbox.scala.activator

import net.fwbrasil.activate.ActivateContext
import net.fwbrasil.activate.storage.StorageFactory 

object persistenceContext extends ActivateContext {
  val storage = StorageFactory.fromSystemProperties("myStorage")
}

import persistenceContext._

class Person(var name: String) extends Entity

class CreatePersonTableMigration extends Migration {
  def timestamp = 201211161
  def up = {
    table[Person]
      .createTable(
        _.column[String]("name"))
  }
}

object simpleMain extends App {

  transactional {
    new Person("John")
  }

  val john = transactional {
    select[Person].where(_.name :== "John").head
  }

  transactional {
    john.name = "John Doe"
  }

  transactional {
    all[Person].foreach(_.delete)
  }
}