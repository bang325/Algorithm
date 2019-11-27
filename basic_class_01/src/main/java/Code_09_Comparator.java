import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Bang
 * @date 2019/8/7  16:38
 */
public class Code_09_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    public static class IdAscComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1,Student o2) {
            return o1.id - o2.id;
        }
    }
    public static class IdDescComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }
    public static class AgeAscComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }
    public static class AgeDescComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }
    public static void printStu(Student[] students){
        for (Student student:students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("=====================================");
    }
    public static void main(String[] args){
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = {student1, student2, student3};
        printStu(students);

        Arrays.sort(students,new IdAscComparator());
        printStu(students);

        Arrays.sort(students,new IdDescComparator());
        printStu(students);

        Arrays.sort(students,new AgeAscComparator());
        printStu(students);

        Arrays.sort(students,new AgeDescComparator());
        printStu(students);
    }
}

