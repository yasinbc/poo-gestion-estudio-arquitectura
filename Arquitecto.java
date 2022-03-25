import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 * Clase Arquitecto
 */
public class Arquitecto
{
    // instance variables - replace the example below with your own
    public ArrayList<String> clientesAsignados;

    /**
     * Constructor for objects of class Arquitecto
     */
    public Arquitecto()
    {
        // initialise instance variables
        clientesAsignados = new ArrayList<String>();
    }
    
    //añade los usuarios dentro de la ArrayList
    private void guardarClientesAsignados(String usuario){
        clientesAsignados.add(usuario);
    }
    
    //devuelve el número de usuarios que hay en la lista
    private int numeroClientesAsignados(){
        return clientesAsignados.size();
    }
    
    public void mostrarClientesAsignados(){
        if(numeroClientesAsignados()<1){//si no hay usuarios registrados lanza un mensaje notificandolo
            System.out.println("Todavía no hay Clientes Asignados en el sistema");
        }else{//Lista a los usuarios y los ordena con un indice
            System.out.println("Lista de clientes registrados: ");   
            System.out.println("ID         Nombre Usuarios");
            for(String index:clientesAsignados){
                System.out.println(clientesAsignados.indexOf(index) +"          "+ index);//asigna un indice a cada usuario por orden de registro
            }
        }
    }
}
