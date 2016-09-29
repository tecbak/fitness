package fitness;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DailyStatistics {
    private Fitness fitness;

    private LocalDate date0;
    private LocalTime time00;
    private LocalTime time01;
    private LocalDateTime dateTime00;
    private LocalDateTime dateTime01;

    private LocalDate date1;
    private LocalTime time10;
    private LocalDateTime dateTime10;

    @Before
    public void setUp() throws Exception {
        fitness = new Fitness();

        //Date, time and datetime of the first day
        date0 = LocalDate.of(2016, 1, 1);
        time00 = LocalTime.of(12, 30);
        time01 = LocalTime.of(15, 25);
        dateTime00 = LocalDateTime.of(date0, time00);
        dateTime01 = LocalDateTime.of(date0, time01);

        //Date, time and datetime of the second day
        date1 = LocalDate.of(2016, 1, 10);
        time10 = LocalTime.of(10, 10);
        dateTime10 = LocalDateTime.of(date1, time10);
    }

    @Test
    public void waterLeft() throws Exception {
        final int waterDailyNorm = 3000;
        final int ml00 = 100;
        final int ml01 = 200;
        final int ml10 = 300;

        fitness.setWaterDailyNorm(waterDailyNorm);

        //Drink twice at one day
        fitness.drink(ml00, dateTime00);
        fitness.drink(ml01, dateTime01);

        //Drink once at another day
        fitness.drink(ml10, dateTime10);

        int expected = waterDailyNorm - (ml00 + ml01);
        int left = fitness.waterLeft(date0);

        assertThat(left, is(expected));
    }
}