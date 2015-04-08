package gameobjects;

import core.Game;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;


/**
 * Created by Matthew on 05/04/2015.
 */
public abstract class GameObject {

    protected Sprite sprite = new Sprite();

    public abstract void draw(RenderWindow window, float dt);

    public boolean isClicked(Vector2f mousePos) {
        return (mousePos.x < sprite.getGlobalBounds().left + sprite.getGlobalBounds().width
                && mousePos.x > sprite.getGlobalBounds().left
                && mousePos.y < sprite.getGlobalBounds().top + sprite.getGlobalBounds().height
                && mousePos.y > sprite.getGlobalBounds().top);
    }

    public abstract void onLeftClick();

    public abstract void update(float dt);

    public Vector2f getPosition(){
        return sprite.getPosition();
    }


}
