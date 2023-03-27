package Master;

/**
 * @author 86176
 */
public class People extends Monkey{
    People(String s) {
        super(s);
    }
    @Override
    public void speak(){
        System.out.println("小样儿~不错嘛~会说话了！");
    }
    void think(){
        System.out.println("别说话，认真思考");
    }
}
