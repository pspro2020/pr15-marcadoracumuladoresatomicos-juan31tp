package dice;

import java.util.concurrent.atomic.LongAdder;

public class Tracker {

    private LongAdder resultOne = new LongAdder();
    private LongAdder resultTwo = new LongAdder();
    private LongAdder resultThree = new LongAdder();
    private LongAdder resultFour = new LongAdder();
    private LongAdder resultFive = new LongAdder();
    private LongAdder resultSix = new LongAdder();

    public void update(int throwResult) {
        switch (throwResult){
            case 1:
                resultOne.increment();
                break;
            case 2:
                resultTwo.increment();
                break;
            case 3:
                resultThree.increment();
                break;
            case 4:
                resultFour.increment();
                break;
            case 5:
                resultFive.increment();
                break;
            case 6:
                resultSix.increment();
                break;
        }
    }

    public void showScore() {
        System.out.println( "\n\nTotal times of face 1: " + getResultOne() + " times\n" +
                "Total times of face 2: " + getResultTwo() + " times\n" +
                "Total times of face 3: " + getResultThree() + " times\n" +
                "Total times of face 4: " + getResultFour() + " times\n" +
                "Total times of face 5: " + getResultFive() + " times\n" +
                "Total times of face 6: " + getResultSix() + " times\n\n");
    }

    public int getResultOne() {
        return resultOne.intValue();
    }

    public int getResultTwo() {
        return resultTwo.intValue();
    }

    public int getResultThree() {
        return resultThree.intValue();
    }

    public int getResultFour() {
        return resultFour.intValue();
    }

    public int getResultFive() {
        return resultFive.intValue();
    }

    public int getResultSix() {
        return resultSix.intValue();
    }
}
