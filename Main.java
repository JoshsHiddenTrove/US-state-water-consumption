mport java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

class BinarySearchTree {

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(String key, List<Integer> line, double average) {
        root = insertRec(root, key, line, average);
    }

    /* A recursive function to insert a new place in BST */
    Node insertRec(Node root, String key, List<Integer> line, double average) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key, line, average);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.compareToIgnoreCase(root.state) < 0)
            root.left = insertRec(root.left, key, line, average);
        else if (key.compareToIgnoreCase(root.state) > 0)
            root.right = insertRec(root.right, key, line, average);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    Node find(String state) {
        return inorderRec(root, state);
    }

    // A utility function to do inorder traversal of BST
    Node inorderRec(Node root, String stateWanted) {
        while (root != null) {
            int temp = stateWanted.compareToIgnoreCase(root.state);
            if (temp == 0) {
                return root;
            }
            /* Otherwise, recur down the tree */
            if (temp < 0)
                return inorderRec(root.left, stateWanted);
            else if (temp > 0)
                return inorderRec(root.right, stateWanted);
        }
        return null;
    }
}


    public class Main {

        public static ArrayList<Integer> parseLine(String columns[], double rate) { // more specific naming
            ArrayList<Integer> years = new ArrayList<Integer>();

            for (int i = 1; i < columns.length; i++) { // for(String s :collumns)
                if (!columns[i].equals("Null")) { // another if check if Null;
                    years.add(Integer.valueOf(columns[i]));
                } else {
                    years.add(0);
                }
            }
            for(int i=1; i<=5; i++){ // make 5 a constant for betterr referencing/readablity
                 double futurePop = Double.valueOf(columns[columns.length-1]) + ( Double.valueOf(columns[columns.length-1]) * (rate * i));
                 int store = (int)futurePop;
                years.add(store);
            }
            return years;
        }

        public static Double findRates(String columns[]) { // more detailed naming
            double avgRate = 0;
            ArrayList<Double> rates = new ArrayList<Double>();
            int size = columns.length-1; // rename amountOfDataPoint
            for (int i = 2; i < columns.length; i++) { // 4 loop cleanup
                if(columns[i].equals("Null") || columns[i-1].equals("Null")){
                    i++;
                    size--;
                }else{
                    double tempRate = (Double.valueOf(columns[i]) - Double.valueOf(columns[i-1]));
                    tempRate = tempRate/ Double.valueOf(columns[i-1]);
                    rates.add(tempRate);
                }
            }
            double storeRates=0;
            for (int i = 0; i < rates.size(); i++) {
                storeRates += rates.get(i);
            }
            avgRate =storeRates/size;
            return avgRate;
        }

        public static void helpFunction() {
            System.out.print("Run -- Runs program by default displays water consumed globally from 1850 to 2025\n" +
                    "Change State -- Allows you to change the predicted birth rate from estimated to low,medium, and high variants or back to estimates\n" +
                    "Change Year -- Changes country note: for default(estimates) only gives water consumption for 1950-2020 while any variants give from 1950-2100\n" +
                    "Help -- Repeats commands\n" +
                    "Exit -- You got this one on your own bud\n");
        }

        public static String ask() { // renaame getInput surround by try/catch
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            input = input.toLowerCase();
            return input;
        }

        public static boolean isValidState(List<String> states,String newState){
            for(int i=0; i < states.size(); i++){ // Null check || ""
                newState = newState.toLowerCase();
                if(newState.equals(states.get(i))){
                    System.out.println("The new state is " + newState + ".");
                    return true;
                }
            }
            System.out.println(newState + " is not a valid state.");
            return false;
        }

        public static boolean isValidYear(String newYear){ // check null and "" .isNumeric check
            if(newYear.equals("1860") || newYear.equals("1870") || newYear.equals("1880") || newYear.equals("1890") || newYear.equals("1900") || // reg ex learn TODOs
                    newYear.equals("1910") || newYear.equals("1920") || newYear.equals("1930") || newYear.equals("1940") || newYear.equals("1940") ||
                    newYear.equals("1950") || newYear.equals("1960") || newYear.equals("1970") || newYear.equals("1980") || newYear.equals("1990") ||
                    newYear.equals("2000") || newYear.equals("2011") || newYear.equals("2012") || newYear.equals("2013") || newYear.equals("2014") ||
                    newYear.equals("2015") || newYear.equals("2016") || newYear.equals("2017") || newYear.equals("2018") || newYear.equals("2019") ||
                    newYear.equals("2020") || newYear.equals("2021") || newYear.equals("2022") || newYear.equals("2023") || newYear.equals("2024") || newYear.equals("2025")){
                System.out.println(newYear + " is the new year");
                return true;
            }
            System.out.println(newYear + " is not a valid new year");
            return false;
        }
        // look at this function geez
        static int getYear(int year){ // reg ex /store in map / own file TODO
            if(year == 1860){
                return 0;
            }
            if(year == 1870){
                return 1;
            }
            if(year == 1880){
                return 2;
            }
            if(year == 1890){
                return 3;
            }
            if(year == 1900){
                return 4;
            }
            if(year == 1910){
                return 5;
            }
            if(year == 1920){
                return 6;
            }
            if(year == 1930){
                return 7;
            }
            if(year == 1940){
                return 8;
            }
            if(year == 1950){
                return 9;
            }
            if(year == 1960){
                return 10;
            }
            if(year == 1970){
                return 11;
            }
            if(year == 1980){
                return 12;
            }
            if(year == 1990){
                return 13;
            }
            if(year == 2000){
                return 14;
            }
            if(year == 2010){
                return 15;
            }
            if(year == 2011){
                return 16;
            }
            if(year == 2012){
                return 17;
            }
            if(year == 2013){
                return 18;
            }
            if(year == 2014){
                return 19;
            }
            if(year == 2015){
                return 20;
            }
            if(year == 2016){
                return 21;
            }
            if(year == 2017){
                return 22;
            }
            if(year == 2018){
                return 23;
            }
            if(year == 2019){
                return 24;
            }
            if(year == 2020){
                return 25;
            }
            if(year == 2021){
                return 26;
            }
            if(year == 2022){
                return 27;
            }
            if(year == 2023){
                return 28;
            }
            if(year == 2024){
                return 29;
            }
            if(year == 2025){
                return 30;
            }
            return 0;
        } // naming get year

        public static void main(String[] args) { // comment code TODO
            helpFunction();
            BinarySearchTree tree = new BinarySearchTree();
            List<String> states = new ArrayList<String>();
            BufferedReader br = null;
            try {
                //Reading the csv file
                br = new BufferedReader(new FileReader("state_popsTest.csv"));
                String line;
                //Read to skip the header
                br.readLine();
                //Reading from the second line
                while (((line = br.readLine()) != null)) {
                    String[] columns = line.split(","); // null check TODO
                    String tempState=columns[0];
                    tempState=tempState.toLowerCase();
                    states.add(tempState);
                    //parseLine(columns);
                    double tempRates =(findRates(columns));
                    tree.insert(columns[0], parseLine(columns,tempRates),tempRates);
                }
            } catch (IOException e) {
                System.out.println("Error occured while closing the BufferedReader " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            String type = "";
            int year = 2020;
            String state = "wyoming";
            while (!type.equals("exit")) {
                System.out.println("What now champ?");
                type = ask();
                if (type.equals("run")) { // switch statement pass in tree.find(shit) as a parameter
                    Node tempNode = tree.find(state);
                    int i= getYear(year);
                    int pop =tempNode.years.get(i);
                    double male = pop * .51;
                    double female = pop * .49;
                    male *= 373.556;
                    female *=  270.89862;
                    int totalWaterConsumption = (int)male + (int)female;

                    if(year>=2020){
                        System.out.println("It's predicted " + state + " will use " + totalWaterConsumption + " gallons of water");
                    }else{
                        System.out.println(state + " used a total of " + totalWaterConsumption + " gallons of water");
                    }

                }
                if (type.equals("change state")) {
                    System.out.println("IDK what to tell you dude pick a state");
                    while (!state.equals("exit")) {
                    String newState = ask();
                    boolean stateStatus = isValidState(states,newState);
                    if(stateStatus == true){ // if(line 307) less declaring
                        state = newState;
                        break;
                    }
                }
                }
                if (type.equals("change year")) {
                    System.out.println("What year you want");
                    System.out.print("Valid years are 1860, 1870, 1880, 1890,1900,1910,1920, 1930, 1940, 1950, 1960,1970,1980,1990,2000\n" +
                            ",2010-2025 \n");
                    while (!state.equals("exit")) { // while true (infinate loop
                        String newYear = ask();
                        if(isValidYear(newYear)){
                            year = Integer.valueOf(newYear);
                            break;
                        }
                    }
                }
                if (type.equals("help")) {
                    helpFunction();
                }
                if (type.equals("exit")) {
                    System.out.println("I see the electric sheep");
                    return;
                }
            }
        }
    }
