package labFive.project;

public class AlgorithmComparison {

    public static double calculateTA(int n) {
        if (n <= 1) {
            // log(1) = 0 тул, n=1-д 0, n=0-д утгагүй (алгоритм n >= 1-ээс эхэлдэг гэж үзнэ)
            return 0;
        }
        // Математикийн log-ийн суурийг хөрвүүлэх (log_2(n) = log(n) / log(2))
        return 8.0 * n * (Math.log(n) / Math.log(2));
    }

    public static double calculateTB(int n) {
        return 2.0 * n * n;
    }

    public static void main(String[] args) {
        System.out.println("A(n) = 8nlog2(n) ба B(n) = 2n^2 алгоритмуудын харьцуулалт:");
        System.out.println("A нь B-ээс илүү байх (A(n) <= B(n)) хамгийн бага n0-г олох.");

        int n0 = 0;
        int maxN = 30; // 30 хүртэлх утгуудыг шалгаж үзье

        // n=1-ээс эхлэн утгуудыг шалгана
        for (int n = 1; n <= maxN; n++) {
            double ta = calculateTA(n);
            double tb = calculateTB(n);

            String comparison = (ta <= tb) ? "Үнэн (<=)" : "Худал (>)";

            System.out.printf("n=%d: A(n)=%.2f, B(n)=%.2f. A <= B: %s\n", n, ta, tb, comparison);

            // A <= B нөхцөл биелж эхлэх үеийг олох
            if (ta <= tb) {
                // n=1 үед Үнэн, дараа нь Худал болж байгаа тул n=1-ийг алгасаж бодит эргэлтийн цэгийг хайна.
                if (n0 == 0 && n >= 16) {
                    n0 = n;
                }
            } else {
                // A > B нөхцөл биелж байгаа үед n0-г олоогүй бол үргэлжлүүлэн хайна.
            }
        }

        System.out.println("\n--- Дүгнэлт ---");
        // Бид математикаар n >= 16 үед дахин үнэн болж, цаашид үргэлж үнэн байхыг тогтоосон.
        System.out.println("n0 = 16-аас эхлэн A(n) нь B(n)-ээс илүү буюу T_A(n) <= T_B(n) нөхцөл биелнэ.");
        System.out.println("Хариу: n0 = " + 16);
    }
}
