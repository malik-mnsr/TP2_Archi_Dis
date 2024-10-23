public class Adresse {
    private String pays;
    private String ville;
    private String rue;
    private String lieuDit;
    private String positionGPS;
    private int numero;

    // Constructor
    public Adresse(String pays, String ville, String rue, String lieuDit, String positionGPS, int numero) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.lieuDit = lieuDit;
        this.positionGPS = positionGPS;
        this.numero = numero;
    }

    // Getters and Setters
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLieuDit() {
        return lieuDit;
    }

    public void setLieuDit(String lieuDit) {
        this.lieuDit = lieuDit;
    }

    public String getPositionGPS() {
        return positionGPS;
    }

    public void setPositionGPS(String positionGPS) {
        this.positionGPS = positionGPS;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Method to display address information
    public void displayAddress() {
        System.out.println("Country: " + pays);
        System.out.println("City: " + ville);
        System.out.println("Street: " + rue);
        System.out.println("Landmark: " + lieuDit);
        System.out.println("GPS: " + positionGPS);
        System.out.println("Number: " + numero);
    }
    @Override
    public String toString() {
        return numero + " " + rue + ", " + lieuDit + ", " + ville + ", " + pays + " (GPS: " + positionGPS + ")";
    }
}
