package core;

import gamestates.GameState_Start;

/**
 * Created by Matthew on 05/04/2015.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.pushState(new GameState_Start(game));
        game.run();
    }
}
