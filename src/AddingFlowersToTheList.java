import java.util.ArrayList;
import java.util.List;

public class AddingFlowersToTheList {

    private List<Plant> plantList = new ArrayList<>();

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
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
