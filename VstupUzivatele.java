import java.util.ArrayList;
import java.util.Scanner;

public class VstupUzivatele {
    private Databaze databaze;
    private Scanner scanner = new Scanner(System.in);

    public VstupUzivatele() {
        databaze = new Databaze();
    }
    
    /**
     * přidání nového uživatele
     */
    
    //TODO: Zkus udělat metodu pro přidání zaznamu. Ať se to tak neopakuje.
    public void pridejZaznam() {
        System.out.println("Zadejte jmeno:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte prijmeni:");
        String prijmeni = scanner.nextLine();
        System.out.println("Zadejte telefon:");
        String vek = scanner.nextLine();
        System.out.println("Zadejte vek:");
        String telefon = scanner.nextLine();
        databaze.pridejZaznam(jmeno, prijmeni, telefon, vek);


    }
    
    /**
     * vypsání vsech ulozenych zaznamu
     */
    public void vypisZaznamy() {
        ArrayList<Zaznam> zaznamy = databaze.getZaznamy();
        for (Zaznam zaznam : zaznamy) {
            System.out.println(zaznam);
        }
    }
    
    /**
     * vyhledání záznamu podle jmena a prijmení
     */
    public void najdiZaznam() {
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