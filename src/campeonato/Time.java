package campeonato;

public class Time {
    private int pontos;
    private int partidasJogadas;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private String nome;
    private int cartoesAmarelos;
    private int cartoesVermelhos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.partidasJogadas = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsPro = 0;
        this.golsContra = 0;
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public void setCartoesAmarelos(int cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public void setCartoesVermelhos(int cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }
}
