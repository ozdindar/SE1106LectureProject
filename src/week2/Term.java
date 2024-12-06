package week2;

import java.util.ArrayList;

class Term {

    double coeff;
    int exp;

    Term(double coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }

    Term(Term other)
    {
        coeff = other.coeff;
        exp = other.exp;
    }

    void multiply(double val)
    {
        coeff *= val;
    }

    void multiply(Term t)
    {
        coeff *= t.coeff;
        exp += t.exp;
    }


    boolean add(Term other)
    {
        if (exp == other.exp)
        {
            coeff += other.coeff;
            return true;
        }
        return false;
    }

    double value(double x)
    {
        return coeff*Math.pow(x,exp);
    }

    public String toString() {
        String s= "";

        if (coeff ==0)
            return "0";

        if (exp==0 || (coeff!=1 && coeff!=-1) )
            s += coeff;

        if (coeff==-1)
            s += "-";

        if (exp==0)
            return s;

        s +="x";

        if (exp==1)
            return s;

        return s+"^"+ exp;
    }


    /**
     * Multiplies this polynom with other
     * @param args
     */
    void multiply(Polynom other)
    {

    }


    public static void main(String[] args) {

        ArrayList<Term> terms = new ArrayList<>();

        terms.add(new Term(0,2));
        terms.add(new Term(1,2));
        terms.add(new Term(1,0));
        terms.add(new Term(2,1));
        terms.add(new Term(-1,2));
        terms.add(new Term(3,2));
        terms.add(new Term(-4,2));



        for (int i = 0; i < terms.size(); i++) {
            System.out.println(terms.get(i));
        }

    }
}
