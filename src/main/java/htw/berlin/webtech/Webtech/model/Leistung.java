package htw.berlin.webtech.Webtech.model;

public enum Leistung {
    HAARE_WASCHEN("Haare Waschen", "200$"),
    HAARE_SCHNEIDEN("Haare Schneiden", "150$"),
    HAARE_FAERBEN("Haare Färben", "200$"),
    HAARE_FLECHTEN("Haare Flechten", "100$"),
    BOX_BRAIDS("Box Braids", "300$"),
    KNOTLESS_BRAIDS("Knotless Braids", "300$"),
    AMERICAN_STYLE("American Style", "255$"),
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
