import junit.framework.{Assert,TestCase}
import org.junit.Test

class TestFKeyboardClick {
	
	@Test def test_1_ABC():Unit = {
	  var t = new Teclado()
	  Assert.assertEquals("ABC",t.clicka(1))
	}
	
	@Test def test_2_DEF():Unit = {
	   var t = new Teclado()
	   Assert.assertEquals("DEF",t.clicka(2))
	}
	
	@Test def test_3_GHI():Unit = {
	  var t = new Teclado()
	  Assert.assertEquals("GHI", t.clicka(3))
	}
	
	@Test def test_4_JKL():Unit = {
	  var t = new Teclado()
	  Assert.assertEquals("JKL", t.clicka(4))
	}
	
}