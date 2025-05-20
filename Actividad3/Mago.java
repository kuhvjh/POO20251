import java.util.Random;

public class Mago extends Personaje {
    public Mago(String nombre, Arma arma) {
        super(nombre, arma);
    }

    @Override
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO + arma.getBonusDano();
        if (rand.nextDouble() > 0.7) {
            dano += 15;
            System.out.println("✨ ¡Ataque mágico extra!");
        }
        oponente.recibirDano(dano);
        System.out.println("🔮 Mago " + this.nombre + " lanza un hechizo con " + arma.getNombre() + " a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}
