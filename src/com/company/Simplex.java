package com.company;

import java.util.ArrayList;

public class Simplex {
    private MatrixA first = new MatrixA();
    private MatrixB second = new MatrixB();
    private MatrixB third = new MatrixB();
    private MatrixA expanded = new MatrixA();

    Simplex () {
        this.first.setMatrix();
        this.second.setMatrix();
        this.third.setMatrix();
    }

    public void expandMatrix() {
        ArrayList<Double> str;
        for(int i = 0; i < this.first.getHight(); i++){
            str = first.getLine(i);
            for(int j = 0; j < this.first.getHight(); j++) {
                if (i == j)
                    str.add(1.0);
                else
                    str.add(0.0);
            }
            str.add(this.second.getMatrix().get(i));
            this.expanded.addstr(str);
        }
        str = this.third.getMatrix();
        for(int i = 0; i < str.size(); i++)
            str.set(i, -str.get(i));
        for(int i = 0; i < this.first.getHight() + 1; i++)
            str.add(0.0);
        this.expanded.addstr(str);
        this.expanded.setLen(this.first.getLen()+this.first.getHight() + 1);
        this.expanded.setHight(this.first.getHight() + 1);
    }
    public void SimplexMethod() {
        int k = this.indexOfMinAtLastStr();
        int h = 0;
        while((k != -1) && (h != -1)){
            k = this.indexOfMinAtLastStr();
            if (k != -1) {
                h = this.indexOfMinAtLastCol(k);
                ArrayList<Double> str = this.expanded.getLine(h);
                double coeff = str.get(k);
                for (int i = 0; i < str.size(); i++)
                    str.set(i, str.get(i) / coeff);
                this.expanded.newstring(h, str);
                for (int i = 0; i < this.expanded.getHight(); i++)
                    this.expanded.newstring(i, this.newLine(i, h, k));
                this.crutchOut();
            }
        }
        System.out.println("Max:" + this.expanded.getLine(this.expanded.getHight() - 1).get(this.expanded.getLen() - 1));
    }

    public void crutchOut() {
        ArrayList<Double> out;
        for(int i = 0; i < this.expanded.getHight(); i++) {
            out = this.expanded.getLine(i);
            for (Double kek : out) {
                System.out.print(kek + "        ");
            }
            System.out.println("");
        }
        System.out.println("==============================================================");
    }

    private int indexOfMinAtLastStr() {
        ArrayList<Double> str = this.expanded.getLine(this.expanded.getHight() - 1);
        double min = 0;
        int k = -1;
        for(int i = 0; i < str.size(); i++)
            if(str.get(i) < min){
                min = str.get(i);
                k = i;
            }
        return k;
    }

    public int indexOfMinAtLastCol(int f) {
        ArrayList<Double> str = new ArrayList<>();
        double min = 999999999;
        int k = -1;
        for(int i = 0; i < this.expanded.getHight() - 1; i++){
            if(this.expanded.getLine(i).get(f) != 0)
                if((this.expanded.getLine(i).get(this.expanded.getLen() - 1)) / (this.expanded.getLine(i).get(f)) < min){
                    min = (this.expanded.getLine(i).get(this.expanded.getLen() - 1)) / this.expanded.getLine(i).get(f);
                    k = i;
                }
        }
        return k;
    }

    public ArrayList<Double> newLine(int firstIndex, int secondIndex, int columnIndex) {
        ArrayList<Double> first = this.expanded.getLine(firstIndex);
        ArrayList<Double> second = this.expanded.getLine(secondIndex);
        if(firstIndex != secondIndex){
            double coeff = first.get(columnIndex)/second.get(columnIndex);
            for(int i = 0; i < first.size(); i++){
                first.set(i, first.get(i) - second.get(i) * coeff);
            }
        }
        return first;
    }
}
