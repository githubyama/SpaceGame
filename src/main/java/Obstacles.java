import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Obstacles {
    int x = 5;
    int y = 5;
    final char block = '\u2588';

    public Place[] obstacleMethod(int x, int y) {
        Place[] obstacles = new Place[7];
        for (int i = 0; i < 7; i++) {
            obstacles[i] = new Place(x + i, y);
        }

        boolean crashIntoObsticle = false;
        for (Place p : obstacles) {
            if (p.x == x && p.y == y) {
                crashIntoObsticle = true;
            }



        } return obstacles;


   }
/*
        if (crashIntoObsticle) {
        x = oldX;
        y = oldY;
    }
        else {
        terminal.setCursorPosition(oldX, oldY); // move cursor to old position
        terminal.putCharacter(' '); // clean up by printing space on old position
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);


    }*/
}
