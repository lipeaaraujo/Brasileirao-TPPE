package campeonato;

import java.util.ArrayList;

public class Rodada {
    private ArrayList<Partida> partidas;

    public Rodada(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public void jogarRodada(int [] golsCasa, int [] golsVisitante,
                            int [] cartoesAmarelosCasa, int [] cartoesAmarelosVisitante,
                            int [] cartoesVermelhosCasa, int [] cartoesVermelhosVisitante) {
        for (int i = 0; i < partidas.size(); i++) {
            partidas.get(i).jogarPartida(
                golsCasa[i],
                golsVisitante[i],
                cartoesAmarelosCasa[i],
                cartoesAmarelosVisitante[i],
                cartoesVermelhosCasa[i],
                cartoesVermelhosVisitante[i]
            );
        }
        
    }

    // GETTERS E SETTERS
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }
}
