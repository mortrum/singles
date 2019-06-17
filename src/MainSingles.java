import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import singles.*;
import singles.Box;

import static singles.Ranges.*;


public class MainSingles extends JFrame {
    private Game game;
    private JPanel panel;
    private JLabel label;


    private final int COLS = 5;
    private final int ROWS = 5;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new MainSingles().setVisible(true);
    }


    private MainSingles() {
        game = new Game(COLS, ROWS);
        game.start();

        setImage();
        initLabel();
        initPanel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel("R click new game, L solve;");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (Coord coord : getAllCoords())
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.y * IMAGE_SIZE, coord.x * IMAGE_SIZE, this);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {


                    long startTime = System.nanoTime();
                    long currentTime = 0;

                    while (game.hasNum() && ((currentTime - startTime) / 1000000 < 100)) { //0.1 sec to search, lehet optimizalni hogy volt e valtozas... de ez csak tricky-re kell a plusz algoritmus

                        game.mainAlgoritm();

                        currentTime = System.nanoTime();
                    }
                    System.out.println("sima algoritm "+(currentTime - startTime) / 1000000);



                    if (!game.good()) {
                        game.trySolve();
                        currentTime = System.nanoTime();
                        System.out.println("plusz algoritm " + ((currentTime - startTime) / 1000000 - 100));
                    }
                    game.checkStatus();
                    label.setText(getMessage());
                }
                if (e.getButton() == MouseEvent.BUTTON2){
                    game.startlast();
                    label.setText(getMessage());
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    game.start();
                    label.setText(getMessage());
                }


                panel.repaint();
            }
        });
        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private String getMessage() {
        switch (game.getState()) {
            case NEW_GAME:
                return "new game started";

            case SOLVED:
                return "Okay it's good!";

            case UNSOLVED:
                return "Something gone wrong";

            default:
                return "";
        }
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Singles");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setImage() {
        for (Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

}
