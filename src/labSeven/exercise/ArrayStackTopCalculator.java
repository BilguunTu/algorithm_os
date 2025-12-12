package labSeven.exercise;

public class ArrayStackTopCalculator {

    public static void main(String[] args) {
        int numPush = 25;
        int numPop = 10;
        int numTop = 12; // t-д нөлөөлөхгүй
        int numIsEmpty = 3; // t-д нөлөөлөхгүй

        int t = -1;

        System.out.println("--- ArrayStack (t) хувьсагчийн өөрчлөлт ---");
        System.out.println("Эхний t утга: " + t);

        System.out.println("\n25 удаагийн PUSH үйлдэл:");
        for (int i = 0; i < numPush; i++) {
            t++;
        }
        System.out.println("Push хийсний дараах t-ийн утга: " + t); // -1 + 25 = 24

        System.out.println("\n10 удаагийн POP үйлдэл:");
        for (int i = 0; i < numPop; i++) {
            t--;
        }

        System.out.println("\n----------------------------------------");
        System.out.println("t хувьсагчийн ЭЦСИЙН УТГА: " + t); // 24 - 10 = 14
        System.out.println("----------------------------------------");

        System.out.println("Стекийн хэмжээ (Size): " + (t + 1));
    }
}
