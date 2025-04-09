import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class VstupUzivatele {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in);

    public VstupUzivatele() {
        databaze = new Databaze();
    }

    private String nactiVstup(String zprava) {
        System.out.println(zprava);
        return scanner.nextLine().trim();
    }

    /**
     * přidání nového uživatele
     */


    public void pridejPojistence() {
        String jmeno = nactiValidovaneJmeno("Zadejte jméno:");
        String prijmeni = nactiValidovaneJmeno("Zadejte příjmení:");
        String telefon = nactiValidovanyTelefon();
        int vek = nactiValidovanyVek();

        databaze.pridejZaznam(jmeno, prijmeni, telefon, String.valueOf(vek));
    }

    /**
     * vypsání vsech ulozenych zaznamu
     */
    public void vypisPojistene() {
        ArrayList<Zaznam> zaznamy = databaze.getZaznamy();
        for (Zaznam zaznam : zaznamy) {
            System.out.println(zaznam);
        }
    }

    /**
     * vyhledání záznamu podle jmena a prijmení
     */
    public void najdiPojistence() {
        String jmeno = nactiValidovaneJmeno("Zadejte jméno:");
        String prijmeni = nactiValidovaneJmeno("Zadejte příjmení:");

        ArrayList<Zaznam> nalezeni = databaze.najdiZaznam(jmeno, prijmeni);

        if (nalezeni.isEmpty()) {
            System.out.println("Pojištěnec nebyl nalezen.");
        } else {
            for (Zaznam zaznam : nalezeni) {
                System.out.println(zaznam);
            }
        }
    }

    /**
     * Metoda  pro načtění a validaci vstupu
     */

    private String nactiValidovaneJmeno(String zprava) {
        String vstup;
        do {
            System.out.println(zprava);
            vstup = scanner.nextLine().trim(); //Odtsraní mezery a převede na malá písmena


            if (vstup.isEmpty()) {
                System.out.println("Toto pole nesmí bytut prázdné!");
            }
        } while (vstup.isEmpty());
        return vstup;
    }

    /**
     * Metoda pro odstranění diakritiky
     *
     * @param text
     * @return
     */

    private String odstranDiakritiku(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    private String nactiValidovanyTelefon() {
        String telefon;
        do {
            telefon = nactiVstup("Zadejte telefon (9 číslic):");
            if (!telefon.matches("\\d{9}")) {
                System.out.println("Telefon musí obsahovat přesně 9 číslic!");
            }
        } while (!telefon.matches("\\d{9}"));
        return telefon;
    }

    private int nactiValidovanyVek() {
        int vek = -1;
        do {
            String vstup = nactiVstup("Zadejte věk (0–120):");
            try {
                vek = Integer.parseInt(vstup);
                if (vek < 0 || vek > 120) {
                    System.out.println("Věk musí být mezi 0 a 120!");
                    vek = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadejte platné číslo!");
            }
        } while (vek == -1);
        return vek;
    }


    /**
     * ukončí program
     */
    public void konecProgramu() {
        System.out.println("Konec programu");
        System.exit(0);
    }

    /**
     * uvodní uvítání
     */
    public void vypisUvod() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("Evidence pojistených");
        System.out.println("---------------------------");
    }

    /**
     * menu ovladání
     */
    public void vypisMenu() {
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat pojisteneho");
        System.out.println("2 - Vypsat vsechny pojistene");
        System.out.println("3 - Vyhledat pojisteneho");
        System.out.println("4 - Konec");
    }
}