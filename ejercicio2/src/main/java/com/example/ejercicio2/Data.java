package com.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Integer> numbers = new ArrayList<>();

    public void add(int number){
        numbers.add(number);
    }

    public boolean numberExists(int number){
        for (int currentNumber: numbers){
            if(number == currentNumber) return true;
        }
        return false;
    }

    public ArrayList<Integer> getPositionsOf(int number){
        if(!numberExists(number)) return null;

        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++){
            if(numbers.get(i).equals(number)){
                positions.add(i);
            }
        }
        return positions;
    }

    public int appeearingTimes(int number){
        if(!numberExists(number)) return 0;
        return getPositionsOf(number).size();
    }
}
