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

    private String formatujJmeno(String jmeno) {
        if (jmeno.isEmpty()) return "";

        return jmeno.substring(0, 1).toUpperCase() + jmeno.substring(1).toLowerCase();
    }

    private String nactiJmeno(String typ) {
        while (true) {
            String jmeno = nactiVstup("Zadejte " + typ + ":");
            if (jmeno.matches("[A-Za-zÁ-ž]+")) {
                return formatujJmeno(jmeno);
            }
            System.out.println("Neplatné " + typ + "Použíjte pouze písmena.");
        }
    }

    /**
     * Validace vstupu Telefonní číslo
     */
    private String nactiTelefon() {
        String telefon;
        while (true) {

            telefon = nactiVstup("Zadejte telefonní číslo:");
            if (telefon.matches("\\d{9}")) {
                return telefon;
            }
            System.out.println("Neplatné číslo! Zadejte 9 čísloc.");

        }
    }

    /**
     * Validace vstupu Věk
     */

    private int nactiVek() {
        while (true) {
            String vstup = nactiVstup("Zadejte vek:");
            try {
                int vek = Integer.parseInt(vstup);
                if (vek > 0 && vek < 100) {
                    return vek;
                }
                System.out.println("Neplatný věk! Zadejte číslo mezi 1 a 99.");
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup! Zadejte číslo.");
            }
        }
    }

    /**
     * přidání nového uživatele
     */


    public void pridejPojistence() {
        String jmeno = nactiVstup("Zadejte jmeno:");
        String prijmeni = nactiVstup("Zadejte prijmeni:");
        String vek = nactiVstup("Zadejte vek:");
        String telefon = nactiVstup("Zadejte telefon:");
        databaze.pridejZaznam(jmeno, prijmeni, vek, telefon);
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
        System.out.println("Zadejte jmeno:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte prijmeni:");
        String prijmeni = scanner.nextLine();
        ArrayList<Zaznam> nalezeni = databaze.najdiZaznam(jmeno, prijmeni);
        for (Zaznam zaznam : nalezeni) {
            System.out.println(zaznam);

        }
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
        System.out.println("Evidence pojistenců");
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