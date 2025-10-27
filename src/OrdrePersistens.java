import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrdrePersistens {
    public class OrdrePersistens {
        public static void ordrePersistens(ArrayList<Pizzaer> ordreArrayList) {
            String ordreFile = "ordre.txt";

            try (FileWriter writer = new FileWriter(ordreFile, true)) {
                for (int i = 0; i < ordreArrayList.size(); i++) {


                    String navn = ordreArrayList.get(i).getNavn();
                    int ordreId = ordreArrayList.get(i).getId();
                    writer.append(navn + ",");
                    writer.append(ordreId+ ",");
                    System.out.println(navn + "," + ordreId);
                }
            } catch (IOException e) {
                e.printStackTrace();


            }


        }

        public static void readOrdre() {
            String komma = ",";
            String line = "";
            String ordreFile = "ordre.txt";
            try (BufferedReader br = new BufferedReader(new FileReader(ordreFile))){
                while ((line = br.readLine()) !=null)
                {
                    String[] data = line.split(komma);

                    System.out.println("navn: " + data[0] + "OrdreId; " + data[1]);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}
