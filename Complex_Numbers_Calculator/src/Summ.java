public class Summ extends ArithmeticOperations {

    public String sum(String a, String b) {
        if (a.contains("i")) {
            c = i.withoutI(a);
            d = i.withoutI(b);
            result = Double.toString(c + d) + "i";
            return result;
        } else {
            c = Double.parseDouble(a);
            d = Double.parseDouble(b);
            result = Double.toString(c + d);
            return result;
        }
    }

}
