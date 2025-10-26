package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

import campeonato.Campeonato;
import campeonato.Time;

// Classe que contem os cenarios para os principais casos
public class TstBase {

	 	Time a, b, c, d;
	    Campeonato campeonato;
	    int[][] golsCasaRodadas;
		int[][] golsVisitanteRodadas;
		int[][] amarelosCasaRodadas;
		int[][] amarelosVisitanteRodadas;
		int[][] vermelhosCasaRodadas;
		int[][] vermelhosVisitanteRodadas;
		int[][] pontuacoes;
		int[][] vitorias;
		int[][] golsMarcados;
		int[][] golsSofridos;
		int[][] saldosGols;

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
	        
	        // Rodada 1: Botafogo 2 x 0 Fluminense, Flamengo 2 x 1 Vasco 
		    // Rodada 2: Botafogo 2 x 1 Vasco, Fluminense 0 x 2 Flamengo
		    // Rodada 3: Botafogo 3 x 1 Flamengo, Vasco 2 x 1 Fluminense
		    // Rodada 4: Fluminense 1 x 2 Botafogo, Vasco 1 x 2 Flamengo
		    // Rodada 5: Vasco 2 x 2 Botafogo, Flamengo 0 x 1 Fluminense
		    // Rodada 6: Flamengo 1 x 4 Botafogo, Fluminense 3 x 1 Vasco
		    // OBS: O fogao nunca perde, como na realidade
		    
		    // Aqui tem os gols so dos mandantes, nao confundir com o placar de cada partida
		    golsCasaRodadas = new int[][]{
		        {2, 2}, // Rodada 1
		        {2, 0}, // Rodada 2
		        {3, 2}, // Rodada 3
		        {1, 1}, // Rodada 4
		        {2, 0}, // Rodada 5
		        {1, 3}  // Rodada 6
		    };
		    
		    // Aqui tem os gols so dos visitantes, nao confundir com o placar de cada partida
		    golsVisitanteRodadas = new int[][] {
		        {0, 1}, // Rodada 1
		        {1, 2}, // Rodada 2
		        {1, 1}, // Rodada 3
		        {2, 2}, // Rodada 4
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
		    
		    pontuacoes = new int[][]{
		        {0, 0, 3, 3},   // Rodada 1
		        {0, 0, 6, 6},   // Rodada 2
		        {0, 3, 6, 9},   // Rodada 3
		        {0, 3, 9, 12},  // Rodada 4
		        {3, 4, 9, 13},  // Rodada 5
		        {4, 6, 9, 16}   // Rodada 6
		    };
		    
		 // Vitórias acumuladas por rodada (Fluminense, Vasco, Flamengo, Botafogo)
		    vitorias = new int[][] {
		        {0, 0, 1, 1},   // Rodada 1
		        {0, 0, 2, 2},   // Rodada 2
		        {0, 1, 2, 3},   // Rodada 3
		        {0, 1, 3, 4},   // Rodada 4
		        {1, 1, 3, 4},   // Rodada 5
		        {2, 1, 3, 5}    // Rodada 6
		    };

		    // Gols marcados acumulados por rodada (Fluminense, Vasco, Flamengo, Botafogo)
		    golsMarcados = new int[][] {
		        {0, 1, 2, 2},   // Rodada 1
		        {0, 2, 4, 4},   // Rodada 2
		        {1, 4, 5, 7},   // Rodada 3
		        {2, 5, 7, 9},   // Rodada 4
		        {3, 7, 7, 11},  // Rodada 5
		        {6, 8, 8, 15}   // Rodada 6
		    };

		    // Gols sofridos acumulados por rodada (Fluminense, Vasco, Flamengo, Botafogo)
		    golsSofridos = new int[][] {
		        {2, 2, 1, 0},  // Rodada 1
		        {4, 4, 1, 1},  // Rodada 2
		        {6, 5, 4, 2},  // Rodada 3
		        {8, 7, 5, 3},  // Rodada 4
		        {8, 9, 6, 5},  // Rodada 5
		        {9, 12, 10, 6}   // Rodada 6
		    };

		    // Saldo de gols acumulado por rodada (Fluminense, Vasco, Flamengo, Botafogo)
		    saldosGols = new int[][] {
		        {-2, -1, 1, 2},  // Rodada 1
		        {-4, -2, 3, 3},  // Rodada 2
		        {-5, -1, 1, 5},   // Rodada 3
		        {-6, -2, 2, 6},   // Rodada 4
		        {-5, -2, 1, 6},   // Rodada 5
		        {-3, -4, -2, 9}    // Rodada 6
		    };


	    }
}
