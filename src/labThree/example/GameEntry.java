package labThree.example;

public class GameEntry {

    private String name;
    private int score;

    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getString() {
        return "(" + name + "," + score + ")";
    }
}
