import java.util.Optional;

public class Main{
  public static void main(String args[]){
   validate(Optional.empty());
  }

  private static void validate(Optional<String> ticketID){
    if (!ticketID.get().startsWith("FOOTBALL_")){
      throw new IllegalStateException("Ticket its invalid.");
    }
  }

}
