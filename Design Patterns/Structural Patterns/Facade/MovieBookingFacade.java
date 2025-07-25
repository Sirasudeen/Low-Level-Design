package Facade;

public class MovieBookingFacade {
    private PaymentService paymentService;
    private SeatReservationService seatReservationService;
    private NotificationService notificationService;

    public MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.seatReservationService = new SeatReservationService();
        this.notificationService = new NotificationService();
    }

    public void bookMovie(String accountId, String movieId, String seatNumber, double amount) {
        paymentService.makePayment(accountId, amount);
        seatReservationService.reserveSeat(movieId, seatNumber);
        notificationService.sendNotification(accountId, "Movie booking confirmed for movie " + movieId);
        
            System.out.println("Movie ticket booking completed successfully!");

    }
}
