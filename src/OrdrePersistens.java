import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdrePersistens {

        public static void ordrePersistens(List<Ordre> ordreListe) {
            String ordreFile = "ordre.txt";

            try (FileWriter writer = new FileWriter(ordreFile, true)) {
                for (Ordre ordre : ordreListe) {

                    writer.write(ordre.getOrdrenr() + "," + ordre.getKunde().getNavn());

                    for (Pizzaer pizza : ordre.getPizzaer()) {
                        writer.write("," + pizza.getNavn() );

                        for (Topping topping : pizza.getToppings()){
                            writer.write("+" + topping.getNavn());
                        }
                    }
                            writer.write("," + ordre.getTotalPris());

                            writer.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();


            }


        }

    public static void readOrdre() {
        String ordreFile = "ordre.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ordreFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


