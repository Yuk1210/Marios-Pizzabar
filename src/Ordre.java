import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ordre{
    private int ordrenr; //Dette er ordrenr, f.eks. “1”, “2”, “3”. Det bruges til at kunne skelne mellem forskellige ordrer.
    private Kunde kunde; //Her gemmer du kunden, der har lavet ordren. Kunde er en anden klasse, du har lavet, med oplysninger som navn og telefonnummer.Så hver ordre “ejer” en kunde.
    private List<Pizzaer> pizzaer; //En liste med alle de pizzaer, kunden har bestilt. vi bruger List<Pizzaer> fordi en kunde kan bestille mere end én pizza.
    private int totalPris; // Gemmer den samlede pris for ordren.

    private LocalDateTime oprettetTid;
    private LocalDateTime afsluttetTid;
    private boolean erAfsluttet; //En sand/falsk værdi (true/false) der fortæller, om ordren er færdig.

    public Ordre(int ordrenr, Kunde kunde, int totalPris) {
        this.ordrenr = ordrenr;
        this.kunde = kunde;
        this.pizzaer = new ArrayList<>();
        this.totalPris = 0; //Du starter den samlede pris på 0 kr.
        this.oprettetTid = LocalDateTime.now();
        this.erAfsluttet = false; //vi starter med at sige at vores ordre ikke er færdig hvilket betyder false.
    }

        // Tilføj pizza til ordren
    public void tilføjPizza(Pizzaer pizza) { //Denne metode hedder tilføjPizza og bor inde i klassen Ordre. Den bliver brugt, når kunden bestiller en ny pizza.
        //Pizzaer pizza → betyder, at metoden modtager et objekt af typen Pizzaer som input. Altså én pizza, som skal lægges til ordren.
        pizzaer.add(pizza);
        totalPris += pizza.getPris();
        //pizza.getPris() henter prisen på den pizza, du lige har lagt til. (f.eks. 57 kr)
        //+= betyder “læg oveni”.
        //Så hvis totalPris tidligere var 0, bliver det nu:
    }

    // Marker ordre som afsluttet
    public void afslutOrdre() {
        erAfsluttet = true;
        afsluttetTid = LocalDateTime.now();
    }

    // Hjælpefunktion til at vise tid pænt
    private String formatTid(LocalDateTime tid) {
        if (tid == null) return "-"; //Hvis tidspunktet (tid) er null, altså ikke sat endnu, returnerer metoden bare en bindestreg "-".
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //Her laver du et objekt (formatter), der ved hvordan tiden skal skrives.
        return tid.format(formatter);
    }

    //Getter
    public int getOrdrenr() {
        return ordrenr;}
    public Kunde getKunde() {
        return kunde;}
    public List<Pizzaer> getPizzaer() {
        return pizzaer;}
    public int getTotalPris() {
        return totalPris;}
    public boolean erAfsluttet() {
        return erAfsluttet; }

    public void tilføjPizza(Pizzaer pizza) {
        pizzaer.add(pizza);
        totalPris += pizza.getPris();
    }

        // Udskriv ordren pænt
    @Override //betyder, at du overskriver standardmetoden toString() fra Java.
    public String toString() { //Alle objekter i Java har som standard en toString()-metode, men uden denne får man fx Ordre@6f2b958e i stedet for pæn tekst.
        //public String toString() → betyder, at metoden returnerer en tekststreng, der beskriver ordren.
        StringBuilder sb = new StringBuilder();
        //Her opretter du et StringBuilder-objekt, som er en effektiv måde at bygge lange tekststrenge på.
        //Du kan føje tekst til den stykke for stykke uden at lave mange nye tekststrenge (mere effektivt end +)
        sb.append("Ordre #").append(ordrenr).append(" - ").append(kunde.navn).append("\n");
        sb.append("Oprettet: ").append(formatTid(oprettetTid)).append("\n");
        sb.append("Afsluttet: ").append(formatTid(afsluttetTid)).append("\n");
        sb.append("Status: ").append(erAfsluttet ? " Afsluttet" : " Aktiv").append("\n");
        sb.append("Pizzaer:\n");

        for (Pizzaer p : pizzaer) {
            //Går igennem alle pizzaer i ordren og tilføjer navn og pris på hver.
            sb.append("  - ").append(p.getNavn()).append(" (").append(p.getPris()).append(" kr)\n");
        }

        sb.append("Total: ").append(totalPris).append(" kr\n");
        return sb.toString();
    }
}
}
