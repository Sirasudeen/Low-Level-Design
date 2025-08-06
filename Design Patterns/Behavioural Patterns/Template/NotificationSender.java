package Template;

public abstract class NotificationSender {
    public final void send(String to, String rawMsg)
    {
        rateLimitCheck(to);
        validateRecipient(to);
        String formatted = formatMessage(rawMsg);
        preSendAuditLog(to, formatted);

        String composedMessage = composeMessage(formatted);
        sendMessage(to, composedMessage);
        
        postSendAnalytics(to);
    }

        private void rateLimitCheck(String to) {
        System.out.println("Checking rate limits for: " + to);
    }

    private void validateRecipient(String to) {
        System.out.println("Validating recipient: " + to);
    }

    private String formatMessage(String message) {
        return message.trim(); 
    }

    private void preSendAuditLog(String to, String formatted) {
        System.out.println("Logging before send: " + formatted + " to " + to);
    }

    protected abstract String composeMessage(String formattedMessage);

    protected abstract void sendMessage(String to, String message);

    protected void postSendAnalytics(String to) {
        System.out.println("Analytics updated for: " + to);
    }
}
