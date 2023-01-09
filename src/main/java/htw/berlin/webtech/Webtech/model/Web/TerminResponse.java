package htw.berlin.webtech.Webtech.model.Web;

public class TerminResponse {
    private int reservierungsNummer;

    public TerminResponse(int reservierungsNummer) {
        this.reservierungsNummer = reservierungsNummer;
    }

    public int getReservierungsNummer() {
        return reservierungsNummer;
    }

    public void setReservierungsNummer(int reservierungsNummer) {
        this.reservierungsNummer = reservierungsNummer;
    }
}
