/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
/**
 *
 * @author josev
 */
public class Tablero {
  private ArrayList<Casilla> casillas; //contenedor de las casillas del juego  
  private boolean porSalida; //para representar si el jugador que tiene el turno ha pasado por la salida o no en dicho turno
  
  Tablero(){    //Constructor
      porSalida=false;
      casillas=new ArrayList<Casilla>();
      Casilla salida = new Casilla("Salida");
      casillas.add(salida);
  }
  
  private boolean correcto(int numCasilla){
      if(!casillas.isEmpty() && numCasilla>=0 && numCasilla<casillas.size()){
          return true;
      }
      else{
          return false;
      }
  }
  
  boolean computarPasoPorSalida(){
      boolean copia = porSalida;
      porSalida = false;
      return copia;
  }
  
  void añadeCasilla(Casilla casilla){
      casillas.add(casilla);
  }
  
  public Casilla getCasilla(int numCasilla){
      if(correcto(numCasilla)==true){
          return casillas.get(numCasilla);
      }
      else{
          return null;
        }
  }
  
  public ArrayList<Casilla> getCasillas(){
      return casillas;
  }
  
  int nuevaPosicion(int actual, int tirada){
      int destino;
      destino = actual + tirada; 
      
      if(destino < casillas.size()){
         return destino;
      }
      else{
          destino = destino % casillas.size();
          porSalida = true;
          return  destino;
      }
  }
  
  
}
