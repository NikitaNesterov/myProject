import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTask {

    /**
     * метод, формирующий повторяющиеся строки
     * @param строка s
     * @return строка с повторяющимися подстроками
     */

    public static String repeatedSymbols(String s) {
        int count = 0;
        String repeated = "";
        Pattern pattern1 = Pattern.compile("[0-9]+");
        Pattern pattern2 = Pattern.compile("\\[[^\\]]+\\]");
        Matcher matcher1 = pattern1.matcher(s);
        Matcher matcher2 = pattern2.matcher(s);

        if (matcher1.find()) {
            count = Integer.parseInt(matcher1.group());
        }

        while (matcher2.find())
        {
            for (int k = 0; k < count; k++)
            {
                String semiStr = matcher2.group();
                repeated += semiStr.substring(1, semiStr.length()-1);
            }
        }
        return repeated;
    }

    public static void main(String[] args) {

        System.out.println("Введите, пожалуйста, контрольную строку: ");
        Scanner scanner = new Scanner(System.in);
        String comingStr = scanner.nextLine();

        Pattern pattern = Pattern.compile("(=?([0-9]+\\[[^\\]]+\\])+)");
        Matcher matcher = pattern.matcher(comingStr);

        ArrayList<String> list = new ArrayList<>();


        while (matcher.find()) {
            String string = matcher.group();
            list.add(string);
        }


        for (String s : list) {
            System.out.println(repeatedSymbols(s));

        }
    }
}
