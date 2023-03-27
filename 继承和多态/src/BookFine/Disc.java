package BookFine;

public class Disc extends Book{
    public int callFines(int borrowingDays) {
        if (borrowingDays>14 & borrowingDays <=17 ){
            money = (borrowingDays-14)*5;
            return money;
        }
        if (borrowingDays>17 ){
            money = (borrowingDays-17)*10;
            return (money+15);
        }
        return 1;
    }


}
