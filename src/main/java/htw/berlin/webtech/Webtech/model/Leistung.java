package htw.berlin.webtech.Webtech.model;

public enum Leistung {
    HAARE_WASCHEN("Haare Waschen", "200$"),
    HAARE_GLAETTEN("Haare Glätten", "250$");

    final String frisurTyp;
    final String preis;

    Leistung(String frisurTyp, String preis) {
        this.frisurTyp = frisurTyp;
        this.preis = preis;
    }

    public String getFrisurTyp() {
        return frisurTyp;
    }

    public String getPreis() {
        return preis;
    }
}
