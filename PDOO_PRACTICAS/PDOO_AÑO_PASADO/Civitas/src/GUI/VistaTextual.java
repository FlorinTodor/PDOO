package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

    public void actualiza(){
        if(juegoModel.finalDelJuego()){
            for(int i=0; i < juegoModel.getJugadores().size(); i++){
            System.out.println(juegoModel.getJugadores().get(i).toString());
          }
        }
        else{
            System.out.println("\n" + separador +"\nJugador actual: " + juegoModel.getJugadorActual().toString());
        }
    }
  //REVISAR LUEGO
    public Respuesta comprar(){
        int opcion = menu ("¿Comprar calle actual?", new ArrayList<>(Arrays.asList("SI","NO")));
        
        return (Respuesta.values()[opcion]);
    }
    
    public OperacionInmobiliaria elegirOperacion(){
        int opcion = menu("¿Que gestion inmobiliria va a usar?", new ArrayList<>(Arrays.asList("CONSTRUIR CASA", "CONSTRUIR HOTEL", "TERMINAR")));
        
        return (OperacionInmobiliaria.values()[opcion]);
    }
    //REVISAR LUEGO
    public int elegirPropiedad(){
        juegoModel.getJugadorActual().toString();
        ArrayList<String> nombrePropiedades = new ArrayList<String>();
        
        for(int i=0; i < juegoModel.getJugadorActual().getPropiedades().size(); i++){
            nombrePropiedades.add(juegoModel.getJugadorActual().getPropiedades().get(i).toString());
        }
        
        int opcion = menu("¿Que propiedad quiere gestionar?", nombrePropiedades);
        
        return opcion;
    }
    
    public void mostrarSiguienteOperacion(OperacionJuego operacion){
        System.out.println("La siguiente operacion que se va a realizar es: " + operacion.toString());
    }
    
    public void mostrarEventos(){
        while( Diario.getInstance().eventosPendientes()){
            System.out.println(Diario.getInstance().leerEvento());
        }
    }
}
