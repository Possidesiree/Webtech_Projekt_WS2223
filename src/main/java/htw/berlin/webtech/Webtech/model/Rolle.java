package htw.berlin.webtech.Webtech.model;

public enum Rolle {
    KUNDE("Kunde"),
    MITARBEITER("Mitarbeiter"),
    ADMIN("Admin");

    final String name;

    Rolle(String name) {
        this.name = name;
    }

    public static Rolle fromName(String name) {
        for (Rolle value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Keine Rolle für den Name");
    }

    public String getName() {
        return name;
    }
}
