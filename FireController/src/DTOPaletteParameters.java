import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;

public class DTOPaletteParameters extends JTable {

    // ATRIBUTOS

    private ArrayList<ColorTarget> colorTarget = new ArrayList<ColorTarget>();

    // CONSTRUCTORES

    public DTOPaletteParameters() {

        defaultColorTargets();
    }

    // METODOS

    // Añadir colorTargets
    public void addColorTarget(int temp, int r, int g, int b, int a) {

        Color c = new Color(r, g, b, a);

        colorTarget.add(new ColorTarget(c, temp));
    }

    public void addColorTargets(ArrayList<ColorTarget> colorTargets) {

        for (int i = 0; i < colorTargets.size(); i++) {

            this.colorTarget.add(colorTargets.get(i));
        }
    }

    // Resetear colorTargets
    public void defaultColorTargets() {
        this.colorTarget = new ArrayList<ColorTarget>();

        // Añadimos los colores por default
        addColorTarget(0, 0, 0, 0, 0);
        addColorTarget(55, 0, 0, 0, 100);
        addColorTarget(60, 155, 0, 0, 110);
        addColorTarget(72, 200, 100, 0, 180);
        addColorTarget(112, 235, 235, 40, 250);
        addColorTarget(130, 255, 255, 200, 255);
        addColorTarget(155, 255, 255, 255, 255);
        addColorTarget(255, 255, 255, 255, 255);
    }

    // GETTERS AND SETTERS

    public ArrayList<ColorTarget> getColorTargets() {

        return this.colorTarget;
    }
}
