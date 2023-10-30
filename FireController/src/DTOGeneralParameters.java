import java.awt.image.BufferedImage;

public class DTOGeneralParameters {

    // ATRIBUTOS

    private int fireWidth = 0;
    private int fireHight = 0;
    private int showFramesPerSecond = 60;
    private int calcFramesPerSecond = 60;
    private int firXPosition = 0;
    private int fireYPosition = 0;
    private BufferedImage backgroundImage;

    // CONSTRUCTOR

    public DTOGeneralParameters() {

    }

    // GETTERS AND SETTERS

    public int getFireWidth() {
        return fireWidth;
    }

    public void setFireWidth(int fireWidth) {
        this.fireWidth = fireWidth;
    }

    public int getFireHight() {
        return fireHight;
    }

    public void setFireHight(int fireHight) {
        this.fireHight = fireHight;
    }

    public int getShowFramesPerSecond() {
        return showFramesPerSecond;
    }

    public void setShowFramesPerSecond(int showFramesPerSecond) {
        this.showFramesPerSecond = showFramesPerSecond;
    }

    public int getCalcFramesPerSecond() {
        return calcFramesPerSecond;
    }

    public void setCalcFramesPerSecond(int calcFramesPerSecond) {
        this.calcFramesPerSecond = calcFramesPerSecond;
    }

    public int getFirXPosition() {
        return firXPosition;
    }

    public void setFirXPosition(int firXPosition) {
        this.firXPosition = firXPosition;
    }

    public int getFireYPosition() {
        return fireYPosition;
    }

    public void setFireYPosition(int fireYPosition) {
        this.fireYPosition = fireYPosition;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
