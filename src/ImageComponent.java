import javax.swing.*;
import java.awt.*;

/**
 * Created by MuhamadSyahirAmir on 10/1/2019.
 */
public class ImageComponent extends JComponent {

    private Icon icon;

    ImageComponent(Icon icon) {
        this.icon = icon;
    }

    void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int x = (800 - w) / 2;
        int y = (600 - h) / 2;
        icon.paintIcon(this, g, x, y);
    }
}
