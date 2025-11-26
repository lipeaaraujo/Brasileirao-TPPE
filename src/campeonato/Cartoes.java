package campeonato;

public class Cartoes {
    private int cartoesAmarelos;
    private int cartoesVermelhos;

    public Cartoes() {
        this.cartoesAmarelos = 0;
        this.cartoesVermelhos = 0;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }
    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public void setCartoesAmarelos(int cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }
    public void setCartoesVermelhos(int cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }
}
