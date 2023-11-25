package logistic;

import observer.Observer;

public class LogisticsAgent implements Observer {
    private String agentName;

    public LogisticsAgent(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public void update(String message) {
        System.out.println("Agente Logístico " + agentName + " recebeu uma atualização: " + message);
    }
}