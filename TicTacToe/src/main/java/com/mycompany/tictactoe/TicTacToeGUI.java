/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import com.mycompany.tictactoe.model.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author jojos
 */
public class TicTacToeGUI {
    private JFrame frame;
    private JButton[][] buttons;
    private Game game;
    private JLabel statusLabel;
    
    public TicTacToeGUI() {
        game = new Game();
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLayout(new BorderLayout());
        
        statusLabel = new JLabel("Player X's Turn");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(statusLabel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton(" ");
                button.setFont(new Font("Arial", Font.BOLD, 40));
                final int row = i;
                final int col = j;
                
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (button.getText().equals("") && !game.checkWin() && !game.checkTie()) {
                            button.setText(String.valueOf(game.getCurrentPlayer()));
                            game.makeMove(row, col);
                            
                            if (game.checkWin()) {
                                statusLabel.setText("Player " + game.getCurrentPlayer() + " wins!");
                                disableAllButtons();
                            }
                            else if (game.checkTie()) {
                                statusLabel.setText("It's a tie!");
                            }
                            else {
                                game.switchPlayer();
                                statusLabel.setText("Player " + game.getCurrentPlayer() + "'s Turn");
                            }
                        }
                    }
                });
                buttons[i][j] = button;
                panel.add(button);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        
        JButton restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.PLAIN, 16));
        restartButton.addActionListener(e -> resetGame());
        
        frame.add(restartButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    private void resetGame() {
        game = new Game();
        statusLabel.setText("Player X's Turn");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }
    
    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
