package labFive.project;

public class AlgorithmBigOEquivalenceExample {

    public static int selectionSort(int[] arr) {
        int n = arr.length;
        int operations = 0; // Үйлдлийн тоог тоолох

        // Гаднах давталт: n удаа гүйнэ
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Доторх давталт: (n-1) + (n-2) + ... + 1 удаа гүйнэ
            for (int j = i + 1; j < n; j++) {
                operations++; // Харьцуулалтын үйлдлийг тоолно
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Свап хийх (тогтмол хугацаа)
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        int n = 10;

        // 1. Хамгийн муу тохиолдол: Уруугаа эрэмбэлэгдсэн массив
        int[] worstCase = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int worstOps = selectionSort(worstCase);

        // 2. Хамгийн сайн тохиолдол: Зөв эрэмбэлэгдсэн массив
        int[] bestCase = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int bestOps = selectionSort(bestCase);

        // n-ийн хувьд O(n^2) гэдэг нь (n*(n-1)/2) харьцуулалт байна.
        int expectedOps = n * (n - 1) / 2;

        System.out.println("--- Сонгох-эрэмбэлэх алгоритмын жишээ (n=" + n + ") ---");
        System.out.println("Алгоритмын гүйцэтгэл нь O(n^2) байх ёстой.");
        System.out.println("n^2-ийн үндсэн харьцангуй тоо: " + expectedOps + " (" + n + "*( " + n + "-1)/2)");

        System.out.println("\n(b) Хамгийн муу тохиолдол:");
        System.out.println("Үйлдлийн тоо (Уруугаа эрэмбэлэгдсэн): " + worstOps);
        System.out.println("Нотлох нь: " + worstOps + " = " + expectedOps + ". Энэ нь O(n^2)-д багтана.");

        System.out.println("\n(a) Ажиллах хугацаа үргэлж:");
        System.out.println("Үйлдлийн тоо (Зөв эрэмбэлэгдсэн): " + bestOps);
        System.out.println("Нотлох нь: " + bestOps + " = " + expectedOps + ". Энэ нь O(n^2)-д багтана.");

        System.out.println("\nДүгнэлт:");
        System.out.println("Selection Sort-ийн хувьд T_best(n) = T_worst(n) = " + expectedOps + ". ");
        System.out.println("Тиймээс, A(n) үргэлж O(n^2) байх нь, A(n) хамгийн муу тохиолдолд O(n^2) байхтай тэнцүү байна.");
    }
}
