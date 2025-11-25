package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import campeonato.Campeonato;
import campeonato.Time;

import java.util.ArrayList;

// Teste que verifica o cenario de empate de pontos, mas o desempate por vitorias
public class TstDesempate {
    
    Time a, b, c, d;
    Campeonato campeonato;
    int[][] golsCasaRodadas;
    int[][] golsVisitanteRodadas;
    int[][] amarelosCasaRodadas;
    int[][] amarelosVisitanteRodadas;
    int[][] vermelhosCasaRodadas;
    int[][] vermelhosVisitanteRodadas;

    
    @Before
    public void setup() {
        a = new Time("Botafogo");
        b = new Time("Flamengo");
        c = new Time("Vasco");
        d = new Time("Fluminense");

        ArrayList<Time> times = new ArrayList<>();
        times.add(a);
        times.add(b);
        times.add(c);
        times.add(d);

        campeonato = new Campeonato(times);
        
        // Tive que alterar o cenario
        // Rodada 1: Botafogo 1 x 0 Fluminense, Flamengo 0 x 0 Vasco 
        // Rodada 2: Botafogo 0 x 1 Vasco, Fluminense 0 x 0 Flamengo
        // Rodada 3: Botafogo 1 x 1 Flamengo, Vasco 2 x 1 Fluminense
        // Rodada 4: Fluminense 1 x 0 Botafogo, Vasco 2 x 2 Flamengo
        // Rodada 5: Vasco 2 x 2 Botafogo, Flamengo 1 x 1 Fluminense
        // Rodada 6: Flamengo 4 x 4 Botafogo, Fluminense 3 x 1 Vasco

        // Aqui tem os gols so dos mandantes, nao confundir com o placar de cada partida
	    golsCasaRodadas = new int[][]{
	        {1, 0}, // Rodada 1
	        {0, 0}, // Rodada 2
	        {1, 2}, // Rodada 3
	        {1, 2}, // Rodada 4
	        {2, 1}, // Rodada 5
	        {4, 3}  // Rodada 6
	    };
	    
	    // Aqui tem os gols so dos visitantes, nao confundir com o placar de cada partida
	    golsVisitanteRodadas = new int[][] {
	        {0, 0}, // Rodada 1
	        {1, 0}, // Rodada 2
	        {1, 1}, // Rodada 3
	        {0, 2}, // Rodada 4
	        {2, 1}, // Rodada 5
	        {4, 1}  // Rodada 6
	    };
	    
	    amarelosCasaRodadas = new int[][] {
	        {1, 0}, {0, 1}, {2, 1}, {0, 1}, {1, 0}, {0, 2}
	    };
	    amarelosVisitanteRodadas = new int[][] {
	        {0, 2}, {1, 0}, {1, 0}, {1, 1}, {0, 1}, {2, 0}
	    };

	    vermelhosCasaRodadas = new int[][] {
	        {0, 0}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {1, 0}
	    };
	    vermelhosVisitanteRodadas = new int[][] {
	        {0, 1}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}
	    };
	    	    
    }

    @Test
    public void desempatePorVitorias() {
    	int totalRodadas = campeonato.getRodadas().size();

    	for (int i = 0; i < totalRodadas; i++) {
	        
			 // Realiza os jogos de cada rodada
	        campeonato.jogarProximaRodada(
	            golsCasaRodadas[i],
	            golsVisitanteRodadas[i],
	            amarelosCasaRodadas[i],
	            amarelosVisitanteRodadas[i],
	            vermelhosCasaRodadas[i],
	            vermelhosVisitanteRodadas[i]
	        );
	        
	        campeonato.classifica();
    	}
        
        // Botafogo e Flamengo empataram em pontos, mas o Botafogo tem 1 vitoria a mais
        // Entao verifica se Botafogo esta na frente do Flamengo
        assertTrue("Botafogo deve estar na frente por mais vitorias",
                campeonato.getTimes().get(0).getNome().equals("Botafogo"));
        assertTrue("Botafogo deve estar na frente por mais vitorias",
                campeonato.getTimes().get(1).getNome().equals("Flamengo"));
    }
}
