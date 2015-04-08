package gamestates;

import core.Game;
import core.Logger;
import gameobjects.Actor;
import gameobjects.Command;
import gameobjects.CommandType;
import gameobjects.GameObject;
import gameobjects.battleship.BattleShipFactory;
import org.jsfml.graphics.View;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.MouseButtonEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 05/04/2015.
 */
public class GameState_Battlefield extends GameState {

    private List<Actor> actors = new ArrayList<Actor>();
    private List<GameObject> guiObjets = new ArrayList<GameObject>();

    private BattleShipFactory bsf = new BattleShipFactory();

    private Actor currentlySelectedActor;

    public GameState_Battlefield(Game game) {
        super(game);
        gameView = new View();
        actors.add(bsf.buildBattleShip("cruiser"));
    }

    @Override
    public void draw(float dt) {
        for (GameObject o : actors) {
            o.draw(game.window, dt);
        }
    }

    @Override
    public void update(float dt) {
        for (GameObject o : actors) {
            o.update(dt);
        }
    }

    @Override
    public void handleInput() {
        for (Event e : game.window.pollEvents()) {
            if (e.type == Event.Type.CLOSED) {
                game.window.close();
            }

            if (e.type == Event.Type.MOUSE_BUTTON_PRESSED) {
                MouseButtonEvent mEvt = e.asMouseButtonEvent();
                Vector2f mouseWorldPos = game.window.mapPixelToCoords(mEvt.position);

                if (mEvt.button == Mouse.Button.LEFT) {

                    for (GameObject o : guiObjets) {
                        if (o.isClicked(mouseWorldPos)) {
                            o.onLeftClick();
                            Logger.println("[GameState_Battlefield.handleInput()] clicked on gui item " + o);
                        }
                    }

                    boolean objSelected = false;
                    for (Actor o : actors) {
                        if (o.isClicked(mouseWorldPos)) {
                            o.onLeftClick();
                            currentlySelectedActor = o;
                            objSelected = true;
                            Logger.println("[GameState_Battlefield.handleInput()] current selection: " + o);
                        }
                    }
                    //left clicked on a GUI object or on blank space so deselect
                    if (!objSelected && currentlySelectedActor != null) {
                        Logger.println("[GameState_Battlefield.handleInput()] Deselecting " + currentlySelectedActor);
                        currentlySelectedActor = null;
                    }

                } else if (mEvt.button == Mouse.Button.RIGHT) {
                    //if there is currently an actor selected
                    if (currentlySelectedActor != null) {
                        Actor actorClicked = null;
                        for (Actor a : actors) {
                            if (a.isClicked(mouseWorldPos)) {
                                //perform right click action
                                actorClicked = a;

                            }
                        }

                        currentlySelectedActor.setCurrentCommand(new Command(CommandType.MOVE, mouseWorldPos, actorClicked));
                    }
                }
            }
        }
    }

    @Override
    public void loadTextures() {

    }
}
