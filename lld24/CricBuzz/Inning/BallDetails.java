package CricBuzz.Inning;

import java.util.ArrayList;
import java.util.List;

import CricBuzz.ScoreUpdater.BattingScoreUpdater;
import CricBuzz.ScoreUpdater.BowlingScoreUpdater;
import CricBuzz.ScoreUpdater.ScoreUpdaterObserver;
import CricBuzz.Team.Player.PlayerDetails;
import CricBuzz.Team.Team;
import CricBuzz.Team.Wicket;
import CricBuzz.Team.WicketType;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public PlayerDetails playedBy;
    public PlayerDetails bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        this.scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        this.scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {
        this.playedBy = battingTeam.getStriker();
        this.bowledBy = over.bowledBy;
        // Throw ball and get the ball type, assuming here that ball type is always
        // NORMAL
        ballType = BallType.NORMAL;

        // wicket or no wicket
        if (isWicketTaken()) {
            runType = RunType.ZERO;
            // considering only BOLD
            wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);
            // making only striker out for now;
            battingTeam.setStriker(null);
        } else {
            this.runType = getRunType();

            if (runType == RunType.ONE || runType == RunType.THREE) {
                // swap the striker and not striker;
                PlayerDetails temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

        // update player scoreboard
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails) {
        for (ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballDetails);
        }
    }

    private RunType getRunType() {
        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        // Random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }
}