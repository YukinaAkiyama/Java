package Socialism;

/**
 * @author 86176
 */
public class Province extends StateCouncil implements CentralPartyCommittee {
    @Override
    void safetyInProduction() {
        System.out.println("我们各省人民一定按照国务院的指示进行安全生产！！！");
    }

    @Override
    public void playLeader() {
        System.out.println("我们各省人民一定坚持党的领导！！！");
    }
}
