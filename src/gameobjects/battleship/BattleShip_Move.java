package gameobjects.battleship;

import core.VMath;
import gameobjects.Actor;
import gameobjects.Command;
import gameobjects.CommandType;
import org.jsfml.system.Vector2f;

/**
 * Created by Matthew on 06/04/2015.
 */
public class BattleShip_Move {

    private float maxSpeed = 0f;
    private Vector2f velocity = Vector2f.ZERO;

    public BattleShip_Move(float maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    public void update(Actor a, float dt){
        Command cmd = a.getCurrentCommand();

        if(VMath.magnitude(velocity) < maxSpeed){
            velocity = Vector2f.mul(VMath.unitDir(cmd.getTargetPosition(), a.getPosition()), maxSpeed);
        }

        //target position reached, so set command to blank command
        if(VMath.nearlyEquals(a.getPosition(), cmd.getTargetPosition())){
            a.setCurrentCommand(new Command(CommandType.IDLE, Vector2f.ZERO, null));
            velocity = Vector2f.ZERO;
        }
        a.move(Vector2f.mul(velocity, dt));
    }

    public void setVelocity(Vector2f velocity){
        this.velocity = velocity;
    }

}
