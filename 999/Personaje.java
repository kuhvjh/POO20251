import java.util.Random;

public class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected Arma arma;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;

    public Personaje(String nombre, Arma arma) {
        this.nombre = nombre;
        this.arma = arma;
        this.puntosDeVida = 100;
    }

    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO + arma.getBonusDano();
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca con " + arma.getNombre() + " a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}

