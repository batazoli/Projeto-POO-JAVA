/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.poo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Vagner Batazoli
 * @version 1.0
 * @since 2018-10-10
 */
public class Mundo {

    public Mundo() throws InterruptedException, IOException {
        boolean loop = true;
        Random random = new Random();
        ArrayList<Caminhao> caminhoes = new ArrayList();
        ArrayList<Carro> carros = new ArrayList();
        ArrayList<Moto> motos = new ArrayList();
        ArrayList<Bike> Bikes = new ArrayList();
        int contVelBike = 0;

        //Adiciona primeiros veiculos em suas ArrayLists e "seto" valores aleatorios para iniciar no mapa
        for (int i = 0; i < 10; i++) {
            caminhoes.add(new Caminhao((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
            carros.add(new Carro((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
            motos.add(new Moto((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
            Bikes.add(new Bike((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
        }

        //Loop para manter td funcionando
        while (loop == true) {
               //as cores que usarei para os objetos
            final String ANSI_RESET =          "\u001B[0m";
            //fundo colorido
            final String ANSI_RED_BACKGROUND = "\u001B[41m";
            final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
            final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
            final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
            final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
            final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
            final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
            //letra colorida
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_GREEN = "\u001B[32m";
            final String ANSI_YELLOW = "\u001B[33m";
            final String ANSI_BLUE = "\u001B[34m";
/* uso uma técnica mto comum para "jogos" que eh mapear tudo em um vetor onde 
1 = parede
0 = espaço vazio
22 = fábricas
*/
            int[][] mapa2 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 22, 22, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},};


            for (int i = 0;i < caminhoes.size();i++) {
                mapa2[caminhoes.get(i).getLinha()][caminhoes.get(i).getColuna()] += caminhoes.get(i).getTAMANHO();
            }
            for (int i = 0;i < carros.size();i++) {
                mapa2[carros.get(i).getLinha()][carros.get(i).getColuna()] += carros.get(i).getTAMANHO();
            }
            for (int i = 0;i < motos.size();i++) {
                mapa2[motos.get(i).getLinha()][motos.get(i).getColuna()] += motos.get(i).getTAMANHO();
            }
            for (int i = 0;i < Bikes.size();i++) {
                mapa2[Bikes.get(i).getLinha()][Bikes.get(i).getColuna()] += Bikes.get(i).getTAMANHO();
            }

            //Verificações de todas as colisões possíveis, desde as do veiculo com veículo como de veículo com Fábrica
            for (int i = 0;
                    i < 30; i++) {
                for (int j = 0; j < 60; j++) {
                    //Todas as possíveis colisões com o caminhão separadas por Grau Hierarquico: Fábrica, Bike, Moto, Carro e o Pŕopio caminhão
                    //Colisão de caminhao com fabrica
                    if (mapa2[i][j] == 34) {
                        mapa2[i][j] = 12;
                        caminhoes.add(new Caminhao((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
                    }
                    //Colisão caminhão com bike
                    if (mapa2[i][j] == 14) {
                        mapa2[i][j] = caminhoes.get(0).getTAMANHO();
                        for (int k = 0; k < Bikes.size(); k++) {
                            if (Bikes.get(k).getLinha() == i && Bikes.get(k).getColuna() == j) {
                                Bikes.remove(k);
                            }
                        }
                    }
                    //Colisão caminhao com moto
                    if (mapa2[i][j] == 15) {
                        mapa2[i][j] = caminhoes.get(0).getTAMANHO();
                        for (int k = 0; k < motos.size(); k++) {
                            if (motos.get(k).getLinha() == i && motos.get(k).getColuna() == j) {
                                motos.remove(k);
                            }
                        }
                    }
                    //Colisão caminhão com carro 
                    if (mapa2[i][j] == 20) {
                        mapa2[i][j] = caminhoes.get(0).getTAMANHO();
                        for (int k = 0; k < carros.size(); k++) {
                            if (carros.get(k).getLinha() == i && carros.get(k).getColuna() == j) {
                                carros.remove(k);
                            }
                        }
                    }
                    //Colisao caminhao com caminhão
                    if (mapa2[i][j] == 24) {
                        mapa2[i][j] = 0;
                        for (int k = 0; k < caminhoes.size(); k++) {
                            if (caminhoes.get(k).getLinha() == i && caminhoes.get(k).getColuna() == j) {
                                caminhoes.remove(k);
                            }
                        }
                    }
                    //Todas as possíveis colisões com o carro separadas por Grau Hierarquico: Fábrica, Bike, Moto e o própio Carro(menos colisão com caminhão(não ter porque ter duas verificações iguais))
                    //Colisão carro com fabrica
                    if (mapa2[i][j] == 30) {
                        mapa2[i][j] = 8;
                        carros.add(new Carro((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
                    }
                    //Colisão de carro com bike
                    if (mapa2[i][j] == 10) {
                        mapa2[i][j] = carros.get(0).getTAMANHO();
                        for (int k = 0; k < Bikes.size(); k++) {
                            if (Bikes.get(k).getLinha() == i && Bikes.get(k).getColuna() == j) {
                                Bikes.remove(k);
                            }
                        }
                    }                    
                    //Colisão carro com moto
                    if (mapa2[i][j] == 11) {
                        mapa2[i][j] = carros.get(0).getTAMANHO();
                        for (int k = 0; k < motos.size(); k++) {
                            if (motos.get(k).getLinha() == i && motos.get(k).getColuna() == j) {
                                motos.remove(k);
                            }
                        }
                    }
                    //Colisao de carro com carro
                    if (mapa2[i][j] == 16) {
                        mapa2[i][j] = 0;
                        for (int k = 0; k < carros.size(); k++) {
                            if (carros.get(k).getLinha() == i && carros.get(k).getColuna() == j) {
                                carros.remove(k);
                            }
                        }
                    }                    
                    //Todas as possíveis colisões com a moto separadas por Grau Hierarquico: Fábrica, Bike a própia Moto (menos colisão com caminhão e carro(não ter porque ter duas verificações iguais))
                    //Colisão moto com fabrica
                    if (mapa2[i][j] == 25) {
                        mapa2[i][j] = 3;
                        motos.add(new Moto((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
                    }                    
                    //Colisão moto com Bike
                    if (mapa2[i][j] == 5) {
                        mapa2[i][j] = motos.get(0).getTAMANHO();
                        for (int k = 0; k < Bikes.size(); k++) {
                            if (Bikes.get(k).getLinha() == i && Bikes.get(k).getColuna() == j) {
                                Bikes.remove(k);
                            }
                        }
                    }
                    //Colisao de moto com moto
                    if (mapa2[i][j] == 6) {
                        mapa2[i][j] = 0;
                        for (int k = 0; k < motos.size(); k++) {
                            if (motos.get(k).getLinha() == i && motos.get(k).getColuna() == j) {
                                motos.remove(k);
                            }
                        }
                    }
                    //Todas as possíveis colisões com a bike separadas por Grau Hierarquico: Fábrica e depois Bike (menos colisão com caminhão, carro e moto(não ter porque ter duas verificações iguais))                    
                    //Colisão de bike com fabrica
                    if (mapa2[i][j] == 24) {
                        mapa2[i][j] = 2;
                        Bikes.add(new Bike((random.nextInt(28) + 1), (random.nextInt(58) + 1), (random.nextInt(4) + 1)));
                    }                    
                    //Colisão de bike com bike
                    if (mapa2[i][j] == 4) {
                        mapa2[i][j] = 0;
                        for (int k = 0; k < Bikes.size(); k++) {
                            if (Bikes.get(k).getLinha() == i && Bikes.get(k).getColuna() == j) {
                                Bikes.remove(k);
                            }
                        }
                    }
                }
            }
            //Mostra Mapa
            for (int i = 0;i < 30; i++) {
                for (int j = 0; j < 60; j++) {
                }
            }
            //for para "printar" o mapa e os objetos
            for (int i = 0;i < 30; i++) {
                System.out.println("");
                for (int j = 0; j < 60; j++) {
                    if(mapa2[i][j] == 0){
                        System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 1) {
                        System.out.print(ANSI_PURPLE_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 2) {
                        System.out.print(ANSI_GREEN_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 3) {
                        System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 8) {
                        System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 12) {
                        System.out.print(ANSI_RED_BACKGROUND + " " + ANSI_RESET);
                    } else if (mapa2[i][j] == 22) {
                        System.out.print(ANSI_WHITE_BACKGROUND + " " + ANSI_RESET);
                    } 
                }
            }

            //Mostra os contadores por hierarquia: mais "fraco" para o mais "forte"
            //Para um melhor entendimento colori as letras diretamente relacionado ao mapa para melhor vizualização 
            System.out.println("");
            System.out.println(ANSI_GREEN + "Bikes: " + ANSI_RESET + Bikes.size());
            System.out.println(ANSI_BLUE + "Motos: " + ANSI_RESET + motos.size());
            System.out.println(ANSI_YELLOW + "Carros: " + ANSI_RESET + carros.size());
            System.out.println(ANSI_RED + "Caminhoes: " +  ANSI_RESET + caminhoes.size());

            for (int i = 0;i < caminhoes.size();i++) {
                caminhoes.get(i).move();
            }
            for (int i = 0;i < carros.size();i++) {
                carros.get(i).move();
                carros.get(i).move();
            }
            for (int i = 0;i < motos.size();i++) {
                motos.get(i).move();
                motos.get(i).move();
                motos.get(i).move();
            }
            for (int i = 0;i < Bikes.size();i++) {
                if (contVelBike % 2 == 0) {
                    Bikes.get(i).move();
                }
            }
            contVelBike++;
            clearConsole();
            Thread.sleep(1000);
        }
    }

    private static void clearConsole() {
        //uso do try/catch para o programa não parar
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception exception) {
        }
    }

}