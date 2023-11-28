package ifpr.paranavai.jogo.modelo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import ifpr.paranavai.jogo.visao.Principal;

public class Personagem extends ElementoGrafico {
    private static final int DESLOCAMENTO = 3;
    private static final int POSICAO_INICIAL_EM_X = 100;
    private static final int POSICAO_INICIAL_EM_Y = 100;

    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private int pontuacao;
    private int vidas;

    private ArrayList<Tiro> tiros;

    public Personagem() {
        this.carregar();
        super.setPosicaoEmX(POSICAO_INICIAL_EM_X);
        super.setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        this.tiros = new ArrayList<Tiro>();
        this.vidas = 3;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/espaconave.png"));
        super.setImagem(carregando.getImage());
    }

    public void atualizar() {
        super.setPosicaoEmX(super.getPosicaoEmX() + this.deslocamentoEmX);
        super.setPosicaoEmY(super.getPosicaoEmY() + this.deslocamentoEmY);
    }

    public void atirar() {
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getAlturaImagem() / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        int novaPosicaoX = super.getPosicaoEmX() + this.deslocamentoEmX;
        int novaPosicaoY = super.getPosicaoEmY() + this.deslocamentoEmY;
    
        switch (codigo) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (novaPosicaoY - DESLOCAMENTO >= 0) {
                    this.deslocamentoEmY = -DESLOCAMENTO;
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (novaPosicaoY + super.getAlturaImagem() + DESLOCAMENTO <= Principal.ALTURA_DA_JANELA) {
                    this.deslocamentoEmY = DESLOCAMENTO;
                }
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (novaPosicaoX - DESLOCAMENTO >= 0) {
                    this.deslocamentoEmX = -DESLOCAMENTO;
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (novaPosicaoX + super.getLarguraImagem() + DESLOCAMENTO <= Principal.LARGURA_DA_JANELA) {
                    this.deslocamentoEmX = DESLOCAMENTO;
                }
                break;
            default:
                break;
        }
    }
    
    
    
    
    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_A:
            case KeyEvent.VK_D:
                deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public void colisao() {
        this.vidas--;
        if (this.vidas <= 0) {
            super.setEhVisivel(false);
        } else {
            super.setPosicaoEmX(POSICAO_INICIAL_EM_X);
            super.setPosicaoEmY(POSICAO_INICIAL_EM_Y);
        }
    }

    public void perderVida() {
        this.vidas--;
    }
    

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVidas() {
        return this.vidas;
    }
}
