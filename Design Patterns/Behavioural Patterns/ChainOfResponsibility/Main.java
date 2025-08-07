package ChainOfResponsibility;
public class Main {
    public  static void main(String[] args)
    {
        SupportHandler general = new GeneralSupport();
        SupportHandler billing = new BillingSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler delivery = new DeliverySupport();


        billing.setNextHandler(technical);
        technical.setNextHandler(delivery);
        general.setNextHandler(billing);

        general.handleRequest("refund");
        general.handleRequest("delivery");
    }
}
