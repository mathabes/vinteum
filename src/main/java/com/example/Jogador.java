package com.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private int pontos;
    private List<Carta> cartas = new ArrayList<>();
    private boolean parou;

    public void receberCarta(Carta carta){
        cartas.add(carta);
        pontos += carta.getNumero();
        if (pontos >= 11) pontos = 10;    
        this.pontos += pontos;
    }

    public void parar(){
        parou = true;
    }
    public int getPontos() {
        return pontos;
    }
    public List<Carta> getCartas() {
        return cartas;
    }
    public boolean parou() {
        return parou;
    }
}
