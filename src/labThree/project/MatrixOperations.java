package labThree.project;

public class MatrixOperations {

    public static int[][] add(int[][] A, int[][] B) {
        // 1. Матрицуудын хэмжээг шалгах
        if (A.length == 0 || B.length == 0 || A.length != B.length || A[0].length != B[0].length) {
            System.err.println("АЛДАА: Матрицуудыг нэмэхийн тулд тэдгээр нь ижил хэмжээтэй байх ёстой.");
            return null; // Нэмэх боломжгүй
        }

        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        // 2. Матрицын элементүүдийг нэмэх
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        // A-ийн хэмжээ: m x n
        int m = A.length;
        int n = A[0].length;

        // B-ийн хэмжээ: n x p
        int n2 = B.length;
        if (n2 == 0) {
            System.err.println("АЛДАА: Хоёр дахь матриц хоосон байна.");
            return null;
        }
        int p = B[0].length;

        // 1. Үржүүлэх боломжийг шалгах: A-ийн баганын тоо (n) нь B-ийн мөрийн тоо (n2) -тэй тэнцүү байх ёстой.
        if (n != n2) {
            System.err.println("АЛДАА: Матрицуудыг үржүүлэхийн тулд эхний матрицын баганын тоо нь хоёр дахь матрицын мөрийн тоотой тэнцүү байх ёстой.");
            return null; // Үржүүлэх боломжгүй
        }

        int[][] result = new int[m][p]; // Үржвэр матриц (m x p)

        // 2. Үржүүлэх үйлдлийг гүйцэтгэх:
        // Үржвэрийн C[i][j] элемент нь A-ийн i-р мөр болон B-ийн j-р баганын элементүүдийн үржвэрийн нийлбэр юм.
        for (int i = 0; i < m; i++) { // A-ийн мөрүүд
            for (int j = 0; j < p; j++) { // B-ийн баганууд
                for (int k = 0; k < n; k++) { // А-ийн баганууд/B-ийн мөрүүд
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix, String name) {
        if (matrix == null) {
            System.out.println(name + ": Үйлдлийг гүйцэтгэх боломжгүй эсвэл үр дүн null байна.");
            return;
        }

        System.out.println("\n--- " + name + " ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%4d", matrix[i][j]); // Элемент бүрийг 4 оронгийн зайтай хэвлэх
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        // --- Жишээ 1: Нэмэх үйлдэл (Ижил хэмжээтэй) ---
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8, 9},
            {10, 11, 12}
        };

        printMatrix(A, "Матриц А (2x3)");
        printMatrix(B, "Матриц B (2x3)");

        int[][] sum = add(A, B);
        printMatrix(sum, "А + В Нийлбэр");

        // --- Жишээ 2: Үржүүлэх үйлдэл (2x3 * 3x2) ---
        int[][] C = {
            {1, 2, 3}, // 2 x 3
            {4, 5, 6}
        };
        int[][] D = {
            {7, 8}, // 3 x 2
            {9, 10},
            {11, 12}
        };

        printMatrix(C, "Матриц C (2x3)");
        printMatrix(D, "Матриц D (3x2)");

        int[][] product = multiply(C, D); // Үр дүн: 2 x 2
        printMatrix(product, "С * D Үржвэр");

        // --- Жишээ 3: Нэмэх үйлдлийн алдаа (Янз бүрийн хэмжээ) ---
        int[][] E = {{1}, {2}};
        System.out.println("\n--- Нэмэх Алдааны жишээ ---");
        int[][] invalidSum = add(A, E); // 2x3 + 2x1 -> Алдаа
        printMatrix(invalidSum, "А + Е Нийлбэр");

        // --- Жишээ 4: Үржүүлэх үйлдлийн алдаа (Үл нийцэх хэмжээ) ---
        System.out.println("\n--- Үржүүлэх Алдааны жишээ ---");
        int[][] F = {
            {1, 2},
            {3, 4}
        }; // 2x2
        int[][] invalidProduct = multiply(C, F); // 2x3 * 2x2 -> Алдаа (3 != 2)
        printMatrix(invalidProduct, "С * F Үржвэр");
    }
}
