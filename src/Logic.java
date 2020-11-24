import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Logic extends JFrame implements ActionListener{

    //array 2 dimensi untuk membuat board 3x3
    static JButton buttonArray[][];
    
    //label untuk menentukan giliran
    static JLabel playerLabel;

    //menentukan kondisi awal
    static boolean player1 = true;
    static boolean player2 = false;
    static boolean gameOver = false;
    static boolean gameDraw = false;
    String player1Symbol = "X";
    String player2Symbol = "O";

    int X = 10, Y = 10;


    //konstuktor buat controls
    public Logic() {
        //membuat panel board dan posisinya
        JPanel panel = new JPanel();
        panel.setBounds(50, 40, 200, 400);
        panel.setLayout(null);

        //membuat array 3x3
        buttonArray = new JButton[3][3];

        //set playerlabel dan lokasinya
        playerLabel = new JLabel("Player 1");
        playerLabel.setBounds(120, 10, 100, 30);

        // membuat loop untuk 9 button 
        // set posisinya
        // menambahkan actionlistener buat klik
        // nambahin buttonl ke panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    buttonArray[i][j] = new JButton();
                    buttonArray[i][j].addActionListener(this);
                    buttonArray[i][j].setBounds(X, Y, 50, 50);
                    X += 60;
                    // If 3 buttons are added
                    // Increment Y to set buttons to next line
                    if (j == 3 - 1) {
                            Y += 60;
                            X = 10;
                    }
                    panel.add(buttonArray[i][j]);
            }
            }
            // Set layout null
            // add player label ke frame
            // Add panel ke frame
            setLayout(null);
            add(playerLabel);
            add(panel);
    }
    // This method handles click events of buttons
    @Override
    public void actionPerformed(ActionEvent e){
        //kalo game blm selesai
        if(gameOver == false) {
            // kalo giliran player 1
            // player 1 diset false, player 2 diset true(buat next turn)
            // panggil set symbol
            // checkwin buat ngecek player 1 menang apa engga
            if (player1) {
                player1 = false;
                player2 = true;
                setSymbol((JButton) e.getSource(), player1Symbol, "Player 2");
                checkWin("Player 1");
            }
            // giliran player 2
            // player 2 diset false, player 1 diset true(buat next turn)
            // panggil set symbol
            // checkwin buat ngecek player 1 menang apa engga
            else {
                player2 = false;
                player1 = true;
                setSymbol((JButton) e.getSource(), player2Symbol, "Player 1");
                checkWin("Player 2");
            }

        }
    }
    public static void setSymbol(JButton button, String symbol, String labelText) {
        // set symbol dalem button
        // disable button
        // set player label
        button.setText(symbol);
        button.setEnabled(false);
        playerLabel.setText(labelText);
    }

    public static void checkWin(String currentPlayer) {
         // Get text di semua button
         String valueAt00 = buttonArray[0][0].getText();
         String valueAt01 = buttonArray[0][1].getText();
         String valueAt02 = buttonArray[0][2].getText();
         String valueAt10 = buttonArray[1][0].getText();
         String valueAt11 = buttonArray[1][1].getText();
         String valueAt12 = buttonArray[1][2].getText();
         String valueAt20 = buttonArray[2][0].getText();
         String valueAt21 = buttonArray[2][1].getText();
         String valueAt22 = buttonArray[2][2].getText();

        // Set gameOver jd true kalo memenuhi exception dibawah
        // kalo row 1 sama
        if (valueAt00 == valueAt01 && valueAt01 == valueAt02 && valueAt00 != "") {
            gameOver = true;
        }
        // kalo row 2 sama
        else if (valueAt10 == valueAt11 && valueAt11 == valueAt12 && valueAt10 != "") {
                gameOver = true;
        }
        // kalo row 3 sama
        else if (valueAt20 == valueAt21 && valueAt21 == valueAt22 && valueAt20 != "") {
                gameOver = true;
        }
        // kalo column 1 sama
        else if (valueAt00 == valueAt10 && valueAt10 == valueAt20 && valueAt00 != "") {
                gameOver = true;
        }
        // kalo column 2 sama
        else if (valueAt01 == valueAt11 && valueAt11 == valueAt21 && valueAt01 != "") {
                gameOver = true;
        }
        // kalo column 3 sama
        else if (valueAt02 == valueAt12 && valueAt12 == valueAt22 && valueAt02 != "") {
                gameOver = true;
        }
        // kalo diagonal sama
        else if (valueAt00 == valueAt11 && valueAt11 == valueAt22 && valueAt00 != "") {
                gameOver = true;

        }
        // kalo diagonal sama
        else if (valueAt02 == valueAt11 && valueAt11 == valueAt20 && valueAt02 != "") {
                gameOver = true;

        } 
        // semua button di klik dan gaada yg memenuhi syarat diatas
        // Set gameOver gameDraw jadi true
        else if (valueAt00 != "" && valueAt01 != "" && valueAt02 != "" && valueAt10 != "" && valueAt11 != ""
                        && valueAt12 != "" && valueAt20 != "" && valueAt21 != "" && valueAt22 != "") {
                gameOver = true;
                gameDraw = true;
        }

        // kalo gameover == true
        if (gameOver) {
            int result = -1;
            
            // kalo draw, keluar message "Game Draw"
            if (gameDraw) {
                    result = JOptionPane.showConfirmDialog(null, "SERI COY\nMain lagi?", "Game Over", JOptionPane.YES_NO_OPTION);
            } 
            // kalo ada yg menang, display currentPlayer
            else {
                    result = JOptionPane.showConfirmDialog(null, currentPlayer + " menang!!\nMain lagi?", "Game Over", JOptionPane.YES_NO_OPTION);
            }

            // kalo result = 0, artinya user pencet yes
            // Reset game, else exit game
            if (result == 0) {
                    resetGame();
            } else {
                    System.exit(0);
            }
        }
    }
    public static void resetGame() {
        // Re-set gameOver dan gameDraw jd false
        gameOver = false;
        gameDraw = false;
        
        // enable semua button dan text jadi ""
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                        buttonArray[i][j].setText("");
                        buttonArray[i][j].setEnabled(true);
                }
        }
        
        // Reset playerLabel
        playerLabel.setText("Player 1");
        
        // Reset player1 jd true dan player2 false
        player1 = true;
        player2 = false;
    }
}