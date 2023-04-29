/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos gabriel de so
 */
package com.mycompany.batalhanaval;

public class Arena extends Execao{
    private final  char[][] arena;
    private int quantSub = 3;
    private int quantCruz = 2;
    private int quantPa = 1;
    private final String[] linhas;
    private final Exception e = new Exception();

public Arena(){
    this.arena = new char[8][8];
    this.linhas = new String[8];
    for (char[] arena1 : arena) {
        for (int j = 0; j < arena1.length; j++) {
            arena1[j] = ' ';
        }
    }
}

public char[][] getArena(){
    return arena;
}

public char getPosicao(int linha,int coluna){
    return arena[linha][coluna];
}

public boolean cheio(){
    return (this.quantCruz+this.quantPa+this.quantSub) ==0;
}

public void setPosicao(int linha,int coluna,char valor){
    this.arena[linha][coluna] = valor;
}

public void adicionarArma(String tipo,int linha,int coluna){
    
    switch (tipo){
        case "Submarino" -> {
            if(verificarQuantNavio(quantSub)){
                System.out.println("Todos os submarinos já foram adicionados");
                break;
            }
            
            if(verificarPosicao(0, linha, coluna,this.arena)){
                arena[linha][coluna] = 's';
                this.quantSub--;
            }
            else{
                System.out.println("Você não pode adicionar mais submarinos!");
            }
            break;
        }
        case "Cruzador" ->{
            if(verificarQuantNavio(quantCruz)){
                System.out.println("Todos os cruzadores já foram adicionados");
                break;
            }
            
            if(verificarPosicao(1, linha, coluna,this.arena) && this.quantCruz>0 ){
                arena[linha][coluna] = 'c';
                arena[linha][coluna+1] = 'c';
                this.quantCruz--;
            }
            else{
                System.out.println("Você não pode adicionar mais cruzadores!");
            }
            break;
        }
        case "Porta-aviao" ->{
            if(verificarQuantNavio(quantPa)){
                System.out.println("Todos os Porta-avioes já foram adicionados");
                break;
            }
            if(verificarPosicao(4, linha, coluna,this.arena) && this.quantPa>0 ){
                for(int i=coluna;i<=coluna+4;i++){
                    arena[linha][i] = 'p';
                    this.quantPa--;
                }
            }
            else{
                System.out.println("Você não pode adicionar mais porta-avioes!");
            }
        }
    }
}

public void printArena(){
    System.out.println("------------------------------------------");
    System.out.println("               Batalha Naval              ");
    System.out.println("------------------------------------------\n");
    System.out.println("    1   2   3   4   5   6   7   8  ");
    for (int i=0;i<arena.length;i++){
        System.out.print(" "+ getLinha(i) +" ");
        for(int j=0;j<arena[i].length;j++){
            if(arena[i][j]!=' ' ){
                System.out.print("|"+ arena[i][j] + "| ");
            }
            else{
                System.out.print("| | ");
            }
	}
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Arena{" + '}';
    }

    int getTamanho() {
        throw new UnsupportedOperationException("Não suportado ainda.");
    }
}
