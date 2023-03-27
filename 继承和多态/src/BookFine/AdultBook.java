package BookFine;

public class AdultBook extends Book{
    @Override
    public int callFines(int borrowingDays) {
        if (borrowingDays>21 & borrowingDays <=24 ){
            money = (borrowingDays-21)*2;
            return money;
        }
        if (borrowingDays>24 ){
            money = (borrowingDays-24)*5;
            return (money+6);
        }
        return 1;
    }
}
