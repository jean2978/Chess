import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Chess {

    public static void main(String[] args) {
        createCanvas();
    }

    private static void createCanvas(){
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new BorderLayout());
        Squares squares = new Squares();

        //Chessboard = 8*8 = 64
        int x = 0;
        int y = 0;

        for (int i = 0; i < 71; i++) {
            if(x < 160){
                if(i % 2 == 0){
                    squares.getSquares().add(new Square(x, y, Color.white));
                }else{
                    squares.getSquares().add(new Square(x, y, Color.black));
                }
                x += 20;
            }else{
                x = 0;
                y += 20;
            }

        }

        jFrame.add(squares);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}

class Squares extends JPanel{
    private final ArrayList<Square> squares = new ArrayList<>();

    public Squares(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("X: " + e.getX() + "\n" + "Y: " + e.getY());
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Square square: squares) {
            g.setColor(square.getColor());
            g.fillRect(square.getPos_x(), square.getPos_y(), square.getWidth(), square.getHeight());
            g.setColor(square.getColor());
            g.drawRect(square.getPos_x(), square.getPos_y(), square.getWidth(), square.getHeight());
        }

    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

}

class Square{

    private final int pos_x,pos_y;
    private final Color color;


    public Square(int x, int y, Color color) {
        this.pos_x = x;
        this.pos_y = y;
        this.color = color;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public int getHeight() {
        return 20;
    }

    public int getWidth() {
        return 20;
    }

    public Color getColor() {
        return color;
    }


}

