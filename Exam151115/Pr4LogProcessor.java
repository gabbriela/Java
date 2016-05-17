package Exam151115;

import java.util.*;

public class Pr4LogProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> errorCounter = new TreeMap<>();
        TreeMap<String, List<String>> criticalErrors = new TreeMap<>();
        TreeMap<String, List<String>> warnings = new TreeMap<>();

        List<String> commands = new ArrayList<>();

        String line = sc.nextLine();

        while(!(line.equals("END"))){
            commands = repairInput(line);

            String projectName = commands.get(0);
            String errorType = commands.get(1);
            String errorMsg = commands.get(2);

            //error counter
            if(!(errorCounter.containsKey(projectName))){
                errorCounter.put(projectName, 1);
            }
            else{errorCounter.put(projectName, errorCounter.get(projectName) + 1);}

            //message
            if(errorType.equals("Critical")){
                if(!(criticalErrors.containsKey(projectName))){
                    criticalErrors.put(projectName, new ArrayList<>());
                    criticalErrors.get(projectName).add(errorMsg);
                }
                else{
                    criticalErrors.get(projectName).add(errorMsg);
                }
            }
            else{  //warning
                if(!(warnings.containsKey(projectName))){
                    warnings.put(projectName, new ArrayList<>());
                    warnings.get(projectName).add(errorMsg);
                }
                else{
                    warnings.get(projectName).add(errorMsg);
                }
            }

            line = sc.nextLine();
        }

        errorCounter.entrySet().stream().sorted((es1, es2) -> es2.getValue().compareTo(es1.getValue())).forEach(
                es -> {
                    String keyName = es.getKey();
                    System.out.println(keyName + ":");
                    System.out.println("Total Errors: " + es.getValue());   // if there are no errors?

                    //print  errors count
                    int count = 0;
                    if(criticalErrors.containsKey(keyName)){count = criticalErrors.get(keyName).size();}

                    System.out.printf("Critical: %d", count);
                    System.out.println();
                    count = 0;
                    if(warnings.containsKey(keyName)){count = warnings.get(keyName).size();}
                    System.out.printf("Warnings: %d", count);
                    System.out.println();

                    //print critical msg
                    System.out.println("Critical Messages:");
                    if(criticalErrors.containsKey(keyName)){
                        criticalErrors.get(keyName).stream().sorted((e1,e2) -> {
                            if (e1.length() != e2.length()) {
                                return Integer.compare(e1.length(), e2.length());
                            }
                            return e1.compareTo(e2);
                                    }).forEach(e1 -> {System.out.println("--->" + e1);});
                    }
                    else{
                        System.out.println("--->None");
                    }
                    //print warning msg
                    System.out.println("Warning Messages:");
                    if(warnings.containsKey(keyName)){
                        warnings.get(keyName).stream().sorted((e1,e2) -> {
                            if (e1.length() != e2.length()) {
                                return Integer.compare(e1.length(), e2.length());
                            }
                            return e1.compareTo(e2);
                        }).forEach(e1 -> {System.out.println("--->" + e1);});
                    }
                    else{
                        System.out.println("--->None");
                    }
                    System.out.println();
                }
        );

    }

    private static List<String> repairInput(String line) {

        //line = line.replaceAll("\\]","");
        //line = line.replaceAll("\\[","");
        //line = line.replaceAll(",","");
        //line = line.replaceAll("\\}","");
        //line = line.replaceAll("\\{","");
        //line = line.replaceAll(":","");
        //line = line.replaceAll(" ","");

        String[] repaired = line.split("\"");
        List<String> commands = new ArrayList<>();
        commands.add(repaired[3]);
        commands.add(repaired[7]);
        commands.add(repaired[11]);

        /*for (int i = 0; i < repaired.length ; i++) {
            if (!(repaired[i].equals("") || repaired[i].equals(" "))) {
                commands.add(repaired[i]);
            }
        }
        */
        return commands;
    }
}
