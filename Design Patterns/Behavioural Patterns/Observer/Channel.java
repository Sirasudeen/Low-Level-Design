package Observer;

public interface Channel {
    void Subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}
