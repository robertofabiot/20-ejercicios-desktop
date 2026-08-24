package com.example.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Double> grades = new ArrayList<>();

    public void add(double grade){
        grades.add(grade);
    }

    public double getAvg(){
        double sum = 0;
        for(double grade: grades){
            sum += grade;
        }
        int size = grades.size();

        return sum / size;
    }

    public double getHighestGrade(){
        double highestGrade = grades.get(0);
        for(int i = 0; i < grades.size(); i++){
            if(highestGrade < grades.get(i)) highestGrade = grades.get(i);
        }
        return highestGrade;
    }

    public double getLowesttGrade(){
        double lowestGrade = grades.get(0);
        for(int i = 0; i < grades.size(); i++){
            if(lowestGrade > grades.get(i)) lowestGrade = grades.get(i);
        }
        return lowestGrade;
    }

    public int getCountOfPassingStudents(){
        int count = 0;
        for(double grade: grades){
            if(grade >= 70) count++;
        }
        return count;
    }

    public int getCountOfFailingStudents(){
        return grades.size() - getCountOfPassingStudents();
    }
}
