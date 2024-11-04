public class Zaznam {

    private String jmeno;
    private String prijmeni;
    private String vek;
    private String telefon;

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public Zaznam(String jmeno, String prijmeni, String vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }
    @Override
    public String toString() {
        return " " + jmeno + " " + prijmeni + " " + vek + " " + telefon;
    }
}
