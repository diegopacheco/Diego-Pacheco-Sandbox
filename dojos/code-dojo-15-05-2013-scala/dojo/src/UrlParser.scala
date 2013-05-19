class UrlParser (val url:String) {

  def getProtocol():String =  if(url.contains("ssh")) "ssh" else "http"
  
  def getHost():String = url.replace(getProtocol() + "://", "").replaceAll(".*@", "")
  
  def getPort():String = if (getProtocol().equals("http")) "80" else "22"
  
}