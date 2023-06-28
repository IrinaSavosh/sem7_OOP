public class Rewrite {
   double number;
   public double withoutI(String withI){
      number = Double.parseDouble(withI.replace("i", ""));
      return number;
   }

   public double withoutMinus(String withMinus){
      number = Double.parseDouble(withMinus.replace("-", ""));
      return number;
   }

   public double withoutDoubleMinus(String withDoubleMinus){
      number = Double.parseDouble(withDoubleMinus.replace("--", ""));
      return number;
   }
}
