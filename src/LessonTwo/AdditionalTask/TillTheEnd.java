package LessonTwo.AdditionalTask;

import java.util.*;

public class TillTheEnd {
    public List<String> list = new ArrayList<>();
    public Scanner input = new Scanner(System.in);

    public void printAll() {
        // о, тут потихеньку зявляеться розуміння. хоча може і не вірно реалізовано
        list.stream().forEach(myString -> System.out.printf("%s\n", myString));

        // ну і звичайні методи
        for (String string : list) {
            System.out.println(string);
        }

        Iterator<String> stringIterator = list.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    public void input() {
        while (true) {
            String string;
            string = input.nextLine();
            if ("end".equals(string)) {
                break;
            }
            list.add(string);
        }
    }

    public static void main(String[] args) {
        TillTheEnd printItAll = new TillTheEnd();
        printItAll.input();
        printItAll.printAll();
    }
}
