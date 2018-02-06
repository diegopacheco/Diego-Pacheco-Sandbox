import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Utf8Main {
	public static void main(String[] args) {
		
		String key = "Diego";
		System.out.println("Encoding: " +  key.getBytes(StandardCharsets.UTF_8));
		
		String dec = StandardCharsets.UTF_8.decode( ByteBuffer.wrap( key.getBytes(StandardCharsets.UTF_8) )  ).toString();
    System.out.println("Decoding byte: " + dec);
		
	}
}
