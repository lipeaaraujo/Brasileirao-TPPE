package campeonato;

import java.util.ArrayList;

public class Rodada {
    private ArrayList<Partida> partidas;

    public Rodada(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    // GETTERS E SETTERS
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }
}
