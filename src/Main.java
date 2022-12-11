import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int cycle = 0;
    static int x = 1;
    static int[] signalStrengths = new int[6];
    static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Puzzle102.txt"));
        ArrayList<String> input = new ArrayList<>();

        while (sc.hasNext()){
            input.add(sc.nextLine());
        }



        for(String line: input){
            if(line.equals("noop")){
                checkCycles();
                cycle ++;
            } else {
                char[] chars = line.toCharArray();
                String number = "";
                for (int i = 5; i < chars.length; i++) {
                    number += chars[i];
                }
                int toAdd = Integer.parseInt(number);

                for (int i = 0; i < toAdd; i++) {
                    checkCycles();
                    cycle ++;
                }
                x += toAdd;
            }
        }

        int totalSignalStrength = 0;
        for(int i : signalStrengths){
            totalSignalStrength += i;
        }
        System.out.println(totalSignalStrength);
    }

    private static void checkCycles(){
        if(counter < 6){
            if(cycle % 20 == 0 && cycle != 40){
                signalStrengths[counter] = cycle * x;
                counter ++;
            }
        }
    }

}
