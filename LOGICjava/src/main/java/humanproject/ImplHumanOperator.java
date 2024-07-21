package humanproject;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ImplHumanOperator implements IHumanOperator{
    @Override
    public void AddHuman(List<Human> humans) {
        System.out.println("Please enter new Human data");
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");
        String name = scanner.nextLine();
        System.out.println("Surname: ");
        String surname = scanner.nextLine();
        System.out.println("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        System.out.println("E-mail: ");
        String email = scanner.nextLine(); // Read the email correctly
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() || email == null || email.isEmpty()) {
            System.out.println("You didn't type anything in one of these: Name/Surname?Email");
        }

        else
        {
        Human human = new Human(name, surname, age, email);
        humans.add(human);
        System.out.println("New human added!");
        }
    }


    @Override
    public void DeleteHuman(List<Human> humans) {
        System.out.println("To delete Human, please enter his e-mail: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        Iterator<Human> iterator = humans.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Human human = iterator.next();
            if (email.equals(human.getEmail())) {
                iterator.remove();
                found = true;
                System.out.println("Deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("No human found with the provided email.");
        }
    }



}
