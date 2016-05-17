package Exam261016;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr2WeirdScript {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = "";
        int n = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();

        key = key(n);

        while(!input.equals("End")) {
            text.append(input);
            input = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile(key + "(.*?)" + key);

        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println(matcher.group(1));
        }

    }
    public static String key (int n){
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        int index = n % 52;
        if(index == 0){
            index = 52;
        }
        String key = letters[index - 1] + letters[index - 1];
        return key;
    }

    public static String key1 (int n){
        String key = "";
        int count = 1; //odd - small letter, even - big letter
        int stop = 26;

        while (n > stop) {
            stop += 54;
            count++;
        }

        int startLetter = stop - 25;
        char startChar;
        if (count % 2 == 0) {
            startChar = 'A';
        } else {
            startChar = 'a';
        }

        for (int i = startLetter; i < stop; i++) {
            if (i == n) {
                key += startChar;
                key += startChar;
                break;
            }
            startChar++;
        }

        return key;
    }
}
