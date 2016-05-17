package Exam280216;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr3SoftUniNumerals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputLine = sc.nextLine();

        inputLine = stringRepair(inputLine);

        BigInteger convertedNum = new BigInteger(inputLine, 5);

        System.out.println(convertedNum);
    }

    private static String stringRepair(String inputLine) {
        // 1
        Pattern numberOne = Pattern.compile("(aba)");
        Matcher matchOne = numberOne.matcher(inputLine);
        while(matchOne.find()){
            inputLine = inputLine.replace(matchOne.group(), "1");
        }
        //4
        Pattern numberFour = Pattern.compile("(cdc)");
        Matcher matchFour = numberFour.matcher(inputLine);
        while(matchFour.find()){
            inputLine = inputLine.replace("cdc", "4");
        }
        //2
        Pattern numberTwo = Pattern.compile("(bcc)");
        Matcher matchTwo = numberTwo.matcher(inputLine);
        while(matchTwo.find()){
            inputLine = inputLine.replace("bcc", "2");
        }
        //0
        Pattern numberZero = Pattern.compile("(aa)");
        Matcher matchZero = numberZero.matcher(inputLine);
        while(matchZero.find()){
            inputLine = inputLine.replace("aa", "0");
        }
        //3
        Pattern numberThree = Pattern.compile("(cc)");
        Matcher matchThree = numberThree.matcher(inputLine);
        while(matchThree.find()){
            inputLine = inputLine.replace("cc", "3");
        }

        return  inputLine;
    }
}
