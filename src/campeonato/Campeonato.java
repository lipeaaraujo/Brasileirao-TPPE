package campeonato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Campeonato {
    private ArrayList<Time> times;
    private ArrayList<Rodada> rodadas;

    public Campeonato(ArrayList<Time> times) {
        this.times = times;
        this.rodadas = criarRodadas();
    }

    private ArrayList<Rodada> criarRodadas() {
        ArrayList<Rodada> rodadas = new ArrayList<>();
        ArrayList<Time> listaTimes = new ArrayList<>(times);
        int n = listaTimes.size();

        int totalRodadas = (n - 1) * 2;

        for (int rodada = 0; rodada < totalRodadas; rodada++) {
            ArrayList<Partida> partidasRodada = new ArrayList<>();

            for (int i = 0; i < n / 2; i++) {
                Time time1 = listaTimes.get(i);
                Time time2 = listaTimes.get(n - 1 - i);

                if (rodada < n - 1) {
                    partidasRodada.add(new Partida(time1, time2)); // ida
                } else {
                    partidasRodada.add(new Partida(time2, time1)); // volta
                }
            }

            rodadas.add(new Rodada(partidasRodada));

            Time ultimo = listaTimes.remove(listaTimes.size() - 1);
            listaTimes.add(1, ultimo);
        }

        return rodadas;
    }

    private int confrontosDiretos(Time time1, Time time2){
        int vitorias_time1 = 0;
        int vitorias_time2 = 0;
        for(Rodada rodada : rodadas){
            for(Partida partida : rodada.getPartidas()){
                if(partida.isConcluida()){
                    Time casa = partida.getTimeCasa();
                    Time visitante = partida.getTimeVisitante();

                    if((casa.equals(time1) && visitante.equals(time2)) || 
                        (casa.equals(time2) && visitante.equals(time1)))
                    {
                        if(casa.equals(time1)){
                            if(partida.getGolsCasa() > partida.getGolsVisitante())
                            {
                                vitorias_time1++;
                            }
                            else if(partida.getGolsCasa() < partida.getGolsVisitante())
                            {
                                vitorias_time2++;
                            }
                        }
                        else
                        {
                            if(partida.getGolsCasa() > partida.getGolsVisitante())
                            {
                                vitorias_time2++;
                            }
                            else if(partida.getGolsCasa() < partida.getGolsVisitante())
                            {
                                vitorias_time1++;
                            }
                        }
                    }
                }
            }
        }

        if(vitorias_time1 > vitorias_time2){
            return 1;
        }
        if(vitorias_time2 > vitorias_time1){
            return 2;
        }
        return 0;
    }

    private void ordenarPorCartoes(List<Time> bloco) {
        Collections.sort(bloco, Comparator
                .comparingInt(Time::getCartoesVermelhos)
                .thenComparingInt(Time::getCartoesAmarelos));
    }
    public void classificacao() {
        // Lógica para exibir a classificação do campeonato
        this.times.sort(Comparator.comparingInt(Time::getPontos)
                    .reversed()
                    .thenComparingInt(Time:: getVitorias)
                    .reversed()
                    .thenComparingInt(Time:: getSaldo)
                    .reversed()
                    .thenComparingInt(Time::getGolsPro).reversed());
        
        int i = 0;
        int times_size = times.size();
        while(i < times_size){
            int j= i ;

            while(j < times_size && 
                  times.get(i).getPontos() == times.get(j).getPontos() &&
                  times.get(i).getVitorias() == times.get(j).getVitorias() &&
                  times.get(i).getSaldo() == times.get(j).getSaldo() &&
                  times.get(i).getGolsPro() == times.get(j).getGolsPro()){
                j++;
            }

            if(j - i > 1){
                List<Time> bloco = times.subList(i, j);
                if(bloco.size() == 2){
                    int r = this.confrontosDiretos(bloco.get(0), bloco.get(1));
                    if(r == 0){
                        this.ordenarPorCartoes(bloco);
                    }
                    else if(r == 2){
                        Collections.swap(times, i, i+ 1);
                    }
                }
                else{
                    ordenarPorCartoes(bloco);
                }
            }
            i = j;
        }
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
