
package mergesort;

public class LeaderboardEntry {
    private final String Username;
    private final int Score;

    public LeaderboardEntry(String Username, int Score) {
        this.Username = Username;
        this.Score = Score;
    }

    public String getUsername() {
        return Username;
    }

    public int getScore() {
        return Score;
    }
    
    
}
