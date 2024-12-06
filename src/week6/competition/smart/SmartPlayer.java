package week6.competition.smart;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;
import week6.utils.ConsolUtils;
import week6.utils.RandomSource;

public class SmartPlayer extends AIPlayer {


    private static final String LOGO =  "           ,-----.            '########:'########::\n" +
                                        "         ,'_/_|_\\_`.           ##.....::..... ##:::\n" +
                                        "        /<<::8[O]::>\\          ##::::::::::: ##::::\n" +
                                        "       _|-----------|_         ######:::::: ##:::::\n" +
                                        "      |  | ====-=- |  |        ##...:::::: ##::::::\n" +
                                        "      |  | -=-==== |  |        ##:::::::: ##:::::::\n" +
                                        "      \\  | ::::|()||  /        ########: ########::\n" +
                                        "       | | ....|()|| |         ........::........::\n" +
                                        "       | |_________| |\n" +
                                        "       | |\\_______/| |\n" +
                                        "      /   \\ /   \\ /   \\  \n" +
                                        "      `---' `---' `---'" ;
    NumberPool pool;

    public SmartPlayer() {
        super("R2D2");
        pool = new NumberPool();
    }

    @Override
    protected void _initGame(int roundCount) {

    }

    @Override
    protected void _congratulate() {
        System.out.println(ConsolUtils.colorize(LOGO,ConsolUtils.ANSI_YELLOW));
    }

    @Override
    protected void _initRound(int r) {
        pool.reset(digitCount);
    }

    @Override
    protected void _winRound() {

    }


    @Override
    protected Digits _makeAGuess() {
        RandomSource rnd = new RandomSource();
        int poolSize = pool.size();
        int index = rnd.randInt(poolSize);
        Digits d = pool.get(index);

        return d;
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        pool.update(guess,comparison);
    }


}
