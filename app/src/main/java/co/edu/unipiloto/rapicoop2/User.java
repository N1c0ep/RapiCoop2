package co.edu.unipiloto.rapicoop2;

public class User {

    private String fullName;
    private String email;
    private String clave;
    private int tipo;

    public User(String fullName, String email, String clave, int tipo) {
        fullName=new String();
        email=new String();
        clave=new String();
        tipo=new Integer(0);
    }
    public User() {

    }
    public void setFullName(String name)
    {
        fullName = name;
    }
    public void setEmail(String email1)
    {
        email = email1;
    }
    public void setPassword(String password)
    {
        clave = password;
    }
    public void setTipo(int tipo1)
    {
        tipo = tipo1;
    }
    public String getFullname() {
        return this.fullName;
    }
    public String geteMail() {
        return this.email;
    }
    public String getPassword() {
        return this.clave;
    }
    public String getTipo() {
        return this.clave;
    }





}
