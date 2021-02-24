package StaticProxy;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsServiceProxy smsProxy = new SmsServiceProxy(smsService);
        smsProxy.send("java");
    }
}
