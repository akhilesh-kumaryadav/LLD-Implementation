package CricBuzz.Inning;

import java.util.ArrayList;
import java.util.List;

import CricBuzz.Match.MatchType;
import CricBuzz.Team.Player.PlayerDetails;
import CricBuzz.Team.Team;

public class InningDetails {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<OverDetails> overs;

    public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void start(int runsToWin) {
        // Set batting players;
        try {
            battingTeam.chooseNextBatsMan();
        } catch (Exception e) {

        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {
            // Choose Bowler
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());

            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if (won == true) {
                    break;
                }
            } catch (Exception e) {
                break;
            }

            // Swap striker and not striker
            PlayerDetails temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }
}