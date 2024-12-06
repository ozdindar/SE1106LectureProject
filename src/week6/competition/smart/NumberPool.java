package week6.competition.smart;

import week6.Digits;
import week6.MMComparison;
import week6.MasterMindUtils;

import java.util.ArrayList;
import java.util.List;

public class NumberPool {

    List<Digits> numbers;

    public NumberPool() {
        numbers = new ArrayList<>();
    }

    public int size() {
        return numbers.size();
    }

    public Digits get(int index) {
        return numbers.get(index);
    }

    /**
     * Fills the pool with all possible digitCount-digit number
     * @param digitCount
     */
    public void reset(int digitCount) {
        int min = (int) Math.pow(10,digitCount-1);
        int max = (int) (Math.pow(10,digitCount)-1);

        for (int n = min; n <=max ; n++) {
            Digits d = new Digits(n);
            if ( MasterMindUtils.isValid(d,digitCount))
                numbers.add(d);
        }
    }

    public void update(Digits guess, MMComparison answ) {
        List<Digits> newNumbers = new ArrayList<>();

        for (Digits d:numbers)
        {
            MMComparison comp = MasterMindUtils.compare(d,guess);
            // we are comparing the calculated answer with the given answer
            if (comp.getPlus()==answ.getPlus() && comp.getMinus()==answ.getMinus())
                newNumbers.add(d);
        }
        numbers = newNumbers;
        System.out.println("Pool is updated. Pool Size: "+ numbers.size());
    }
}
