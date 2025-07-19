package isp;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        AiAgent agent = new AiAgent();
        human.work(); human.eat();
        agent.work();
    }
}
