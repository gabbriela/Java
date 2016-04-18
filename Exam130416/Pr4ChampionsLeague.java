package Exam130416;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr4ChampionsLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String,List<Integer>> teamsWins = new TreeMap<>();
        TreeMap<String, List<String>> opponents = new TreeMap<>();

        String[] input = scanner.nextLine().split("[|]");

        while(!input[0].equals("stop")){
            //team names
            String teamOne = input[0].trim();
            String teamTwo = input[1].trim();
            String winner = "";

            //scores
            String[] score = input[2].trim().split(":");
            int teamOneScoreOne = Integer.parseInt(score[0]);
            int teamTwoScoreOne = Integer.parseInt(score[1]);
            score = input[3].trim().split(":");
            int teamOneScoreTwo = Integer.parseInt(score[1]);
            int teamTwoScoreTwo = Integer.parseInt(score[0]);

            //winner
            if(teamOneScoreOne+teamOneScoreTwo == teamTwoScoreOne+teamTwoScoreTwo){
                if(teamOneScoreTwo > teamTwoScoreOne){winner = teamOne;}
                else{winner = teamTwo;}
            }
            else{
                if(teamOneScoreOne+teamOneScoreTwo > teamTwoScoreOne+teamTwoScoreTwo){winner = teamOne;}
                else{winner = teamTwo;}
            }


            if (!teamsWins.containsKey(teamOne)){
                teamsWins.put(teamOne, new ArrayList<Integer>());
            }
            if (!teamsWins.containsKey(teamTwo)){
                teamsWins.put(teamTwo,new ArrayList<Integer>());
            }

            teamsWins.get(winner).add(1);

            //opponents
            if (!opponents.containsKey(teamOne)){
                opponents.put(teamOne, new ArrayList<>());
                opponents.get(teamOne).add(teamTwo);
            }
            else{opponents.get(teamOne).add(teamTwo);}
            if (!opponents.containsKey(teamTwo)){
                opponents.put(teamTwo, new ArrayList<>());
                opponents.get(teamTwo).add(teamOne);
            }
            else{opponents.get(teamTwo).add(teamOne);}

            input = scanner.nextLine().split("[|]");
        }

        System.out.println(teamsWins);
    }
}
