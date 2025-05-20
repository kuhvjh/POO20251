import java.util.Random;

public class Guerrero extends Personaje {
    public Guerrero(String nombre, Arma arma) {
        super(nombre, arma);
    }

    @Override
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO + 5 + arma.getBonusDano();
        oponente.recibirDano(dano);
        System.out.println("💥 Guerrero " + this.nombre + " ataca con " + arma.getNombre() + " a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}
