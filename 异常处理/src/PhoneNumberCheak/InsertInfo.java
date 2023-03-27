package PhoneNumberCheak;

import java.util.regex.Pattern;

public class InsertInfo {
    boolean checkBool = true;
    public boolean addInfo(String name, int age, String phoneNumber)throws CheckException {
        if ((phoneNumber != null) && (!phoneNumber.isEmpty())) {
            checkBool = Pattern.matches("^1[3-9]\\d{9}$", phoneNumber);
            if (checkBool){
                System.out.println("Please check your personal information!");
                System.out.println("name："+name+"  age："+age+"  phone number："+phoneNumber);
            }else {
                throw new CheckException();
            }
        }
        return false;
    }
}
