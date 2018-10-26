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
public class Caminhao extends Veiculo {
 //como o caminhao herda do veiculo, passo os paremetros do caminhao pro veiculo   
    
    public Caminhao(int linha, int coluna, int move){
        super(linha, coluna, "Vermelho", 12, 1, move);
    }
    
}
