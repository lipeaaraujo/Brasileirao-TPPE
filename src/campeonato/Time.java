package campeonato;

public class Time {
    private String nome;
    private int pontos;
    private int partidasJogadas;
    private Desempenho desempenho;
    private Gols golsJogo;
    private Cartoes cartoes;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.partidasJogadas = 0;
        this.cartoes = new Cartoes();
        this.desempenho = new Desempenho();
        this.golsJogo = new Gols();
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
        return desempenho.getVitorias();
    }

    public int getEmpates() {
        return desempenho.getEmpates();
    }

    public int getDerrotas() {
        return desempenho.getDerrotas();
    }

    public int getGolsPro() {
        return golsJogo.getGolsPro();
    }
    public int getGolsContra() {
        return golsJogo.getGolsContra();
    }

    public int getSaldo() {
        return golsJogo.getSaldo();
    }

    public int getCartoesAmarelos() {
        return cartoes.getCartoesAmarelos();
    }
    
    public int getCartoesVermelhos() {
        return cartoes.getCartoesVermelhos();
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
        this.desempenho.setVitorias(vitorias);
    }

    public void setEmpates(int empates) {
        this.desempenho.setEmpates(empates);
    }

    public void setDerrotas(int derrotas) {
        this.desempenho.setDerrotas(derrotas);
    }

    public void setGolsPro(int golsPro) {
        this.golsJogo.setGolsPro(golsPro);
    }

    public void setGolsContra(int golsContra) {
        this.golsJogo.setGolsContra(golsContra);
    }

    public void setCartoesAmarelos(int cartoesAmarelos) {
        this.cartoes.setCartoesAmarelos(cartoesAmarelos);
    }
    public void setCartoesVermelhos(int cartoesVermelhos) {
        this.cartoes.setCartoesVermelhos(cartoesVermelhos);
    }


    
    @Override
    public String toString() {
        return "Time: " + nome + "\n" +
               "Pontos: " + pontos + "\n" +
               "Partidas Jogadas: " + partidasJogadas + "\n" +
               "Vitórias: " + desempenho.getVitorias() + "\n" +
               "Empates: " + desempenho.getEmpates() + "\n" +
               "Derrotas: " + desempenho.getDerrotas() + "\n" +
               "Gols Pró: " + golsJogo.getGolsPro() + "\n" +
               "Gols Contra: " + golsJogo.getGolsContra() + "\n" +
               "Saldo de Gols: " + golsJogo.getSaldo() + "\n" +
               "Cartões Amarelos: " + cartoes.getCartoesAmarelos() + "\n" +
               "Cartões Vermelhos: " + cartoes.getCartoesVermelhos() + "\n";
    }

}
