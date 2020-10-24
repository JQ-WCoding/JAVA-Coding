package ATM;

public class ATMuserDB {
    private int id;
    private int pw;
    private int money;
    // 새 클래스에 만들고 private 써도 되나? 그러면 db.arId 표현했을때 private 자기가 참조할 수 있구나

    public ATMuserDB() { // default

    }
    // cmd + n constructor
    public ATMuserDB(int id, int pw, int money) {
        this.id = id;
        this.pw = pw;
        this.money = money;
    }
    // 캡슐화
    // cmd + n getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
