package Fishing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Fishing{
    public static Date setDate(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the date in \"yyyy-MM-DD\" format");
        String time=input.nextLine();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            System.out.println("Error!");
        }
        System.out.println("Date: "+ date);
        return date;
    }

    public static void fishingTime(Date startTime, Date overTime){
        long startDate=startTime.getTime();
        long overDate=overTime.getTime();
        long days = ((overDate - startDate)/(24 * 60 * 60 * 1000)) % 5;
        if(days > 0 && days < 4) {
            System.out.println("\nThis day is fishing day!");
        } else {
            System.out.println("\nThis day is drying day!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Start Time:");
        Date date1 = setDate();
        System.out.println("Over Time:");
        Date date2 = setDate();
        fishingTime(date1,date2);
    }
}
