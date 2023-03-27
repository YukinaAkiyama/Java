package LowCalculator;

/**
 * @author 86176
 */
public class LowListener extends LowPanel{
    private double sideLengthA;
    private double sideLengthB;
    private double sideLengthC;
    public java.text.DecimalFormat df1 =new java.text.DecimalFormat("#.00");
    public java.text.DecimalFormat df2 =new java.text.DecimalFormat("#.0000");

    LowListener(){
        resultButton.addActionListener(
                e -> {
                    sideLengthA = Double.parseDouble(lengthText1.getText());
                    sideLengthB = Double.parseDouble(lengthText2.getText());
                    sideLengthC = Double.parseDouble(lengthText3.getText());
                    getLengthA(sideLengthA);
                    getLengthB(sideLengthB);
                    getLengthC(sideLengthC);
                    result.setText(resultShowText());
                });

        restartButton.addActionListener(
                e -> {
                    lengthText1.setText("");
                    lengthText2.setText("");
                    lengthText3.setText("");
                    result.setText("");
                });
    }

    public String getLengthA(double lengthA){
        return df1.format(lengthA);
    }
    public String getLengthB(double lengthB){
        return df1.format(lengthB);
    }
    public String getLengthC(double lengthC){
        return df1.format(lengthC);
    }

    public String resultShowText(){
        String message;
        message = "三角形"
                +getLengthA(sideLengthA)+","
                +getLengthB(sideLengthB)+","
                +getLengthC(sideLengthC)
                +"的面积是"
                +getArea(sideLengthA,sideLengthB,sideLengthC);
        return message;
    }
    public String getArea(double length1, double length2, double length3){
        double area;
        double p;
        double sqrt;
        p = (length1+length2+length3)/2;
        sqrt = p*(p-length1)*(p-length2)*(p-length3);
        area = Math.sqrt(sqrt);
        return String.valueOf(df2.format(area));
    }
}
