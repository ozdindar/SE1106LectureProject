package week6;

import java.security.SecureRandom;
import java.util.Random;

public class R2D2  extends AIPlayer{

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
    Random rng = new SecureRandom();
    DigitsPool pool ;

    public R2D2() {
        super("R2D2");

        pool = new DigitsPool();
    }

    @Override
    protected void _initGame(int roundCount) {

    }

    @Override
    protected void _congratulate() {
        System.out.println(LOGO);
    }

    @Override
    protected void _initRound(int r) {
        pool.init(digitCount);
    }

    @Override
    protected void _winRound() {

    }

    @Override
    protected Digits _makeAGuess() {
        int index = rng.nextInt(pool.poolSize());

        return pool.get(index);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {
        pool.update(guess,comparison);
    }
}
