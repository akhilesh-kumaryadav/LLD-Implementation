package CricBuzz.Team.Player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<PlayerDetails> bowlersList;
    Map<PlayerDetails, Integer> bowlerVsOverCount;
    PlayerDetails currentBowler;

    public PlayerBowlingController(List<PlayerDetails> bowlers) {
        setBowlersList(bowlers);
    }

    private void setBowlersList(List<PlayerDetails> bowlersList) {
        this.bowlersList = new LinkedList<>();
        this.bowlerVsOverCount = new HashMap<>();

        for (PlayerDetails bowler : bowlersList) {
            this.bowlersList.addLast(bowler);
            this.bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        PlayerDetails playerDetails = bowlersList.poll();

        if (bowlerVsOverCount.get(playerDetails) + 1 == maxOverCountPerBowler) {
            this.currentBowler = playerDetails;
        } else {
            this.currentBowler = playerDetails;
            this.bowlersList.addLast(playerDetails);
            this.bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails) + 1);
        }
    }

    public PlayerDetails getCurrentBowler() {
        return currentBowler;
    }
}