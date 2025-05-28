import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;

public class DisplayGrafico {

    private BufferedImage image;
    private Graphics2D g2d;

    private int width;
    private int height;

    DisplayGrafico(int width, int height) {

        this.width = width;
        this.height = height;
        image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        // Imposta tutti i pixel a nero (o spenti)
        g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < width; x += 30) {
            g2d.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += 30) {
            g2d.drawLine(0, y, width, y);
        }

        g2d.setColor(Color.BLUE);
        // asse x
        g2d.drawLine(0, height/2, width, height/2);
        // asse y
        g2d.drawLine(width/2, 0, width/2, height);

        //g2d.dispose();
    }

    // Metodo pubblico per ottenere l'immagine
    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Graphics2D getGraphics2D () {
        return g2d;
    }

    public void reset() {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < width; x += 30) {
            g2d.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += 30) {
            g2d.drawLine(0, y, width, y);
        }

        g2d.setColor(Color.BLUE);
        g2d.drawLine(0, height / 2, width, height / 2);  // asse X
        g2d.drawLine(width / 2, 0, width / 2, height);   // asse Y
    }

}