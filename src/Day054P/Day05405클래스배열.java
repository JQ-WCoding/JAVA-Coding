package Day054P;

class Animal {
    String name;
    int age;

    public void print() {
        System.out.println(name + " : " + age);
    }
}

public class Day05405클래스배열 {
    public static void main(String[] args) {
        String data = "3\n";
        data = data + "기린/3\n";
        data = data + "코끼리/1\n";
        data = data + "사슴/5\n";

        System.out.println(data);

        Animal[] animals;
        // 문제 1) data 에 있는 내용을 잘라서 animalList 에 저장 후 출력해보자.

        // 문제 2) 가장 어린 동물 삭제 후 다시 data 변수에 저장해보자.
    }
}
