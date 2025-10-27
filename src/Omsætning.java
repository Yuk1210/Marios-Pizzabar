import java.util.ArrayList;
import java.util.List;

public class Omsætning {

    private List<Ordre> ordrer;

    public Omsætning() {
        this.ordrer = new ArrayList<>();
    }
    public void tilføjOrdre(Ordre ordre) {
        ordrer.add(ordre);
    }
    public int beregnTotalOmsætning() {
        int total = 0;
        for (Ordre o : ordrer) {
            total += o.getTotalPris();
        }
        return total;
    }
    public void visOmsætning() {
        System.out.println("===== OMSÆTNINGS RAPPORT =====");
        for (Ordre o : ordrer ){
            System.out.println(" Ordre nr: " + o.getOrdrenr() + " | Kunde: " + o.getKunde().getNavn() + " | Total: " + o.getTotalPris() + " kr");
        }
        System.out.println("_________________________________");
        System.out.println("Samlet omsætning: " + beregnTotalOmsætning() + "kr");
    }
}