import org.junit._
import org.junit.Assert._

class BowlingTest {
  	
  var bowling:Bowling = null
  
  @Before def init = bowling = new Bowling()  
  
  @Test def throwBallTest  = assertTrue( 
                bowling.throwBall().a >= 0 && 
                bowling.throwBall().a <=10
        )
  
  @Test def throwSecondBall = {
    val result:Result = bowling.throwBall()
    assertTrue(result.a < 10)
    assertTrue(result.b > 0)
  } 
  
}
