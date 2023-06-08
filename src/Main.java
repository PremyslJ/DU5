import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Plant plant = new Plant("Fialka", "je fialová a hezká",
                LocalDate.of(2021, 5, 12), LocalDate.of(2021, 1, 1),
                0
        );

        System.out.println(plant.getName() + "     " + plant.getFrequencyOfWatering());
        System.out.println("Název květiny:   " + plant.getName() + "   Datum poslední zálivky:  "
                + plant.getWatering() + "   Doporučené datumm zálivky:  " + plant.getOtherTopping());

        plant.setFrequencyOfWatering(-8);


        System.out.println(plant.getFrequencyOfWatering() + "      " + plant.getOtherTopping());
        AddingFlowersToTheList addingFlowersToTheList = new AddingFlowersToTheList();
       // addingFlowersToTheList.add(plant);
       // addingFlowersToTheList.add(plant);
        addingFlowersToTheList.add(new Plant("Fialka", "je fialová a hezká",
                LocalDate.of(2021, 5, 12), LocalDate.of(2021, 1, 1),
                5
        ));

        System.out.println(addingFlowersToTheList.getPlantList().size());

    }


}