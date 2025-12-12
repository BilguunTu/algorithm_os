package labTwo.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Энэхүү класс нь текстийн баримт бичиг доторх үсэг тус бүрийн давтамжийг тооцоолж,
// түүнийг консол дээр бар диаграм хэлбэрээр харуулна.
public class CharacterFrequencyChart {

    // Өгөгдсөн String баримт бичиг дэх үсгүүдийн давтамжийг тооцоолж Map-д хадгална.
    private static Map<Character, Integer> getFrequencyMap(String document) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : document.toCharArray()) {
            // Зөвхөн цагаан толгойн үсэг мөн эсэхийг шалгана.
            if (Character.isLetter(ch)) {
                // Үсгийг том үсэг рүү хөрвүүлэн тоолно (case-insensitive тоололт).
                char upperCaseCh = Character.toUpperCase(ch);
                // Давтамжийг Map-д нэмэх эсвэл одоо байгаа тоог 1-ээр нэмэгдүүлэх.
                frequencyMap.put(upperCaseCh, frequencyMap.getOrDefault(upperCaseCh, 0) + 1);
            }
        }
        return frequencyMap;
    }

    // Үсгийн давтамжийг агуулсан Map-ийг ашиглан консол дээр бар диаграмыг хэвлэнэ.
    private static void printBarChart(Map<Character, Integer> frequencyMap) {

        // 1. Хамгийн их давтамжийг олох (Диаграмын барын уртыг нормчлохын тулд).
        if (frequencyMap.isEmpty()) {
            System.out.println("Баримт бичигт цагаан толгойн үсэг олдсонгүй.");
            return;
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        final int MAX_BAR_LENGTH = 50; // Диаграмын хамгийн их урт.

        System.out.println("\n-------------------------------------------------------");
        System.out.println("  Үсэг тус бүрийн давтамжийн бар диаграм (A-Z)");
        System.out.println("-------------------------------------------------------");

        // 2. А-аас Z хүртэлх үсэг тус бүрийг эргэлтэнд оруулж хэвлэх.
        for (char c = 'A'; c <= 'Z'; c++) {
            int count = frequencyMap.getOrDefault(c, 0);
            // 3. Барын уртыг тооцоолох: (Одоогийн давтамж / Хамгийн их давтамж) * Макс урт.
            int barLength = (maxFrequency > 0)
                    ? (int) Math.round(((double) count / maxFrequency) * MAX_BAR_LENGTH)
                    : 0;

            // Барын дүрс (жишээлбэл: #####) -ийг үүсгэх.
            String bar = String.join("", Collections.nCopies(barLength, "#"));

            // 4. Үр дүнг хэвлэх: [Үсэг] [Тоо] [Бар]
            System.out.printf("%c (%4d) |%-50s|%n", c, count, bar);
        }
        System.out.println("-------------------------------------------------------");
        // Нийт тоологдсон үсгийн тоог хэвлэх.
        System.out.printf("  Нийт тоологдсон үсэг: %d%n",
                frequencyMap.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("-------------------------------------------------------");
    }

    // Өгөгдсөн файлын зам (filePath) -аас текстийн агуулгыг уншиж буцаана.
    private static String readDocumentFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        // "try-with-resources" ашиглан Scanner-ийг үүсгэх бөгөөд автоматаар хаагдана.
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            // Файлын бүх агуулгыг нэг String болгон унших.
            return scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
        }
    }

    // Програмын үндсэн эхлэх цэг.
    public static void main(String[] args) {
        String documentContent = "";

        // 1. Оролтын баримт бичгийг бэлдэх: Файл эсвэл Жишээ текст
        // АРГА 1: Жишээ текст ашиглах
        documentContent = "This is a sample document for testing the character frequency chart. The quick brown fox jumps over the lazy dog. Programming in Java is fun and useful for various tasks like data analysis and visualization!";
        System.out.println("*** Жишээ Текст Ашиглаж байна ***");
        System.out.println("Текст: " + documentContent.substring(0, Math.min(documentContent.length(), 100)) + "...");

        // АРГА 2: Файл унших (Файлын замыг өөрчилж болно!)
        String filePath = "document.txt"; // Файлынхаа замыг энд өөрчилнө үү!
        try {
            documentContent = readDocumentFromFile(filePath);
            System.out.println("=== '" + filePath + "' Файл Ашиглаж байна ===");
        } catch (FileNotFoundException e) {
            // Файл олохгүй тохиолдолд алдааны мэдээлэл өгөөд жишээ текст рүү шилжих.
            System.err.println("Алдаа: Файл олдсонгүй: " + filePath);
            System.err.println("Жишээ текст рүү шилжлээ.");
            documentContent = "This is fallback content.";
        }

        // 2. Давтамжийг тооцоолох
        Map<Character, Integer> frequencies = getFrequencyMap(documentContent);

        // 3. Бар диаграмыг хэвлэх
        printBarChart(frequencies);
    }
}
