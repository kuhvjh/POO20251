import java.util.Random;
import java.util.Scanner;

// Clase base
class Personaje {
    protected String nombre;
    protected int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
    }

    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
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

// Subclase Guerrero
class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO + 5; // Guerreros pegan más fuerte
        oponente.recibirDano(dano);
        System.out.println("💥 Guerrero " + this.nombre + " lanza un espadazo a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}

// Subclase Mago
class Mago extends Personaje {
    public Mago(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        if (rand.nextDouble() > 0.7) {
            dano += 15; // Posibilidad de ataque mágico extra
            System.out.println("✨ ¡Ataque mágico extra!");
        }
        oponente.recibirDano(dano);
        System.out.println("🔮 Mago " + this.nombre + " lanza un hechizo a " + oponente.getNombre() + " causando " + dano + " puntos de daño.");
    }
}

// Clase que controla el juego
public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciarPelea() {
        System.out.println("\n🗡️ ¡La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!\n");

        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        System.out.println("\n🏁 ¡La pelea ha terminado!");
        if (jugador1.estaVivo()) {
            System.out.println("🎉 " + jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println("🎉 " + jugador2.getNombre() + " ha ganado la pelea.");
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("Turno de " + atacante.getNombre() + ". Vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Juego de Lucha ===");
        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("¿Qué clase quieres para " + nombre1 + "? (guerrero/mago): ");
        String clase1 = scanner.nextLine().toLowerCase();

        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("¿Qué clase quieres para " + nombre2 + "? (guerrero/mago): ");
        String clase2 = scanner.nextLine().toLowerCase();

        Personaje p1 = clase1.equals("mago") ? new Mago(nombre1) : new Guerrero(nombre1);
        Personaje p2 = clase2.equals("mago") ? new Mago(nombre2) : new Guerrero(nombre2);

        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea();
    }
}
