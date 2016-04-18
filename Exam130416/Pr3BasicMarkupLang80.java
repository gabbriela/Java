package Exam130416;


import java.util.Scanner;

public class Pr3BasicMarkupLang80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        String[] command = scanner.nextLine().split("\"");

        while(command.length > 1){

            if(command.length > 3){
                int repeater = Integer.parseInt(command[1]);
                String currentWord = command[3];
                if(!currentWord.isEmpty()){
                    for (int k = 0; k < repeater; k++) {
                        counter++;
                        System.out.printf("%d. ", counter + currentWord);
                        System.out.println();
                    }
                }
            }
            else{
                String currentWord = command[1];
                if (command[0].contains("<inverse")){

                    String inversed = changeString(currentWord, "inverse");

                    if(!inversed.isEmpty()){
                        counter++;
                        System.out.printf("%d. %s", counter, inversed);
                        System.out.println();
                    }
                }
                else{
                    String reverse = changeString(currentWord, "reverse");
                    if(!reverse.isEmpty()){
                        counter++;
                        System.out.printf("%d. %s", counter, reverse);
                        System.out.println();
                    }
                }
            }
            command = scanner.nextLine().split("\"");
        }
    }

    public static String changeString(String currentWord, String command){
        StringBuilder inversed = new StringBuilder();
         if(command.equals("inverse")) {
             for (int k = 0; k < currentWord.length(); k++) {
                 char current = currentWord.charAt(k);

                 if (current >= 'a' && current <= 'z') {
                     current = Character.toUpperCase(current);
                     inversed.append(current);
                 } else {
                     current = Character.toLowerCase(current);
                     inversed.append(current);
                 }
             }
         }
        else{
             inversed.append(currentWord).reverse();
         }

        return inversed.toString();
    }
}
