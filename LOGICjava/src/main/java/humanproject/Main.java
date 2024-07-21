package humanproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IFileOperator fileOperator = new ImplFileOperator();
        IHumanAnalyzer humanAnalyzer = new ImplHumanAnalyzer();
        IHumanOperator humanOperator = new ImplHumanOperator();
        humanproject.Menu menu = new humanproject.Menu();
        List<Human> humans = new ArrayList<>();
        humans = fileOperator.deserialize("people.csv");
        System.out.println("System: data loaded successfully");
        System.out.println("Welcome to the People Analyzer program!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.displayMenu();

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 1:
                    humanAnalyzer.printwithid(humans);
                    break;
                case 2:
                    humanAnalyzer.SortedAgeDescending(humans);
                    humanAnalyzer.LongestSurname(humans);
                    humanAnalyzer.AverageAge(humans);
                    break;
                case 3:
                    humanOperator.AddHuman(humans);
                    break;
                case 4:
                    humanOperator.DeleteHuman(humans);
                    break;
                case 5:
                    fileOperator.serialize(humans, "people");
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
