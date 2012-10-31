case class Gambinator(associations:List[Association]) {

  private [Gambinator] var answer:String = "y"
  
  
  def ask():String = associations(0).question.question
  def guess():String = associations(0).target.filter(_.cooker == answer)(0).name
  def answer(answer:String = "y"):Unit = this.answer = answer
  
}

case class Question(question:String)
case class Target(name:String,cooker:String)

case class Association(target:List[Target], question:Question)
