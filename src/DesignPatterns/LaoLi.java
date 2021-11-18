package DesignPatterns;

public class LaoLi implements Person {
    private String name = "小李";
    public LaoLi() {};
    @Override
    public void getMessage(String s) {
        System.out.println(name+"接到了小美的短信，内容是：" + s);
    }
}
