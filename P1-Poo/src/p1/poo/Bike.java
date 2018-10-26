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
public class Bike extends Veiculo{
 //como a bike herda do veiculo, passo os paremetros da bike pro veiculo   
    public Bike(int linha, int coluna, int move) {
        super(linha, coluna, "Verde", 2, 0.5, move);
    }
    
}
