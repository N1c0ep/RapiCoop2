package co.edu.unipiloto.rapicoop2;

public class Producto {
    private String  nombreProducto;
    private int precio ;
    private String imagen_64;
    private int stock ;



    public Producto(String NombreProducto,int precio, String imagen64, int stock) {
        nombreProducto=new String();
        imagen_64=new String();
        stock=new Integer(0);
        precio=new Integer(0);
    }
    public void SetNPrducto (String name){nombreProducto = name;}
    public void Setimagen (String imagen){imagen_64 = imagen;}
    public void SetStock (int cantidad){stock = cantidad;}
    public void setPrecio(int precio) {this.precio = precio;}

    public String getNombreProducto() { return nombreProducto;}
    public int getPrecio() {return precio;}
    public String getImagen_64() {return imagen_64;}
    public int getStock(){return stock;}
}
