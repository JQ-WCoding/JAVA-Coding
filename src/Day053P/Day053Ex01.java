package Day053P;

class Student {
    String name;
    int age;
}

public class Day053Ex01 {
    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        int[] arr = {n1, n2, n3};
//		int[] arr = new int[3];
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;


        Student s1 = new Student();
        s1.name = "홍길동";
        s1.age = 19;

        Student s2 = new Student();
        s2.name = "김길동";
        s2.age = 20;
        // 클래스를 메모리에 할당할 때, 소괄호()
        Student s3 = new Student();
        s3.name = "최길동";
        s3.age = 21;

        Student[] stList = new Student[3];
        // 클래스 생성!(실수를 가장 많이 하는 부분)
        for (int i = 0; i < stList.length; i++) {
            stList[i] = new Student();
        }

		stList[0].name = "유길동";
		System.out.println(stList[0].name);
    }
}

