package LessonFour;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class TaskThree {

    public void dateFrom(LocalDateTime dateTimeFrom) {
        LocalDateTime now = LocalDateTime.now();
        Period period = Period.between(dateTimeFrom.toLocalDate(), now.toLocalDate());
        Duration duration;

        if (dateTimeFrom.toLocalTime().compareTo(now.toLocalTime()) < 0) {
            duration = Duration.between(dateTimeFrom.toLocalTime(), now.toLocalTime());
        } else {
            duration = Duration.between(now.toLocalTime(), dateTimeFrom.toLocalTime());
            period = period.minusDays(1);
        }

        int years = period.getYears();
        int month = period.getMonths();
        int days = period.getDays();
        System.out.println(dateTimeFrom.toLocalTime().compareTo(now.toLocalTime()));

        long hours = duration.toHoursPart();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        System.out.printf("Difference between dates is %d - years, %d - month, %d - days, " +
                "%d - hours, %d - minutes, %d - seconds \n", years, month, days, hours, minutes, seconds);
    }

    public static void main(String[] args) {
        TaskThree dateCounter = new TaskThree();
        LocalDateTime birthDateTime = LocalDateTime.of(1988, 11, 11, 17, 11, 11);
        dateCounter.dateFrom(birthDateTime);
    }

}
