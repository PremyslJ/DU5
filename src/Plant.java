import java.time.LocalDate;;
import java.util.ArrayList;
import java.util.List;

public class Plant {
    private static int idCounter = 0;
    private int id = idCounter++;

    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    List<Plant> plantList = new ArrayList<>();


    public void add(Plant newPlant) {

        plantList.add(newPlant);
    }

    // konstruktor pro nastavení všech atributů
    public Plant(String name, String notes, LocalDate planted, LocalDate watering,
                 int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.setWatering(watering);
        this.setFrequencyOfWatering(frequencyOfWatering);
    }

    // konstruktor, který nastaví jako poznámku prázdný řetězec a datum poslední zálivky nastaví na dnešní datum
    public Plant(String name, LocalDate planted, int frequencyOfWatering) throws PlantException {
        this.name = name;
        this.notes = "";
        this.watering = LocalDate.now();
        this.planted = planted;
        this.setFrequencyOfWatering(frequencyOfWatering);
    }

    // konstruktor, který nastaví totéž co druhý a navíc výchozí frekvenci
    // zálivky na 7 dnů a datum zasazení na dnešní datum
    public Plant(String name, LocalDate planted) throws PlantException {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.setFrequencyOfWatering(7);
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

    // vrátí odchycenou vyjímku "datum zálivky je starši než zasazení rotliny"
    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("datum zálivky je starši než zasazení rotliny");
        }
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    // vrátí odchycenou vyjímku "frekvence zálivky je rovna nebo menší než nula,zadáno "
    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        if (frequencyOfWatering <= 0) {
            throw new PlantException(
                    "frekvence zálivky je rovna nebo menší než nula,zadáno  (" + frequencyOfWatering + ")");
        }

        this.frequencyOfWatering = frequencyOfWatering;
    }


    // public LocalDate getOtherTopping(){

    //   LocalDate otherTopping;

    //   otherTopping=  watering.plusDays(frequencyOfWatering);

    //  return otherTopping;

    //  }
    // metoda, která vrátí název květiny, datum poslední zálivky a datum doporučené další zálivky.
    public String getWateringInfo() {

        return "Název:   " + name + "   Datum poslední zálivky:   " + watering + "   Doporučená doba zálivky:   " + watering.plusDays(frequencyOfWatering);
    }

    @Override
    public String toString() {
        return
                "  ID rostliny:              " + id + '\n' +
                        "  Název rostliny:           " + name + '\n' +
                        "  poznámka:                 " + notes + '\n' +
                        "  datum, kdy byla zasazena: " + planted + '\n' +
                        "  datum poslední zálivky:   " + watering + '\n' +
                        "  frekvence zalévání (dny): " + frequencyOfWatering + '\n' +
                        "  doporučená doba zálivky:  " + watering.plusDays(frequencyOfWatering) + '\n'

                ;
    }
}
