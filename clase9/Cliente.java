public class Cliente {

    //atributos
    private String cedula;
    private String nombre;

    //constructor 
    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    //metodos 
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }


}