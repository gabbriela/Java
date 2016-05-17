package Exam280216;

import java.util.Scanner;

public class Pr1CollectResourses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String importantRes = "stone wood food gold";
        int mostResources = 0;

        String[] board = sc.nextLine().split(" ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] path = sc.nextLine().split(" ");
            int start = Integer.parseInt(path[0]);
            int jump = Integer.parseInt(path[1]);
            int collected = 0;
            String collectedMaterials = "";
            int counter = start;
            while(true) {

                String[] current = board[counter].split("_");
                String material = current[0];

                int quantity;
                if(current.length == 1){quantity = 1;}
                else{quantity = Integer.parseInt(current[1]);}

                String checker = Integer.toString(counter);
                if(collectedMaterials.contains(checker)){
                    break;
                }
                if(importantRes.contains(material)){
                    collected += quantity;
                }

                collectedMaterials += checker + " ";

                for (int k = 1; k <= jump; k++) {
                    if((counter + 1) == board.length){
                        counter = 0;
                    }
                    else{
                        counter++;
                    }
                }
            }

            if(collected > mostResources){
                mostResources = collected;
            }

        }

        System.out.println(mostResources);
    }
}
