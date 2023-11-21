package ifpr.paranavai.jogo.modelo;

public class TiroSuper extends ElementoGrafico {

    private static final int VELOCIDADE = 3;

    public TiroSuper(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.carregar();
        super.setPosicaoEmX(posicaoPersonagemEmX);
        super.setPosicaoEmY(posicaoPersonagemEmY - (this.getAlturaImagem() / 2));
    }

    @Override
    public void carregar() {
        // Implemente o carregamento da imagem para o TiroSuper
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(super.getPosicaoEmX() + VELOCIDADE);
    }
}
