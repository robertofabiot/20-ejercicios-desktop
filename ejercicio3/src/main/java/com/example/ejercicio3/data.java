package com.example.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class data {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void addNumber(int number){
        numbers.add(number);
    }

    public List<Integer> getSortedNumbers(){
        List<Integer> sortedNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++){
            int minimum = numbers.get(i);
            for(int j = i; j < numbers.size(); j++){
                if(numbers.get(j) < minimum) minimum = numbers.get(j);
            }
            sortedNumbers.add(minimum);
        }
        return sortedNumbers;
    }

}
