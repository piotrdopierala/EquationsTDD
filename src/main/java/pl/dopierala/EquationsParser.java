package pl.dopierala;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationsParser {

    private double a;
    private double b;


    public static Equation parse(String toParse) {
        double a = 0;
        double b = 0;
        double c = 0;

        //5x+6=100;
        String[] eqSplit = toParse.split("=");
        c = Double.parseDouble(eqSplit[1]);

        boolean hasX = eqSplit[0].contains("x");
        boolean hasmX = eqSplit[0].contains("-x");
        String[] xSplit = eqSplit[0].split("x");
        if (xSplit.length == 2) {
            a = Double.parseDouble(xSplit[0]);
            b = Double.parseDouble(xSplit[1]);
        } else { //x not found split is one element, check if its a or b
            if (xSplit.length == 1 && !xSplit[0].equals("-")) {
                if (hasX)
                    a = Double.parseDouble(xSplit[0]);
                else
                    b = Double.parseDouble(xSplit[0]);
            }else{ //x or -x without number
                if(hasmX)
                    a=-1;
                else
                    a=1;
            }
        }

        return new Equation(a, b, c);
    }

    public static Equation parseRegExp(String toParse) {

        double a = 0, b = 0, c = 0;

        Pattern ptForA = Pattern.compile("-?\\d+x");
        Pattern ptForB = Pattern.compile("(\\+|-|^)\\d+=");
        Pattern ptForC = Pattern.compile("=-?\\d+$");
        Matcher mForA = ptForA.matcher(toParse);
        Matcher mForB = ptForB.matcher(toParse);
        Matcher mForC = ptForC.matcher(toParse);

        if (mForA.find()) {
            String strA = mForA.group();
            a = Double.valueOf(strA.substring(0, strA.length() - 1));
        } else {
            if (toParse.contains("x"))
                if (toParse.contains("-x"))
                    a = -1;
                else
                    a = 1;
            else
                a = 0;
        }


        if (mForB.find()) {
            String strB = mForB.group();
            b = Double.valueOf(strB.substring(0, strB.length() - 1));
        } else
            b = 0;

        if (mForC.find()) {
            String strC = mForC.group();
            c = Double.valueOf(strC.substring(1, strC.length()));
        } else
            throw new IncorrectEquationException("Missing parameter after '=' sign. ");

        return new Equation(a, b, c);
    }
}
