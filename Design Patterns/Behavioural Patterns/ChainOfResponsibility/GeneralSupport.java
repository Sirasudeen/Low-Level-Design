package ChainOfResponsibility;

public class GeneralSupport extends SupportHandler{
    @Override
    public void handleRequest(String reqType) {
        if (reqType.equalsIgnoreCase("general")) {
            System.out.println("GeneralSupport: Handling general query");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(reqType);
        }
    }
}
