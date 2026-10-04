package CricBuzz.Team;

import java.util.List;
import java.util.Queue;

import CricBuzz.Team.Player.PlayerBattingController;
import CricBuzz.Team.Player.PlayerBowlingController;
import CricBuzz.Team.Player.PlayerDetails;

public class Team {
    public String teamName;
    public Queue<PlayerDetails> playing11;
    public List<PlayerDetails> bench;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> bench,
            List<PlayerDetails> bowlers) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        this.battingController = new PlayerBattingController(playing11);
        this.bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsMan() throws Exception {
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler) {
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public PlayerDetails getStriker() {
        return battingController.getStriker();
    }

    public void setStriker(PlayerDetails player) {
        battingController.setStriker(player);
    }

    public PlayerDetails getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setNonStriker(PlayerDetails player) {
        battingController.setNonStriker(player);
    }

    public PlayerDetails getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for (PlayerDetails playerDetails : playing11) {
            playerDetails.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        for (PlayerDetails playerDetails : playing11) {
            // System.out.println("AKKI" + playerDetails.bowlingScoreCard.totalOversCount);
            if (playerDetails.bowlingScoreCard.totalOversCount > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns() {
        int totalRun = 0;
        for (PlayerDetails player : playing11) {
            totalRun += player.battingScoreCard.totalRuns;
        }

        return totalRun;
    }
}