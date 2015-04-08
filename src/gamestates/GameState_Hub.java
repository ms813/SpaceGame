package gamestates;

import core.*;
import gameobjects.ButtonObject;
import gameobjects.GameObject;
import gameobjects.GameObject_OnClick;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.MouseButtonEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 05/04/2015.
 */
public class GameState_Hub extends GameState {

    private List<GameObject> gameObjects = new ArrayList<GameObject>();

    public GameState_Hub(Game game) {
        super(game);

        textureManager = new TextureManager();
        loadTextures();
        background = new Sprite(textureManager.getTexture("startMenuBg.jpg"));

        createGameObjects();
    }

    @Override
    public void draw(float dt) {
        game.window.clear(Color.GREEN);

        game.window.draw(background);

        for (GameObject obj : gameObjects) {
            obj.draw(game.window, dt);
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void handleInput() {
        for (Event e : game.window.pollEvents()) {
            if (e.type == Event.Type.CLOSED) {
                game.window.close();
            }

            if (e.type == Event.Type.MOUSE_BUTTON_PRESSED) {
                MouseButtonEvent mEvt = e.asMouseButtonEvent();
                if (mEvt.button == Mouse.Button.LEFT) {
                    for (GameObject o : gameObjects) {
                        if(o.isClicked(game.window.mapPixelToCoords(mEvt.position))){
                            o.onLeftClick();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void loadTextures() {
        textureManager.loadTexture("button.png");
    }

    private void createGameObjects() {

        /*****************
        *  Start button  *
        *****************/
        Vector2f pos = Vector2f.mul(new Vector2f(game.window.getSize()), 0.5f);
        gameObjects.add(new ButtonObject("Start battle", pos,
                new GameObject_OnClick() {
                    @Override
                    public void onClick() {
                        Logger.println("[GameState_Hub] Start game button clicked, loading battlefield");
                        game.changeState(new GameState_Battlefield(game));
                    }
                }));
    }
}
