package airport;

import java.util.Random;
public class Weather {
    Random random;

    public Boolean isStorm(){
        random = new Random();
        return random.nextBoolean();
    }
}
