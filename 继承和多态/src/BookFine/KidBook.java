package BookFine;

public class KidBook extends Book{
    public int callFines(int borrowingDays) {
        if (borrowingDays>21 ){
            money = (borrowingDays - 21);
            return money;

        }
        return borrowingDays;
    }
}
