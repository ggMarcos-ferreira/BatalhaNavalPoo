package com.mycompany.batalhanaval;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos gabriel de so
 */

import java.io.IOException;
import java.util.Scanner;

public class BatalhaNaval {
public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    Jogo jogo = new Jogo();
    Player player1 = null, player2 = null;

    int op = 0;

    while(op < 3){
        jogo.printMenu();
        op = s.nextInt();

        switch(op){
            case 1 ->{
                if(player1 != null && player2 != null){
                    System.out.println("Os players já foram conectados");
                    break;
                }
                else if(player1 == null){
                    player1 = jogo.criarJogador();
                    System.out.println("Player 1 criado");
                }
                else{
                    player2 = jogo.criarJogador();
                    System.out.println("Player 2 criado");
                }
                break;
            }

            case 2 ->{
                if(player1 == null || player2 == null){
                    System.out.println("Você não criou nenhum player, não será possível jogar!");
                    break;
                }
                else if(player1.win() || player2.win()){
                    System.out.println("");
                    break;
                }
                jogo.Joga(player1, player2);
                System.out.println("FIM DE JOGO!");
                break;
            }         
        }
    }
}

}
