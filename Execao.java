/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos gabriel de so
 */
package com.mycompany.batalhanaval;
import java.util.ArrayList;

public class Execao {
    private ArrayList<String> linhas = new ArrayList<>();
    public Execao() {
        linhas.add("A");
        linhas.add("B");
        linhas.add("C");
        linhas.add("D");
        linhas.add("E");
        linhas.add("F");
        linhas.add("G");
        linhas.add("H");
    }
    
    public boolean verificarNome(String nome){
        boolean isNumber = false;
        for(int i=0;i<nome.length();i++){
            if(!Character.isDigit(nome.charAt(i))){
                isNumber = true;
            }
        }
        return isNumber;
    }
    
    public boolean verificarNavios(String navio){
        return "Submarino".equals(navio) || "Cruzador".equals(navio) || "Porta-aviao".equals(navio);
    }
    
    public boolean verificarLinha(String linha){
        boolean isTrue = false;
        for(String linhai:linhas){
            if(linhai.equals(linha)){
                isTrue = true;
            }
        }
        
        return isTrue;
    }
    
    public boolean verificarColuna(int coluna){
        return coluna>=1 && coluna<=8;
    }
    
    public boolean verificarPosicao(int num, int linha,int coluna,char[][] arena){
        int cont = coluna+num;
        if(cont>=8){
            return false;
        }
        
        for(int i=Math.max(coluna-1,0);i<=Math.min(cont, 7);i++){
            if (arena[linha][i]!=' '){

                return false;
            }
        }
        for(int i=Math.max(0,coluna);i<=Math.min(coluna+num-1,7);i++){
  
            if((arena[Math.max(0,linha-1)][i]!=' ' || arena[Math.min(7,linha+1)][i]!=' ')){
                    
                return false;
            }
        }     
        return true;

    }
    public boolean verificarTiro(int linha,int coluna, char[][] arena){
        return arena[linha][coluna] != ' '  ;
    }
    
    public String getLinha(int pos){
        return linhas.get(pos);
    } 
    
    public int converter(String letra){
        return linhas.indexOf(letra)+1;
    }
    
    public boolean verificarQuantNavio(int quant){
        return quant==0;
    }
}
