package week2;

import java.util.ArrayList;

class Polynom {

    ArrayList<Term> terms;

    Polynom()
    {
        terms = new ArrayList<>();
    }

    Polynom(Polynom other)
    {
        terms =new ArrayList<>();

        for (int i = 0; i < other.terms.size(); i++) {
            terms.add(new Term(other.terms.get(i)));
        }
    }

    void addTerm(Term t)
    {
        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            if (term.add(t))
            {
                return;
            }

        }

        terms.add(t);
    }


    public String toString() {
       String s = "";

        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            s += t;
            if (i<terms.size()-1)
            {
                if (terms.get(i+1).coeff>=0)
                    s  +=" + ";
            }
        }

       return s;
    }

    void multiply(Term t)
    {
        for (int i = 0; i < terms.size(); i++) {
            terms.get(i).multiply(t);
        }
    }

    double value(double x)
    {
        double val = 0.0;

        for (int i = 0; i < terms.size(); i++) {
            val += terms.get(i).value(x);
        }
        return val;
    }

    public static void main(String[] args) {
        Polynom p = new Polynom();

        p.addTerm(new Term(1,3));
        p.addTerm(new Term(2,4));
        p.addTerm(new Term(-4,7));

        p.addTerm(new Term(1,4));

        p.addTerm(new Term(-3,4));

        System.out.println(p);

        p.multiply(new Term(2,3));

        System.out.println(p);
    }
}
