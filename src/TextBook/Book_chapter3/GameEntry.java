package TextBook.Book_chapter3;

public class GameEntry {

    private String name;            // name of the person earning this score
    private int score;      // the score value;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if (numEntries < board.length || newScore > board[numEntries].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }

            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }

    /**
     * Remove and return the high score at index i
     */
    public GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index : " + i);
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
