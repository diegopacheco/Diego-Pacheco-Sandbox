import java.util.Optional;

public class Main {
    public static void main(String args[]) {
        validate(Optional.of("VOLLEYBALL_12354"));
        validate(Optional.of("FOOTBALL_12354"));
        validate(Optional.of("FAKE_12354"));
    }

    private static void validate(Optional<String> ticketID) {
        if (null == ticketID || !ticketID.get().startsWith("FOOTBALL_")) {
            throw new IllegalStateException("Ticket [" + ticketID + "] its invalid.");
        }
        //... More validations such as ID exist on DB or cache...
    }

}
