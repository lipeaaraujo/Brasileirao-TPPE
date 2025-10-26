package tests;


import static org.junit.Assert.assertFalse;
import java.util.HashSet;
import java.util.Set;
import org.junit.*;
import campeonato.Partida;
import campeonato.Rodada;
import campeonato.Time;

// Teste que verifica se nao ha repeticao entre as partidas ao longo de todo o campeonato
public class TstSorteio extends TstBase {

    @Test
    public void testNaoHaPartidasRepetidasNoCampeonato() {
        Set<String> confrontos = new HashSet<>();

        int rodadaNumero = 1;
        for (Rodada rodada : campeonato.getRodadas()) {
            for (Partida partida : rodada.getPartidas()) {
                Time casa = partida.getTimeCasa();
                Time visitante = partida.getTimeVisitante();

                // Forma de salvar os confrontos
                String confronto = casa.getNome() + " x " + visitante.getNome();

                // Se o confronto já existir, o teste falha
                assertFalse(
                    "Partida repetida detectada: " + confronto + " (rodada " + rodadaNumero + ")",
                    confrontos.contains(confronto)
                );

                confrontos.add(confronto);
            }
            rodadaNumero++;
        }
    }

}
