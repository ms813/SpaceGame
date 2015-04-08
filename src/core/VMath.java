package core;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import javax.swing.*;

/**
 * Created by Matthew on 07/04/2015.
 */
public class VMath {

    public static final Vector2f UP = new Vector2f(0, -1);
    public static final Vector2f DOWN = new Vector2f(0, 1);
    public static final Vector2f LEFT = new Vector2f(-1, 0);
    public static final Vector2f RIGHT = new Vector2f(1, 0);

    public static strictfp Vector2f normalize(Vector2f v){
        return Vector2f.div(v, magnitude(v));
    }

    public static strictfp float magnitude(Vector2f v){
        return (float) Math.sqrt(v.x * v.x + v.y * v.y);
    }

    public static strictfp float dot(Vector2f a, Vector2f b){
        return a.x * b.x + a.y * b.y;
    }

    public static strictfp float radBetween(Vector2f a, Vector2f b) {
        float cosTheta = dot(a, b) / (magnitude(a) * magnitude(b));
        return new Float(Math.acos(cosTheta));
    }

    public static strictfp float degBetween(Vector2f a, Vector2f b) {
        return new Float(radBetween(a, b) * 180 / Math.PI);
    }

    public static strictfp Vector2f unitDir(Vector2f to, Vector2f from){
    return normalize(Vector2f.sub(to, from));
    }

    public static strictfp boolean nearlyEquals(Vector2f a, Vector2f b){
        return (a.x < b.x + 5.0f) && (a.x > b.x - 5.0f) && (a.y < b.y + 5.0f) && (a.y > b.y - 5.0f);
    }

    public static strictfp Vector2f centroid(FloatRect r){
        return new Vector2f(r.width* 0.5f, r.height * 0.5f);
    }
}
