package Adapter;

class Main 
{
    public static void main(String[] args)
    {

        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkOut("123", 100);
        CheckoutService checkoutService2 = new CheckoutService(new RazorPayAdapter());
        checkoutService2.checkOut("1234", 101);
    }
}