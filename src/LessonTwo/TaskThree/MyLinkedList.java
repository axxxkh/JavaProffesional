package LessonTwo.TaskThree;

import java.util.*;

public class MyLinkedList {
    public List<Integer> myList = new LinkedList<>();
    public Scanner input = new Scanner(System.in);

    private int checkNumber() {
        do {
            try {
                return input.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("it's not a integer. try to enter only digits");
                input.nextLine();
            }
        } while (true);
    }

    public int getMinimum() {
        int minNumber = myList.get(0);
        int iteratorValue;
        Iterator<Integer> iterator = myList.listIterator();

// проба пера, хотів всі варіанти реалізувати

        minNumber = myList.stream().mapToInt(o -> o).min().orElse(minNumber);
        return minNumber;
//
//        while (iterator.hasNext()) {
//            iteratorValue = iterator.next();
//            if (iteratorValue < minNumber) {
//                minNumber = iteratorValue;
//            }
//        }
//        return minNumber;

//        for (int i : myList) {
//            if (minNumber > i) {
//                minNumber = i;
//            }
//        }
//        return minNumber;
    }

    public void getIntegerList(int numberOfLines) {
        System.out.printf("\nEnter %d numbers divided by enter", numberOfLines);
        for (int i = 0; i < numberOfLines; i++) {
            myList.add(checkNumber());
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("Enter number of numbers you want to input");
        myLinkedList.getIntegerList(myLinkedList.checkNumber());
        System.out.println(myLinkedList.getMinimum());
    }
}
