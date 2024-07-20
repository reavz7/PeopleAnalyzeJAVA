package humanproject;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImplFileOperator implements  IFileOperator {
    @Override
    public void serialize(List<Human> humans, String filename) {
        String csvFile = "C:\\files\\" + filename;
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (Human human : humans) {
                writer.write(human.getName() + "," + human.getSurname() + "," + human.getAge() + "," + human.getEmail() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Zapisano do pliku " + filename);
    }

    @Override
    public List<Human> deserialize(String filename) {
        List<Human> humans = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\files\\" + filename));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get(0);
                String surname = csvRecord.get(1);
                Integer age = Integer.parseInt(csvRecord.get(2));
                String email = csvRecord.get(3);
                Human human = new Human(name, surname, age, email);
                humans.add(human);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return humans;
    }
}
