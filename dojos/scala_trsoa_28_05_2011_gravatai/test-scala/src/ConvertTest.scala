import junit.framework.{Assert,TestCase}
import org.junit.Test

class AppTestTest {
	
	@Test def test_1_to_I     = Assert.assertEquals("I",Converter.toRoman(1))
	@Test def test_2_to_II    = Assert.assertEquals("II",Converter.toRoman(2))
	@Test def test_3_to_III   = Assert.assertEquals("III" , Converter.toRoman(3))
	@Test def test_4_to_IV    = Assert.assertEquals("IV", Converter.toRoman(4))
	@Test def test_5_to_V     = Assert.assertEquals("V", Converter.toRoman(5))
	@Test def test_6_to_VI    = Assert.assertEquals("VI", Converter.toRoman(6))
	@Test def test_7_to_VII   = Assert.assertEquals("VII", Converter.toRoman(7))
	@Test def test_8_to_VIII  = Assert.assertEquals("VIII", Converter.toRoman(8))
	@Test def test_9_to_IX    = Assert.assertEquals("IX", Converter.toRoman(9))
	@Test def test_10_to_X    = Assert.assertEquals("X", Converter.toRoman(10))
	@Test def test_11_to_XI   = Assert.assertEquals("XI", Converter.toRoman(11))
	@Test def test_20_to_XX	  = Assert.assertEquals("XX", Converter.toRoman(20))
	@Test def test_30_to_XXX  = Assert.assertEquals("XXX", Converter.toRoman(30))
	@Test def test_31_to_XXXI = Assert.assertEquals("XXXI", Converter.toRoman(31))
    
}