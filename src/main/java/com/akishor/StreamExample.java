package com.akishor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class StreamExample {


    public List doubleList(List<Integer> numbers){

        return numbers.stream()
                .map(number->number*2)
                .collect(Collectors.toList());
    }

    public List<String> getStudentNames(List<Student> students){

        return students.parallelStream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    public CompletableFuture<List<String>> getStudentNamesParallel(List<Student> students){

        return CompletableFuture.completedFuture(students.parallelStream()
                .map(student -> student.getName())
                .collect(Collectors.toList()));
    }

    public Map<String, Student> getStudentMap(List<Student> students){
        return students.stream()
                .collect(Collectors.toMap(Student::getName, student -> student));
    }
}
