package week6.competition;

import week6.AIPlayer;
import week6.Digits;
import week6.MMComparison;

import java.util.Arrays;

public class DmitriAI extends AIPlayer {

    private int[] state;
    private int c;
    private int pos = 0;
    private boolean found;
    private int[] dig;
    private int[] a;
    private int[] fin;
    public DmitriAI() {
        super("Dmitrii");
    }

    @Override
    protected void _initGame(int roundCount) {

    }

    @Override
    protected void _congratulate() {

    }

    @Override
    protected void _initRound(int r) {
        this.state = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.c = 0;
        this.found = false;

    }

    @Override
    protected void _winRound() {

    }

    private Digits generateGuess() {
        int[] d = new int[]{-1, -1, -1, -1};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                if ((i == 0) && (j == 0)) continue; //skip placing 0 as first

                boolean already = false;
                for (int a = 0; a < j; a++) {
                    if (d[a] == i) already = true;
                }
                if (already) continue; //skip placing duplicates

                if (d[j] < 0) {
                    d[j] = i;
                }
                else {
                    if (this.state[d[j]] > this.state[i]) {
                        d[j] = i;
                    }
                }

            }
        }

        return new Digits(d);
    }

    @Override
    protected Digits _makeAGuess() {
        if (!this.found) return generateGuess();

        a = new int[]{-1,-1,-1,-1};
        int x = 1;
        for (int i = 0; i < 4; i++) {
            boolean f = true;
            while(f) {
                f = false;
                for (int d : this.dig) {
                    if (x == d) {
                        x++;
                        f = true;
                        break;
                    }
                }
                for (int d : this.a) {
                    if (x == d) {
                        x++;
                        f = true;
                        break;
                    }
                }

            }
            a[i] = x;
        }

        for (int i = 0; i < c; i++) {
            a[i] = this.fin[i];
        }
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(this.dig[this.pos] == this.fin[j]) {
                    pos++;
                    if (pos == 4) pos = 0;
                }
            }
        }
        a[c] = this.dig[this.pos];

        return new Digits(a);
    }

    @Override
    protected void _giveAnswer(Digits guess, MMComparison comparison) {

        if ((comparison.getMinus() + comparison.getPlus()) == 0) {
            for (int x : guess.getDigits()) {
                this.state[x] = 999;
            }
            return;
        }


        if (this.found && (Arrays.equals(guess.getDigits(), a))) {
           if (comparison.getPlus() > c) {
               this.fin[c] = guess.getDigits()[c];
               c++;
           }
           else {
               pos++;
               if (pos == 4) pos = 0;
           }
           return;
        }

        if ((comparison.getMinus() + comparison.getPlus()) == 4) {
            if (!this.found) {
                this.dig = (guess.getDigits().clone());
                this.fin = new int[] {-1, -1, -1, -1};
                this.found = true;
                return;
            }

        }

        for (int x : guess.getDigits()) {
            this.state[x]+= 5 - comparison.getMinus() - comparison.getPlus() * 2;
        }


    }
}
