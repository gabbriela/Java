package Exam130416;

import java.util.Scanner;

public class Pr2Monopoly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money = 50;
        int turns = 0;
        int totalHotels = 0;
        int moneyPerRun = 0;

        String[] dimensions = scanner.nextLine().split(" ");

        int firstDim = Integer.parseInt(dimensions[0]);
        int secondDim = Integer.parseInt(dimensions[1]);

        String[] board = new String[firstDim];

        //arrange the board
        for (int i = 1; i <= firstDim; i++) {
            String line = scanner.nextLine();

            if (i % 2 != 0){
                board[i-1] = line;
            }
            else{
                board[i-1] = new StringBuilder(line).reverse().toString();
            }
        }

        // go
        for (int i = 0; i < board.length; i++) {
            String currentDimension = board[i];
            for (int k = 0; k < secondDim; k++) {
                char current = currentDimension.charAt(k);
                if (current == 'H'){

                    totalHotels++;
                    System.out.printf("Bought a hotel for %d. Total hotels: %d.", money, totalHotels);
                    System.out.println();
                    money = 0;
                    moneyPerRun += 10;
                }
                else if (current == 'F'){

                }
                else if (current == 'S'){
                    int moneySpent = 0;
                    if ((i + 1) % 2 == 0){
                        moneySpent = (currentDimension.length() - (k + 1) + 1) * (i + 1);
                    }
                    else{
                        moneySpent = (i + 1) * (k + 1);
                    }

                    if(money == 0){moneySpent = 0;}
                    else if(moneySpent > money){moneySpent = money;}

                    money -= moneySpent;
                    if(money < 0){money = 0;}

                    System.out.printf("Spent %d money at the shop.", moneySpent);
                    System.out.println();
                }
                else if (current == 'J'){
                    System.out.printf("Gone to jail at turn %d.", turns);
                    System.out.println();
                    turns +=2;
                    money += moneyPerRun + moneyPerRun;
                }

                turns++;
                money += moneyPerRun;
            }
        }

        System.out.printf("Turns %d", turns);
        System.out.println();
        System.out.printf("Money %d", money);
        System.out.println();
    }
}
