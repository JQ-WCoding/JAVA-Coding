package Day055P;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        setAge(age);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Day05505캡슐화2 {
    public static void main(String[] args) {
        Student student = new Student("홍길동", 11);
        System.out.println(student.getAge());
        System.out.println(student.getName());
    }
}
