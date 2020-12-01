package Day054P;
class Member{
    String name;
    int num;
}
class MemberManager{
    Member[] members = new Member[3];
}
public class Day05401클래스배열 {
    public static void main(String[] args) {
        MemberManager memberManager = new MemberManager();

        Member member1 = new Member();
        memberManager.members[0] = member1;
        member1.name = "김철수";
        member1.num = 1001;

        member1 = new Member();
        memberManager.members[1] = member1;
        member1.name = "이만수";
        member1.num = 1002;

        Member temp = memberManager.members[1];
        System.out.println(temp.name);
    }
}
