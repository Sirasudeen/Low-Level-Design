package Prototype;

public interface EmailTemplate extends Cloneable {
    void setContent(String content);
    void send(String to);
    EmailTemplate clone();
}
