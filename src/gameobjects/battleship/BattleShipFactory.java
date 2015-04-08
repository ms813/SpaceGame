package gameobjects.battleship;

import com.sun.xml.internal.bind.v2.TODO;
import core.Logger;
import core.TextureManager;
import core.VMath;
import org.jsfml.graphics.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew on 06/04/2015.
 */
public class BattleShipFactory {

    private TextureManager shipTextureManager = new TextureManager();

    private static HashMap<String, Integer> shipCount = new HashMap<String, Integer>();

    public BattleShip buildBattleShip(String type){

        Integer c = shipCount.get(type);
        if(c != null){
            //ship found, increment count
            shipCount.put(type, ++c);
        }else{
            //ship not found, add to counter
            shipCount.put(type, 1);
        }

        BattleShip battleShip = new BattleShip();
        battleShip.setName(type + shipCount.get(type));
        Logger.println("[BattleShipFactory.buildBattleShip()] Creating " + battleShip.getName());
        Sprite s = new Sprite();

        if(type.equals("cruiser")){
            s.setTexture(shipTextureManager.getTexture("spaceship.png"));
            //TODO build and set components;
            battleShip.setMoveComponent(new BattleShip_Move(50.0f));
            s.setScale(0.5f, 0.5f);
        }
        s.setOrigin(VMath.centroid(s.getLocalBounds()));
        battleShip.setSprite(s);
        return battleShip;
    }

}
