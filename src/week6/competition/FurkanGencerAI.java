package week6.competition;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;
import week6.MasterMindUtils;
import week6.utils.ConsolUtils;
import week6.utils.RandomSource;

import java.util.ArrayList;


public class FurkanGencerAI extends AIPlayer {

    private ArrayList<Integer>[] digitsList;
    private ArrayList<Integer>[] possibleDigitsList;
    private ArrayList<Digits> containPlusGuess;
    private int plusCount;
    private int totalGuessForRound;

    public FurkanGencerAI() {
        super("Furkan Gencer");
    }

    @Override
    protected void _initGame(int roundCount) {
        digitsList = new ArrayList[digitCount];
        possibleDigitsList = new ArrayList[digitCount];
        containPlusGuess = new ArrayList<>();

        for (int i = 0; i < digitCount; i++) {
            digitsList[i] = new ArrayList<>();
            possibleDigitsList[i] = new ArrayList<>();
        }

    }

    @Override
    protected void _congratulate() {
        System.out.println(ConsolUtils.colorize("EZ GAME xd",ConsolUtils.ANSI_PURPLE));
    }

    @Override
    protected void _initRound(int r) {

        resetMemory();
        prepareRound();

    }

    @Override
    protected void _winRound() {
        System.out.println("In this round, "+totalGuessForRound + " total guesses were made and finally I made the right guess :D");
    }

    @Override
    protected Digits _makeAGuess() {
        int[] guess = new int[digitCount];
        int tryTimes = 0;

        do{
            for (int d = 0; d < digitCount; d++) {
                guess[d] = makeDigitGuess(d);
            }
            if(tryTimes>500){
                startGuessingAgain2();
                return MasterMindUtils.randomNumber(digitCount);
            }

            tryTimes++;
        }while (MasterMindUtils.hasDuplicates(guess) && !containPlusGuess.contains(new Digits(guess)));

        return new Digits(guess);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        totalGuessForRound++;

        analyzeGuess(guess, comparison);


    }

    private void resetMemory(){

        containPlusGuess.clear();

        clearDigitsList();
        clearPossibleDigitsList();
    }

    private void prepareRound(){

        plusCount = 0;
        totalGuessForRound = 0;

        for (int d = 0; d < digitCount; d++) {
            for (int n = 0; n < 10; n++) {
                digitsList[d].add(n);
            }
        }
        digitsList[digitCount-1].remove((Integer) 0);
    }

    private int makeDigitGuess(int d){
        int randomNum;
        RandomSource rs= new RandomSource();
        do {
            randomNum = rs.randInt(10);
        }while (!digitsList[d].contains((Integer) randomNum));
        return randomNum;
    }

    private void analyzeGuess(Digits guess, MMComparison comparison){

        if(comparison.getPlus()>0){
            if(checkNotes(guess)){
            takeNotes(guess,comparison);
            removeList(guess);
            }
        }
        if((comparison.getPlus() == 0) && (comparison.getMinus() > 0)){
            removeList(guess);
        }
        if((comparison.getPlus() == 0) && (comparison.getMinus() == 0)){
            removeAllList(guess);
        }

        if(plusCount == digitCount){
            startGuessingAgain1();
            return;
        }

        for (int d = 0; d < digitCount; d++) {
            if(digitsList[d].isEmpty())
                startGuessingAgain2();
        }

    }

    private void removeList(Digits guess){
        int digit;
        for (int d = 0; d < digitCount; d++) {
            digit = guess.getDigits()[d];
            digitsList[d].remove((Integer) digit);
        }
    }

    private void removeAllList(Digits guess){
        int digit;
        for (int n = 0; n < digitCount; n++) {
            digit = guess.getDigits()[n];
            for (int d = 0; d < digitCount; d++) {
                digitsList[d].remove((Integer) digit);
            }
        }
    }

    private void takeNotes(Digits guess,MMComparison comparison){
        int digit;
        plusCount += comparison.getPlus();
        containPlusGuess.add(guess);
        for (int d = 0; d < digitCount; d++) {
            digit = guess.getDigits()[d];
            possibleDigitsList[d].add(digit);
        }
    }

    private boolean checkNotes(Digits guess){
            int digit;
            for (int d = 0; d < digitCount; d++) {
                digit = guess.getDigits()[d];
                if(possibleDigitsList[d].contains((Integer) digit))
                    return false;
            }
            return true;
    }

    private void startGuessingAgain1(){
        plusCount = 0;
        clearDigitsList();
        putPossiblesToDigitsList();
        clearPossibleDigitsList();
    }

    private void startGuessingAgain2(){
        plusCount = 0;
        carryRestsToPossible();
        clearDigitsList();
        putPossiblesToDigitsList();
        clearPossibleDigitsList();
    }

    private void clearDigitsList(){
        for (int d = 0; d < digitCount; d++) {
            digitsList[d].clear();
        }
    }

    private void clearPossibleDigitsList(){
        for (int d = 0; d < digitCount; d++) {
            possibleDigitsList[d].clear();
        }
    }

    private void putPossiblesToDigitsList(){
        int n;
        for (int i = 0; i < digitCount; i++) {
            for (int j = 0; j < possibleDigitsList[i].size(); j++) {
                n = (int) possibleDigitsList[i].get(j);
                digitsList[i].add((Integer) n);
            }
        }
    }

    private void carryRestsToPossible(){
        int n;
        for (int i = 0; i < digitCount; i++) {
            for (int j = 0; j < digitsList[i].size(); j++) {
                n = (int) digitsList[i].get(j);
                possibleDigitsList[i].add((Integer) n);
            }
        }
    }

}




