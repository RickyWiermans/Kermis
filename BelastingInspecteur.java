class BelastingInspecteur {

    void belastingOphalen(Attractie[] alleAttracties) {
        double betalen;
        for (Attractie attractie : alleAttracties) {
            if (attractie.kansSpelBelasting()) {
                betalen = attractie.kansSpelBelastingBetalen();
                Kermis.kassa -= betalen;
            }
        }
    }
}
