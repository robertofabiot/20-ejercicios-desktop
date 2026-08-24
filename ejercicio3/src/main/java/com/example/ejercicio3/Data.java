package com.example.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void addNumber(int number){
        numbers.add(number);
    }

    // Corregí esto sin ia ni google. Si alguien lo ve quiero que sepa que me siento orgulloso
    // de que aun me queden conexiones neuronales suficientes para hacer esto.
    public List<Integer> getSortedNumbers(){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        for(int i = 0; i < sortedNumbers.size(); i++){
            for(int j = i; j < sortedNumbers.size(); j++){
                if(sortedNumbers.get(j) < sortedNumbers.get(i)){
                    int temp = sortedNumbers.get(i);
                    sortedNumbers.set(i, sortedNumbers.get(j));
                    sortedNumbers.set(j, temp);
                }
            }
        }
        return sortedNumbers;
    }

}
