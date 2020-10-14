//Javier Enrique Luna Díaz
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Hilo extends Thread {
    private JTextArea area;                 //Atributos para manipular proceso, así como el rc
    private RCompartido rc;
    private final static int inicio = 995;
    private final static int fin = 1000;
    private boolean dead = false;
    
    Hilo(JTextArea area,RCompartido rc){
        this.area = area;                   //Creamos el hilo con su respectiva area y rc
        this.rc = rc;
    }
    
    public void run(){          //Proceso para correr el hilo
        while(true){            //Recordando que para bloquear y desbloquear se hace uso de la cerradura
            try{
                if(rc.isEntra()){      //Verificamos si podemos acceder el rc
                    rc.bloquear();      //Lo bloqueamos para los demás procesos
                        if(isdead()){   
                            stop();     //Método de clase para ejemplificasr kill
                        }               //El cual NO debe ser usado
                    rc.setrc(this.getName());
                    area.append(rc.getrc()+": Eats\n");
                    rc.desbloquear();       //Una vez acabamos de usar el recurso lo desbloqueamos
                }
                else{
                    area.append("En espera...\n");  //Sino puede acceder al recurso se queda en espera
                }
                Thread.sleep((int) (inicio+Math.random()*fin));
            }catch(Exception e){e.printStackTrace();}
        }
    }
    
    public boolean isdead(){
        return dead;
    }
    public void setdead(boolean dead){
        this.dead = dead;
    }
}
