public class Quadrado {
    // x é qual linha y qual coluna 
    // cor: 1-preto  2-branco  0- sem peça
    private int x,y,cor;
    private String nome;
    public Quadrado(int x, int y, int cor, String nome) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.nome = nome;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }
    public void tira_peca(){
        cor=0;
        nome="nada  ";
    }
    public void poe_peca(int c,String n){
        cor=c;
        nome=n;
    }
    public String printQuadrado(){
        return nome+" "+cor;
    }
    
}
