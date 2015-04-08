package core;

import gamestates.GameState;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.VideoMode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Matthew on 05/04/2015.
 */
public class Game {

    public RenderWindow window = new RenderWindow();
    private Stack<GameState> gameStates = new Stack<GameState>();

    public Game() {
        window.create(new VideoMode(1024, 800), "Space Game");
        window.setVerticalSyncEnabled(true);

    }

    public void run() {

        Clock clock = new Clock();

        while (window.isOpen()) {
            Time elapsed = clock.restart();
            Float dt = elapsed.asSeconds();

            peekState().handleInput();

            window.clear(Color.BLACK);
            peekState().update(dt);
            peekState().draw(dt);
            window.display();
        }
    }

    public void pushState(GameState state) {
        gameStates.push(state);
    }

    public void popState() {
        if (!gameStates.isEmpty()) {
            gameStates.pop();
        }
    }

    public void changeState(GameState state) {
        popState();
        pushState(state);
    }

    public GameState peekState() {
        try {
            if (gameStates.isEmpty()) {
                throw new EmptyStackException();
            }
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        return gameStates.peek();
    }
}
