/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcos gabriel de so
 */
package com.mycompany.batalhanaval;

public class Player extends Execao{
	private String nome;
	private Arena minhaarena;
	private Arena arenainimiga;
	private int cont = 0;
	private Exception e = new Exception();
	
	public Player(String nome, Arena minhaarena) {
    		this.nome = nome;
    		this.minhaarena = minhaarena;
    		this.arenainimiga = new Arena();
	}

	public String getName() {
    		return nome;
	}

	public void setNome(String nome) {
    		this.nome = nome;
	}

	public int getCont() {
    		return cont;
	}

	public void setCont(int cont) {
    		this.cont = cont;
	}

	public Arena getMinhaarena() {
    		return minhaarena;
	}

	public void setMinhaarena(Arena minhaarena) {
    		this.minhaarena = minhaarena;
	}

	public Arena getArenainimiga() {
    		return arenainimiga;
	}

	public void setArenainimiga(Arena arenainimiga) {
   		this.arenainimiga = arenainimiga;
	}

	public void registrarTiro(int linha, int coluna, Arena arenainimiga){
    	    if(verificarTiro(linha,coluna,arenainimiga.getArena())){
        	this.arenainimiga.setPosicao(linha, coluna, arenainimiga.getPosicao(linha, coluna));
        	System.out.println("Acertou um navio");
        	cont++;
        	this.setCont(cont);
    	}
            else{
        	this.arenainimiga.setPosicao(linha, coluna, 'o');
        	System.out.println("Tiro na agua");
    	}
}
        public boolean win() {
    for (int i = 0; i < minhaarena.getTamanho(); i++) {
        for (int j = 0; j < minhaarena.getTamanho(); j++) {
            if (minhaarena.getPosicao(i, j) == Posicao.Navio) {
                return false;
            }
        }
    }
    return true;
}

}
