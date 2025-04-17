public class Camara extends Producto {
    private String marca;
    private String modelo;

    public Camara(String marca, String modelo, int numero, double precio) {
        super(numero, precio); // Llama al constructor de Producto
        this.marca = marca;
        this.modelo = modelo;
    }

    // Métodos que ya tenías
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    // Implementación del método abstracto (polimorfismo)
    @Override
    public String getDescripcion() {
        return "Cámara " + marca + " " + modelo;
    }
}