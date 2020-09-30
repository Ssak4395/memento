import java.util.ArrayList;
import java.util.List;

public class Originator {
private ArrayList<Ball> Balls = new ArrayList<>();

public void set(ArrayList<Ball> newball)
{
Balls = newball;
}

public Memento storeInMemento()
{
  return new Memento(Balls);
}

public List<Ball> restoreFromMemento(Memento m )
{
 Balls = m.getBallList();

 return Balls;
}

}
