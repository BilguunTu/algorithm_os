package labFive.project;

public class AlgorithmEvenNumberSum {

    public static long sumEvenNumbers_Iterative(int n) {
        if (n < 1) {
            return 0; // n >= 1 гэсэн нөхцөлтэй тул 0-г буцаана.
        }

        long sum = 0;
        int limit = 2 * n; // Нийлбэрийг олох дээд хязгаар

        // 0, 2, 4, ..., 2n тоонуудыг нэмнэ.
        for (int i = 0; i <= limit; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static long sumEvenNumbers_Formula(int n) {
        if (n < 1) {
            return 0;
        }
        // Томьёо: n * (n + 1)
        // Үр дүн их байх магадлалтай тул n-ийг long болгож үржүүлнэ.
        return (long) n * (n + 1);
    }

    public static void main(String[] args) {
        int n1 = 5; // 0-ээс 10 хүртэл (0+2+4+6+8+10 = 30)
        int n2 = 10; // 0-ээс 20 хүртэл (0+2+...+20 = 110)
        int n3 = 100; // 0-ээс 200 хүртэл

        System.out.println("--- Давталт ашигласан арга (O(n)) ---");
        System.out.printf("n=%d (0-10): Нийлбэр = %d\n", n1, sumEvenNumbers_Iterative(n1));
        System.out.printf("n=%d (0-20): Нийлбэр = %d\n", n2, sumEvenNumbers_Iterative(n2));
        System.out.printf("n=%d (0-200): Нийлбэр = %d\n", n3, sumEvenNumbers_Iterative(n3));

        System.out.println("\n--- Томьёо ашигласан арга (O(1)) ---");
        System.out.printf("n=%d (0-10): Нийлбэр = %d\n", n1, sumEvenNumbers_Formula(n1)); // 5 * 6 = 30
        System.out.printf("n=%d (0-20): Нийлбэр = %d\n", n2, sumEvenNumbers_Formula(n2)); // 10 * 11 = 110
        System.out.printf("n=%d (0-200): Нийлбэр = %d\n", n3, sumEvenNumbers_Formula(n3)); // 100 * 101 = 10100
    }
}
