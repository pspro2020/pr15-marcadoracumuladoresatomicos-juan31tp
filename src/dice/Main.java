package dice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    private static final DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
    private static final int NTHREADS = 3;

    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Dice dice = new Dice();
        Thread[] subThreads = new Thread[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {
            subThreads[i] = new Thread(new SubThread(dice, tracker), "Subthread # " + i);
        }

        threadStarter(subThreads);

        for(int i=0; i<NTHREADS; i++){
            try {
                subThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(LocalTime.now().format(dateTimeFormatter) + " -> " + Thread.currentThread().getName() + ": Exception during the join.");
            }
        }

        tracker.showScore();

    }

    private static void threadStarter(Thread[] threads) {
        for (int i=0; i<NTHREADS; i++){
            threads[i].start();
        }
    }

}
