package Day053P;

class Client {
    String name;
    int score;

    public void setData(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void printData() {
        System.out.println(this.name + " : " + this.score);
    }
}

public class Day05302클래스배열 {
    public static void main(String[] args) {

        Client[] clients = new Client[3];

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client();
        }

        clients[0].setData("김청수", 100);
        clients[1].setData("이만수", 20);
        clients[2].setData("박영희", 70);

        for (Client client : clients) {
            client.printData();
        }
    }
}
