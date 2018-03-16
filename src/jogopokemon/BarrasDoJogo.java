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
public class BarrasDoJogo extends ImageView{
    /**
     * Construtor da classe BarrasDoJogo.
     * @param img Imagem da barra da cena LutaPokemon.
     * @param x Posição da imagem em x.
     * @param y Posição da imagem em y.
     * @param scaleX Largura da imagem.
     * @param scaleY Altura da imagem.
    */
    public BarrasDoJogo(Image img, double x, double y, double scaleX, double scaleY) {
        this.setImage(img);
        this.setX(x);
        this.setY(y);
        this.setScaleX(scaleX);
        this.setScaleY(scaleY);
    
    }

    
    
    
}
