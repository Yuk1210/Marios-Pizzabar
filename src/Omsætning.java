import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

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
            System.out.println(" Ordre nr: " + o.getOrdreNr() + " | Kunde: " + o.getKunde().getNavn() + " | Total: " + o.getTotalPris() + " kr");
        }
        System.out.println("_________________________________");
        System.out.println("Samlet omsætning: " + beregnTotalOmsætning() + "kr");
    }

    public void visPizzaStstistik() {
        if(ordrer.isEmpty()) {
            System.out.println("Ingen statistik at vise.");
            return;
        }

        Map<String, Integer> pizzaTæller = new HashMap<>();

        //Gå gennem alle ordrer og tæller pizzaer
        for(Ordre o : ordrer) {
            for(Pizzaer p : o.getPizzaer()) {
                pizzaTæller.put(p.getNavn(), pizzaTæller.getOrDefault(p.getNavn(), 0) + 1);
            }
        }

        //Sorter efter flest bestillinger
        pizzaTæller.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " bestillinger"));
    }
}