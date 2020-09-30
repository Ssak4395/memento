import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

class GameWindow {
    private final GraphicsContext gc;
    private Scene scene;
    private BallPit model;

    GameWindow(BallPit model) {
        this.model = model;

        Pane pane = new Pane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.setSpacing(30);
        Button b  = new Button();
        b.setText("Generate New Ball");
        Button saveGame = new Button("Save");
        Button revertGame = new Button("Revert");
        saveGame.setOnAction(e->model.Save1());
        revertGame.setOnAction(e->model.Revert());

        TextField colourText = new TextField("Enter Colour");
        TextField strategyText = new TextField("Enter Strategy");
      Button clear = new Button();
      clear.setText("Clear All ");
      clear.setOnAction(e->model.ClearAll());
        hbox.getChildren().addAll(colourText,strategyText,b,saveGame,revertGame,clear);



        b.setMinWidth(100);
        b.setOnAction(e-> model.handlenewBall(colourText.getText(),strategyText.getText()));
        this.scene = new Scene(pane, model.getWidth(), model.getHeight());
        Canvas canvas = new Canvas(model.getWidth(), model.getHeight());
        gc = canvas.getGraphicsContext2D();
        pane.getChildren().addAll(canvas,hbox);
    }

    Scene getScene() {
        return this.scene;
    }

    void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void draw() {
        model.tick();

        gc.clearRect(0, 0, model.getWidth(), model.getHeight());

        for (Ball ball: model.getBalls()) {
            gc.setFill(ball.getColour());
            gc.fillOval(ball.getxPos() - ball.getRadius(),
                        ball.getyPos() - ball.getRadius(),
                        ball.getRadius() * 2,
                        ball.getRadius() * 2);
        }
    }
}
