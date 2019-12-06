package com.company;

import java.util.*;

public class MatrixA {
    private List<ArrayList<Double>> Matrix = new ArrayList<>();
    private int len, hight = 0;

    public void setMatrix () {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        String [] ints;
        while(!str.toLowerCase().equals("next")){
            System.out.println("Enter a new string");
            str = scanner.nextLine();
            if(!str.toLowerCase().equals("next")) {
                ints = str.split(" ");
                this.setHight(this.getHight() + 1);
                this.setLen(ints.length);
                this.Matrix.add(makeLinestr(ints));
            }
        }

    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
    public ArrayList<Double> makeLinestr(String [] ints){
        ArrayList<Double> answer = new ArrayList<>();
        for(String str:ints) answer.add(Double.parseDouble(str));
        return answer;
    }
    public ArrayList<Double> makeLineint(Double [] ints){
        ArrayList<Double> answer = new ArrayList<>();
        for(Double i:ints) answer.add(i);
        return answer;
    }
    public ArrayList<Double> getLine(int number){
        return this.Matrix.get(number);
    }
    public void addstr(ArrayList<Double> str){
        this.Matrix.add(str);
    }
    public void newstring(int index, ArrayList<Double> str) {
        this.Matrix.set(index, str);
    }
}
