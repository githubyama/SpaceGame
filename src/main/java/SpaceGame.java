import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.text.Position;


public class SpaceGame {

    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        Place place = new Place(40, 25);
        terminal.setCursorPosition(place.getX(), place.getY());

        /*terminal.setCursorPosition(40, 25);*/

        terminal.putCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK);

       
        KeyStroke latestKeyStroke = null;

        boolean continueReadingInput = true;
        while (continueReadingInput) {

            int index = 0;
            KeyStroke keyStroke = null;
            do {
                index++;
                if (index % 50 == 0) {
                    if (latestKeyStroke != null) {
                        handleSpaceShip(place, latestKeyStroke, terminal);
                    }
                }

                Thread.sleep(5); // might throw InterruptedException
                keyStroke = terminal.pollInput();


            } while (keyStroke == null);
            latestKeyStroke = keyStroke;



        }

    }


    private static void handleSpaceShip(Place spaceShip, KeyStroke keyStroke, Terminal terminal) throws Exception {
        // Handle player
        Place oldPosition = new Place(spaceShip.getX(), spaceShip.getY());
        switch (keyStroke.getKeyType()) {
            case ArrowDown:
                spaceShip.y += 1;
                break;
            case ArrowUp:
                spaceShip.y -= 1;
                break;
            case ArrowRight:
                spaceShip.x += 1;
                break;
            case ArrowLeft:
                spaceShip.x -= 1;
                break;

        }
        terminal.setCursorPosition(oldPosition.x, oldPosition.y);
        terminal.putCharacter(' ');

        terminal.setCursorPosition(spaceShip.x, spaceShip.y);
        terminal.putCharacter(Symbols.TRIANGLE_UP_POINTING_BLACK);

        terminal.flush();
    }


}




