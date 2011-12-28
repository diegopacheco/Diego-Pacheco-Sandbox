package scala.dojo

object Loop{   
   def doTimes(n:Int)(f: => Unit):Unit = for(i <- 1 to n){ f }  
   
   def main(args: Array[String]) {
       doTimes(2){
          println("Hey!")
       }
   }
   
}

case class BanckAccount(var balance:Float = 0){
  def deposit(amount:Float)         = balance += amount
  def withdrawl(amount:Float):Either[String, Float] = {
	  (balance - amount) match {
	     case i:Float if i >= 0 => {
	    	applyWithdrawl(amount)
	        Right(amount) 
	     }
	     case i:Float if i < 0  => Left("fudeu")
	  }
  }
  
  private[BanckAccount] def applyWithdrawl(amount:Float){
      balance -= amount	
  }
  
  def transfer(otherAccount:BanckAccount, amount:Float) = {
	  applyWithdrawl(amount)
	  otherAccount.deposit(amount)
  }
}
