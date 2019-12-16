package arkanoid;

        import static arkanoid.Constants.SCREEN_HEIGHT;
        import static arkanoid.Constants.SCREEN_WIDTH;
        import javax.swing.JFrame;

public class Main {
    public static void main(String[] args)
    {
        JFrame game = new JFrame();
        Gameplay gamePlay = Gameplay.getInstance();
        game.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        game.setTitle("Arkanoid game");
        game.setResizable(false);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(gamePlay);

    }
}
