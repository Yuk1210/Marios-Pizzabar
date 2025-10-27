public class Kunde {
    public String navn;
    public String ordrenr;

    public Kunde(String navn, String ordrenr) {
        this.navn = navn;
        this.ordrenr = ordrenr;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
}
