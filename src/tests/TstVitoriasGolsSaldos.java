package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

// Teste que verifica a quantidade de vitorias, gols marcados, gols sofridos e saldo de gols a cada rodada
public class TstVitoriasGolsSaldos extends TstBase {

	@Test
	public void test() {
		 int totalRodadas = campeonato.getRodadas().size();
		// Ordem desejada dos times para verificação
	        String[] ordemTimes = {"Fluminense", "Vasco", "Flamengo", "Botafogo"};

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
	        
	        campeonato.classificacao();
	        
	        // Verifica cada time
            for (int tIdx = 0; tIdx < ordemTimes.length; tIdx++) {
                String nomeTime = ordemTimes[tIdx];
                var time = campeonato.getTimes().stream()
                        .filter(tm -> tm.getNome().equals(nomeTime))
                        .findFirst().orElse(null);

                assertEquals("Rodada " + (i+1) + " - Vitórias de " + time.getNome(),
                		vitorias[i][tIdx], time.getVitorias());
                assertEquals("Rodada " + (i+1) + " - Gols pró de " + time.getNome(),
                		golsMarcados[i][tIdx], time.getGolsPro());
                assertEquals("Rodada " + (i+1) + " - Gols contra de " + time.getNome(),
                		golsSofridos[i][tIdx], time.getGolsContra());
                assertEquals("Rodada " + (i+1) + " - Saldo de " + time.getNome(),
                		saldosGols[i][tIdx], time.getSaldo());
            }
		 }
	}
}