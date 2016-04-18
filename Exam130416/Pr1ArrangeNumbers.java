package Exam130416;


import java.util.*;

public class Pr1ArrangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> arrange = new TreeMap<>();

        String[] numbers = scanner.nextLine().split(", ");

        String[] keys = new String[numbers.length];
       // List<String> repeatedKeys = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            String currentNum = numbers[i];
            String word = "";

            for (int k = 0; k < currentNum.length(); k++) {
                char currChar = currentNum.charAt(k);

                switch (currChar){
                    case '0':  word += "zero"; break;
                    case '1':  word += "one"; break;
                    case '2':  word += "two"; break;
                    case '3':  word += "three"; break;
                    case '4':  word += "four"; break;
                    case '5':  word += "five"; break;
                    case '6':  word += "six"; break;
                    case '7':  word += "seven"; break;
                    case '8':  word += "eight"; break;
                    case '9':  word += "nine"; break;
                }
            }
            keys[i] = word;
            //if (arrange.containsKey(word)){repeatedKeys.add(currentNum);}
            arrange.put(word, currentNum);
        }

        Arrays.sort(keys);


        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            String numToPrint = arrange.get(key);
            if (i == keys.length - 1){
                System.out.print(numToPrint);
            }
            else{
                System.out.print(numToPrint + ", ");
            }
        }
        System.out.println();
    }
}
