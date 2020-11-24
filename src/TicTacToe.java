import javax.swing.JFrame;
public class TicTacToe{
        public static void main(String[] args) {
                // create frame
                JFrame frame = new Logic();
                // set ukuran sama title frame
                frame.setTitle("TicTacToe");
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
        }
}