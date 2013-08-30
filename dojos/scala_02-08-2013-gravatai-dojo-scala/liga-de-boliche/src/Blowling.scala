import scala.reflect._ 

class Bowling {

  var rounds = 10
  
  def throwBall(pin:Int = 10):Result =  {
    var a:Int = RandomNiggas.randomBaby(10)
    Result( a,RandomNiggas.randomBaby(a) )
  }
  

  
}

object RandomNiggas{
  
  def randomBaby(number:Int):Int = (Math.random() * number).asInstanceOf[Int]
}

case class Result(@BeanProperty var a:Int = 0,@BeanProperty var b:Int = 0) {}