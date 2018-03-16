package jogopokemon;

import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;    
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *@author Wendell
 *  Classe que cria a cena menuJogo.
 */
public class MenuJogo extends Scene {
    
    private final AudioClip audioMenu = new AudioClip(getClass().getResource("/audio/audioMenuPokemon.mp3").toString());
    private Label start;
    private final Font font = Font.loadFont(MenuJogo.class.getResource("/font/ARCADECLASSIC.TTF").toString(), 20);
    private final Timer tempo = new Timer();
    private int status = 0;
    
    
    
    /**
     *   Construtor da cena MenuJogo
     * @param root Nó raiz
     * @param width Largura da cena.
     * @param height Altura da cena.
     * @param cor Cor de fundo da cena.
    */
    
    public MenuJogo(Pane root, double width, double height, Color cor) {
        super(root, width, height);

        start = new Label("Press  Start");
        start.setTextFill(Color.WHITESMOKE);
        start.setFont(font);
        start.setLayoutX(126);
        start.setLayoutY(240);

        Timeline ficaPreto = new Timeline(new KeyFrame(Duration.seconds(0.9), ev -> {start.setTextFill(null);}));
        ficaPreto.setCycleCount(Animation.INDEFINITE);
        ficaPreto.setAutoReverse(true);

        Timeline ficaBranco = new Timeline(new KeyFrame(Duration.seconds(0.9), ev -> {start.setTextFill(Color.WHITE);}));
        ficaBranco.setCycleCount(Animation.INDEFINITE);
        ficaBranco.setAutoReverse(true);

        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                switch (status) {
                    case 0:
                        ficaPreto.play();
                        status = 1;
                        break;
                    case 1:
                        ficaBranco.play();
                        status = 0;
                        break;
                }
            }
        }, 1000, 1000);
        
        ImageView imagemDeTelaDeFundo = new ImageView("imagens/Pokemons/TelaInicial/telaDeFundo.png");
        imagemDeTelaDeFundo.setScaleX(1.03);
        imagemDeTelaDeFundo.setScaleY(1.03);
        imagemDeTelaDeFundo.setLayoutX(5);
        imagemDeTelaDeFundo.setLayoutX(5);
        Rectangle fundo = new Rectangle(0, 0, 800, 800);
        fundo.setFill(cor);

        root.getChildren().addAll(fundo, imagemDeTelaDeFundo, start);
    }
    /**
    *    Metodo para iniciar o audio da cena MenuJogo.
    */
    public void audioPlay() {
        audioMenu.play(100);
    }
    /**
    *    Metodo para parar o audio da cena MenuJogo.
    */
    public void audioStop() {
        audioMenu.stop();
    }
}
