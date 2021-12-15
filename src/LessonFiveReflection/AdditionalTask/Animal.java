package LessonFiveReflection.AdditionalTask;

import java.time.LocalDateTime;

public class Animal {
    private final String name = "asd";
    protected LocalDateTime birthTime = LocalDateTime.now();
    public String sex = "male";

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthTime=" + birthTime +
                ", sex='" + sex + '\'' +
                '}';
    }
}
