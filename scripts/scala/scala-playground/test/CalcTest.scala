import org.junit.Test
import junit.framework.Assert

class CalcTest {
	
	@Test
	def testSum1Plus1() = {
		val calc   = new Calc()
		val result = calc.sum(1, 1)
		Assert.assertEquals("1 + 1 deveria ser 2, erro na soma",2, result)		
	}
	
	@Test
	def testSum1minus1() = {
		val calc   = new Calc()
		val result = calc.sub(1, 1)
		Assert.assertEquals("1 - 1 deveria ser 0, erro na soma",0, result)		
	}
	
}
