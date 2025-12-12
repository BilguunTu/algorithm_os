package labSeven.exercise;

public class ArrayRecursionBinarySearch {

    public static int findMax(int[] A, int n) {
        // Суурь Тохиолдол: Ганцхан элементтэй
        if (n == 1) {
            return A[0];
        }

        // Рекурсив Тохиолдол:
        int maxOfRest = findMax(A, n - 1);

        // Олдсон хамгийн их утга болон A[n-1]-ийг харьцуулж, ихийг нь буцаана.
        return Math.max(maxOfRest, A[n - 1]);
    }

    public static int binarySearch(int[] A, int target, int low, int high) {
        // Суурь Тохиолдол 1: Хайх хэсэг байхгүй (Олдоогүй)
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        // Суурь Тохиолдол 2: Олдсон
        if (target == A[mid]) {
            return mid;
        } // Рекурсив Тохиолдол:
        else if (target < A[mid]) {
            // Зүүн талд хайх
            return binarySearch(A, target, low, mid - 1);
        } else {
            // Баруун талд хайх
            return binarySearch(A, target, mid + 1, high);
        }
    }
}
