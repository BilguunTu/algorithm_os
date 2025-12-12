package labTwo.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

// Animal анхны класс. Бүх амьтдын үндсэн шинж чанаруудыг агуулна.
class Animal {

    private final String id;
    private final String type;
    private final boolean isMale; // true: Male (Эр), false: Female (Эм)
    private final float strength;

    public Animal(String type, boolean isMale, float strength) {
        this.id = UUID.randomUUID().toString().substring(0, 8); // Unique ID
        this.type = type;
        this.isMale = isMale;
        this.strength = strength;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isMale() {
        return isMale;
    }

    public float getStrength() {
        return strength;
    }

    // Хүйсний нэрийг буцаах туслах функц
    public String getGenderString() {
        return this.isMale ? "Эр" : "Эм";
    }

    @Override
    public String toString() {
        return String.format("%s [ID:%s, Хүйс:%s, Хүч:%.2f]",
                type, id, getGenderString(), strength);
    }
}

// Lion Animal-ийн нэг төрөл. 
class Lion extends Animal {

    public Lion(boolean isMale, float strength) {
        super("Арслан", isMale, strength);
    }
}

// CollisionSimulation Симуляцийн үндсэн логик болон main функц. 
public class CollisionSimulation {

    private static final Random RANDOM = new Random();
    private static int totalOffspringCount = 0;

    public static void main(String[] args) {
        // Эхний амьтдыг үүсгэх (Эр, Эм, Хүчний ялгаатай)
        List<Animal> population = initializePopulation();
        System.out.println("Симуляцийн Эхлэл: " + population.size() + " амьтан.");
        printPopulation(population);

        final int SIMULATION_STEPS = 5;

        // Симуляцийн алхмуудыг гүйцэтгэх
        for (int step = 1; step <= SIMULATION_STEPS; step++) {
            System.out.println("\n--- АЛХАМ " + step + " ---");
            if (population.size() < 2) {
                System.out.println("Хангалттай амьтан үлдсэнгүй. Симуляци дууслаа.");
                break;
            }

            // Санамсаргүй байдлаар хоёр амьтан сонгож мөргөлдүүлэх
            processRandomCollision(population);
            printPopulation(population);
        }

        System.out.println("\n--------------------------------");
        System.out.println("СИМУЛЯЦИЙН ТӨГСГӨЛ");
        System.out.println("Үлдсэн амьтдын тоо: " + population.size());
        System.out.println("Нийт үржүүлсэн тоо: " + totalOffspringCount);
        System.out.println("--------------------------------");
    }

    // Симуляцийг эхлүүлэх амьтдын жагсаалтыг үүсгэнэ.
    private static List<Animal> initializePopulation() {
        List<Animal> animals = new ArrayList<>();
        // Эрэгтэй Арслангууд
        animals.add(new Lion(true, 5.5f));
        animals.add(new Lion(true, 7.8f)); // Хамгийн хүчтэй эр
        animals.add(new Lion(true, 4.2f));
        // Эмэгтэй Арслангууд
        animals.add(new Lion(false, 6.1f));
        animals.add(new Lion(false, 3.9f));
        animals.add(new Lion(false, 7.1f)); // Хамгийн хүчтэй эм
        return animals;
    }

    // Санамсаргүй хоёр амьтан сонгож мөргөлдөөнийг боловсруулна. 
    private static void processRandomCollision(List<Animal> population) {
        if (population.size() < 2) {
            return;
        }

        // Санамсаргүй хоёр индекс сонгох
        int index1 = RANDOM.nextInt(population.size());
        int index2;
        do {
            index2 = RANDOM.nextInt(population.size());
        } while (index1 == index2); // Ижил амьтан сонгохгүй байх

        Animal a1 = population.get(index1);
        Animal a2 = population.get(index2);

        System.out.printf("Мөргөлдөөн: %s | %s%n", a1.toString(), a2.toString());

        // Төрлийг шалгах - Зөвхөн ижил төрөл мөргөлдөнө гэж үзье.
        if (!a1.getType().equals(a2.getType())) {
            System.out.println(" -> Төрөл өөр тул юу ч болохгүй.");
            return;
        }

        // Шинэ мөргөлдөөний логикийг хэрэгжүүлэх
        if (a1.isMale() != a2.isMale()) {
            // ДҮРЭМ 1: Ижил төрөл, Өөр хүйс -> Үржилд орж, шинэ амьтан үүсгэх
            Animal offspring = createOffspring(a1, a2);
            population.add(offspring);
            totalOffspringCount++;
            System.out.println(" -> Үржилд орлоо: Шинэ төл: " + offspring.toString());
        } else {
            // ДҮРЭМ 2: Ижил төрөл, Ижил хүйс -> Хүчээрээ өрсөлдөх
            Animal winner = a1.getStrength() >= a2.getStrength() ? a1 : a2;
            Animal loser = winner.equals(a1) ? a2 : a1;

            population.remove(loser);

            System.out.printf(" -> Ижил хүйс, Өрсөлдөөн: %s яллаа. %s устлаа.%n",
                    winner.getId(), loser.getId());
        }
    }

    //Хоёр эцэг эхээс шинэ амьтан үүсгэх (Хүйс болон Хүч санамсаргүй).
    private static Animal createOffspring(Animal parent1, Animal parent2) {
        // Төлийн хүйсийг санамсаргүй сонгох
        boolean offspringIsMale = RANDOM.nextBoolean();

        // Хүчийг эцэг эхийн хүчний дундаж дээр санамсаргүй хэлбэлзэл нэмэх
        float avgStrength = (parent1.getStrength() + parent2.getStrength()) / 2.0f;
        float newStrength = avgStrength + (RANDOM.nextFloat() * 2.0f - 1.0f); // +/- 1.0 хүртэлх хэлбэлзэл

        // Хүчийг сөрөг тоо гаргахгүй байхыг баталгаажуулах
        if (newStrength < 1.0f) {
            newStrength = 1.0f;
        }

        // Шинэ Lion объект үүсгэх (Төрөл нь эцэг эхийнхтэй ижил)
        return new Lion(offspringIsMale, newStrength);
    }

    // Одоогийн популяцийн байдлыг хэвлэх.
    private static void printPopulation(List<Animal> population) {
        System.out.println("\nОдоогийн Популяци (" + population.size() + "):");

        // Хүчээр нь эрэмбэлж хэвлэх
        List<Animal> sortedPopulation = population.stream()
                .sorted((a, b) -> Float.compare(b.getStrength(), a.getStrength()))
                .collect(Collectors.toList());

        for (Animal a : sortedPopulation) {
            System.out.println(" - " + a);
        }
    }
}
