package Exam151115;

import java.util.Scanner;

public class Pr3RubicksMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int commandsCount = sc.nextInt();
        sc.nextLine();

        int sideA = Integer.parseInt(input[0]);
        int sideB = Integer.parseInt(input[1]);

        int[][] board = new int[sideA][sideB];
        int[][] originalBoard = new int[sideA][sideB];


        int counter = 1;
        for (int i = 0; i < sideA; i++) {
            for (int k = 0; k < sideB; k++) {
                board[i][k] = counter;
                originalBoard[i][k] = counter;
                counter++;
            }
        }

        for (int i = 0; i < commandsCount; i++) {
            input = sc.nextLine().split(" ");

            String command = input[1];
            int timesToMove = Integer.parseInt(input[2]);
            if (timesToMove != 0) {
                if(timesToMove > sideA ){ timesToMove = timesToMove % sideA; }

                if (command.equals("up")) {
                    int col = Integer.parseInt(input[0]);
                    moveMatrixUp(board, col, timesToMove, sideA);

                } else if (command.equals("down")) {
                    int col = Integer.parseInt(input[0]);
                    moveMatrixDown(board, col, timesToMove, sideA);
                } else if (command.equals("left")) {
                    int row = Integer.parseInt(input[0]);
                    moveMatrixLeft(board, row, timesToMove, sideB);

                } else if (command.equals("right")) {
                    int row = Integer.parseInt(input[0]);
                    moveMatrixRight(board, row, timesToMove, sideB);
                }
            }
        }

        for (int i = 0; i < sideA; i++) {
            for (int k = 0; k < sideB; k++) {
                if(originalBoard[i][k] != board[i][k]){
                    swap(i, k, board, originalBoard, sideA, sideB);
                }
                else{
                    System.out.println("No swap required");
                }
            }
        }
        System.out.println();
    }

    private static void swap(int a, int b, int[][] board, int[][] originalBoard, int sideA, int sideB) {
        boolean found = false;

        for (int i = 0; i < sideA; i++) {
            for (int k = 0; k < sideB; k++) {
                if (originalBoard[a][b] == board[i][k]){
                    System.out.printf("Swap (%d, %d) with (%d, %d)",a , b, i, k);
                    System.out.println();
                    int temp = board[a][b];
                    board[a][b] = board[i][k];
                    board[i][k] = temp;
                    found = true;
                    break;
                }
            }
            if (found){break;}
        }
    }

    private static void moveMatrixDown(int[][] board, int col, int timesToMove, int size) {

        for (int i = 0; i < timesToMove; i++) {

            int lastElement = board[size - 1][col];

            for (int k = size - 1; k > 0; k--) {
                board[k][col] = board[k - 1][col];
            }

            board[0][col] = lastElement;
        }
    }

    private static void moveMatrixUp(int[][] board, int col, int timesToMove, int size) {
        for (int i = 0; i < timesToMove; i++) {

            int firstElement = board[0][col];

            for (int k = 0; k < size - 1; k++) {
                board[k][col] = board[k + 1][col];
            }

            board[size - 1][col] = firstElement;
        }
    }

    private static void moveMatrixLeft(int[][] board, int row, int timesToMove, int size) {

        for (int i = 0; i < timesToMove; i++) {

            int firstElement = board[row][0];

            for (int k = 0; k < size - 1; k++) {
                board[row][k] = board[row][k + 1];
            }

            board[row][size - 1] = firstElement;
        }
    }

    private static void moveMatrixRight(int[][] board, int row, int timesToMove, int size) {


        for (int i = 0; i < timesToMove; i++) {

            int lastElement = board[row][size - 1];

            for (int k = size - 1; k > 0; k--) {
                board[row][k] = board[row][k - 1];
            }

            board[row][0] = lastElement;
        }
    }

}
