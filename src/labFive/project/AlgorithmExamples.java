package labFive.project;

public class AlgorithmExamples {

    public static int example1(int[] arr) {
        int n = arr.length;
        int total = 0;
        // O(n) давталт
        for (int j = 0; j < n; j++) {
            total += arr[j];
        }
        return total;
    }

    public static int example2(int[] arr) {
        int n = arr.length;
        int total = 0;
        // O(n/2) -> O(n) давталт
        for (int j = 0; j < n; j += 2) {
            total += arr[j];
        }
        return total;
    }

    public static int example3(int[] arr) {
        int n = arr.length;
        int total = 0;
        // Гаднах давталт: n удаа (j)
        for (int j = 0; j < n; j++) // Доторх давталт: 1, 2, 3, ..., n удаа (k)
        {
            for (int k = 0; k <= j; k++) {
                total += arr[j]; // Энэ нь утгыг нэмэх үйлдэл

            }
        }
        return total;
    }

    public static int example4(int[] arr) {
        int n = arr.length;
        int prefix = 0;
        int total = 0;
        // O(n) давталт
        for (int j = 0; j < n; j++) {
            prefix += arr[j]; // O(1)
            total += prefix;  // O(1)
        }
        return total;
    }

    public static int example5(int[] first, int[] second) {
        int n = first.length;
        int count = 0;

        // Гаднах давталт: n удаа (i)
        for (int i = 0; i < n; i++) {
            int total = 0;

            // Доторх үүрлэсэн давталтууд (Example 3-тай ижил): O(n^2)
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= j; k++) {
                    total += first[k];
                }
            }

            if (second[i] == total) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5}; // n=5
        int[] data2 = {1, 3, 6, 10, 15}; // 5 элементтэй

        System.out.println("--- Кодны жишээнүүдийн Big-Oh анализ ---");

        // Example 1: O(n)
        System.out.println("1. example1 (O(n)): Нийлбэр = " + example1(data));

        // Example 2: O(n)
        System.out.println("2. example2 (O(n)): Тэгш индексийн нийлбэр (arr[0]+arr[2]+arr[4]) = " + example2(data));

        // Example 3: O(n^2)
        // Анхааруулга: Таны өгсөн код arr[j]-г нэмдэг нь математикийн хувьд prefix sum-ийн нийлбэрийг тооцоолохгүй, 
        // харин гүйцэтгэлийн хувьд O(n^2) хэвээр үлдэнэ. 
        System.out.println("3. example3 (O(n^2)): Үйлдлийн үр дүн = " + example3(data));

        // Example 4: O(n)
        System.out.println("4. example4 (O(n)): Prefix sums-ийн нийлбэр = " + example4(data));

        // Example 5: O(n^3)
        // data массивын O(n^2) гүйлтийн total-ийн үр дүн нь n*(n+1)/2 = 15. 
        // data2-т total=15-тай тэнцэх 1 удаагийн тохиолдол байна.
        System.out.println("5. example5 (O(n^3)): Тохирох тоо = " + example5(data, data2));
    }
}
