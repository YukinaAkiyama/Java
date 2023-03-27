package BookFine;

public class Main{
    public static void main(String[] args) {
        KidBook kidBook = new KidBook();
        int KidMoney = 2* kidBook.callFines(30);
        AdultBook adultBook = new AdultBook();
        int AdultMoney = 2* adultBook.callFines(30);
        Disc disc = new Disc();
        int DiscMoney = disc.callFines(30);
        int TotalMoney = KidMoney+AdultMoney+DiscMoney;
        System.out.println("总共需要缴纳罚金数额为："+TotalMoney);
    }
}
