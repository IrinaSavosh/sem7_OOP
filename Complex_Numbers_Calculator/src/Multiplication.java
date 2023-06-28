public class Multiplication extends ArithmeticOperations{
   public String multiplication(String a, String b) {

      if (a.contains("i") & b.contains("i")) {
          c = i.withoutI(a);
          d = i.withoutI(b);
          result = "-" + Double.toString(c * d);
          return result;
      } else if (b.contains("i")) {
          c = Double.parseDouble(a);
          d = i.withoutI(b);
          result = Double.toString(c * d) + "i";
          return result;
      } else if (a.contains("i")) {
          c = i.withoutI(a);
          d = Double.parseDouble(b);
          result = Double.toString(c * d) + "i";
          return result;
      } else {
          c = Double.parseDouble(a);
          d = Double.parseDouble(b);
          result = Double.toString(c * d);
          return result;
      }

  }
}
