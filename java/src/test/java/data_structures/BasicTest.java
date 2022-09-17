package data_structures;

import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.junit.jupiter.api.Test;
import org.w3c.dom.NameList;

import javax.lang.model.SourceVersion;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;


public class BasicTest {

    @Test
    void test1(){
        class Student {
            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return code.equals(student.code) &&
                        name.equals(student.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(code,name);
            }
        }

        Student s1 = new Student();
        s1.setCode("00001");
        s1.setName("test1");
        Student s2 = new Student();
        s2.setCode("00001");
        s2.setName("test2");

        HashMap<Student, String> map = new LinkedHashMap<>();
        map.put(s1,"test1");
        map.put(s2, "test2");
        System.out.println(map.toString());

        Set<Student> students = new LinkedHashSet<>();

        students.add(s1);
        students.add(s2);
        s2.setCode("00002");
        students.add(s2);
        System.out.println(students);
    }

    class Student {

        private int age;
        private String name;

        public Student(int age, String name){
            this.age = age;
            this.name = name;
        }


    }


    @Test
    void testvarargs() throws CloneNotSupportedException {
        getUsers("type",1,2);
        assertEquals(true, Objects.equals("test1","test1"));

        String[] strs = {"a","b","c"};
        List<String> list = Arrays.asList(strs);
        Arrays.stream(strs).map(String::toString);

        ArrayList<Student> sts = new ArrayList<Student>();

        sts.add(new Student(1,"zsl"));
        sts.add(new Student(2, "zsl2"));
        sts.add(new Student(2,"lisi"));
        sts.add(new Student(1,"zhangsna"));

        Arrays.sort(sts.toArray(new Student[4]), new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.age >s2.age? -1:1;
            }
        });

        Executors.newFixedThreadPool(2);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Instant instant;


    }

    private String[] getUsers(String type, Integer... ids){
        String[] res = new String[10];
        res[0] = type;
        res[1] = ids[0]+"";
        res[1] = ids[1]+"";

        return res;
    }

}
