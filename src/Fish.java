import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fish extends Thread {

    private Gender gender;
    private String name;
    private int lifeTime;
    private static final Random random = new Random();
    private static final CopyOnWriteArrayList<Fish> aquarium = new CopyOnWriteArrayList<>();

    public Fish(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.lifeTime = 1 + random.nextInt(10);
        System.out.println(name + "(" + gender + ") tug'uldi . yashash muddati: " + lifeTime + " kun");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < lifeTime; i++) {
                Thread.sleep(1000);
                if (gender.equals(Gender.MALE)) {
                    Fish mate = findMate();
                    if (mate != null) {
                        giveBirth(mate);
                    }
                }
                System.out.println(name + " (" + gender + ") yashayapti. Qolgan kunlar: " + (lifeTime - i - 1));
            }
        } catch (InterruptedException e) {
            System.out.println(name + " uzildi.");
        }
        System.out.println(name + " (" + gender + ") o'ldi.");
        aquarium.remove(this);
    }




    private Fish findMate() {
        for (Fish fish : aquarium) {
            if (fish != this && fish.gender.equals(Gender.MALE)) {
                System.out.println(name + " fish " + "(" + gender + " ) and " + fish.name + "(" + fish.gender + ") has met");
            }
        }
        return null;
    }


    private void giveBirth(Fish mate) {
        Gender gender1 = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        String fishName = "Fish" + (aquarium.size() + 1);

        Fish fish = new Fish(fishName, gender1);
        aquarium.add(fish);
        Thread thread = new Thread(fish);
        thread.start();
        System.out.println("fish has been added to the list");
    }

    public static void addFish(Fish fish) {
        aquarium.add(fish);
        Thread thread = new Thread(fish);
        thread.start();
    }
}
