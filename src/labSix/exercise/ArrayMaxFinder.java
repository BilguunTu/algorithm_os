package labSix.exercise;

public class ArrayMaxFinder {

    public static int findMaxRecursive(int[] arr, int n) {
        // 1. Үндсэн Суурь (Base Case): 1 элементтэй бол түүнийг буцаана.
        if (n == 1) {
            return arr[0];
        }

        // 2. Рекурсив Үйлдвэрлэл:
        // a. Эхний n-1 элементийн хамгийн ихийг олох (Рекурсив дуудлага)
        int maxOfRest = findMaxRecursive(arr, n - 1);

        // b. Сүүлийн элемент (arr[n-1]) болон maxOfRest-ын аль ихийг нь буцаана.
        return Math.max(arr[n - 1], maxOfRest);
    }

    public static void main(String[] args) {
        int[] A = {10, 324, 45, 90, 98, 1};
        int n = A.length;

        int maxElement = findMaxRecursive(A, n);

        System.out.println("Массив A: " + java.util.Arrays.toString(A));
        System.out.println("Массивын хамгийн их элемент (рекурсив): " + maxElement); // Гаралт: 324
    }
}
