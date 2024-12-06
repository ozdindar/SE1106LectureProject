package week6.competition;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;
import week6.MasterMindUtils;
import week6.utils.RandomSource;

import java.util.ArrayList;

public class AliBeratTopcuAI extends AIPlayer {

    private MasterMindUtils masterMindUtils = new MasterMindUtils();

    ArrayList<Digits> matchpool = new ArrayList<>();
    ArrayList<Digits> roundpool = new ArrayList<>();
    RandomSource randomSource = new RandomSource();





    public AliBeratTopcuAI() {
        super("Ali Berat Topcu");
    }
    //game pool of digits digits shouldnt have duplicate digits so no 1102 no 1111 no 1223 etc dynamicly so if  digitcount changes still functions
    private void initmainpool() {
        for (int i = (int)Math.pow(10, digitCount-1); i < Math.pow(10, digitCount); i++) {
            Digits digits = new Digits(i);
            if (masterMindUtils.isValid(digits,digitCount))
                matchpool.add(digits);

        }
    }


    @Override
    protected void _initGame(int roundCount) {
        initmainpool();
    }

    @Override
    protected void _congratulate() {
        System.out.println("i win");
    }


    @Override
    protected void _initRound(int r) {
        roundpool.clear();
        roundpool.addAll(matchpool);
    }

    @Override
    protected void _winRound() {
        System.out.println("round win");

    }

    @Override
    protected Digits _makeAGuess() {
        int index = randomSource.randInt(roundpool.size());
        Digits guess = new Digits(roundpool.get(index));
        return guess;

    }

    private void poolremove(Digits guess, MMComparison OGComparison) {
        int OGTotal = OGComparison.getMinus() + OGComparison.getPlus();
        for (int i = 0; i < roundpool.size(); i++) {
            MMComparison mm = masterMindUtils.compare(guess, roundpool.get(i));
            int mmtotal = mm.getMinus() + mm.getPlus();
            if (mmtotal != OGTotal){
                removefrompool(i);
                i--;
            }
        }
    }

    private void removefrompool(int i) {
        roundpool.remove(i);
    }



    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        poolremove(guess,comparison);
    }

}
