package Day036P;

public class Day03601문자열SelfTestP {
    public static void main(String[] args) {
        String helTlo = "helTlo";
        int size = helTlo.length();

        char t = 'T';
        System.out.println(helTlo.charAt(3));

        for (int i = 0; i < size; i++) {
            if (helTlo.charAt(i) == t) {
                System.out.println(i);
            }
        }

        String hello = "hello";
        // olleh로 재출력

        StringBuffer olleh = new StringBuffer(hello);
        olleh.reverse();
        System.out.println(olleh);
    }
}
