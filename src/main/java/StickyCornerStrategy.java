public class StickyCornerStrategy extends BallMovementStrategy {

    @Override
    public void influenceMovement(Ball b, BallPit pit) {
        // figure out which corner it's closest to
        // break it down into the two cases
        // either it is closer to east or west
        double extraXVel = 0.017, extraYVel = 0.017;
        // the default is going NORTH WEST

        if (b.getxPos() < (1/2) * pit.getWidth()) {
            extraXVel *= -1; // should try to go to zero (east)
        }

        if (b.getyPos() < (1/2) * pit.getHeight()) {
            extraYVel *= -1; // should try to fall to the bottom (south)
        }

        b.setyVel(b.getyVel() + extraYVel);
        b.setxVel(b.getxVel() + extraXVel);
    }
}
