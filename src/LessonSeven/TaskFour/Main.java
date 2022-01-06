package LessonSeven.TaskFour;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // з цим так і не вийшло толком. і наче бібліотеку додав через Мейвен. і класи імпортуються без проблем
/*        javax.xml.bind.JAXBException: Implementation of JAXB-API has not been found on module path or classpath.
                - with linked exception:
[java.lang.ClassNotFoundException: com.sun.xml.internal.bind.v2.ContextFactory]
        at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:278)*/
        Adress adress = new Adress("Big", "Kiev", "New Street", "122-3d");
        Adress adress1 = new Adress("small", "Jashkiv", "old Street", "1");
        Adress adress2;
        try {
            File file = new File("src/LessonSeven/TaskFour/city2.xml");
            JAXBContext jabx = JAXBContext.newInstance(adress.getClass());
            Marshaller marshaller = jabx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(adress, file);
            marshaller.marshal(adress, System.out);
            Unmarshaller unmarshaller = jabx.createUnmarshaller();
            adress2 = (Adress) unmarshaller.unmarshal(file);
            System.out.println(adress2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
