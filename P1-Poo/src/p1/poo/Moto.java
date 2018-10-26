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
public class Moto extends Veiculo{
 //como a moto herda do veiculo, passo os paremetros da moto pro veiculo   

    public Moto(int linha, int coluna, int move) {
        super(linha, coluna, "Azul", 3, 3, move);
    }
    
}
