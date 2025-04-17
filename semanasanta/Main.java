import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear objetos
        Cliente cliente = new Cliente("123456", "Juan Pérez");
        Foto[] fotos = {new Foto("foto1.jpg"), new Foto("foto2.png")};
        
        Producto[] productos = {
            new Camara("Sony", "Alpha A7", 1, 1500.0),
            new Impresion("Color", fotos, 2, 5.99)
        };

        Pedido pedido = new Pedido(cliente, productos, LocalDate.now(), 123456789);

        // ¡Resultado concreto!
        pedido.mostrarResumen();
    }
}