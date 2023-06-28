import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class CreatingArray {
    public ArrayList<String> arr = new ArrayList<String>();

    public ArrayList<String> creatigArray() {
        System.out.println(
                "Введите выражение, которое нужно посчитать, где мнимое число указано с окончанием 'i', " +
                        "а также знаки и числа разделены пробелами: ");
        Scanner sc = new Scanner(System.in);
        String entering = sc.nextLine();

        String divider = " ";
        String[] array = entering.split(divider);
        
        Collections.addAll(arr, array);
        ChangingThePlus plus = new ChangingThePlus(arr);
        plus.changing();

        sc.close();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).contains("--")) {
                Rewrite minus = new Rewrite();
                arr.set(i, Double.toString(minus.withoutDoubleMinus(arr.get(i))));

            }
        }
        return arr;
    }
}
