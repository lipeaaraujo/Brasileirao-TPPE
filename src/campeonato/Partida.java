package campeonato;

public class Partida {
    private Time timeCasa;
    private Time timeVisitante;
    private int golsCasa;
    private int golsVisitante;
    private int cartoesAmarelosCasa;
    private int cartoesAmarelosVisitante;
    private int cartoesVermelhosCasa;
    private int cartoesVermelhosVisitante;
    private boolean concluida;

    public Partida(Time timeCasa, Time timeVisitante) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.golsCasa = 0;
        this.golsVisitante = 0;
        this.cartoesAmarelosCasa = 0;
        this.cartoesAmarelosVisitante = 0;
        this.cartoesVermelhosCasa = 0;
        this.cartoesVermelhosVisitante = 0;
        this.concluida = false;
    }

    public void jogarPartida(
        int golsCasa,
        int golsVisitante,
        int cartoesAmarelosCasa,
        int cartoesAmarelosVisitante,
        int cartoesVermelhosCasa,
        int cartoesVermelhosVisitante
    ) {
        // Lógica para atualizar o placar e os cartões
    } 

    // GETTERS E SETTERS
    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public int getGolsCasa() {
        return golsCasa;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public int getCartoesAmarelosCasa() {
        return cartoesAmarelosCasa;
    }

    public int getCartoesAmarelosVisitante() {
        return cartoesAmarelosVisitante;
    }

    public int getCartoesVermelhosCasa() {
        return cartoesVermelhosCasa;
    }

    public int getCartoesVermelhosVisitante() {
        return cartoesVermelhosVisitante;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setGolsCasa(int golsCasa) {
        this.golsCasa = golsCasa;
    }

    public void setGolsVisitante(int golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

    public void setCartoesAmarelosCasa(int cartoesAmarelosCasa) {
        this.cartoesAmarelosCasa = cartoesAmarelosCasa;
    }

    public void setCartoesAmarelosVisitante(int cartoesAmarelosVisitante) {
        this.cartoesAmarelosVisitante = cartoesAmarelosVisitante;
    }

    public void setCartoesVermelhosCasa(int cartoesVermelhosCasa) {
        this.cartoesVermelhosCasa = cartoesVermelhosCasa;
    }

    public void setCartoesVermelhosVisitante(int cartoesVermelhosVisitante) {
        this.cartoesVermelhosVisitante = cartoesVermelhosVisitante;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
