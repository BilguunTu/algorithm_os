package labSeven.exercise;

public class ArrayRecursion {

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
}
