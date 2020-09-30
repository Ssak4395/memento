import java.lang.reflect.Array;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class CloneFactory{


  ArrayList<Ball> register = new ArrayList<>();

  public ArrayList<Ball> getRegister() {
    return register;
  }

  public void setRegister(ArrayList<Ball> register) {
    this.register = register;
  }

  public ArrayList<Ball> retClonedRegister()
  {
    ArrayList<Ball> clonedRegister = new ArrayList<>();
    clonedRegister = (ArrayList<Ball>) getRegister().clone();
    return clonedRegister;
  }


  public Drawable getClone(Ball sample)
  {
    return sample.makeCopy();
  }
}