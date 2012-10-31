
import org.junit.Test
import junit.framework.Assert

class TestGambinator {
	
  @Test
  def testIfCooks():Unit = {
		val g:Gambinator = new Gambinator(List(new Association(List(new Target("Jose","Y"),new Target("Jeff","N")),new Question("Cozinha?"))))
		Assert.assertEquals("Cozinha?",g.ask)
		g.answer("Y")
		Assert.assertEquals("Jose",g.guess)
  }
  
  @Test
  def testNotCooks():Unit = {
       val g:Gambinator = new Gambinator(List(new Association(List(new Target("Jeff","N"),new Target("Jose","Y")), new Question("Cozinha?"))))
       g.answer("N")
       Assert.assertEquals("Jeff",g.guess)
  }
  
  @Test
  def testTwoCookers():Unit={
    val g:Gambinator = new Gambinator(List(new Association(List(new Target("Jeff","Y"), new Target("Jose","Y")),new Question("Cozinha?"))))
    g.answer("Y")
    Assert.assertEquals(4, g.guess().size)
  }
  
}