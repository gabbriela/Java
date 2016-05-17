package Exam261016;

import java.util.Locale;
import java.util.Scanner;

public class Pr3TheHeiganDance {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        Scanner sc = new Scanner(System.in);

        int playerLife = 18500;
        double bossLife = 3000000.00;

        char[][] board = new char[16][16];

        int playerX = 7;
        int playerY = 7;
        int[] playerPosition = {playerX, playerY};

        double playerHit = sc.nextDouble();
        sc.nextLine();

        String[] input = sc.nextLine().split(" ");

        int cloudHit = 0;
        String killingMagic = "";

        while (true) {
            bossLife -= playerHit;

            playerX = playerPosition[0];
            playerY = playerPosition[1];

            if (cloudHit > 0 && (bossLife > 0)) {
                playerLife -= 3500;
                cloudHit--;
                if(playerLife <= 0){killingMagic = "Plague Cloud";}
            }
            if (playerLife > 0) {

            }
            //Boss Attack
            String magicType = input[0];
            int attackX = Integer.parseInt(input[1]);
            int attackY = Integer.parseInt(input[2]);

            if (playerInAttackRange(attackX, attackY, playerX, playerY)) {
                //player Run
                playerPosition = playerRun(board, playerX, playerY, attackX, attackY);
            }
            if ((playerX == playerPosition[0] && playerY == playerPosition[1]) && playerLife > 0 && (bossLife > 0)) {
                if (magicType.equals("Cloud")) {
                    playerLife -= 3500;
                    cloudHit = 2;
                    cloudHit--;
                    if(playerLife <= 0){killingMagic = "Plague Cloud";}
                } else{
                    playerLife -= 6000;   //Eruption
                    if(playerLife <= 0){killingMagic = "Eruption";}
                }
            }



            if (bossLife <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.printf("Player: %d", playerLife);
                System.out.println();
                System.out.printf("Final position: %d, %d", playerX, playerY);
                System.out.println();

                break;
            }
            if (playerLife <= 0) {
                System.out.printf("Heigan: %.2f", bossLife);
                System.out.println();
                System.out.printf("Player: Killed by %s", killingMagic);
                System.out.println();
                System.out.printf("Final position: %d, %d", playerX, playerY);
                System.out.println();
                break;
            }

            input = sc.nextLine().split(" ");
        }


        System.out.println();
    }

    private static boolean playerInAttackRange(int attackX, int attackY, int playerX, int playerY) {
        boolean isInAttackRange = false;

        for (int i = attackX - 1; i <= attackX + 1; i++) {
            for (int k = attackY - 1; k <= attackY + 1; k++) {
                if (playerX == i && playerY == k) {
                    isInAttackRange = true;
                    break;
                }
            }
        }

        return isInAttackRange;
    }

    private static int[] playerRun(char[][] board, int playerX, int playerY, int attackX, int attackY) {
        int[] playerPosition = new int[2];

        if ((playerX - 1 >= 0) && !(playerInAttackRange(attackX,attackY, playerX-1, playerY))) {
            playerX = playerX - 1;
        }
        else if ((playerY + 1 < board.length - 1) && !(playerInAttackRange(attackX,attackY, playerX, playerY + 1))) {
            playerY = playerY + 1;
        }
        else if ((playerX + 1 < board.length - 1) && !(playerInAttackRange(attackX,attackY, playerX+1, playerY))) {
            playerX = playerX + 1;
        }
        else if ((playerY - 1 >= 0) && !(playerInAttackRange(attackX,attackY, playerX, playerY - 1))) {
            playerY = playerY - 1;
        }
        playerPosition[0] = playerX;
        playerPosition[1] = playerY;

        return playerPosition;
    }
}
