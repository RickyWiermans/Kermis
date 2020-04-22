class Kermis {
    static double kassa = 0.0;
    static int kaartjes = 0;
    public static void main(String[] args) {
        Attractie[] alleAttracties = new Attractie[6];
        alleAttracties[0] = new Botsauto("Botsauto",2.50,25);
        alleAttracties[1] = new Spin("Spin",2.25, 8);
        alleAttracties[2] = new Spiegelpaleis("Spiegelpaleis",2.75,20);
        alleAttracties[3] = new Spookhuis("Spookhuis", 3.20, 20);
        alleAttracties[4] = new Hawaii("Hawaii",2.90,10);
        alleAttracties[5] = new LadderKlimmen("Ladderklimmen",5.00,5);
        new StartKermis(alleAttracties).start();
    }
}

/*
Er is een kleine kermis gemaakt in dit programma. Als start worden eerst alle attracties gemaakt.
Vervolgens wordt de kermis opgestart in startkermis. In die klasse kan de gebruiker de kermis bijhouden.
Je kan kiezen om in een attractie te gaan zitten, zien hoeveel omzet er is, zien hoeveel kaartjes er
verkocht zijn. Daarnaast kan eventueel een monteur worden aangeroepen als een attractie een
inspectie nodig heeft. Bovendien wordt er om de zoveel tijd een belastinginspecteur erbij gehaald.
Als laatste heb je natuurlijk ook de mogelijkheid om de kermis te verlaten.
*/