import java.util.Scanner;

public class EvidencePojisteni {
    /**
     * Hlavní metoda programu
     *
     * @param args
     */
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
                    vstupUzivatele.pridejPojistence();
                    break;
                case "2":
                    vstupUzivatele.vypisPojistene();
                    break;
                case "3":
                    vstupUzivatele.najdiPojistence();
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

        }
    }
}