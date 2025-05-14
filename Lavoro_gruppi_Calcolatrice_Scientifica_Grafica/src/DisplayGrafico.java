import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class DisplayGrafico {

    private BufferedImage image;
    private Graphics2D g2d;

    DisplayGrafico(int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Imposta tutti i pixel a nero (o spenti)
        g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < width; x += 50) {
            g2d.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < height; y += 50) {
            g2d.drawLine(0, y, width, y);
        }

        g2d.setColor(Color.BLACK);
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

    public void Draw (int x, int y, Color color) {
        image.setRGB(x, y, color.getRGB());
    }
}