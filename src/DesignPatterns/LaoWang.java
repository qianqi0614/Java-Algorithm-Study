package DesignPatterns;

public class LaoWang implements Person{
    private String name = "小王";

    public LaoWang() {};

    @Override
    public void getMessage(String s) {
        System.out.println(name+"接到了小美的短信，内容是:" + s);
    }
}
