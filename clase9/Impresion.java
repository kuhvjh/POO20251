public class Impresion extends Producto {

    //atributos 
    private String color;
    private Foto[] foto;  //arrego de fotos

    //constructor
    public Impresion(String color, Foto[] foto, int numero) {
        super(numero); //llama al constructor de la clase padre
        this.color = color;
        this.foto = foto;
    }

    //metodos
    public String getColor() {
        return color;
    }
    public String getfoto(){
        return foto.toString();

    }

}