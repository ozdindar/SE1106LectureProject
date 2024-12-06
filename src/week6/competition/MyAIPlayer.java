package week6.competition;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;

public class MyAIPlayer extends AIPlayer {
    public MyAIPlayer() {
        super("Your Name");
    }

    @Override
    protected void _initGame(int roundCount) {

    }

    @Override
    protected void _congratulate() {

    }

    @Override
    protected void _initRound(int r) {

    }

    @Override
    protected void _winRound() {

    }

    @Override
    protected Digits _makeAGuess() {
        return new Digits(100);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {

    }
}
