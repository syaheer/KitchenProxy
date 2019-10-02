import javax.swing.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main {
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("Menu Item Viewer");
    private JMenuBar menuBar;
    private JMenu menu;
    private Hashtable menuItem = new Hashtable();

    public static void main(String[] args) throws Exception {
        Main menuItemViewer = new Main();
    }

    private Main() throws Exception {
        menuItem.put("Orange Beef", "https://i.imgur.com/BiFkD83.jpg");
        menuItem.put("Ham Fried Rice", "https://i.imgur.com/eTuCPxM.jpg");
        menuItem.put("Chinese Dumplings with Pork and Cabbage", "https://i.imgur.com/evzIQVF.jpg");
        menuItem.put("Honey Sriracha Chicken", "https://i.imgur.com/ApuihUx.jpg");
        menuItem.put("Chinese Spare Ribs", "https://i.imgur.com/lVdWrve.jpg");
        menuItem.put("Shrimp Chow Mein", "https://i.imgur.com/LUiR7W8.jpg");
        menuItem.put("Beijing Beef", "https://i.imgur.com/5NljFvC.jpg");
        URL initialURL = new URL((String) menuItem.get("Orange Beef"));
        menuBar = new JMenuBar();
        menu = new JMenu("Food Menu");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        for (Enumeration e = menuItem.keys(); e.hasMoreElements(); ) {
            String name = (String) e.nextElement();
            JMenuItem jMenuItem = new JMenuItem(name);
            menu.add(jMenuItem);
            jMenuItem.addActionListener(event -> {
                imageComponent.setIcon(new ImageProxy(getFoodUrl(event.getActionCommand())));
                frame.repaint();
            });
        }

        // set up frame and menus
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private URL getFoodUrl(String name) {
        try {
            return new URL((String) menuItem.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}