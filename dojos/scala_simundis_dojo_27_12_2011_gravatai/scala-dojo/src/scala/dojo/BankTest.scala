package scala.dojo

import junit.framework.Assert._
import junit.framework.TestCase
import org.junit.Test
import scala.reflect.BeanProperty
import org.junit.Before

class BankAccountTest {
	
	@BeanProperty var bc:BanckAccount = null	
	
    @Before
    def setup{
	  bc = new BanckAccount(500)
    }
  
	@Test 
	def test_deposit_500_dollars() = {
	  bc.deposit(100)
	  assertEquals(600.0f,bc.balance)
	}
	
	@Test 
	def test_withdrawl_100_dollars() = {
	  val draw:Either[String,Float] = bc.withdrawl(500)
	  assertEquals(0.0f,bc.balance)
	}
	
	@Test
	def test_withdrwal_over_limit:Unit = {
		bc.withdrawl(900) match {
		  case Right(_) => fail
		  case _ => Unit
		}
	}
	
	@Test
	def test_transfer = {
	  val bc2:BanckAccount = new BanckAccount()
	   bc.transfer(bc2,200.0f)
	   assertEquals(200.0f,bc2.balance)
	   assertEquals(300.0f,bc.balance)
	}
}