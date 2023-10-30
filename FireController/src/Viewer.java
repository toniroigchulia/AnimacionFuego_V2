import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Viewer extends Canvas {

    // ATRIBUTOS

    private BufferedImage backgroundImg;
    private BufferStrategy bs;

    // CONSTRUCTOR

    public Viewer() {
        
        this.setSize(new Dimension(520, 520));
        bs = null;
    }

    // METODOS

    // Cargamos la imagen de fondo para su uso
    public void loadBackground(BufferedImage backgroundImage) {

        try {

            this.backgroundImg = backgroundImage;
        } catch (Exception e) {
            System.err.println("Error loading background. ");
            System.err.println(e);
        }
    }

    // Metodo para dibujar en el buffer el background
    public void prepairBackground() {
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        Graphics g = bs.getDrawGraphics();
        g = bs.getDrawGraphics();
        g.drawImage(this.backgroundImg, 0, 0, this.getWidth(), this.getHeight(), null);

        g.dispose();
    }

    // Metdo para mostrar el background
    public void paintBackground() {

        prepairBackground();
        bs.show();
    }

    // Metodo para dibujar en el buffer el fuego
    public void prepairFire(FireModel fireImg) {
        if (this.bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }

        fireImg.next();

        Graphics g = bs.getDrawGraphics();
        g.drawImage(fireImg, (int) ((this.getWidth() / 2.43) + fireImg.getPosX()),
                (int) ((this.getHeight() / 1.655) - fireImg.getPosY()),
                (int) ((this.getWidth() / 2.2) + fireImg.getWidth()),
                (int) ((this.getHeight() / 4.618) + fireImg.getHeight()), null);
        fireImg.next();
        g.dispose();
    }

    // Metodo para mostrar el fuego
    public void paintFire(FireModel fireImg) {

        prepairBackground();
        prepairFire(fireImg);
        bs.show();
    }
}
