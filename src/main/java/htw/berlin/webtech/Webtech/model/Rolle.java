package htw.berlin.webtech.Webtech.model;

public enum Rolle {
    KUNDE("Kunde"),
    MITARBEITER("Mitarbeiter");

    final String name;

    Rolle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
