package observer;


public class ConcreteObserver implements Observer {
    private Subject subject;

    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(String message) {
        System.out.println("Observer recebeu uma atualização: " + message);
    }
}
