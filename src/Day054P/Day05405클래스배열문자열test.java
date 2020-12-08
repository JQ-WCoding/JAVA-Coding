package Day054P;

import java.util.Arrays;

class Animal {
    String name;
    int age;

    public void print() {
        System.out.println(name + " : " + age);
    }
}

public class Day05405클래스배열문자열test {
    public static void main(String[] args) {
        String data = "3\n";
        data = data + "기린/3\n";
        data = data + "코끼리/1\n";
        data = data + "사슴/5\n";

//        System.out.println(data);

        Animal[] animals;
        // 문제 1) data 에 있는 내용을 잘라서 animalList 에 저장 후 출력해보자.
        String[] splitData = data.split("\n");
        int size = Integer.parseInt(splitData[0]);
        animals = new Animal[size];

        for (int i = 0; i < size; i++) {
            animals[i] = new Animal();

            String[] innerSplit = splitData[i + 1].split("/");
            animals[i].name = innerSplit[0];
            animals[i].age = Integer.parseInt(innerSplit[1]);
        }

        for (int i = 0; i < animals.length; i++) {
            animals[i].print();
        }
        System.out.println();

        // 문제 2) 가장 어린 동물 삭제 후 다시 data 변수에 저장해보자.
        int min = animals[0].age;
        int index = -1;
        for (int i = 0; i < animals.length; i++) {
            if (min > animals[i].age) {
                min = animals[i].age;
                index = i;
            }
        }

        Animal[] temp = new Animal[size - 1];

        // 하나 줄이기
        int count = 0;
        for (int i = 0; i < animals.length; i++) {
            if (index != i) {
                temp[count] = animals[i];
                count++;
            }
        }
        // 하나 줄인거 출력
        for (int i = 0; i < temp.length; i++) {
            temp[i].print();
        }
        System.out.println();

        count = 0;
        temp = new Animal[size];
        for (int i = 0; i < animals.length; i++) {
            if (index != i) {
                temp[count] = animals[i];
                count++;
            }
        }
        temp[count] = animals[index];

        for (int i =0;i< temp.length;i++){
            temp[i].print();
        }
    }
}
