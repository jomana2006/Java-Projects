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

public class Player {
    private String name;
    private char symbol; //'X' or 'O'

    public Player(String name, char symbol) {
        //constructor
        
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
}