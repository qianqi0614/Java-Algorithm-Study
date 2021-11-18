package DesignPatterns;

public class Test {
    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoLi xiaoLi = new LaoLi();
        LaoWang xiaoWang = new LaoWang();

        xiaoMei.addPerson(xiaoLi);
        xiaoMei.addPerson(xiaoWang);

        xiaoMei.notifyPerson();
    }
}
