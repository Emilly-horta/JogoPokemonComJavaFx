/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.scene.image.Image;

/**
 *
 * @author Wendell
 */
public enum Pokemons {
    ARCANINE(new Image("imagens/Pokemons/Arcanine.png"),new Image("imagens/Pokemons/ArcanineFront.png"),LabelPokemon.getARCANINE(), true, 60, 10, 40, 50, 120, 295, 20),
    CHARMANDER(new Image("imagens/Pokemons/Charmander.png"),new Image("imagens/Pokemons/CharmanderFront.png"),LabelPokemon.getCHARMANDER(), true, 60, 10, 105, 50, 120, 295, 10),
    KADABRA(new Image("imagens/Pokemons/Kadabra.png"),new Image("imagens/Pokemons/KadabraFront.png"), LabelPokemon.getKADABRA(),true, 65, 250, 30, 50, 120, 295, 20),
    NINETALES(new Image("imagens/Pokemons/Ninetales.png"),new Image("imagens/Pokemons/NinetalesFront.png"), LabelPokemon.getNINETALES(), true, 60, 410, 40, 50, 120, 295, 20),
    PIKACHU(new Image("imagens/Pokemons/Pikachu.png"),new Image("imagens/Pokemons/PikachuFront.png"), LabelPokemon.getPIKACHU(), true, 50, 177, 45, 50, 120, 295, 20),
    PRIMEAPE(new Image("imagens/Pokemons/Primeape.png"),new Image("imagens/Pokemons/PrimeapeFront.png"),LabelPokemon.getPRIMEAPE(), true, 60, 85, 40, 50, 120, 280, 20),
    RAPIDASH(new Image("imagens/Pokemons/Rapidash.png"),new Image("imagens/Pokemons/RapidashFront.png"), LabelPokemon.getRAPIDASH(), true, 60, 330, 35, 50, 120, 295, 10);
    
    private Image urlImagemBack;
    private Image urlImagemFront;
    private LabelPokemon labelPokemon;
    private boolean presevar;
    private double dimensao;
    private double posicaoX;
    private double posicaoY;
    private double posicaoXPokemon1;
    private double posicaoYPokemon1;
    private double posicaoXPokemon2;
    private double posicaoYPokemon2;
    
    Pokemons(Image urlImagemBack, Image urlImagemFront, LabelPokemon labelPokemon, boolean presevar, double dimensao, double posicaoX, double posicaoY, double posicaoXPokemon1, double posicaoYPokemon1 ,double posicaoXPokemon2, double posicaoYPokemon2){
        this.urlImagemFront = urlImagemFront;
        this.urlImagemBack = urlImagemBack;
        this.labelPokemon = labelPokemon;
        this.presevar = presevar;
        this.dimensao = dimensao;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.posicaoXPokemon1 = posicaoXPokemon1;
        this.posicaoYPokemon1 = posicaoYPokemon1;
        this.posicaoXPokemon2 = posicaoXPokemon2;
        this.posicaoYPokemon2 = posicaoYPokemon2;
        
        //
    }
    /**
     * @return ARCANINE
    */
    public static Pokemons getARCANINE() {
        return ARCANINE;
    }
    /**
     * @return CHARMANDER
    */
    public static Pokemons getCHARMANDER() {
        return CHARMANDER;
    }
    /**
     * @return KADABRA
    */
    public static Pokemons getKADABRA() {
        return KADABRA;
    }
    /**
     * @return NINETALES
    */
    public static Pokemons getNINETALES() {
        return NINETALES;
    }
    /**
     * 
     * @return PIKACHU
    */
    public static Pokemons getPIKACHU() {
        return PIKACHU;
    }
    /**
     * @return PRIMEAPE
    */
    public static Pokemons getPRIMEAPE() {
        return PRIMEAPE;
    }
    /**
     * @return RAPIDASH
    */
    public static Pokemons getRAPIDASH() {
        return RAPIDASH;
    }
    /**
     * @return urlImagemBack
    */
    public Image getUrlImagemBack() {
        return urlImagemBack;
    }
    /**
     * @return urlImagemFront
    */
    public Image getUrlImagemFront() {
        return urlImagemFront;
    }
    /**
     * @return labelPokemon
    */
    public LabelPokemon getLabelPokemon() {
        return labelPokemon;
    }
    /**
     * @return presevar
    */
    public boolean isPresevar() {
        return presevar;
    }
    /**
     * @return dimensao
    */
    public double getDimensao() {
        return dimensao;
    }
    /**
     * @return posicaoX
    */
    public double getPosicaoX() {
        return posicaoX;
    }
    /**
     * @return posicaoY
    */
    public double getPosicaoY() {
        return posicaoY;
    }
    /**
     * @return posicaoXPokemon1
    */
    public double getPosicaoXPokemon1() {
        return posicaoXPokemon1;
    }
    /**
     * @return posicaoYPokemon1
    */
    public double getPosicaoYPokemon1() {
        return posicaoYPokemon1;
    }
    /**
     * @return posicaoXPokemon2
    */
    public double getPosicaoXPokemon2() {
        return posicaoXPokemon2;
    }
    /**
     * @return posicaoYPokemon2
    */
    public double getPosicaoYPokemon2() {
        return posicaoYPokemon2;
    }
    
    
}
