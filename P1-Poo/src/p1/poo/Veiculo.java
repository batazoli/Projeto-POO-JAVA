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
public class Veiculo {

    protected double VELOCIDADE;
    protected int linha, coluna, TAMANHO, DIRECAO;
    protected String COR;
/**
*Crio o veiculo onde tem os principais atributos que a bike, caminhão, carro, 
*moto podem usar e até mesmo um pedestre se renomeasse a classe para ficar mais entendivel.
*@param linha recebo a exata linha onde o veiculo, seja qual for está
* @param coluna recebo a exata linha onde a coluna, seja qual for
* @param cor recebo a cor do veiculo
* @param tamanho o quanto ele ocupa do meu mapa
* @param velocidade recebo a velocidade do veiculo conseguindo assim até distinguir e aplicar regras se preciso por fluxo de código
* @param DIRECAO vejo em qual direção ele esta para mover ele para usando o move
*/
 
    public Veiculo(int linha, int coluna, String cor, int tamanho, double velocidade, int DIRECAO) {
        this.linha = linha;
        this.coluna = coluna;
        this.COR = cor;
        this.TAMANHO = tamanho;
        this.VELOCIDADE = velocidade;
        this.DIRECAO = DIRECAO;
    }

    void move() {
        if (DIRECAO == 1) {
            moveCima();
        } else if (DIRECAO == 2) {
            moveBaixo();
        } else if (DIRECAO == 3) {
            moveEsquerda();
        } else if (DIRECAO == 4) {
            moveDireita();
        }
    }

    void moveCima() {
        if (linha == 1){
            linha += 27;
        } else {
            linha -= 1;
        }
    }

    void moveBaixo() {
        if (linha == 28){
            linha -= 27;
        } else {
            linha +=1;
        }
    }

    void moveEsquerda() {
        if (coluna == 1){
            coluna += 57; 
        } else {
            coluna -= 1;
        }
    }

    void moveDireita() {
        if (coluna == 58){
            coluna -= 57;
        } else {
            coluna += 1;
        }
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setCouluna(int coluna) {
        this.coluna = coluna;
    }

    public double getVELOCIDADE() {
        return VELOCIDADE;
    }

    public int getTAMANHO() {
        return TAMANHO;
    }

    public String getCOR() {
        return COR;
    }
}
