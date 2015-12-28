package youtubechannelart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class YouTubeChannelArt {

    public static void main(String[] args) throws IOException {
        int width = 2048;
        int height = 1152;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D gr = img.createGraphics();

        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, width, height);

        Random rand = new Random(100);
        for (int count = 0; count < 10000; count++) {
            int i = rand.nextInt(width);
            int j = rand.nextInt(height);
            Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0.5f);

            // 3 objects placed randomly
            // first one is circle
            // second is rect
            // third is rounded rect
            gr.setColor(color);
            float p = rand.nextFloat();

            int objectSize = width / 10;
            int w = rand.nextInt(objectSize);
            int h = rand.nextInt(objectSize);
            if (p < 0.33) {
                // circle
                gr.fillOval(i - w / 2, j - h / 2, w, h);
            } else if (p < 0.66) {
                // rect
                gr.fillRect(i - w / 2, j - h / 2, w, h);
            } else {
                // rounded rect
                gr.fillRoundRect(i - w / 2, j - h / 2, w, h, w / 4, h / 4);
            }
        }
        
        for (int count = 0; count < 50; count++) {
            gr.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 10 + rand.nextInt(height / 10)));
            int i = rand.nextInt(width);
            int j = rand.nextInt(height);
            Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 0.5f);
            gr.setColor(color);
            gr.drawString("Code4Lyfe", i, j);
        }

        ImageIO.write(img, "png", new File("channelArt.png"));
    }
}
