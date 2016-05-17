package Exam280216;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr4Events {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, TreeSet<String>>> eventLog = new TreeMap<>();
        // name #([A-Za-z]+):
        // place  @([A-Za-z]+)
        // time (\d+:\d+)
        Pattern pattern = Pattern.compile("#([A-Za-z]+): @([A-Za-z]+)\\s*(\\d+:\\d+)");

        int eventCount = scanner.nextInt();
        scanner.nextLine();

        String inputLine = "";
        for (int i = 0; i < eventCount; i++) {
            inputLine = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputLine);

            boolean validData = matcher.find();

            if (validData){
                String personName = matcher.group(1);
                String eventPlace = matcher.group(2);
                String eventTime = matcher.group(3);

                //add place
                if(!(eventLog.containsKey(eventPlace))){
                    eventLog.put(eventPlace, new TreeMap<>());
                    eventLog.get(eventPlace).put(personName, new TreeSet<>());
                    eventLog.get(eventPlace).get(personName).add(eventTime);
                }
                else{ //add person
                    if(!(eventLog.get(eventPlace).containsKey(personName))){
                        eventLog.get(eventPlace).put(personName, new TreeSet<>());
                        eventLog.get(eventPlace).get(personName).add(eventTime);
                    }
                    else{
                        eventLog.get(eventPlace).get(personName).add(eventTime);
                        //eventLog.get(eventPlace).put(personName, eventLog.get(eventPlace).get(personName) + eventTime);
                    }
                }
            }
        }

        System.out.println();

        int counter = 1;
        eventLog.entrySet().stream().forEach(es ->
                    {

                        System.out.println(es.getKey() + ":");
                        es.getValue().entrySet().stream().forEach(set ->
                        {
                            System.out.printf("%d. %s -> ", counter, set.getKey());
                            System.out.print(String.join(", ", set.getValue()));
                            System.out.println("");
                        });

                    });
    }
}
