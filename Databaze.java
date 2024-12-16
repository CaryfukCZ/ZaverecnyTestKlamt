import java.util.ArrayList;

public class Databaze {
    private ArrayList<Zaznam> zaznamy;

    public Databaze() {
        zaznamy = new ArrayList<>();


    }

    /**
     * Přidá nového pojištěného
     * @param jmeno
     * @param prijmeni
     * @param vek
     * @param telefon
     */
    public void pridejZaznam(String jmeno, String prijmeni, String vek, String telefon) {
        zaznamy.add(new Zaznam(jmeno, prijmeni, vek, telefon));
        System.out.print("Data byla uložena. ");


    }

    /**
     * Zobrazí všechny uložené záznamy
     * @return
     */
    public ArrayList<Zaznam> getZaznamy() {
        return zaznamy;

    }

    /**
     * Vyhledá zaznamy podle jmena a prijmení
     * @param jmeno
     * @param prijmeni
     * @return vysledek
     */
    public ArrayList<Zaznam> najdiZaznam(String jmeno, String prijmeni) {
        ArrayList<Zaznam> nalezeni = new ArrayList<>();
        for (Zaznam zaznam : zaznamy) {
            if (zaznam.getJmeno().equals(jmeno) && zaznam.getPrijmeni().equals(prijmeni)) {
                nalezeni.add(zaznam);
            }
        }
        return nalezeni;
    }
}