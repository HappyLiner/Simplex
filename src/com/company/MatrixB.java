package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixB {
    private ArrayList<Double> matrix = new ArrayList<>();

    public void setMatrix() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String [] ints = str.split(" ");
        for(String newstr:ints) this.matrix.add(Double.parseDouble(newstr));
    }

    public ArrayList<Double> getMatrix() {
        return matrix;
    }


    public void setMatrix(ArrayList<Double> matrix) {
        this.matrix = matrix;
    }
}
