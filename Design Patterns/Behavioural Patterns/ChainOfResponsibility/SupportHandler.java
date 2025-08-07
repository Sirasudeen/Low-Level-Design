package ChainOfResponsibility;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;
    public void setNextHandler(SupportHandler supportHandler)
    {
        this.nextHandler = supportHandler;
    }

    public abstract void handleRequest(String reqType);
}
