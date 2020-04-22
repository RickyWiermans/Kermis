class Attractie extends RisicoRijkeAttracties implements GokAttractie{
    private int aantal = 0;
    private double prijs, oppervlakte, winst;
    private String name;

    Attractie(String name, double prijs, double oppervlakte) {
        this.name = name;
        this.prijs = prijs;
        this.oppervlakte = oppervlakte;
    }

    void draaien(){
        System.out.println(getName() + " draait.");
    }

    void kaartVerkocht(){
        if(opstellingsKeuring()){
            try{
                throw new Exception();
            } catch (Exception e) {
                System.out.println("De attractie " + getName() + " moet gekeurd worden! Typ 'm' voor een goedkeurig.");
            }
        }
        else{
            draaien();
            this.aantal++;
            Kermis.kaartjes++;
            setWinst();
        }
    }

    void controleerAttractie(){
        if(opstellingsKeuring()){
            Spin.count++;
            Hawaii.count++;
            System.out.println(getName() + " is goedgekeurd!");
        }
    }

    void setWinst(){
        this.winst += this.prijs;
        Kermis.kassa += this.prijs;
    }

    double getWinst(){
        return this.winst;
    }

    String getName(){
        return this.name;
    }

    int getAantalKaartjes(){
        return this.aantal;
    }

    @Override
    boolean opstellingsKeuring() {
        return false;
    }

    @Override
    public double kansSpelBelastingBetalen() {
        return 0;
    }

    @Override
    public boolean kansSpelBelasting() {
        return false;
    }

    void printWinst(){
        System.out.println("De omzet van " + getName() + " is " + getWinst());
    }

    void printAantalKaartjes(){
        System.out.println(getName()  + " verkocht " + getAantalKaartjes() + " kaartje(s).");
    }
}

class Botsauto extends Attractie{

    Botsauto(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }
}

class Spin extends Attractie{
    static int count = 0;
    double belasting;

    Spin(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }


    @Override
    boolean opstellingsKeuring() {
        return getAantalKaartjes() - count * 5 > 5;
    }

    @Override
    public double kansSpelBelastingBetalen() {
        double kansBelasting = 0.3 * getWinst() - belasting;
        belasting += kansBelasting;
        return kansBelasting;
    }

    @Override
    public boolean kansSpelBelasting() {
        return true;
    }
}

class Spiegelpaleis extends Attractie{

    Spiegelpaleis(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }
}

class Spookhuis extends Attractie{

    Spookhuis(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }
}

class Hawaii extends Attractie{
    static int count = 0;

    Hawaii(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }

    @Override
    boolean opstellingsKeuring() {
        return getAantalKaartjes() - count * 10 > 10;
    }
}

class LadderKlimmen extends Attractie{
double belasting;

    LadderKlimmen(String name, double prijs, double oppervlakte) {
        super(name, prijs, oppervlakte);
    }

    @Override
    public double kansSpelBelastingBetalen() {
        double kansBelasting = 0.3 * getWinst() - belasting;
        belasting += kansBelasting;
        return kansBelasting;
    }

    @Override
    public boolean kansSpelBelasting() {
        return true;
    }
}
