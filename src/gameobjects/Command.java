package gameobjects;

import org.jsfml.system.Vector2f;

/**
 * Created by Matthew on 08/04/2015.
 */
public class Command {
    private CommandType type;
    private Actor targetActor;
    private Vector2f targetPos;

    public Command(CommandType type, Vector2f targetPos, Actor targetActor){
        this.type = type;
        this.targetPos = targetPos;
        this.targetActor = targetActor;
    }

    public Actor getTargetActor() {
        return targetActor;
    }

    public Vector2f getTargetPosition() {
        return targetPos;
    }

    public CommandType getType() {
        return type;
    }
}
