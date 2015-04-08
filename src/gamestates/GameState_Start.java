package gamestates;

import core.FontManager;
import core.Game;
import core.Logger;
import core.TextureManager;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.View;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;


/**
 * Created by Matthew on 05/04/2015.
 */
public class GameState_Start extends GameState{

    public GameState_Start(Game game){
        super(game);

        textureManager = new TextureManager();
        loadTextures();

        fontManager = new FontManager();

        background = new Sprite(textureManager.getTexture("startMenuBg.jpg"));

        gameView = new View();
    }

     @Override
    public void draw(float dt){
         game.window.setView(gameView);
         game.window.draw(background);
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

            if(e.type == Event.Type.RESIZED){
                gameView.setSize(new Vector2f(e.asSizeEvent().size));
                background.setPosition(game.window.mapPixelToCoords(Vector2i.ZERO));
            }

            if(e.type == Event.Type.KEY_PRESSED){
                KeyEvent keyEvt = e.asKeyEvent();

                switch(keyEvt.key){
                    case ESCAPE:{
                        game.window.close();
                        break;
                    }
                    case SPACE:{
                        Logger.println("[GameState_Start] Space key pressed, loading Hub state");
                        game.changeState(new GameState_Hub(game));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void loadTextures() {
        textureManager.loadTexture("startMenuBg.jpg");
    }
}
