package Exam280216;

import java.util.Scanner;

public class Pr2ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] size = sc.nextLine().split(" ");

        int sizeA = Integer.parseInt(size[0]);
        int sizeB = Integer.parseInt(size[1]);

        int[][] parking = new int[sizeA][sizeB];
        //create parking
        //for (int i = 0; i <sizeA ; i++) {
        //    for (int k = 0; k < sizeB; k++) {
        //        parking[i][k] = 0;
        //    }
       // }

        String[] car = sc.nextLine().split(" ");

        while (!(car[0].equals("stop"))){

            int entranceRow = Integer.parseInt(car[0]);
            int parkRow = Integer.parseInt(car[1]);
            int parkCol = Integer.parseInt(car[2]);

            sameRowSpace(parking, parkRow, parkCol, entranceRow, sizeB);

            car = sc.nextLine().split(" ");
        }
    }

    private static void sameRowSpace(int[][] parking, int parkRow, int parkCol, int entranceRow, int sizeB) {
        int rowTurns = 0;
        if(entranceRow > parkRow){
            rowTurns = entranceRow - parkRow;
        }
        else if(entranceRow < parkRow){
            rowTurns = parkRow - entranceRow;
        }

        boolean forParking = true;
        if(parking[parkRow][parkCol] == 0){
            System.out.println(parkCol + 1 + rowTurns);
            parking[parkRow][parkCol] = 1;
        }
        else{
            for (int i = parkCol-1; i > 0; i--) {
                if(parking[parkRow][i] == 0){
                    System.out.println(i + 1 + rowTurns);
                    parking[parkRow][i] = 1;
                    forParking = false;
                    break;
                }
            }
            if(forParking){
                for (int i = parkCol + 1; i < sizeB ; i++) {
                    if(parking[parkRow][i] == 0){
                        System.out.println(i + 1 + rowTurns);
                        parking[parkRow][i] = 1;
                        forParking = false;
                        break;
                    }
                }

                if(forParking){
                    System.out.printf("Row %d full", parkRow);
                    System.out.println();
                }
            }
        }
    }
}
