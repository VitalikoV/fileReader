package com.company;

import java.util.ArrayList;

public class Resolver {


    public Resolver() {
    }


    public Double getResults(ArrayList<Double> numbers, int whatToDo) {
        getException(numbers, whatToDo);
        double result = determineResult(numbers, whatToDo);
        return result;
    }


    protected double determineResult(ArrayList<Double> numbers, int whatToDo) {
        double result;
        switch (whatToDo) {
            case 1:
                result = numbers.get(0) + numbers.get(1);
                break;
            case 2:
                result = numbers.get(0) * numbers.get(1);
                break;
            case 3:
                result = numbers.get(0) / numbers.get(1);
                break;
            case 4:
                result = Math.pow(numbers.get(0), 2) + Math.pow(numbers.get(1), 2);
                break;
            default:
                result = 0;
        }
        return result;
    }


    private void getException(ArrayList<Double> numbers, int whatToDo) {
        if (whatToDo < 1 || whatToDo > 4 || numbers.size() != 2) {
            throw new IllegalArgumentException("can`t determine your expression");
        }
    }

}
