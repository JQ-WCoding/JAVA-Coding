package Portfolio.bank;

public class Main {
    public static void main(String[] args) {
        FileManger fileManger = new FileManger();

        ClientManager clientManager = new ClientManager();
        AccountManager accountManager = new AccountManager();

        Bank junBank = new Bank(fileManger, clientManager, accountManager);
        junBank.run();
    }
}
