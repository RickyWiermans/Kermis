import java.util.Scanner;

class StartKermis {
    Attractie[] alleAttracties;

    StartKermis(Attractie[] alleAttracties) {
        this.alleAttracties = alleAttracties;
    }

    void start() {
        BelastingInspecteur belastingInspecteur = new BelastingInspecteur();
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        String inputUser;

        new output().kermisActiviteiten();
        while (go) {
            System.out.print("User input is: ");
            inputUser = sc.nextLine();

            if (inputUser.equals("o")) {
                System.out.println("De totale omzet is: " + Kermis.kassa + ".");
                for (Attractie attractie : alleAttracties) {
                    attractie.printWinst();
                }
            } else if (inputUser.equals("k")) {
                System.out.println("Totaal aantal kaartjes verkocht: " + Kermis.kaartjes + ".");
                for (Attractie attractie : alleAttracties) {
                    attractie.printAantalKaartjes();
                }
            } else if (inputUser.equals("q")) {
                System.out.println("Dank je wel voor het bezoeken van de kermis!");
                go = false;
            } else if (inputUser.equals("m")){
                for (Attractie attractie : alleAttracties) {
                    attractie.controleerAttractie();
                }
            } else if (inputUser.isEmpty()){
                System.out.println("Geen input, probeer opnieuw");
            } else if ("123456".contains(inputUser)) {
                alleAttracties[Integer.parseInt(inputUser) - 1].kaartVerkocht();
                    if (Kermis.kaartjes%15 == 0){
                        System.out.println("De belastinginspecteur komt langs.");
                        belastingInspecteur.belastingOphalen(alleAttracties);
                    }
            } else {
                System.out.println("Verkeerde input, probeer opnieuw");
            }

            System.out.println();
        }
    }
}

class output{
    void kermisActiviteiten(){
        System.out.println("Toets in cijfer/letter in.");
        System.out.println("'1' voor botsauto's");
        System.out.println("'2' voor spin");
        System.out.println("'3' voor spiegelpaleis");
        System.out.println("'4' voor spookhuis");
        System.out.println("'5' voor hawaii");
        System.out.println("'6' voor ladderklimmen");
        System.out.println("'m' voor onderhoud als dat nodig is");
        System.out.println("'o' voor de omzet van alle attracties");
        System.out.println("'k' voor het totaal aantal verkochte kaartjes");
        System.out.println();
    }
}
