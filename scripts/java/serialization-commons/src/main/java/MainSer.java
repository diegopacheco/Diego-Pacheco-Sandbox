import org.apache.commons.lang3.SerializationUtils;

public class MainSer {
	
	public static void main(String[] args) {
		
		byte[] ser = SerializationUtils.serialize("Diego");
		System.out.println("Ser: " + ser);
		
		Object res  = SerializationUtils.deserialize( ser );
		System.out.println("Res: " + res);
	}
}
