import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Crosses extends JPanel {
    static JFrame JFrame;
    static List<JButton> fieldButtons;
    static JLabel informLabel;
    static String[] gameField;
    static String turn;
    static boolean winner;
    static int cellValue;
    private static Object args;
    private Container panel;

    public static void main(String[] args) {
        JFrame = new JFrame();
        JFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Crosses crosses = new Crosses();
        JFrame.add(crosses);
        JFrame.setContentPane(crosses);
        JFrame.setVisible(true);

        fieldButtons = new ArrayList<JButton>();
        informLabel = new JLabel("Welcome to the game tic-tac-toe!!!");

        gameField = new String[9];
        turn = "x";
        winner = false;
        cellValue = 0;
        EmptyField();
    }

    static void EmptyField() {
        JFrame.setLayout(null);
        informLabel.setBounds(10, 160, 400, 400);
        JFrame.add(informLabel);
        int xInc = 0;
        int yInc = -100;
        for (int i = 0; i < 9; i++) gameField[i] = "empty";
        for (int y = 0; y < 3; y++) {
            xInc = 0;
            yInc += 100;
            for (int x = 0; x < 3; x++) {
                fieldButtons.add(new JButton(""));
                fieldButtons.get(cellValue).setBounds(xInc, yInc, 100, 100);
                JFrame.add(fieldButtons.get(cellValue));
                fieldButtons.get(cellValue).addActionListener(new ActionListener() {
                    int value = cellValue;

                    public void actionPerformed(ActionEvent e) {
                        if (!winner && gameField[value].equals("empty")) {
                            gameField[value] = turn;
                            fieldButtons.get(value).setText(turn);
                            if (turn.equals("x")) {
                                turn = "o";

                            } else {
                                turn = "x";
                            }
                            WinOrNot();
                        } else if (winner) informLabel.setText("The game is already over!");
                        else informLabel.setText("This cell is already occupied! You can choose another cell!");
                    }
                });
                cellValue++;
                xInc += 100;
            }
            JFrame.setSize(300, 450);
            JFrame.setResizable(false);
        }
    }

    public static void WinOrNot() {
        if (gameField[0].equals(turn) && gameField[1].equals(turn) && gameField[2].equals(turn) ||
                gameField[3].equals(turn) && gameField[4].equals(turn) && gameField[5].equals(turn) ||
                gameField[6].equals(turn) && gameField[7].equals(turn) && gameField[8].equals(turn) ||
                gameField[0].equals(turn) && gameField[3].equals(turn) && gameField[6].equals(turn) ||
                gameField[1].equals(turn) && gameField[4].equals(turn) && gameField[7].equals(turn) ||
                gameField[2].equals(turn) && gameField[5].equals(turn) && gameField[8].equals(turn) ||
                gameField[0].equals(turn) && gameField[4].equals(turn) && gameField[8].equals(turn) ||
                gameField[2].equals(turn) && gameField[4].equals(turn) && gameField[6].equals(turn)) {
            winner = true;
            informLabel.setText("Выиграл игрок " + turn);
        }
    }
}
