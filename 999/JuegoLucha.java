import java.util.Scanner;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciarPelea() {
        System.out.println("🛡️ La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "...");
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }
        if (jugador1.estaVivo()) {
            System.out.println("🏆 " + jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println("🏆 " + jugador2.getNombre() + " ha ganado la pelea.");
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre() + ". Puntos de vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }

    public static Arma elegirArma(Scanner scanner) {
        System.out.println("Elige un arma:");
        System.out.println("1. Espada (+5 daño)");
        System.out.println("2. Bastón mágico (+3 daño)");
        System.out.println("3. Hacha (+7 daño)");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1: return new Arma("Espada", 5);
            case 2: return new Arma("Bastón mágico", 3);
            case 3: return new Arma("Hacha", 7);
            default:
                System.out.println("Opción no válida. Se asignará Espada por defecto.");
                return new Arma("Espada", 5);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jugador 1
        System.out.print("Introduce el nombre del jugador 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("¿Qué clase quieres para " + nombre1 + "? (guerrero/mago): ");
        String clase1 = scanner.nextLine().toLowerCase();
        Arma arma1 = elegirArma(scanner);

        // Jugador 2
        System.out.print("Introduce el nombre del jugador 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("¿Qué clase quieres para " + nombre2 + "? (guerrero/mago): ");
        String clase2 = scanner.nextLine().toLowerCase();
        Arma arma2 = elegirArma(scanner);

        Personaje p1 = clase1.equals("mago") ? new Mago(nombre1, arma1) : new Guerrero(nombre1, arma1);
        Personaje p2 = clase2.equals("mago") ? new Mago(nombre2, arma2) : new Guerrero(nombre2, arma2);

        JuegoLucha juego = new JuegoLucha(p1, p2);
        juego.iniciarPelea();
    }
}

