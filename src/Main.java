import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Thief thief = new Thief(GetData());

    }

    private static List<String> GetData() {
        List<String> data = new ArrayList<>();
        String sizes = null;
        String values = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Lukasz Tolpa\\IdeaProjects\\AlgorytmZlodzieja\\Data\\dane26.txt"));
            String line = reader.readLine();
            while (line != null) {

                if (line.equals("sizes15")) {
                    sizes = reader.readLine();
                    reader.readLine();
                    values = reader.readLine();
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] sizesTab = sizes.split("\\s");
        String[] valuesTab = values.split("\\s");

        for (int i = 0 ; i < sizesTab.length ; i++){
            String element;
            element = valuesTab[i]+ "/" + sizesTab[i];
            data.add(element);
        }
        return data;
    }
}
