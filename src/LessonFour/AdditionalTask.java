package LessonFour;

import java.util.Scanner;

public class AdditionalTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter login of latin letters");
        String login;
        String password;

        do {
            login = input.nextLine();
        } while (!login.matches("^[a-zA-Z]+$"));

        System.out.println("Enter login of numbers, characters and letters");
        do {
            password = input.nextLine();
        } while (!password.matches("^[0-9]*$"));
    }
}
