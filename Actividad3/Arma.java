public class Arma {
    private String nombre;
    private int bonusDano;

    public Arma(String nombre, int bonusDano) {
        this.nombre = nombre;
        this.bonusDano = bonusDano;
    }

    public int getBonusDano() {
        return bonusDano;
    }

    public String getNombre() {
        return nombre;
    }
}
