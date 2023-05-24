public class Tabuleiro {
    private Quadrado[][] tabuleiro;
    // tabuleiro[i] qual linha
	// tabuleiro[i][j] qual quadrado de qual linha 
	// 0<=i<8 0<=j<8 mas 1<=linha<9 e 1<=coluna<9
    private String nada=  "nada  ";
    private String torre= "torre ";
    private String cavalo="cavalo";
    private String bispo= "bispo ";
    private String rei=   "rei   ";
    private String rainha="rainha";
    private String peao=  "peao  ";

    public Tabuleiro(){
        tabuleiro=new Quadrado[8][8];
        for (int i=0;i<8;i++){
            cria_linha(tabuleiro[i],i+1);
        }
        posicao_inicial();
    }
    private void cria_linha(Quadrado[] linha,int qual){
        for (int j=0;j<8;j++){
            linha[j]=new Quadrado(qual, j+1, 0, nada);
        }
    }
    public void poe_peca(int linha, int coluna,int cor,String nome){
        tabuleiro[linha-1][coluna-1].poe_peca(cor, nome);
    }
    private void reseta_tabuleiro(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                tabuleiro[i][j].tira_peca();
            }
        }
    }
    public void tira_peca(int linha,int coluna){
        poe_peca(linha, coluna, 0, nada);

    }
    public void posicao_inicial(){
        // reseta tabuleiro
        reseta_tabuleiro();
        // Por as peças Pretas
        poe_peca(1, 1, 1, torre);
        poe_peca(1, 2, 1, cavalo);
        poe_peca(1, 3, 1, bispo);
        poe_peca(1, 4, 1, rainha);
        poe_peca(1, 5, 1, rei);
        poe_peca(1, 6, 1, bispo);
        poe_peca(1, 7, 1, cavalo);
        poe_peca(1, 8, 1, torre);

        poe_peca(2, 1, 1, peao);
        poe_peca(2, 2, 1, peao);
        poe_peca(2, 3, 1, peao);
        poe_peca(2, 4, 1, peao);
        poe_peca(2, 5, 1, peao);
        poe_peca(2, 6, 1, peao);
        poe_peca(2, 7, 1, peao);
        poe_peca(2, 8, 1, peao);

        // Por as peças Brancas
        poe_peca(8, 1, 2, torre);
        poe_peca(8, 2, 2, cavalo);
        poe_peca(8, 3, 2, bispo);
        poe_peca(8, 4, 2, rainha);
        poe_peca(8, 5, 2, rei);
        poe_peca(8, 6, 2, bispo);
        poe_peca(8, 7, 2, cavalo);
        poe_peca(8, 8, 2, torre);

        poe_peca(7, 1, 2, peao);
        poe_peca(7, 2, 2, peao);
        poe_peca(7, 3, 2, peao);
        poe_peca(7, 4, 2, peao);
        poe_peca(7, 5, 2, peao);
        poe_peca(7, 6, 2, peao);
        poe_peca(7, 7, 2, peao);
        poe_peca(7, 8, 2, peao);

    }
    public String getNome(int x,int y){
        return tabuleiro[x][y].getNome();
    }
    public int getCor(int x,int y){
        return tabuleiro[x][y].getCor();
    }
    public void printTabuleiro(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(tabuleiro[i][j].printQuadrado());
            }
            System.out.println("");
        }
    }
}
