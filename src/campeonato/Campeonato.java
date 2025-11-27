package campeonato;

import java.util.ArrayList;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<Rodada> rodadas;

    public Campeonato(ArrayList<Time> times) {
        this.times = times;
        this.rodadas = criarRodadas();
    }

    private ArrayList<Partida> confrontosDiretos(ArrayList<Time> timesConfronto, int rodada) {
        int n = timesConfronto.size();
        ArrayList<Partida> confrontos = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            Time time1 = timesConfronto.get(i);
            Time time2 = timesConfronto.get(n - 1 - i);

            if (rodada < n - 1) {
                confrontos.add(new Partida(time1, time2)); // ida
            } else {
                confrontos.add(new Partida(time2, time1)); // volta
            }
        }
        return confrontos;
    }

    private ArrayList<Rodada> criarRodadas() {
        ArrayList<Rodada> rodadas = new ArrayList<>();
        ArrayList<Time> listaTimes = new ArrayList<>(times);
        int n = listaTimes.size();

        int totalRodadas = (n - 1) * 2;

        for (int rodada = 0; rodada < totalRodadas; rodada++) {
            ArrayList<Partida> partidasRodada = new ArrayList<>();
            partidasRodada = confrontosDiretos(listaTimes, rodada);
            rodadas.add(new Rodada(partidasRodada));

            Time ultimo = listaTimes.remove(listaTimes.size() - 1);
            listaTimes.add(1, ultimo);
        }

        return rodadas;
    }
    
    // Logica de classificao dos times na tabela de pontos
    public void classifica() {
        new Classificacao(times,rodadas).classificar();
    }

	public void jogarProximaRodada(int [] golsCasa, int [] golsVisitante,
                                   int [] cartoesAmarelosCasa, int [] cartoesAmarelosVisitante,
                                   int [] cartoesVermelhosCasa, int [] cartoesVermelhosVisitante) {
        for (Rodada rodada : rodadas) {
            boolean rodadaConcluida = rodada.getPartidas().stream().allMatch(Partida::isConcluida);
            if (!rodadaConcluida) {
                rodada.jogarRodada(golsCasa, golsVisitante,
                                   cartoesAmarelosCasa, cartoesAmarelosVisitante,
                                   cartoesVermelhosCasa, cartoesVermelhosVisitante);
                break;
            }
        }

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