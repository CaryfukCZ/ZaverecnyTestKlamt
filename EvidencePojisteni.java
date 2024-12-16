import java.util.Scanner;

public class EvidencePojisteni {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VstupUzivatele vstupUzivatele = new VstupUzivatele();
        String volba = "";

        while (!volba.equals("4")) {
            vstupUzivatele.vypisUvod();
            vstupUzivatele.vypisMenu();
            volba = scanner.nextLine();
            System.out.println();
            switch (volba) {
                case "1":
                    vstupUzivatele.pridejZaznam();
                    break;
                case "2":
                    vstupUzivatele.vypisZaznamy();
                    break;
                case "3":
                    vstupUzivatele.najdiZaznam();
                    break;
                case "4":
                    vstupUzivatele.konecProgramu();
                    break;
                default:
                    System.out.println("Neplatná volba. Zadejte prosím znovu.");
                    break;
            }

            System.out.print("Pokracujte libovolnou klavesou... ");
            scanner.nextLine();

//TODO: Přepsat a dobře pojmenovat proměnne

        }
    }
}