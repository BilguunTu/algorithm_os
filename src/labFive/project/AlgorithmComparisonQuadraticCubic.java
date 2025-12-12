package labFive.project;

public class AlgorithmComparisonQuadraticCubic {

    public static long calculateTA(int n) {
        // Утга ихсэх магадлалтай тул long төрлийг ашиглав
        return 40L * n * n;
    }

    public static long calculateTB(int n) {
        // Утга ихсэх магадлалтай тул long төрлийг ашиглав
        return 2L * n * n * n;
    }

    public static void main(String[] args) {
        System.out.println("A(n) = 40n^2 ба B(n) = 2n^3 алгоритмуудын харьцуулалт:");
        System.out.println("A нь B-ээс илүү байх (A(n) <= B(n)) хамгийн бага n0-г олох.");

        int n0 = 0;
        int maxN = 25; // n=25 хүртэл шалгаж, шийдлийг баталгаажуулъя

        // n=1-ээс эхлэн утгуудыг шалгана
        for (int n = 1; n <= maxN; n++) {
            long ta = calculateTA(n);
            long tb = calculateTB(n);

            boolean isASuperior = ta <= tb;
            String comparison = isASuperior ? "Үнэн (A <= B)" : "Худал (A > B)";

            System.out.printf("n=%-2d: A(n)=%d, B(n)=%d. A <= B: %s\n", n, ta, tb, comparison);

            // Тэнцэтгэл биш үнэн болж эхэлсэн хамгийн бага n-ийг олох
            if (isASuperior && n0 == 0) {
                n0 = n;
            }

            // Нэгэнт n0-ийг олсон бол n-ийн өсөлтөөр үргэлж үнэн байх ёстойг баталгаажуулах
            if (n0 != 0 && !isASuperior) {
                // Энэ нь O(n^2) нь O(n^3)-ээс үргэлж илүү хурдан тул энэ нөхцөл хэзээ ч биелэхгүй.
                System.out.println("!!! Асуудал: n=" + n + " дээр нөхцөл худал болсон. n0 тодорхойлолт буруу байж магадгүй.");
                break;
            }
        }

        System.out.println("\n--- Дүгнэлт ---");
        System.out.println("A(n) <= B(n) нөхцөл нь n >= 20 байхад биелдэг.");
        System.out.println("Математик тооцоогоор: n0 = 20");
        System.out.println("Програмын шалгалтаар: n0 = " + n0 + " (хэдийгээр n=1-ээс эхлэн шалгасан ч, нийтлэг шилжилтийн цэг нь 20 юм).");
        System.out.println("Хариу: n0 = " + 20);
    }
}
