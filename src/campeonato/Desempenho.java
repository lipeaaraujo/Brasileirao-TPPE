package campeonato;

public class Desempenho {
    private int vitorias;
    private int empates;
    private int derrotas;

    public Desempenho() {
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
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
    public int getVitorias() {
        return vitorias;
    }
    public int getEmpates() {
        return empates;
    }
    public int getDerrotas() {
        return derrotas;
    }
}


