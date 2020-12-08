package Day054P;

class Quiz {
    int num;
    int size;
    char[] data;

    public void print() {
        for (char datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }
}

public class Day05406클래스배열문자열test2 {
    public static void main(String[] args) {
        String data = "6\n";
        data += "0/2/a/b\n";
        data += "1/3/a/b/c\n";
        data += "2/5/a/b/c/d/e\n";
        data += "3/4/a/b/c/d\n";
        data += "4/3/a/b/c\n";
        data += "5/1/a";

        Quiz[] quiz;
        // data의 정보를 Quiz 클래스배열에 저장해보자.
        String[] inData = data.split("\n");
        quiz = new Quiz[Integer.parseInt(inData[0])];

        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = new Quiz();
            String[] innerData = inData[i + 1].split("/");
            quiz[i].num = Integer.parseInt(innerData[0]);
            quiz[i].size = Integer.parseInt(innerData[1]);
            quiz[i].data = new char[quiz[i].size];
            for (int j = 0; j < quiz[i].size; j++) {
                // char 형
                quiz[i].data[j] = innerData[2 + j].charAt(0);
            }
        }

        for (Quiz value : quiz) {
            value.print();
        }
    }
}
