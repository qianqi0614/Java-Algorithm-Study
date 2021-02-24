package StaticProxy;

public class SmsServiceProxy implements SmsService{

    private final SmsService smsService;

    public SmsServiceProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("Do something before sending.");
        smsService.send(message);
        System.out.println("Do something after sending.");
        return null;
    }
}
