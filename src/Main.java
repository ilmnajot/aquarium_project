import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();


        int maleCount = 1 + random.nextInt(5);
        int femaleCount = 1 + random.nextInt(5);

        System.out.println("Akvariumda " + maleCount + " ta erkak va " + femaleCount + " ta urg'ochi baliq bor.");


        for (int i = 0; i < maleCount; i++) {
            String name = "Erkak Baliq " + (i + 1);
            Fish maleFish = new Fish(name, Gender.MALE);
            Fish.addFish(maleFish);
        }

        for (int i = 0; i < femaleCount; i++) {
            String name = "Urg'ochi Baliq " + (i + 1);
            Fish femaleFish = new Fish(name, Gender.FEMALE);
            Fish.addFish(femaleFish);
        }
    }
}