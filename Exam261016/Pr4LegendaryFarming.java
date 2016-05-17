package Exam261016;

import java.util.Scanner;
import java.util.*;

public class Pr4LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        String[] inputLine;

        boolean continueRead = true;
        String material = "";

        while(continueRead){
            inputLine = sc.nextLine().toLowerCase().split(" ");

            int runs = inputLine.length;
            if(runs % 2 != 0){runs =- 1;}

            for (int i = 0; i < runs; i+=2) {
                material = inputLine[i+1];
                int value = Integer.parseInt(inputLine[i]);

                //add key material
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + value);
                    //check if 250
                    if(keyMaterials.get(material) >= 250){
                        continueRead = false;
                        break;
                    }
                }
                else{  // add junk material
                    if(!(junkMaterials.containsKey(material))){
                        junkMaterials.put(material, value);
                    }
                    else{junkMaterials.put(material, junkMaterials.get(material) + value); }

                }
            }
        }

        keyMaterials.put(material, keyMaterials.get(material) - 250);

        if(material.equals("shards")){
            System.out.println("Shadowmourne obtained!");
        }
        else if(material.equals("fragments")){
            System.out.println("Valanyr obtained!");
        }
        else{
            System.out.println("Dragonwrath obtained!");
        }

        keyMaterials.entrySet().stream().sorted((es1, es2) -> Integer.compare(es2.getValue(), es1.getValue())).
                forEach(es -> {System.out.printf("%s: %d", es.getKey(), es.getValue());
                    System.out.println();});


        junkMaterials.entrySet().stream().forEach(es ->
                            {
                                System.out.printf("%s: %d", es.getKey(), es.getValue());
                                System.out.println();
                            });
    }
}
