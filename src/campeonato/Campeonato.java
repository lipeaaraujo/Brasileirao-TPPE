package campeonato;

import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<Rodada> rodadas;

    public Campeonato(ArrayList<Time> times) {
        this.times = times;
        this.rodadas = criarRodadas();
    }

    private ArrayList<Rodada> criarRodadas() {
        // Lógica para criar as rodadas do campeonato
        return new ArrayList<Rodada>();
    }
    
    public void classificacao() {
        // Lógica para exibir a classificação do campeonato
    }

    public void jogarProximaRodada() {
        // Lógica para jogar a próxima rodada do campeonato
    }

    // GETTERS E SETTERS
    public ArrayList<Rodada> getRodadas() {
        return rodadas;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    public void setRodadas(ArrayList<Rodada> rodadas) {
        this.rodadas = rodadas;
    }
}
