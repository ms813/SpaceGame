package gameobjects.battleship;

import gameobjects.Actor;
import gameobjects.Command;
import gameobjects.CommandType;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

/**
 * Created by Matthew on 06/04/2015.
 */
public class BattleShip extends Actor {

    private String name = "new_battleship";

    private BattleShip_Attack attackComponent;
    private BattleShip_Defend defendComponent;
    private BattleShip_Move moveComponent;

    public BattleShip() {

    }

    @Override
    public void draw(RenderWindow window, float dt) {
        window.draw(sprite);
    }

    @Override
    public void onLeftClick() {
    }

    @Override
    public void update(float dt) {
        if(currentCommand.getType() == CommandType.IDLE){
            //no current command
        }
        if(currentCommand.getType() == CommandType.MOVE){
            moveComponent.update(this, dt);
        }
    }


    public void setAttackComponent(BattleShip_Attack attackComponent) {
        this.attackComponent = attackComponent;
    }

    public void setDefendComponent(BattleShip_Defend defendComponent) {
        this.defendComponent = defendComponent;
    }

    public void setMoveComponent(BattleShip_Move moveComponent) {
        this.moveComponent = moveComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void setCurrentCommand(Command cmd) {
        currentCommand = cmd;
        moveComponent.setVelocity(Vector2f.ZERO);
    }

    @Override
    public Command getCurrentCommand(){
        return currentCommand;
    }
}
