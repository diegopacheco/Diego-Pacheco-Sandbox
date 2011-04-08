/**
 * Scala Bean with Scala Syntax Suggar
 *
 * @author Diego Pacheco
 *
 */
object bean1 {

  private var name: String = null
  private var steps: List[String] = null
  private var args: Map[Int, String] = null

  def getArgs() = args

  def setArgs(args: Map[Int, String]) {
    this.args = args
  }

  def getSteps() = steps

  def setSteps(steps: List[String]): Unit = {
    this.steps = steps
  }
  
  def getName() = name
  
  def setName(name:String){
	  this.name = name
  }
    
  override def toString() : String = {
	  "Name: " + getName() + ", Args: " + getArgs() + ",Steps: " + getSteps()
  }

  def main(args : Array[String]) : Unit = {	  
       var b = bean1;
       b.name = "Diego Pacheco"
       b.steps = List("Passo 1", "Passo 2", "Passo 3")
       
       var margs = Map(1 -> "Diego", 2 -> "Scala", 3 -> "Functional", 4 -> "Rocks")
       b.setArgs( margs )       
       
       printf("Object result: %s",b)
  }
}
