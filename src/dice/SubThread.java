package dice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SubThread implements Runnable{

    private static final DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
    private static final int NTHROWS = 10000;
    Dice dice;
    Tracker tracker;

    public SubThread(Dice dice, Tracker tracker) {
        this.dice=dice;
        this.tracker=tracker;
    }

    public void run() {
        for (int i=0; i<NTHROWS; i++){
            System.out.println(LocalTime.now().format(dateTimeFormatter) + " -> " + Thread.currentThread().getName() + ": Throwing dice");
            tracker.update(dice.throwIt());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
