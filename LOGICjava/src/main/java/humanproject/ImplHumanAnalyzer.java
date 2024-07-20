package humanproject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImplHumanAnalyzer implements  IHumanAnalyzer{
    @Override
    public void AverageAge(List<Human> humans) {
        double sum = 0;
        double counter = 0;

        for (Human human : humans)
        {
            sum += human.getAge();
            counter++;
        }
        double averageage = sum/counter;


        System.out.println("Średni wiek ludzi wynosi: " + averageage);

    }

    @Override
    public void LongestSurname(List<Human> humans) {

        String surnameflag = "";
        for (Human human : humans)
        {
            if (surnameflag.length() < human.getSurname().length())
            {
                surnameflag = human.getSurname();
            }

        }

        System.out.println("Osoba z najdluzszym nazwiskiem to: " + surnameflag);


    }

    @Override
    public void SortedAgeDescending(List<Human> humans) {
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h2.getAge(), h1.getAge());
            }
        });
        System.out.println("Lista posortowana malejąco według wieku:");
        for (Human human : humans) {
            System.out.println(human);
        }
    }

    @Override
    public void printwithid(List<Human> humans) {
        int id = 0;


        for (Human human : humans)
        {

            System.out.println("Id: " + id + " " + human.getName() + " " + human.getSurname() + " " + human.getAge() + " " + human.getEmail());
            id++;
        }


    }
}
