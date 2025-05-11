
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class DisplayGrafico {

    private BufferedImage image;
    private Graphics2D g2d;

    DisplayGrafico(int x, int y) {
        image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        // Imposta tutti i pixel a nero (o spenti)
        g2d = image.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 400);
        g2d.dispose();
    }

    public void Draw (int x, int y, Color color) {
        image.setRGB(x, y, color.getRGB());
    }
}