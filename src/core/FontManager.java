package core;

import org.jsfml.graphics.Font;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew on 06/04/2015.
 */
public class FontManager {

    private HashMap<String, Font> fonts = new HashMap<String, Font>();

    public Font getFont(String name) {
        Font font = new Font();
        boolean found = false;

        for (Map.Entry<String, Font> entry : fonts.entrySet()) {
            if (entry.getKey().equals(name)) {
                font = entry.getValue();
                found = true;
            }
        }

        if (!found) {
            try {
                font.loadFromFile(Paths.get("resources" + File.separator + "fonts" + File.separator + name + ".ttf"));
                fonts.put(name, font);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Can't find font '" + name + ".ttf' in resources/fonts/");
            }
        }

        return font;
    }

    public Font getFont() {
        return getFont("arial");
    }
}
