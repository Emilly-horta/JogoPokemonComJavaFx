/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopokemon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Wendell
 */
public class Pokemon extends ImageView{
    /**
     * Construtor da classe Pokemon.
     * @param img Imagem do pokemon.
     * @param presevar Preserva o tamanho da imagem.
     * @param dimensao Dimensão da imagem.
     * @param posicaoX Posição da imagem do pokemon em X na Cena.
     * @param posicaoY  Posição da imagem do pokemon em Y na Cena.
    */
    public Pokemon(Image img, boolean presevar, double dimensao, double posicaoX, double posicaoY){
        this.setImage(img);
        this.setPreserveRatio(presevar);
        this.setFitWidth(dimensao);
        this.setX(posicaoX);
        this.setY(posicaoY);
    }
    
    
}
