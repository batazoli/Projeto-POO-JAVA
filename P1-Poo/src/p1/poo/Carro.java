/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.poo;

/**
 *
 * @author Vagner Batazoli
 * @version 1.0
 * @since 2018-10-10
 */
public class Carro extends Veiculo{
 //como o carro herda do veiculo, passo os paremetros do carro pro veiculo   
   
    public Carro(int linha, int coluna, int move) {
        super(linha, coluna, "Amarelo", 8, 2, move);
    }
    
}
