public class Camara extends Producto {

    //atributps
    private String marca;
    private String modelo;


    //constructor 
    public Camara(String marca, String modelo, int numero) {
        super(numero); //llama al constructor de la clase padre
        this.marca = marca;
        this.modelo = modelo;
    }
    //metodos
    public String getMarca(){
        return marca;
    }
    public String getmodelo(){
        return modelo;
        
    }
}