package humanproject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImplHumanAnalyzer implements IHumanAnalyzer {
    @Override
    public void AverageAge(List<Human> humans) {
        double sum = 0;
        double counter = 0;

        for (Human human : humans) {
            sum += human.getAge();
            counter++;
        }
        double averageAge = sum / counter;

        System.out.println("The average age of people is: " + averageAge);
    }

    @Override
    public void LongestSurname(List<Human> humans) {
        String longestSurname = "";
        for (Human human : humans) {
            if (longestSurname.length() < human.getSurname().length()) {
                longestSurname = human.getSurname();
            }
        }

        System.out.println("The person with the longest surname is: " + longestSurname);
    }

    @Override
    public void SortedAgeDescending(List<Human> humans) {
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h2.getAge(), h1.getAge());
            }
        });
        System.out.println("List sorted in descending order by age:");
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    @Override
    public void printwithid(List<Human> humans) {
        int id = 0;

        for (Human human : humans) {
            System.out.println("Id: " + id + " " + human.getName() + " " + human.getSurname() + " " + human.getAge() + " " + human.getEmail());
            id++;
        }
    }
}
