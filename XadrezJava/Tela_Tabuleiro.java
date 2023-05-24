import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tela_Tabuleiro extends JFrame implements ActionListener{
    
    private String nada=  "nada  ";
    private String torre= "torre ";
    private String cavalo="cavalo";
    private String bispo= "bispo ";
    private String rei=   "rei   ";
    private String rainha="rainha";
    private String peao=  "peao  ";
    private String nome_imagem;
    private String nome_anterior;
    private XadrezRegras tabuleiro=new XadrezRegras();
    private int turno=2;
    private int mover=0;
    private int x_anterior;
    private int y_anterior;
    private JButton[][] quadrados=new JButton[8][8];
    JPanel centro =new JPanel(new GridLayout(8,8));
    
    public Tela_Tabuleiro(){
        // Nome da tela
        super("Xadrez");

        // variaveis para a tela
        int x_atual,y_atual,x_desejado,y_desejado;
        Container caixa=getContentPane();
        
        
        //criando os botoes
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                quadrados[i][j]=new JButton(tabuleiro.getNome(i, j)+" "+String.valueOf(i+1)+ " "+String.valueOf(j+1), null);
            }
        }

        // Poder clicar nos botoes
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                quadrados[i][j].addActionListener(this);
            }
        }
        
        posicao_atual();
        // Desing da tela
        caixa.add(centro);
        setLocation(400, 0);
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Mostrar a Tela
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("\n"+ e.getSource()+"\n"+e.getModifiers());
        String peca=e.getActionCommand();
        String nome=peca.substring(0, 6);
        int linha_atual=Integer.parseInt(peca.substring(7, 8));
        int coluna_atual=Integer.parseInt(peca.substring(9, 10));
        if (nome!=nada & mover==0){
            x_anterior=linha_atual;
            y_anterior=coluna_atual;
            nome_anterior=nome;
            mover=1;
            return;
        }
        if( nome_anterior.equals(torre) & mover==1){
            tabuleiro.mover_torre(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        if( nome_anterior.equals(cavalo) & mover==1){
            tabuleiro.mover_cavalo(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        if( nome_anterior.equals(rei) & mover==1){
            tabuleiro.mover_rei(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        if( nome_anterior.equals(rainha) & mover==1){
            tabuleiro.mover_rainha(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        if( nome_anterior.equals(bispo) & mover==1){
            tabuleiro.mover_bispo(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        if( nome_anterior.equals(peao) & mover==1){
            tabuleiro.mover_peao(x_anterior, y_anterior, linha_atual, coluna_atual);
            mover=0;
            posicao_atual();
            return;
        }
        mover=0;
        tabuleiro.printTabuleiro();
    }
    public void posicao_atual(){
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                quadrados[i][j].setText(tabuleiro.getNome(i, j)+" "+String.valueOf(i+1)+ " "+String.valueOf(j+1));
                quadrados[i][j].setIcon(qual_imagem(tabuleiro.getNome(i, j),tabuleiro.getCor(i, j)));
                centro.add(quadrados[i][j]);
            }
        }
    }
    public ImageIcon qual_imagem(String nome,int cor){
        // Criando imagens 
        if(nome.equals(torre)){
            nome_imagem="torre";
        }
        if(nome.equals(cavalo)){
            nome_imagem="cavalo";
        }
        if(nome.equals(peao)){
            nome_imagem="peao";
        }
        if(nome.equals(bispo)){
            nome_imagem="bispo";
        }
        if(nome.equals(rei)){
            nome_imagem="rei";
        }
        if(nome.equals(nada)){
            nome_imagem="nada";
        }
        if(nome.equals(rainha)){
            nome_imagem="rainha";
        }
        String index=nome_imagem+String.valueOf(cor)+".png";
        ImageIcon imagem = new ImageIcon(index);
        return imagem;
    }
}
