import java.util.ArrayList;
import java.util.List;

public class CareTaker implements  Cloneable{


  List<Memento> savedMementos = new ArrayList<>();


  public void addMemento(Memento m)
  {
   savedMementos.add(m);
  }

  public Memento getMemento(int index)
  {
    return  savedMementos.get(index);

  }
}
