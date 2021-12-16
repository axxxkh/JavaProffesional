package LessonFour;

public class TaskTwo {
    public static void main(String[] args) {
        String someText = new String("Деякі з кращих книг для Java-програмістів, починаючи від ядра Java і " +
                "закінчуючи передовими практиками, модульним тестуванням і фреймворком Spring." +
                "Якщо ви Java-програміст і хочете знати, що почитати, щоб поліпшити свої знання Java " +
                "або стати кращим розробником, то ви потрапили в потрібне місце." +
                "У цій статті я збираюся поділитися деякими з кращих коли-небудь написаних книг з Java. " +
                "До цього я не розумів, як насправді використовувати інтерфейс. Мені вони здаються марними, " +
                "тому що ви не можете написати код, який би там щось робив. Але, прочитавши книгу, я зрозумів, " +
                "наскільки вони гарні з точки зору зменшення взаємозв'язку між різними частинами вашої програми." +
                "З цього моменту я прочитав багато книг з програмування, в основному пов'язаних з Java. Сьогодні я " +
                "збираюся поділитися 10 кращими книгами по Java, які повинен прочитати кожен розробник Java. Навіть " +
                "якщо деякі знання застаріли, велика частина того, що ви дізнаєтеся, допоможе вам розвинути ваші знання " +
                "і кар'єру на все життя.");

        String[] replaceWords = new String[]{"з", "і", "під", "на", "над"};
        for (String regex : replaceWords) {
            someText = someText.replaceAll(("\\b" + regex + "[.]?\\b"), "JAVA");
        }
        System.out.println(someText);
    }
}
