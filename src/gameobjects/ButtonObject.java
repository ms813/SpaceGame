package gameobjects;

import core.FontManager;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;

import java.io.IOException;
import java.nio.file.Paths;


/**
 * Created by Matthew on 05/04/2015.
 */
public class ButtonObject extends GameObject {

    private static Texture btnTexture = null;
    private static Font font = new FontManager().getFont("arial");
    private static Vector2f size = new Vector2f(256f, 64f);

    private GameObject_OnClick btnClick;

    private Text label = new Text();


    public ButtonObject(String lblText, Vector2f pos, GameObject_OnClick btnClick){
        label.setFont(font);
        label.setString(lblText);

        if(btnTexture == null){
            try{
                btnTexture = new Texture();
                btnTexture.loadFromFile(Paths.get("resources/textures/button.png"));
            } catch (IOException e){
                e.printStackTrace();
                System.err.println("Failed to load button texture!");
            }
        }

        this.sprite = new Sprite(btnTexture);
        sprite.setColor(Color.GREEN);
        label.setColor(Color.BLACK);

        sprite.setScale(new Vector2f(size.x / sprite.getLocalBounds().width, size.y/sprite.getLocalBounds().height));

        sprite.setOrigin(sprite.getLocalBounds().width * 0.5f, sprite.getLocalBounds().height * 0.5f);
        label.setOrigin(label.getLocalBounds().width * 0.5f, label.getLocalBounds().height * 0.5f);
        sprite.setPosition(pos);
        label.setPosition(pos);

        this.btnClick = btnClick;
    }

    @Override
    public void draw(RenderWindow window, float dt){
        window.draw(sprite);
        window.draw(label);
    }

    @Override
    public void onLeftClick() {
        btnClick.onClick();
    }

    @Override
    public void update(float dt) {

    }
}
