import javafx.scene.paint.Paint;

import java.util.Random;

public class Ball implements Drawable {
    private double xPos;
    private double yPos;

    @Override
    protected Object clone() {
        Ball clone = null;
        try
        {
            clone = (Ball) super.clone();
            clone.setxPos(this.xPos);
            clone.setyPos(this.yPos);
        }
        catch (CloneNotSupportedException c )
        {
            System.out.print("you encountered a error");
            throw new RuntimeException(c);
        }
        return  clone;
    }

    private double radius;
    private double xVel;
    private double yVel;
    private Paint colour;
    // new field for the strategy!
    private BallMovementStrategy movementStrategy;


    Ball(double startX, double startY, double startRadius, Paint colour, BallMovementStrategy strategy) {
        this.xPos = startX;
        this.yPos = startY;
        this.radius = startRadius;
        this.colour = colour;
        this.movementStrategy = strategy;
        xVel = new Random().nextInt(5);
        yVel = new Random().nextInt(5);
    }

    void tick() {
        xPos += xVel;
        yPos += yVel;
    }

    void setxVel(double xVel) {
        this.xVel = xVel;
    }

    void setyVel(double yVel) {
        this.yVel = yVel;
    }

    double getRadius() {
        return radius;
    }

    double getxPos() {
        return xPos;
    }

    double getyPos() {
        return yPos;
    }

    Paint getColour() {
        return colour;
    }

    double getxVel() {
        return xVel;
    }

    double getyVel() {
        return yVel;
    }

    void setxPos(double xPos) {
        this.xPos = xPos;
    }

    void setyPos(double yPos) {
        this.yPos = yPos;
    }

    void think(BallPit pit) {
        // Here is where the strategy should have some effect.
        // You can add parameters to the think method so the ball knows something about its
        // world to make decisions with, or you can inject things upon construction for it to query
        movementStrategy.influenceMovement(this, pit);
    }


    @Override
    public Ball makeCopy() {
Ball obj = null;
        try {
            obj = (Ball) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
