package com.example.ejercicio1.utils;

import java.util.Arrays;

public class Data {
    private final int[] numbers = new int[10];
    private int position = 0;

    public void add(int number){
        numbers[position] = number;
        position++;
    }

    public int getMax(){
        int max = numbers[0];
        for(int i = 0; i < position; i++){
            if(numbers[i]>max){
                max = numbers[i];
            }
        }
        return max;
    }

    public int getMin(){
        int min = numbers[0];
        for(int i = 0; i < position; i++){
            if(numbers[i]<min){
                min = numbers[i];
            }
        }
        return min;
    }

    public float getAvg(){
        return (((float) getSum()) / position);
    }

    public int getSum(){
        int sum = 0;
        for(int number: numbers){
            sum += number;
            }
        return sum;
        }

    public int getEvenNumbersCount(){
        int evenNumbersCount = 0;
        for(int i = 0; i < position; i++){
            if(numbers[i] % 2 == 0){
                evenNumbersCount++;
            }
        }
        return evenNumbersCount;
    }

    public int getOddNumbersCount(){
        return position - getEvenNumbersCount();
    }

}
