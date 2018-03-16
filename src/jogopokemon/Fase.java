/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author familha
 */
public class Fase {

    /**
     *
     * @param root Nó raiz
     * @param width Largura da cena.
     * @param height Altura da cena.
     */
    
    private LutaPokemon lutaPokemon;
    
    private Pokemons pokemonEscolhido;
    
    
    
    private Pane root;
    private double width;
    private double height;
    private Color cor;
    
    /**
     * Construtor da classe Fase.
     * @param root
     * @param width
     * @param height
     * @param cor
    */
    public Fase(Pane root, double width, double height, Color cor){
        this.root = root;
        this.width = width;
        this.height = height;
        this.cor = cor;
        this.lutaPokemon = new LutaPokemon(root,width,height,cor);
    }
    /**
     * esse método é responsavel por setar a fase dois.
     * @return lutaPokemon;
    */
    public LutaPokemon fase2(){
        System.out.println("Play Fase2");
        lutaPokemon.removerTelaPerdeuVenceu();
        setPokemons(pokemonEscolhido);
        return lutaPokemon; 
    }
    /**
     * @return lutaPokemon;
    */
    public LutaPokemon getLutaPokemon() {
        return lutaPokemon;
    }
    /**
     * Metodo responsavel por settar os pokemons na fase2.
    */
    public void setPokemons(Pokemons pokemon){
        pokemonEscolhido = pokemon;
        lutaPokemon.setPokemon1(pokemon);
        lutaPokemon.setPokemon2(new Random().nextInt(7));
    }
    /**
     * 
     * @param tela
     * @param cena
    */
    public void finalizarFase2(Stage tela, Scene cena){
      tela.setScene(cena);
    }
    
}
