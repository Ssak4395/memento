import java.util.ArrayList;
import java.util.List;

public class Memento {

  private ArrayList<Ball> balls;

  public Memento(ArrayList<Ball> balls)
  {
    this.balls = balls;
  }

  public ArrayList<Ball> getBallList()
  {
    return balls;
  }

}
