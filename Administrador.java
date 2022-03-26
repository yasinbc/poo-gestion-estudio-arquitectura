import java.util.*;
import javax.swing.*;
import java.io.*;

/**
 * Write a description of class Administrador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrador
{
    public ArrayList<String> usuarios; //Contiene todos lo registros de los usuarios
    public Iterator<String> it;

    /**
     * Constructor que inizializa las variables
     */
    public Administrador()
    {
        usuarios = new ArrayList<String>();
    }
    
    //añade los usuarios dentro de la ArrayList
    private void guardarUsuarios(String usuario){
        usuarios.add(usuario);
    }
    
    //devuelve el número de usuarios que hay en la lista
    private int numeroUsuarios(){
        return usuarios.size();
    }
    
    //imprime en consola usuarios registrados
    public void mostrarUsuarios(){
        if(numeroUsuarios()<1){//si no hay usuarios registrados lanza un mensaje notificandolo
            System.out.println("Todavía no hay usuarios Registrados en el sistema");
        }else{//Lista a los usuarios y los ordena con un indice
            System.out.println("Lista de usuarios: ");   
            System.out.println("ID         Nombre Usuarios");
            for(String index:usuarios){
                System.out.println(usuarios.indexOf(index) +"          "+ index);//asigna un indice a cada usuario por orden de registro
            }
        }
    }
    
    //elimina de la lista los usuarios
    public void eliminarUsuario(){
        String opcion = "";//variable en la que se almacena la opcion en forma de cadena
        int opcionInt = 0;//variable en la que se almacena la opcion en forma de entero
        
        System.out.println("Usuarios dados de Alta en el sistema: ");
        mostrarUsuarios();//muestra los usuarios por consola
        
        //almacena el la opcion en forma de cadena
        opcion = JOptionPane.showInputDialog("Lista de usuarios en la consola. \nIntroduzca el número del usuario que quiere dar de baja:");
        opcionInt = Integer.parseInt(opcion);//convierte y almacena la opcion de cadena a entero
        
        //si no introduce indice correcto lo notifica para que se repita la secuencia
        if(opcionInt<0 || opcionInt>numeroUsuarios()-1){
            System.out.println("Tiene que introducir un número de usuario entre 0 y "+(numeroUsuarios()-1));
            System.out.println("Intentelo de nuevo, por favor");
        }else{//remueve usuario seleccionado de la lista
            usuarios.remove(opcionInt);
               
            System.out.println("");
            System.out.println("");
            System.out.println("Ha eliminado al usuarío número "+opcion+" con éxito de la lista anterior.");
            if(numeroUsuarios() == 0){//si la lista esta vacia lo notifica
                System.out.println("No hay usuarios registrados en el sistema.");
            }else{//muestra usuarios restantes en la lista
                System.out.println("Lista de suarios restantes en el sistema: ");
                mostrarUsuarios();
            }
        }
    }
    
    //introduce nuevos usuarios a la lista
    public void altaUsuario(){
        String opcion = "";//variable que almacenará al usuario en la lista
        String opcionAux = "";//variable auxiliar que almacenará otro nombre en caso de que el introducido este repetido en ArrayList
        opcion = JOptionPane.showInputDialog("Introduzca nombre de usuario a registar: ");//introduce y almacena opcion
        
        if(usuarios.contains(opcion)){//si se repite el usuario en ArrayList
            //pregunta nuevo usuario y lo introduce dentro de la variable auxiliar
            opcionAux = JOptionPane.showInputDialog(opcion+" ya existe en el sista. Introduzca otro usuario, por favor.");
            if(!usuarios.contains(opcionAux)){//si el nuevo usuario no existe en la ArrayList lo introduce dentro de la lista
                guardarUsuarios(opcionAux);// lo introduce en la ArrayList
                System.out.println(opcion+" dado de alta en el sistema");
            }
            System.out.println(opcion+" ya existe en el sistema. Por favor intentelo de nuevo.");    
        }else{//En caso de no repetirse el usuario en el ArrayList, lo introduce
            guardarUsuarios(opcion);//introduce nuevo usuario en la lista
            System.out.println(opcion+" dado de alta en el sistema");//muestra en consola nuevo usuario ingresado
        }
        
        //guardarUsuarios(opcion);//introduce nuevo usuario en la lista
        //System.out.println(opcion+" dado de alta en el sistema");//muestra en consola nuevo usuario ingresado
    }
    
    //Reemplaza un nombre por otro en la lista de usuarios
    public void modificarUsuario(){ 
        String opcion = "";//almacenará el nombre del usuario
        int opcionInt = 0;//álmacenará el indice del usuario
        String nuevoUsuario = "";//almacenará la conversion del indice del usuario de cadena a entero
        
        System.out.println("Qué usuario desea modificar?");
        mostrarUsuarios();//muestra los usuarios por pantalla
        
        //introduce y almacena el indice del usuario en forma de cadena
        opcion = JOptionPane.showInputDialog("Lista de usuarios en la consola. \nIntroduzca el número del usuario que quiere modificar:");
        opcionInt = Integer.parseInt(opcion);//pasa de string a entero para que lo lea la condicion
        
        //introduce el numero de usuario el cual modificará
        nuevoUsuario = JOptionPane.showInputDialog("Introduzca el nuevo nombre de usuario: ");
        
        //cambia el usuario que estaba por el nuevo introducido
        usuarios.set(opcionInt, nuevoUsuario);//primer parametro introduce posicion del usuario, segundo parametro introduce nuevo usuario
        
        System.out.println("");
        mostrarUsuarios();//muestra los usuarios actuales, incluido el que se ha modificado121212
    }
    
    private void muestraUsuariosSinIndex(){
        it = usuarios.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    public void asignarUsuario(){
        String opcion = "";
        int opcionInt = 0;
        String opcionAux = "";
        
        mostrarUsuarios();
        opcion = JOptionPane.showInputDialog("Observe la lista de usuarios por pantalla \ne introduzca su indice para elegir usuario.");
        opcionInt = Integer.parseInt(opcion);
        
        
        
        opcion = JOptionPane.showInputDialog("\n1-Arquitecto \n2-Aparejador \n3-Contable");
        opcionInt = Integer.parseInt(opcion);
        
        
        
        
        mostrarUsuarios();
    }
    
}