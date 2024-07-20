package humanproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        IFileOperator fileOperator = new ImplFileOperator();
        IHumanAnalyzer humanAnalyzer = new ImplHumanAnalyzer();
        IHumanOperator humanOperator = new ImplHumanOperator();

        List<Human> humans = new ArrayList<>();

        humans = fileOperator.deserialize("people.csv");

        System.out.println("System: data loaded successfully");
        System.out.println("Welcome to the People Analyzer program!");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a number (1- People file 2- Average age 3- Longest surname 4- Sorted by age)");
            System.out.println("5- Add new human 6- Remove human 7- Save file 8- Exit");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    humanAnalyzer.printwithid(humans);
                    break;
                case 2:
                    humanAnalyzer.AverageAge(humans);
                    break;
                case 3:
                    humanAnalyzer.LongestSurname(humans);
                    break;
                case 4:
                    humanAnalyzer.SortedAgeDescending(humans);
                    break;
                case 5:
                    humanOperator.AddHuman(humans);
                    break;
                case 6:
                    humanOperator.DeleteHuman(humans);
                    break;
                case 7:
                    fileOperator.serialize(humans, "people");
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        }
    }
}
