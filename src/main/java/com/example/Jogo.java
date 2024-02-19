package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo(){
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador){
        //early return
        if (jogador.parou()) return null;

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }
}
