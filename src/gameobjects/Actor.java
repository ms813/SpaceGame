package gameobjects;

import org.jsfml.system.Vector2f;

/**
 * Created by Matthew on 07/04/2015.
 */
public abstract class Actor extends GameObject {
    //default command is empty
    protected Command currentCommand = new Command(CommandType.IDLE, Vector2f.ZERO, null);

    public void setCurrentCommand(Command cmd){
        this.currentCommand = cmd;
    }
    public Command getCurrentCommand(){
        return currentCommand;
    }

    public void move(Vector2f offset){
        sprite.move(offset);
    }
}
