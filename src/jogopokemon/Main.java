/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 *
 * @author Wendell
 *  Classe responsavel por juntar todas todas as cenas.
 */
public class Main extends Application {

    public static void Lauch(String[] args) {
        launch(args);
    }
    
    private AudioClip audioClick = new AudioClip(getClass().getResource("/audio/ClickPokemon.mp3").toString());
    
    /**
    *   Construtor das Cenas MenuJogo, TelaDeSelect e LutaPokemon.
    */
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Menu
        Pane rootMenu = new Pane();
        MenuJogo menuJogo = new MenuJogo(rootMenu, 482, 318, Color.BLACK);
        menuJogo.audioPlay();
        primaryStage.setScene(menuJogo);
        //2ª tela
        Pane rootSelect = new Pane();
        TelaDeSelect telaDeSelect = new TelaDeSelect(rootSelect, 482, 318, Color.CORNFLOWERBLUE);
        //3ª tela
        Pane rootLuta = new Pane();
        Fase fase = new Fase(rootLuta, 482, 318, Color.BLACK);
        
        /**
        *   Metodo para capturar o evento do tecla ENTER do teclado da cena MenuJogo.
        */
        menuJogo.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    audioClick.play(100);
                    menuJogo.audioStop();
                    telaDeSelect.audioPlay();
                    primaryStage.setScene(telaDeSelect);
                }
            }
        });
        /**
        *   Metodo para capturar o evento do tecla ENTER, LEFT, RIGTH, DOWN, UP e ESCAPE do teclado da cena TelaDeSelect.
        */
        telaDeSelect.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    telaDeSelect.moverRight();
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    telaDeSelect.moverLeft();
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    telaDeSelect.moverDown();
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    telaDeSelect.moverUP();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                    audioClick.play(100);
                    telaDeSelect.audioStop();
                    fase.getLutaPokemon().audioPlay();
                    fase.setPokemons(telaDeSelect.getSelectPokemon());
                    primaryStage.setScene(fase.getLutaPokemon());
                }
                if (event.getCode().equals(KeyCode.ESCAPE)) {
                    audioClick.play(100);
                    telaDeSelect.audioStop();
                    menuJogo.audioPlay();
                    telaDeSelect.setPosiX(10);
                    telaDeSelect.setPosiY(30);
                    primaryStage.setScene(menuJogo);
                }
            }
        });
        /**
        *   Metodo para capturar o evento do tecla ENTER, LEFT, RIGTH, DOWN, UP, SPACE, DIGIT1 e DIGIT2 do teclado da cena LutaPokemon que está dentro da classe Fase.
        */
        fase.getLutaPokemon().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.RIGHT)) {
                    fase.getLutaPokemon().moverRight();
                }
                if (event.getCode().equals(KeyCode.LEFT)) {
                    fase.getLutaPokemon().moverLeft();
                }
                if (event.getCode().equals(KeyCode.UP)) {
                    fase.getLutaPokemon().moverUp();
                }
                if (event.getCode().equals(KeyCode.DOWN)) {
                    fase.getLutaPokemon().moverDown();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                        audioClick.play(100);
                    if (fase.getLutaPokemon().getPosicaoX() == 276 && fase.getLutaPokemon().getPosicaoY() == 250) {
                        fase.getLutaPokemon().setStatus(true);
                        fase.getLutaPokemon().barraDeAtaques(0);
                    }
                    if (fase.getLutaPokemon().getPosicaoX() == 376 && fase.getLutaPokemon().getPosicaoY() == 280) {
                        fase.getLutaPokemon().audioStop();
                        fase.getLutaPokemon().sleep(primaryStage, menuJogo);
                        Timeline time = new Timeline(new KeyFrame(Duration.seconds(3), lamb -> menuJogo.audioPlay()));
                        time.play();
                    }
                    if (fase.getLutaPokemon().getPosicaoX() == 276 && fase.getLutaPokemon().getPosicaoY() == 280) {
                        fase.getLutaPokemon().audioStop();
                        telaDeSelect.audioPlay();
                        telaDeSelect.setPosiX(10);
                        telaDeSelect.setPosiY(30);
                        primaryStage.setScene(telaDeSelect);
                    }
                }
                if (event.getCode().equals(KeyCode.DIGIT1)) { // Pega o evento  da tecla 1
                    if (fase.getLutaPokemon().getStatus() == true) {
                        fase.getLutaPokemon().barraDeAtaques(1);
                        fase.getLutaPokemon().atkArranha(0);
                        fase.getLutaPokemon().setStatus(false);
                        fase.getLutaPokemon().decidirATKInimigo();
                    }
                }
                if (event.getCode().equals(KeyCode.DIGIT2)){ //Pega o evento  da tecla 2
                    if (fase.getLutaPokemon().getStatus()){
                        fase.getLutaPokemon().barraDeAtaques(1);
                        fase.getLutaPokemon().atkMordida(0);
                        fase.getLutaPokemon().setStatus(false);
                        fase.getLutaPokemon().decidirATKInimigo();
                    }
                }
                if(event.getCode().equals(KeyCode.SPACE)){
                    if(fase.getLutaPokemon().getPermitirTeclaSpace()){
                    if(fase.getLutaPokemon().statusDeVitoriaDoPokemon() == 0){
                       System.out.println("Passei por ganhei");
                       primaryStage.setScene(null);//
                       primaryStage.setScene(fase.fase2());
                       if(fase.getLutaPokemon().getFinalizarFase2() == 2){
                       fase.finalizarFase2(primaryStage, menuJogo );
                       }
                    }else if(fase.getLutaPokemon().statusDeVitoriaDoPokemon() == 1){
                        System.out.println("Passei por Perdi");
                    }
                    fase.getLutaPokemon().setPermitirTeclaSpace(false);
                    }
                }
                
            }
        });
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Pokémon");
        primaryStage.getIcons().add(new Image("imagens/Pokemons/Icones/pokemonIcons.png"));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(1);
            }
        });
    }

}
