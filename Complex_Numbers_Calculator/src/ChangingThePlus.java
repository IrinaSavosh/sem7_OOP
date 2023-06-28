import java.util.ArrayList;
import java.util.List;

public class ChangingThePlus {

   private List<String> numbers = new ArrayList<>();

   public ChangingThePlus(List<String> numbers) {
      this.numbers = numbers;
   }

   public List<String> getNumbers() {
      return numbers;
   }

   public void setNumbers(List<String> numbers) {
      this.numbers = numbers;
   }

   public void changing() {
      for (int i = 0; i < numbers.size(); i++) {
         if (numbers.get(i).equals("+")) {
            numbers.remove(i);
         }
         if (numbers.get(i).equals("-")) {
            numbers.set(i + 1, "-" + numbers.get(i + 1));
            numbers.remove(i);
         }
      }
   }

}
