import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddingFlowersToTheList addingFlowersToTheList = new AddingFlowersToTheList();
        try {
            addingFlowersToTheList.loadDataFromFile("kvetiny.txt");
        } catch (PlantException e) {
            System.err.println("nepodarilo se na49st soubor");
            Plant plant = null;
            try {
                plant = new Plant(
                        "Fialka", "je fialová a hezká",
                        LocalDate.of(2021, 5, 12), LocalDate.of(2021, 1, 1),
                        5
                );


                System.out.println(plant.getName() + "     " + plant.getFrequencyOfWatering());
                System.out.println("Název květiny:   " + plant.getName() + "   Datum poslední zálivky:  "
                        + plant.getWatering() + "   Doporučené datumm zálivky:  " + plant.getOtherTopping());

                //   plant.setFrequencyOfWatering(-8);


                System.out.println(plant.getFrequencyOfWatering() + "      " + plant.getOtherTopping());
            } catch (PlantException e) {
                System.err.println("Nastala chyba při přidávání rostliny" + e.getLocalizedMessage());
            }
            addingFlowersToTheList.add(plant);
            addingFlowersToTheList.add(plant);

            try {
                addingFlowersToTheList.add(new Plant("Fialka", "je fialová a hezká",
                        LocalDate.of(2020, 5, 12), LocalDate.of(2021, 1, 1),
                        1
                ));
                System.out.println("Název květiny:   " + plant.getName() + "   Datum poslední zálivky:  "
                        + plant.getWatering() + "   Doporučené datumm zálivky:  " + plant.getOtherTopping());
                //  System.out.println(addingFlowersToTheList.getPlantList().size());

            } catch (PlantException e) {
                System.err.println("Nastala chyba při přidávání rostliny  " + e.getLocalizedMessage());
            }
        }


    }
}