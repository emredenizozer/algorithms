import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.function.BiFunction;

public class Klarna {
    public static String maskify(String str) {
        if(str == null || str.equals(""))
            return "";

        String strText = str.trim();

        int strLen = strText.length();
        int endIndex = strLen - 4;

        if(strLen < 6)
            return strText;

        StringBuilder sbMaskString = new StringBuilder();

        sbMaskString.append(strText.charAt(0));

        for (int i = 1; i < endIndex; i++) {

            if (Character.isDigit(strText.charAt(i))) {
                sbMaskString.append("#");
            } else {
                sbMaskString.append(strText.charAt(i));
            }

        }

        for (int i = endIndex; i < strLen; i++) {
            sbMaskString.append(strText.charAt(i));
        }

        return sbMaskString.toString();
    }

    public static String numberToOrdinal(int i) {
        if (i == 0) {
            return "0";
        }

        String[] suffixArray = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };

        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixArray[i % 10];
        }
    }

    public static int reversePolishNotation(String str) {
        if(str == null || str.equals(""))
            return 0;

        String expression = str.trim();

        Stack<Integer> numbers = new Stack<>();
        Arrays.asList(expression.split(" ")).stream().forEach(item -> {
            switch(item) {
                case "+":
                    calcSign(numbers, (n1, n2) -> n2 + n1);
                    break;
                case "-":
                    calcSign(numbers, (n1, n2) -> n2 - n1);
                    break;
                case "*":
                    calcSign(numbers, (n1, n2) -> n2 * n1);
                    break;
                case "/":
                    calcSign(numbers, (n1, n2) -> n2 / n1);
                    break;
                default:
                    numbers.push(Integer.parseInt(item));
            }
        });

        if (numbers.size() > 1)
            return -1;

        return numbers.pop();
    }

    protected static Stack<Integer> calcSign(Stack<Integer> numbers, BiFunction<Integer, Integer, Integer> operation) throws EmptyStackException {
        if (numbers == null)
            throw new EmptyStackException();

        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }

    public static void main(String[] args) {

    }
}