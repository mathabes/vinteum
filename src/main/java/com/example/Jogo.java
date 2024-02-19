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

    public boolean acabou(){

        var osDoisPararam = jogador.parou() && computador.parou();
        var jogadorEstourou = jogador.getPontos() > 21;
        var computadorEstourou = computador.getPontos() > 21;

        return osDoisPararam || jogadorEstourou || computadorEstourou;
    }

    public String resultado(){
        // TODO - refatorar variavel jogador estourou
        var pontosIguais = jogador.getPontos() == computador.getPontos();
        var computadorEstourou = computador.getPontos() > 21;
        var jogadorEstourou = jogador.getPontos() > 21;
        var osDoisEstouraram = computadorEstourou && jogadorEstourou;
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();

        if(pontosIguais || osDoisEstouraram) return "Empatou";
        if (jogadorEstourou && (computadorEstourou || jogadorTemMaisPontos)) return "Você Ganhou!";
        return "Você Perdeu!";
    }
}
