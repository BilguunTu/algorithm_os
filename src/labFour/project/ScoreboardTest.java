package labFour.project;

public class ScoreboardTest {

    public static void main(String[] args) {
        Scoreboard board = new Scoreboard(10); // Дээд тал нь 10 оноо хадгална

        // Оноо нэмэх
        board.add(new GameEntry("Alice", 100));
        board.add(new GameEntry("Bob", 80));
        board.add(new GameEntry("Charlie", 150));
        board.add(new GameEntry("David", 50));
        board.add(new GameEntry("Eve", 120));

        board.printScores();
        // Үр дүн: 150, 120, 100, 80, 50

        // Онооны самбарыг дүүргэж, хэтрүүлэн нэмэх
        board.add(new GameEntry("Fiona", 90));
        board.add(new GameEntry("George", 110));
        board.add(new GameEntry("Hannah", 60));
        board.add(new GameEntry("Ian", 70));
        board.add(new GameEntry("Jack", 130)); // 10 дахь оноо

        board.printScores();

        // 11 дэх оноо (Хамгийн бага онооноос их тул нэмэгдэж, хамгийн бага нь хасагдана)
        board.add(new GameEntry("Kelly", 50)); // Оноо 50. Хамгийн бага оноо 50-тай тэнцүү тул хадгалагдахгүй.
        board.add(new GameEntry("Liam", 140)); // Оноо 140. Нэмэгдээд, хамгийн бага оноо (50) хасагдана.

        board.printScores();

        // Эхний оноог хасах (Индекс 0)
        try {
            GameEntry removed0 = board.remove(0);
            System.out.println("\nХасагдсан: " + removed0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        board.printScores();

        // Индекс 5 дээрх оноог хасах
        try {
            GameEntry removed5 = board.remove(5);
            System.out.println("\nХасагдсан: " + removed5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        board.printScores();
    }
}
