import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerManager {

    private List<Plant> plantList = new ArrayList<>();

    //metoda pro načtení květin ze souboru
    public void loadDataFromFile(String filename, String delimiter) throws PlantException {
        String[] items = new String[0];
        String line = "";
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                // System.out.println(line);

                items = line.split(delimiter); // uloží do pole a rozdělí text pomocí oddělovače
                // if(items.length != 5) throw new PlantException("vetsi pocet polozek"+line);
                String name = items[0];
                String notes = items[1];
                int frequencyOfWatering = Integer.parseInt(items[2]);
                LocalDate watering = LocalDate.parse(items[3]);
                LocalDate planted = LocalDate.parse(items[4]);

                Plant newPlant = new Plant(name, notes, planted, watering, frequencyOfWatering);
                plantList.add(newPlant);
                lineNumber++;


            }
            // vyjímky
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor" + filename + "nebyl nalezen" + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException(", špatně zadaný znak(není číslo) :   " + items[2] + "  na radku: " + lineNumber + ": " + line);
        } catch (DateTimeParseException e) {
            throw new PlantException(", špatně zadané datum:   " + items[3] + "  na radku:" + lineNumber + ": " + line);
        }

    }

    //metoda pro uložení květin do souboru
    public void saveDataToFile(String filename, String delimiter) throws PlantException {
        // 1. otevřít soubor pro zápis
        // 2. zapsat data
        // 3. zavřít soubor
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Plant plant : plantList) {
                writer.println(
                        plant.getName() + delimiter
                                + plant.getNotes() + delimiter
                                + plant.getFrequencyOfWatering() + delimiter
                                + plant.getWatering() + delimiter
                                + plant.getPlanted()
                );
            }
        } catch (IOException e) {
            throw new PlantException("Chyba zápisu do souboru " + filename + ": " + e.getLocalizedMessage());
        }
    }


    // přidání další květiny do seznamu
    public void add(Plant newPlant) {

        plantList.add(newPlant);
    }

    // metoda pro vymazání květiny ze seznamu
    public void remove(Plant plant) {

        plantList.remove((plant));
    }

    // metoda pro získání květiny pomocí indexu
    public Plant get(int index) {
        return plantList.get(index);

    }

    // kopie plantListu
    public List<Plant> getPlantList() {
        return new ArrayList<>(plantList);
    }
}