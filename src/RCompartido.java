//Javier Enrique Luna Díaz
public class RCompartido {
    private String rc;              //Necesitamos nuestra cerradura para acceder al rc
    private Cerradura cerradura;
    
    RCompartido(){
        cerradura = new Cerradura();        //Creamos nuestra cerradura
    }
    
    public void bloquear(){     //Bloqueamos nuestro rc cerrando la cerradura
        cerradura.cerrar();
    }
    
    public void desbloquear(){      //Desbloqueamos nuestro rc abriendo la cerradura
        cerradura.abrir();
    }
    
    public String getrc() {         //Obtenemos el rc
        return rc;
    }
    
    public boolean isEntra(){           //Para verificar si podemos entrar, verificamos la cerradura
        return cerradura.estado();
    }
    
    public void setrc(String rc) {       //Establecemos neustro rc
        this.rc = rc;
    }
    
}
