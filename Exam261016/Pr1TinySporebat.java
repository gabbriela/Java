package Exam261016;


import java.util.Scanner;

public class Pr1TinySporebat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lifePoints = 5800;
        int glowCaps = 0;
        boolean dead = false;
        String input = scanner.nextLine();

        while(!input.equals("Sporeggar")){

            for (int i = 0; i < input.length(); i++) {
                if(i == input.length() - 1){
                    int caps = input.charAt(i) - 48;
                    glowCaps += caps;
                }
                else{
                    char current = input.charAt(i);

                    if(current == 'L'){
                        lifePoints += 200;
                    }
                    else{
                        int pointsToTake = (int)current;
                        lifePoints -= pointsToTake;
                    }
                }
                if(lifePoints <= 0){
                    break;
                }
            }

            if(lifePoints <= 0){
                dead = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (dead){
            System.out.printf("Died. Glowcaps: %d", glowCaps);
            System.out.println();
        }
        else{
            System.out.printf("Health left: %d", lifePoints);
            System.out.println();

            if(glowCaps >= 30){
                System.out.printf("Bought the sporebat. Glowcaps left: %d", glowCaps - 30);
            }
            else{
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowCaps);
            }
        }
    }
}
