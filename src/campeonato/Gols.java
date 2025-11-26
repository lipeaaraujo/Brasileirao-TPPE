package campeonato;

public class Gols {
    private int golsPro;
    private int golsContra;

    public Gols() {
        this.golsPro = 0;
        this.golsContra = 0;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public int getSaldo() {
        return golsPro - golsContra;
    }

    public void setGolsPro(int gols) {
        this.golsPro = gols;
    }

    public void setGolsContra(int gols) {
        this.golsContra = gols;
    }
}