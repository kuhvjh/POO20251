public abstract class Producto {
    private int numero;
    private double precio; // Nuevo atributo

    public Producto(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
    }

    // Métodos que ya tenías
    public int getNumero() {
        return numero;
    }

    // Nuevo getter
    public double getPrecio() {
        return precio;
    }

    // Método abstracto para polimorfismo
    public abstract String getDescripcion();
}