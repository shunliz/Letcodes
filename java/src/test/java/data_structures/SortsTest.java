package data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {
    Person[] ps = null;

    @Test
    void shellSort() {
        int[] arr = {3,6,8,2,9};
        Sorts.shellSort(arr);
        assertArrayEquals(new int[]{2,3,6,8,9}, arr);
    }

    @Test
    void nonRec_quickSort() {
        int[] arr = {3,6,8,2,9};
        Sorts.nonRec_quickSort(arr,0,4);
        assertArrayEquals(new int[]{2,3,6,8,9}, arr);
    }

    @Test
    void countingSort() {
        int[] arr = {3,2,8,9,3,6,8,2,9};
        arr=Sorts.countingSort(arr);
        assertArrayEquals(new int[]{2,2,3,3,6,8,8,9,9}, arr);

    }

    @Test
    void mycountingSort() {
        int[] arr = {3,2,8,9,3,6,8,2,9};
        arr=Sorts.mycountingSort(arr);
        assertArrayEquals(new int[]{2,2,3,3,6,8,8,9,9}, arr);
    }

    @Test
    void radixSort() {
        int[] arr = {34,25,81,94,33,67,82,23,99};
        arr=Sorts.radixSort(arr);
        assertArrayEquals(new int[]{23,25,33,34,67,81,82,94,99}, arr);

    }

    class Person implements Comparable {
        String name;
        int age;
        int height;

        public Person(){

        }

        public Person(String name, int age, int height, int weight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        int weight;

        @Override
        public int compareTo(Object o) {
            if(!(o instanceof Person)){
                throw new IllegalArgumentException("Cannot compare to none person type");
            }
            Person person = (Person) o;
            return this.age - person.age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }

    class Teacher extends Person {
        int workage;

        public Teacher(String name, int age, int height, int weight, int workage) {
            super(name, age, height, weight);
            this.workage = workage;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", workage=" + workage +
                    '}';
        }
    }

    class MathTeacher extends Teacher {
        String tclass;

        public MathTeacher(String name, int age, int height, int weight, int workage, String tclass) {
            super(name, age, height, weight, workage);
            this.tclass = tclass;
        }

        @Override
        public String toString() {
            return "MathTeacher{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    ", weight=" + weight +
                    ", workage=" + workage +
                    ", tclass='" + tclass + '\'' +
                    '}';
        }
    }

    @BeforeEach
    void init(){
        Teacher zhangsan = new MathTeacher("zhangsan",21, 180,60, 4, "1math");
        Teacher lisi = new MathTeacher("lisi",41, 175,70, 7, "4math");
        Teacher wangwu = new MathTeacher("wangwu",51, 165,60, 14, "5math");

        ps = new Person[]{zhangsan, lisi, wangwu};
    }

    @Test
    void bubbleSort() {

        Sorts.bubbleSort(ps, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height-o2.height;
            }
        });
        Sorts.print(ps);

        Sorts.bubbleSort(ps, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });
        Sorts.print(ps);

        Sorts.bubbleSort(ps,null);
        Sorts.print(ps);

        System.out.println("###############################");
    }

    @Test
    void selectSort() {
        Person[] before = ps;
        Sorts.selectSort(ps,null);
        Sorts.print(ps);
        assertArrayEquals(before, ps);
    }

    @Test
    void insertSort() {
        Person[] before = ps;
        Sorts.insertSort(ps,null);
        Sorts.print(ps);
        assertArrayEquals(before, ps);
    }

    @Test
    void quickSort() {
        Person[] after = {ps[2],ps[1],ps[0]};
        Sorts.quickSort(ps, 0, 2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height-o2.height;
            }
        });
        Sorts.print(ps);
        assertArrayEquals(after, ps);
    }

    @Test
    void quickSort2() {
        int[] arr = {3,6,8,2,9};
        Sorts.myquicksort(arr,0, 4);
        assertArrayEquals(new int[]{2,3,6,8,9}, arr);
    }

    @Test
    void mergeSort() {
        Person[] before = ps;
        Sorts.mergeSort(ps, 0, 2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Sorts.print(ps);
        assertArrayEquals(before, ps);
    }



}