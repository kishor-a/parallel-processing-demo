package com.akishor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;

public class StreamExampleTest {

    List<Student> students;
    StreamExample streamExample;

    @Before
    public void setup() throws Exception{

        streamExample =  new StreamExample();

        Student johnStudent = new Student("John","5","Science");
        Student student2 = new Student("Peter","7","Art");
        Student student3 = new Student("Karim","5","Geology");

        students = Arrays.asList(johnStudent,student2,student3);
    }

    @Test
    public void doubleListTest(){
        StreamExample streamExample =  new StreamExample();

        List<Integer> inputList = Arrays.asList(1,2,3);
        List<Integer> expectedList = Arrays.asList(2,4,6);

        List resultList = streamExample.doubleList(inputList);

        Assert.assertThat(resultList, is(expectedList));
    }

    @Test
    public void testGetAllStudentNames(){

        List<String> names = streamExample.getStudentNames(students);
        List<String> expectedNames = Arrays.asList("John","Peter","Karim");

        Assert.assertThat(names,is(expectedNames));
    }

    @Test
    public void testGetAllStudentNamesFuture(){

        List<String> names = streamExample.getStudentNamesParallel(students).join();
        List<String> expectedNames = Arrays.asList("John","Peter","Karim");

        Assert.assertThat(names,is(expectedNames));
    }

    @Test
    public void testCollectToMapForStudentList(){

        Map<String, Student> studentMap = streamExample.getStudentMap(students);
        Student johnStudent = new Student("John","5","Science");

        Assert.assertEquals(studentMap.get("John"),johnStudent);
    }

}