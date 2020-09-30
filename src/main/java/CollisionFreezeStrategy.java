public class CollisionFreezeStrategy extends BallMovementStrategy {
    @Override
    public void influenceMovement(Ball b, BallPit pit) {
        // tries to stop when it bounces off another ball
        for (Ball other : pit.getBalls()) {
            if (pit.checkCollision(b, other)) {
                // try to stop?? bih what
                // maybe try to make its velocities smaller
                // like honestly i dont even know
                // accelerate it in the opposite direction that it is going
                double extraXVel = 0.0, extraYVel = 0.0;

                // This is a bit dodgy and not exactly correct
                // but you get the idea.
                b.setxVel(0);
                b.setyVel(0);
            }
        }
    }
}
