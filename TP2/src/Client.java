public class Client {
    private String name;
    private int phone;
    private String email;
    private CarteCredit creditCard; // Association with CreditCard class

    // Constructor
    public Client(String name, int phone, String email, CarteCredit creditCard) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creditCard = creditCard;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarteCredit getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CarteCredit creditCard) {
        this.creditCard = creditCard;
    }

    // Method to display client information
    public void displayClientInfo() {
        System.out.println("Client Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Credit Card Information: ");
        creditCard.displayCardInfo(); // Display associated credit card details
    }

}
