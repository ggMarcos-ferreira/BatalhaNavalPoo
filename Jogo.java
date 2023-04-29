/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos gabriel de so
 */
package com.mycompany.batalhanaval;

import java.io.IOException;
import java.util.Scanner;

public class Jogo extends Execao{
    private final Scanner s = new Scanner(System.in);
    private final Exception e = new Exception();

    public Arena criarArena(){
        Arena arena = new Arena();
        int i = 0;

        while (i <= 6) {
            String tipo = null, linha = null;
            int coluna = -1;

            arena.printArena();

            if (arena.cheio()) {
                System.out.println("Todos os navios já foram adicionados!");
                break;
            }

            while (true) {
                System.out.println("Insira o tipo de Navio que deseja adicionar(Submarino, Cruzador ou Porta-aviao):");
                tipo = s.next();

                if (this.verificarNavios(tipo)) {
                    break;
                }
                System.out.println("Opção inválida!");
                System.out.println("Você tem as seguintes opções: Submarino, Cruzador ou Porta-Aviões");
            }

            while (true) {

                System.out.println("Insira a posição da linha onde deseja adicionar o Navio:");
                System.out.println("Uma letra de A a H:");
                linha = s.next();

                if (this.verificarLinha(linha)) {
                    break;
                }
                System.out.println("Intervalo nulo!");
            }

            while (true) {

                System.out.println("Insira a posição da coluna onde deseja adicionar o Navio:");
                System.out.println("Um número de 1 a 8:");
                coluna = s.nextInt();

                if (this.verificarColuna(coluna)) {
                    break;
                }
                System.out.println("Intervalo nulo!");
            }

            int linhac;
            linhac = converter(linha);

            arena.adicionarArma(tipo, linhac - 1, coluna - 1);
            if (!arena.cheio()) {
                i++;
            }
        }
        arena.printArena();
        return arena;
    }

    public Player criarJogador() {
        String nome;
        while (true) {
            System.out.println("Insira seu nome:");
            nome = s.next();

            if (this.verificarNome(nome)) {
                break;
            } else {
                System.out.println("Digite seu nome (Obs: apenas com letras):");
            }
        }
        Arena arena = this.criarArena();
        Player player = new Player(nome, arena);
        return player;
    }

    public void Joga(Player player1, Player player2) throws IOException{
    int partida = 1;
    while (true){
        
        System.out.println("Partida " + partida);
        
        
        System.out.println("A vez é do(a):" + player1.getName());
        String line ;
        int column;
        player1.getArenainimiga().printArena();
        for(int i=0;i<2;i++){
            while (true){
            
            System.out.println("Insira a posição da linha que deseja adicionar: ");
            System.out.println("Uma letra de A a H: ");
            line = s.next();
            
            if(this.verificarLinha(line)){
                break;  
            }
            System.out.println("Intervalo nulo!");
        }
        
        while (true){
            
            System.out.println("Insira a posição da coluna que deseja adicionar: ");
            System.out.println("Um número de 1 a 8: ");
            column =s.nextInt();
            
            if(this.verificarColuna(column)){
                break;  
            }
            System.out.println("Intervalo nulo!");
        }
            
            int convertedLine = converter(line);
            player1.registrarTiro(convertedLine-1, column-1, player2.getMinhaarena());
            player1.getArenainimiga().printArena();
            
        }
        
        if (player1.win() ){
            
            System.out.println("O vencedor é : " + player1.getName());
            break;
            
        }
        // Player 2's turn
        
        System.out.println("A vez é do(a)" + player2.getName());
        
        player2.getArenainimiga().printArena();
        for(int i=0;i<2;i++){
            
            while (true){
            
            System.out.println("Insira a posição da linha que deseja adicionar: ");
            System.out.println("Uma letra de A a H: ");
            line = s.next();
            
            if(verificarLinha(line)){
                break;  
            }
            System.out.println("Intervalo nulo!");
        }
        
        while (true){
            
            System.out.println("Insira a posição da coluna que deseja adicionar: ");
            System.out.println("Um número de 1 a 8: ");
            column =s.nextInt();
            
            if(verificarColuna(column)){
                break;  
            }
            System.out.println("Intervalo nulo!");
        }

            int convertedLine = converter(line);
            player2.registrarTiro(convertedLine-1, column-1, player1.getMinhaarena());
            player2.getArenainimiga().printArena();
        }
        
        if (player2.win() ){
            
            System.out.println("O vencedor é: " + player2.getName());
            break;     
            
        }
        partida++;
    }
    
}

public void printMenu(){
    System.out.println("--------------------------MENU--------------------------");
    System.out.println("|  Tecle 1 para criar um player:                          |");
    System.out.println("|  Tecle 2 para jogar:                                    |");
    System.out.println("|  Tecle 3 para sair:                                     |");
    System.out.println("--------------------------------------------------------");
}
}
