import org.junit.Test
import org.junit.Assert._

class UrlParserTest {
  
  @Test def testProtocolHttp():Unit = assertEquals("http", new UrlParser("http://google.com").getProtocol())
  
  @Test def testHostGoogle():Unit = assertEquals("google.com", new UrlParser("http://google.com").getHost())
  
  @Test def testProtocolSsh():Unit = assertEquals("ssh", new UrlParser("ssh://rafael@opoletto").getProtocol())
  
  @Test def testHostRedTube():Unit = assertEquals("redtube.com", new UrlParser("http://redtube.com").getHost())
  
  @Test def testHostSsh():Unit = assertEquals("redtube.com", new UrlParser("ssh://rafael@redtube.com").getHost())
  
  @Test def testPort():Unit = assertEquals("80", new UrlParser("http://google.com").getPort())
  
  @Test def testPortSsh():Unit = assertEquals("22", new UrlParser("ssh://rafael@opoletto:22").getPort())
  
  @Test def testHostSshJeffyViado():Unit = assertEquals("redtube.com", new UrlParser("ssh://jeffy@redtube.com").getHost())
  
}