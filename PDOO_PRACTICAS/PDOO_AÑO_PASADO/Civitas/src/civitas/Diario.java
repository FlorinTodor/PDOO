package civitas;

import java.util.ArrayList;

public class Diario {
  static final private Diario instance = new Diario();
  
  private final ArrayList<String> eventos;
  
  static public Diario getInstance() {
    return instance;
  }
    /*
    public ArrayList<String> getEventos() {
        return eventos;
    }
  */
  
  public String getEventos() {
      String eventosActuales = "";
      for(int i = 0; i < eventos.size(); i++){
          eventosActuales += eventos.get(i) + "\n\n";
      }
      return eventosActuales;
    }
  
  private Diario () {
    eventos = new ArrayList<>();
  }
  
  void ocurreEvento (String e) {
    eventos.add (e);
  }
  
  public boolean eventosPendientes () {
    return !eventos.isEmpty();
  }
  
  public String leerEvento () {
    String salida = "";
    if (!eventos.isEmpty()) {
      salida = eventos.remove(0);
    }
    return salida;
  }
}
