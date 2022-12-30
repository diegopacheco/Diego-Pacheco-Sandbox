public class Main {
    public static void main(String args[]) {
        validate("VOLLEYBALL_12354");
        validate("FOOTBALL_12354");
        validate("FAKE_12354");
    }

    private static void validate(String ticketID) {
        if (null == ticketID || (!ticketID.startsWith("FOOTBALL_") && !ticketID.startsWith("VOLLEYBALL_"))) {
            throw new IllegalStateException("Ticket [" + ticketID + "] its invalid.");
        }
        //... More validations such as ID exist on DB or cache...
    }

}
