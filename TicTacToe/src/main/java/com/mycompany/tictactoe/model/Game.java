/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe.model;

/**
 *
 * @author jojos
 */
import java.util.*;

public class Game {
  private char[][] board; //The game board 3x3
  private char currentPlayer; //'X' or 'O'
  
  private void initialiseBoard() {
    //creates an empty board to play
    
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = '-';
        }
    }
  }
  public Game() {
      //constructor that initialises an empty board, and sets the first player to 'X'
      
      board = new char[3][3];
      initialiseBoard();
      currentPlayer = 'X';
  }
  public boolean isBoardFull() {
    //checking if the board is full
    
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
  }
  public void printBoard() {
    //prints the updated board while playing

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
  }
  public boolean makeMove( int row, int col) {
    //Lets the player play the game

    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
        board[row][col] = currentPlayer;
        return true;
    }
    else {
        return false;
    }
  }
  public boolean checkWin() {
    //checks for winning player

    for (int i = 0; i < 3; i++) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
            return true;
        }
    }
    for (int j = 0; j < 3; j++) {
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
            return true;
        }
    }
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
        return true;
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
        return true;
    }
    return false;
  }
  public boolean checkTie() {
    //checks if the players tied

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
  }
  public void switchPlayer() {
    //switches between players

    if (currentPlayer == 'X') {
        currentPlayer = 'O';
    }
    else {
        currentPlayer = 'X';
    }
  }
  public char getCurrentPlayer() {
    return currentPlayer;
  }
}