package pl.dopierala;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationsParser {

    private double a;
    private double b;



    public static Equation parse(String toParse) {

        double a=0,b=0,c=0;


        Pattern ptForA = Pattern.compile("-?\\d+x(\\+|\\=)");
        Pattern ptForB = Pattern.compile("(\\+|-)\\d+=");
        Pattern ptForC = Pattern.compile("=-?\\d+$");
        Matcher mForA = ptForA.matcher(toParse);
        Matcher mForB = ptForB.matcher(toParse);
        Matcher mForC = ptForC.matcher(toParse);

        if(mForA.find()) {
            String strA = mForA.group();
            a = Double.valueOf(strA.substring(0,strA.length()-2));
        }else
            a=1;


        if(mForB.find()) {
            String strB = mForB.group();
            b = Double.valueOf(strB.substring(0,strB.length()-1));
        }
        else
            b=0;

        if(mForC.find()) {
            String strC = mForC.group();
            c = Double.valueOf(strC.substring(1,strC.length()));
        }
        else
            throw new IncorrectEquationException("Missing parameter after '=' sign. ");

        return new Equation(a,b,c);
    }
}
