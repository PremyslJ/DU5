import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // vytvoření proměnné a objektu
        FlowerManager flowerManager = new FlowerManager();


        try {   // vytvoření objektu
            Plant plant = new Plant(
                    "Kaktus", "bodá jako včela", LocalDate.of(2020, 12, 30),
                    LocalDate.of(2021, 1, 5), 3
            );

            // zavolá metodu "getWateringInfo()" a vypíše na obrazovku
            System.out.println(plant.getWateringInfo() + "\n");

            // vyjímky
        } catch (PlantException e) {
            System.err.println("  Nastala chyba při přidávání rostliny,  " + e.getLocalizedMessage());
        }
        try {
            flowerManager.loadDataFromFile(Settings.fileName(), Settings.delimiter());
        } catch (PlantException e) {
            System.err.println("  nepodařilo se načíst data ze souboru!!!" + e.getLocalizedMessage());
        }

        // přidá další objekt do seznamu
        try {
            flowerManager.add(new Plant("Gerbera", "z řádu hvězdnicotvaré",
                    LocalDate.of(2022, 5, 5),
                    LocalDate.of(2023, 11, 1),
                    286));
        } catch (PlantException e) {
            System.err.println("  nelze přidat do seznamu" + e.getLocalizedMessage());
        }
        // přidá další objekt do seznamu +
        try {
            flowerManager.add(new Plant("Růže", "cévnaté rostliny",
                    LocalDate.of(2022, 5, 1),
                    LocalDate.of(2023, 1, 1),
                    5));
        } catch (PlantException e) {
            System.err.println("  nelze přidat do seznamu" + e.getLocalizedMessage());
        }
        // výpis seznamu květin pomocí cyklu "foreach"
        List<Plant> plantList = flowerManager.getPlantList();
        plantList.forEach(System.out::println);


        flowerManager.remove(plantList.remove(1));  // vymaže objekt s indexem č.1

        // výpis seznamu květin pomocí cyklu "foreach"
        plantList.forEach(System.out::println);

        try {
            flowerManager.saveDataToFile(Settings.fileName1(), Settings.delimiter());
        } catch (PlantException e) {
            System.err.println("   Chyba při zápisu do souboru: " + e.getLocalizedMessage() + "!");
        }


        //  System.out.println(plantList.get(1));  //vrátí jednu rostlinu dle idexu


    }


}
