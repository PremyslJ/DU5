import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingFlowersToTheList {

    private List<Plant> plantList = new ArrayList<>();

    public void loadDataFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor" + filename + "nebyl malezen" + e.getLocalizedMessage());
        }
    }

    // přidání další rostliny
    public void add(Plant newPlant) {
        plantList.add(newPlant);
    }

    public void remove(Plant plant) {

        plantList.remove((plant));
    }

    public  Plant get(int index){
        return plantList.get(index);

    }
    public String getList(){

        for(Plant plant:plantList){

        }
        return null;
    }


}
