public class Cliente {
    private String cedula;
    private String nombre;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    // Métodos que ya tenías
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
}