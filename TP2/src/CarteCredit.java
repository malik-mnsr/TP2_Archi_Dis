public class CarteCredit {
    private String name;        // First name on the card
    private String lastname;    // Last name on the card
    private String info;        // Card information (e.g., card number)

    // Constructor
    public CarteCredit(String name, String lastname, String info) {
        this.name = name;
        this.lastname = lastname;
        this.info = info;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    // Method to display credit card information
    public void displayCardInfo() {
        System.out.println("Cardholder Name: " + name + " " + lastname);
        System.out.println("Card Info: " + info);
    }
}
