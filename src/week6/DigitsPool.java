package week6;

import java.util.ArrayList;

public class DigitsPool {

    ArrayList<Digits> candidates;


    public DigitsPool() {
        this.candidates = new ArrayList<>();
    }

    public int poolSize() {
        return candidates.size();
    }

    public Digits get(int index)
    {
        return candidates.get(index);
    }

    public void update(Digits guess, MMComparison comparison) {
        ArrayList<Digits> updated = new ArrayList<>();
        for (Digits d:candidates)
        {
            MMComparison answer = MasterMindUtils.compare(guess,d);
            if (answer.isEqual(comparison))
                updated.add(d);
        }
        candidates = updated;
    }

    public void init(int digitCount) {

        candidates.clear();

        int min = (int) Math.pow(10,digitCount-1);
        int max = (int) Math.pow(10,digitCount)-1;

        for (int n = min; n <= max ; n++) {
            Digits d = Digits.fromInt(n);
            if (MasterMindUtils.isValid(d,digitCount))
                candidates.add(d);
        }
    }
}
