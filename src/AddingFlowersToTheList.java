import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingFlowersToTheList {

    private List<Plant> plantList = new ArrayList<>();

    public void loadDataFromFile(String filename){
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))
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
