package campeonato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Classificacao {
	private List<Time> times;
    private List<Rodada> rodadas;
	
	
	public Classificacao(ArrayList<Time> times,ArrayList<Rodada> rodadas) {
		this.times = times;
        this.rodadas = rodadas;
		
	}
	
	public void classificar(){
		ordenaTimes();
		desempata();
	}
	
	public void ordenaTimes() {
		times.sort(Comparator.comparingInt(Time::getPontos)
				.reversed()
				.thenComparingInt(Time:: getVitorias)
				.reversed()
				.thenComparingInt(Time:: getSaldo)
				.reversed()
				.thenComparingInt(Time::getGolsPro).reversed());
	}
	
	public void desempata()
	{
        int i = 0;
        int n = times.size();

        while (i < n) {
            int j = i;

            while (j < n &&
                    empataram(times.get(i), times.get(j))) {
                j++;
            }

            if (j - i > 1) {
                List<Time> bloco = times.subList(i, j);

                if (bloco.size() == 2) {
                    desempataDupla(bloco);
                } else {
                    ordenarPorCartoes(bloco);
                }
            }

            i = j;
        }
    };
    
    private boolean empataram(Time a, Time b) {
    	return a.getPontos() == b.getPontos()
    			&& a.getVitorias() == b.getVitorias()
    			&& a.getSaldo() == b.getSaldo()
    			&& a.getGolsPro() == b.getGolsPro();
    };
    
    private void desempataDupla(List<Time> bloco) {
        Time t1 = bloco.get(0);
        Time t2 = bloco.get(1);

        int r = confrontosDiretos(t1, t2);

        if (r == 0) { // empate no confronto direto, desempata pelo cartao
            ordenarPorCartoes(bloco);
        }
        else if (r == 2) { 
            // time 2 venceu → inverter
            Collections.swap(times, times.indexOf(t1), times.indexOf(t2));
        }
    }
    
    private int confrontosDiretos(Time t1, Time t2) {
        int v1 = 0; // Vitorias do time 1
        int v2 = 0; // Vitorias do time 2

        for (Rodada rodada : rodadas) {
            for (Partida p : rodada.getPartidas()) {
                if (!p.isConcluida()) continue;

                Time casa = p.getTimeCasa();
                Time visitante = p.getTimeVisitante();

                boolean envolve = (casa.equals(t1) && visitante.equals(t2)) ||
                                  (casa.equals(t2) && visitante.equals(t1));
                if (!envolve) continue;

                if (casa.equals(t1)) {
                    if (p.getGolsCasa() > p.getGolsVisitante()) v1++;
                    else if (p.getGolsCasa() < p.getGolsVisitante()) v2++;
                } else {
                    if (p.getGolsCasa() > p.getGolsVisitante()) v2++;
                    else if (p.getGolsCasa() < p.getGolsVisitante()) v1++;
                }
            }
        }

        if (v1 > v2) return 1;
        if (v2 > v1) return 2;
        return 0;
    }

    private void ordenarPorCartoes(List<Time> bloco) {
        Collections.sort(bloco, Comparator
                .comparingInt(Time::getCartoesVermelhos)
                .thenComparingInt(Time::getCartoesAmarelos));
    }
    
}