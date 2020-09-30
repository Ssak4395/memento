import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameWindow window = new GameWindow(new BallPit(700, 800));
        window.run();

        primaryStage.setTitle("Strategy Balls");
        primaryStage.setScene(window.getScene());
        primaryStage.show();

        window.run();
    }
}
