package com.company;

public class Main {

    public static void main(String[] args) {
        Simplex simplex = new Simplex();
        simplex.expandMatrix();
        simplex.crutchOut();
        simplex.SimplexMethod();
    }
}
