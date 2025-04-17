public class Impresion extends Producto {
    private String color;
    private Foto[] fotos;

    public Impresion(String color, Foto[] fotos, int numero, double precio) {
        super(numero, precio);
        this.color = color;
        this.fotos = fotos;
    }

    // Métodos que ya tenías
    public String getColor() {
        return color;
    }

    public Foto[] getFotos() {
        return fotos;
    }

    // Implementación del método abstracto (polimorfismo)
    @Override
    public String getDescripcion() {
        return "Impresión " + color + " (" + fotos.length + " fotos)";
    }
}