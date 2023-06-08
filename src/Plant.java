import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plant {

    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    List<Plant>plantList = new ArrayList<>();


    public  void add(Plant newPlant){
        plantList.add(newPlant);
    }

    @Override
    public String toString() {
        return "AddingFlowersToTheList{" +
                "plantList=" +plantList +
                '}';
    }


    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }

    public LocalDate getOtherTopping(){

        LocalDate otherTopping;

        otherTopping=  watering.plusDays(frequencyOfWatering);

        return  otherTopping;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

   public void setNotes(String notes) {
        this.notes = notes;
   }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        if(frequencyOfWatering <=0){
            throw new RuntimeException("frekvence je rovna nebo menší než nula,zadáno  ("+frequencyOfWatering+" )");
        }

        this.frequencyOfWatering = frequencyOfWatering;
   }




    }

