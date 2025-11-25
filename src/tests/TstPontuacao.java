package tests;

import static org.junit.Assert.*;
import org.junit.Test;

// Teste que verifica a pontuacao de cada time ao final de cada rodada
public class TstPontuacao extends TstBase {
	
	@Test
	public void testeCalculaPontuacao() {
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
	        
	        // Verifica a pontuação de cada time
	        // Comecei o for do ultimo para o primeiro pois foi salvo assim
            for (int t = 0; t < campeonato.getTimes().size() ; t++) {
            	
                int pontosEsperados = pontuacoes[i][t];
                int pontosReais = campeonato.getTimes().get(t).getPontos();
                assertEquals(
                    "Rodada " + (i) + ", Time " + campeonato.getTimes().get(t).getNome(),
                    pontosEsperados,
                    pontosReais
                );
            }
	     
	     
		}
	}
}