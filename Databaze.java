import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Databaze {
    private ArrayList<Zaznam> zaznamy;

    public Databaze() {
        zaznamy = new ArrayList<>();


    }

    /**
     * Přidá nového pojištěného
     *
     * @param jmeno
     * @param prijmeni
     * @param vek
     * @param telefon
     */
    public void pridejZaznam(String jmeno, String prijmeni, String vek, String telefon) {
        Zaznam zaznam = new Zaznam(jmeno, prijmeni, vek, telefon);
        zaznamy.add(zaznam);
        System.out.print("Data byla uložena. ");


    }

    /**
     * Zobrazí všechny uložené záznamy
     *
     * @return
     */
    public ArrayList<Zaznam> getZaznamy() {
        return zaznamy;

    }

    /**
     * Vyhledá zaznamy podle jmena a prijmení
     *
     *
     * @return vysledek
     */


    // Metoda pro odstranění diakritiky
    private String odstranDiakritiku(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }

    public ArrayList<Zaznam> najdiZaznam(String jmeno, String prijmeni) {
        ArrayList<Zaznam> nalezeni = new ArrayList<>();
        String hledaneJmeno = odstranDiakritiku(jmeno.toLowerCase());
        String hledanePrijmeni = odstranDiakritiku(prijmeni.toLowerCase());

        for (Zaznam zaznam : zaznamy) {
            String zaznamJmeno = odstranDiakritiku(zaznam.getJmeno().toLowerCase());
            String zaznamPrijmeni = odstranDiakritiku(zaznam.getPrijmeni().toLowerCase());

            if (zaznamJmeno.equals(hledaneJmeno) && zaznamPrijmeni.equals(hledanePrijmeni)) {
                nalezeni.add(zaznam);
            }
        }
        return nalezeni;
    }
}






