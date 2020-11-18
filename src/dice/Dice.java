package dice;

import java.util.Random;

public class Dice {

    private Random rnd = new Random();

    public int throwIt(){
        return rnd.nextInt(6)+1;
    }

}
