package week14.generics.genericclass;

public class ParanthesisValidator {

    String openings;
    String closings;

    public ParanthesisValidator(String openings, String closings) {
        this.openings = openings;
        this.closings = closings;
    }

    private boolean validate(String st) {

        Stack<Character> stack = new Stack<>(st.length());

        for (int i = 0; i < st.length(); i++) {
            Character c = st.charAt(i);

            if (openings.indexOf(c)>=0)
                stack.push(c);

            else if (closings.indexOf(c)>=0)
            {
                if (stack.isEmpty() || !isMatching( stack.pop(),c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatching(Character open, Character close) {
        return openings.indexOf(open)== closings.indexOf(close);
    }

    public static void main(String[] args) {
        ParanthesisValidator validator = new ParanthesisValidator("{[(<","}])>");

        String st = " dfgsdfg";

        if (validator.validate(st))
            System.out.println(st + " : valid");
        else
            System.out.println(st + " : invalid");
    }


}
