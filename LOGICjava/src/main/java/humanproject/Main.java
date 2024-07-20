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

        List<Human> humans = new ArrayList<>();

        humans = fileOperator.deserialize("people.csv");


        System.out.println("system: data loaded succesfully");
        System.out.println("Welcome in People analyzer program!");


        Scanner scanner = new Scanner(System.in);


        while (true)
        {
            System.out.println("Please enter a number (1- People file 2- Average age 3- Longest surname 4- Sorted by age)");
            int wybor = scanner.nextInt();
            if (wybor == 1)
            {
                humanAnalyzer.printwithid(humans);
            }
            else if (wybor == 2)
            {
                humanAnalyzer.AverageAge(humans);
            }
            else if (wybor == 3)
            {
                humanAnalyzer.LongestSurname(humans);
            }
            else if (wybor == 4)
            {
                humanAnalyzer.SortedAgeDescending(humans);
            }
            else if(wybor == 5)
            {
                fileOperator.serialize(humans, "people");
            }


        }


    }

}