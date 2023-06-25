import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // vytvoření proměnné a objektu
        FlowerManager flowerManager = new FlowerManager();


//        try {   // vytvoření objektu
//
//            Plant plant = new Plant(
//                    "Kaktus", "bodá jako včela", LocalDate.of(2020, 12, 30),
//                    LocalDate.of(2021, 1, 5), 3
//
//            ));
//
//            // zavolá metodu "getWateringInfo()" a vypíše na obrazovku
//            System.out.println(plant.getWateringInfo() + "\n");
//
//            // vyjímky
//        } catch (PlantException e) {
//            System.err.println("  Nastala chyba při přidávání rostliny,  " + e.getLocalizedMessage());
//        }
        try {
            flowerManager.loadDataFromFile(Settings.fileNameInput(), Settings.delimiter());
        } catch (PlantException e) {
            System.err.println("  nepodařilo se načíst data ze souboru!!!" + e.getLocalizedMessage());
        }

        // přidá další objekt do seznamu
        try {
            flowerManager.add(new Plant("Gerbera", "z řádu hvězdnicotvaré",
                    LocalDate.of(2022, 1, 1),
                    LocalDate.of(2023, 1, 1),
                    286));
        } catch (PlantException e) {
            System.err.println("  nelze přidat do seznamu" + e.getLocalizedMessage());
        }
        // přidá další objekt do seznamu +
        try {
            flowerManager.add(new Plant("Růže", "cévnaté rostliny",
                    LocalDate.of(2022, 1, 1),
                    LocalDate.of(2023, 1, 1),
                    5));
        } catch (PlantException e) {
            System.err.println("  nelze přidat do seznamu" + e.getLocalizedMessage());
        }


        // flowerManager.remove(plantList.remove(1));  // vymaže objekt s indexem č.1

        // výpis seznamu květin pomocí cyklu "foreach"
        //plantList.forEach(System.out::println);

        try {
            flowerManager.saveDataToFile(Settings.fileNameOutput(), Settings.delimiter());
        } catch (PlantException e) {
            System.err.println("   Chyba při zápisu do souboru: " + e.getLocalizedMessage() + "!");
        }


        //  System.out.println(plantList.get(1));  //vrátí jednu rostlinu dle idexu


        // výpis seznamu květin pomocí cyklu "foreach"
        List<Plant> plantList = flowerManager.getPlantList();
        // plantList.forEach(System.out::println);


        System.out.println(" ");


        // Seřazení výstupních dat podle názvu květiny (abecedně)

        System.out.println("Seřazení výstupních dat podle názvu květiny (abecedně)");
        System.out.println(" ");
        {
            Collections.sort(plantList, Comparator.comparing(Plant::getName));

            System.out.println(plantList);
        }

        System.out.println(" ");
        System.out.println(" ");


        // Seřaď rostliny podle data poslední zálivky
        System.out.println(" ");

        System.out.println("Seřadí rostliny podle data poslední zálivky");
        System.out.println(" ");
        {
            Collections.sort(plantList, Comparator.comparing(Plant::getWatering));

            System.out.println(plantList);
        }

        //Najdi a vypiš dny, kdy jsi zasadil(a) alespoň jednu rostlinu
        System.out.println("Dny sázení rostlin:\n");
        ArrayList<LocalDate> plantingDays = new ArrayList<>();
        for (Plant plant : plantList) {
            LocalDate plantingDate = plant.getPlanted();
            if (!plantingDays.contains(plantingDate)) {
                plantingDays.add(plantingDate);
                System.out.println(plantingDate);

            }


        }
    }
}
