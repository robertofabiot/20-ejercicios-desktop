package com.example.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class data {
    private List<String> students = new ArrayList<>();

    public List<String> getStudents(){
        return students;
    }

    public String add(String student){
        students.add(student);
        return student;
    }

    public List<Integer> search(String student){
        List<Integer> positionsOfStudent = new ArrayList<>();
        for(int i = 0; i < students.size(); i++){
            if(student.equals(students.get(i))) positionsOfStudent.add(i);
        }
        return positionsOfStudent;
    }

    public boolean delete(String student){
        return students.remove(student);
    }

    public Integer getQuantity(String student){
        return search(student).size();
    }
}
