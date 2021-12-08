package LessonTwo.TaskTwo;

import java.util.*;

public class MyCollection {
    List<String> myCollection = new LinkedList<>();
    Scanner input = new Scanner(System.in);
    char[] charArray;

    public void doubleValues() {
        ListIterator<String> iter = myCollection.listIterator();
        String myString;

        while (iter.hasNext()) {
            myString = iter.next();
            iter.add(myString);

//             не уважно перший раз прочитав задачу, але в принципі вийшло подвоїти символи
//            charArray = myString.toCharArray();
//            char[] charArrayTemp = new char[charArray.length*2];
//            for (int i = 0; i < charArray.length; i++) {
//                charArrayTemp[i * 2] = charArray[i];
//                charArrayTemp[i * 2 + 1] = charArray[i];
//            }
//            iter.set(Arrays.toString(charArrayTemp));
        }
    }

    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        System.out.println("Enter five words divided by enter");
        myCollection.myCollection.add(myCollection.input.nextLine());
        myCollection.myCollection.add(myCollection.input.nextLine());
        myCollection.myCollection.add(myCollection.input.nextLine());
        myCollection.myCollection.add(myCollection.input.nextLine());
        myCollection.doubleValues();
        System.out.println(myCollection.myCollection.toString());
    }
}
