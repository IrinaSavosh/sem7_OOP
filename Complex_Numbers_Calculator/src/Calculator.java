import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Calculator {

    ArrayList<String> arr = new ArrayList<String>();

    public Calculator() {

        CreatingArray array = new CreatingArray();
        Logger log = Logger.getLogger(Calculator.class.getName());
        FileHandler handler;
        try {
            handler = new FileHandler(); // создаем
            log.addHandler(handler); // добавляем
            XMLFormatter s_form = new XMLFormatter(); // создаем новый файл, куда будем записывать массив
            handler.setFormatter((s_form));
        } catch (SecurityException | IOException e) {

            e.printStackTrace();
        }
        arr.addAll(array.creatigArray());
        log.info("Тестовове логирование");
        firstArithmeticOperacion();
        log.info("Тестовове логирование");
        if (arr.size() > 1) {
            secondArithmeticOperacion();
        }
        log.info("Тестовове логирование");

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).contains("--")) {
                Rewrite end = new Rewrite();
                arr.set(i, Double.toString(end.withoutDoubleMinus(arr.get(i))));

            }
        }
        log.info("Тестовове логирование");
    }

    public ArrayList<String> firstArithmeticOperacion() {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals("*")) {
                Multiplication multi = new Multiplication();
                arr.set(i, multi.multiplication(arr.get(i - 1), arr.get(i + 1)));
                arr.remove(i + 1);
                arr.remove(i - 1);
                i--;
            } else if (arr.get(i).equals("/")) {
                Divide div = new Divide();
                arr.set(i, div.divide(arr.get(i - 1), arr.get(i + 1)));
                arr.remove(i + 1);
                arr.remove(i - 1);
            }
        }
        return arr;
    }

    public ArrayList<String> secondArithmeticOperacion() {
        Summ s = new Summ();
        ArrayList<String> listI = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).contains("i")) {
                listI.add(arr.get(i));
            } else {
                list.add(arr.get(i));
            }
        }
        arr.clear();
        if (listI.size() > 1) {
            for (int j = 0; j < listI.size() - 1; j++) {
                String check = s.sum(listI.get(j), listI.get(j + 1));
                if (check.contains("i")) {
                    listI.set(0, check);
                    listI.remove(j + 1);
                    j--;
                } else {
                    list.add(check);
                    listI.remove(j + 1);
                    listI.remove(j);
                    j -= 2;
                }
            }
        }
        if (list.size() > 1) {
            for (int k = 0; k < list.size() - 1; k++) {
                list.set(0, s.sum(list.get(k), list.get(k + 1)));
                list.remove(k + 1);
                k--;
            }
        }
        if (listI.size() > 0) {
            arr.addAll(listI);
        }
        if (list.size() > 0) {
            arr.addAll(list);
        }

        return arr;
    }

    @Override
    public String toString() {
        if (arr.size() > 1) {
            if (arr.get(1).contains("-")) {
                return (arr.get(0) + " " + arr.get(1));
            } else {
                return (arr.get(0) + " + " + arr.get(1));
            }
        } else {
            String s = arr.get(0);
            return s;
        }
    }
}
