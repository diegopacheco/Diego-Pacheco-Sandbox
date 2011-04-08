import java.util.ArrayList;

/**
 * Scala functional code to return the max element of the list of int
 * 
 * @author Diego Pacheco
 *
 */
object funcsample {
  
  def main(args : Array[String]) : Unit = {	  
	  val values = List(1,5,100,40,400,44,50)
	  printf("MAX %d", findMax(values))	  
  }
  
  def findMax(temperatures : List[Int]) = {
	  temperatures.foldLeft(Integer.MIN_VALUE) { Math.max }
  }
  
}
