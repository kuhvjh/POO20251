import java.time.LocalDate;

public class Pedido {
    private Cliente cliente;
    private Producto[] productos;
    private LocalDate fecha;
    private int numeroTarjetaCredito;

    public Pedido(Cliente cliente, Producto[] productos, LocalDate fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    // Métodos que ya tenías
    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    // Nuevo método: Calcula el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio(); // Polimorfismo: getPrecio() viene de Producto
        }
        return total;
    }

    // Nuevo método: Muestra resumen del pedido (resultado concreto)
    public void mostrarResumen() {
        System.out.println("=== RESUMEN PEDIDO ===");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Fecha: " + fecha);
        System.out.println("Productos:");
        for (Producto p : productos) {
            System.out.println("- " + p.getDescripcion() + " | Precio: $" + p.getPrecio());
        }
        System.out.println("Total a pagar: $" + calcularTotal());
    }
}