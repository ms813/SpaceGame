package gamestates;

import core.FontManager;
import core.Game;
import core.TextureManager;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.View;

/**
 * Created by Matthew on 05/04/2015.
 */
public abstract class GameState {

    public GameState(Game game){
        this.game = game;
    }

    public abstract void draw(float dt);
    public abstract void update(float dt);
    public abstract void handleInput();

    public abstract void loadTextures();

    protected Game game;
    protected View gameView;

    protected TextureManager textureManager;
    protected FontManager fontManager;

    protected Sprite background;
}
