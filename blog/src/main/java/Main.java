import java.util.Optional;

public class Main{
  public static void main(String args[]){
   validate("VOLLETBALL_12354");
  }

  private static void validate(String ticketID){
    if (null != ticketID && ticketID.startsWith("FOOTBALL_")){
      throw new IllegalStateException("Ticket its invalid.");
    }
    if (null != ticketID && ticketID.startsWith("VOLLEYBALL_")){
      throw new IllegalStateException("Ticket its invalid.");
    }
  }

}
