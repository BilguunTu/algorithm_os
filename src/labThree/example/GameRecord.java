package labThree.example;

public class GameRecord {

    public static class Scoreboard {

        private int numEntries = 0;
        private GameEntry[] board;

        public Scoreboard(int capacity) {
            board = new GameEntry[capacity];
        }

        public void add(GameEntry e) {
            int newScore = e.getScore();
            if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
                if (numEntries < board.length) {
                    numEntries++;
                }
                int j = numEntries - 1;
                while (j > 0 && board[j - 1].getScore() > newScore) {
                    board[j] = board[j - 1];
                    j--;
                }
                board[j] = e;
            }
        }

        public GameEntry remove(int i) throws IndexOutOfBoundsException {
            if (i < 0 || i >= numEntries) {
                throw new IndexOutOfBoundsException("Invalid index: " + i);
            }

            GameEntry temp = board[i];

            for (int j = i; j < numEntries - 1; j++) {
                board[j] = board[j + 1];
            }

            board[numEntries - 1] = null;

            numEntries--;
            return temp;
        }
    }

    public static void main(String[] args) {

        Scoreboard highscores = new Scoreboard(8);

        String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};

        int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

        GameEntry records;
        for (int i = 0; i < names.length; i++) {

            records = new GameEntry(names[i], scores[i]);

            highscores.add(records);
        }

        System.out.println("scores, one" + highscores);
        for (int i = 0; i < highscores.numEntries; i++) {
            System.out.println(i + ".  " + highscores.board[i].toString());
        }

        System.out.println("\nRemove element - " + highscores.remove(4).toString() + "\n");

        for (int i = 0; i < highscores.numEntries; i++) {
            System.out.println(i + ".  " + highscores.board[i].toString());
        }

    }

}
