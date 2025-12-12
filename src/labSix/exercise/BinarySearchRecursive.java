package labSix.exercise;

public class BinarySearchRecursive {

    public static int binarySearch(int[] arr, int target, int low, int high) {

        // 1. Үндсэн Суурь (Base Case - Олдоогүй)
        // low > high гэдэг нь дэд массив хоосорсон, хайлт амжилтгүй болсон гэсэн үг.
        if (low > high) {
            return -1;
        }

        // Голын индексийг overflow-оос сэргийлэн тооцох.
        int mid = low + (high - low) / 2;

        // 2. Үндсэн Суурь (Base Case - Олдсон)
        if (arr[mid] == target) {
            return mid; // Элемент олдсон, индексийг буцаана.
        } // 3. Рекурсив Үйлдвэрлэл
        // Хэрэв голын элемент хайж буйгаас их бол зүүн талд хайна.
        else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        } // Хэрэв голын элемент хайж буйгаас бага бол баруун талд хайна.
        else { // arr[mid] < target
            return binarySearch(arr, target, mid + 1, high);
        }
    }

    // Хэрэглэх үндсэн функц
    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target1 = 23; // Олддог утга
        int target2 = 40; // Олддоггүй утга
        int n = sortedArray.length;

        // Хайлт 1: Олдсон
        int index1 = binarySearch(sortedArray, target1, 0, n - 1);
        System.out.println("Хайсан утга " + target1 + " (Олдсон): Индекс = " + index1);

        // Хайлт 2: Олдоогүй
        int index2 = binarySearch(sortedArray, target2, 0, n - 1);
        System.out.println("Хайсан утга " + target2 + " (Олдоогүй): Индекс = " + index2);
    }
}
