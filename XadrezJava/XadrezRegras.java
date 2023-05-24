public class XadrezRegras{
    private Tabuleiro tabuleiro;
    private int turno;
    // turno: 2-branco  1-preto

    private String nada=  "nada  ";
    private String torre= "torre ";
    private String cavalo="cavalo";
    private String bispo= "bispo ";
    private String rei=   "rei   ";
    private String rainha="rainha";
    private String peao=  "peao  ";


    public XadrezRegras(){
        tabuleiro=new Tabuleiro();
        turno=2;
    }

    public String getNome(int x,int y){
        return tabuleiro.getNome(x, y);
    }
    // Regras Para Mover Cada Peça
    public boolean se_pode_torre(int x_atual,int y_atual,int x_desejado,int y_desejado){
        int d_x=x_desejado-x_atual;
        int d_y=y_desejado-y_atual;
        boolean pode=false;
        int cora=tabuleiro.getCor(x_atual,y_atual);
        int cord;
        int brea=0;
        // cora == cor atual da peca; cord = cor do quadrado desejado
        if (d_x==0 & d_y>0){
            for(int j=y_atual+1;j<=y_desejado;j++){
                cord= tabuleiro.getCor(x_desejado,j);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & j!=y_desejado){
                    pode=false;
                    break;
                }
            }
        }
        if (d_x==0 & d_y<0){
            for(int j=y_atual-1;j>=y_desejado;j--){
                cord= tabuleiro.getCor(x_desejado,j);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & j!=y_desejado){
                    pode=false;
                    break;
                }
            }
        }
        if (d_x>0 & d_y==0){
            for(int i=x_atual+1;i<=x_desejado;i++){
                cord= tabuleiro.getCor(i,y_desejado);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
            }
        }
        if (d_x<0 & d_y==0){
            for(int i=x_atual-1;i>=x_desejado;i--){
                cord= tabuleiro.getCor(i,y_desejado);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
            }
        }
        return pode;
    }
    public void mover_torre(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if(se_pode_torre( x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), torre);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }

    public boolean se_pode_bispo(int x_atual,int y_atual,int x_desejado,int y_desejado){
        int d_x=x_desejado-x_atual;
        int d_y=y_desejado-y_atual;
        boolean pode=false;
        int cora=tabuleiro.getCor(x_atual,y_atual);
        int cord;
        int brea=0;
        int j=y_atual;
        if(d_x==d_y & d_x>0){
            for(int i=x_atual+1;i<=(x_desejado);i++){
                cord=tabuleiro.getCor(i, j+1);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
                j++;
            }
        }
        if(d_x==d_y & d_x<0){
            for(int i=x_atual-1;i>=(x_desejado);i--){
                cord=tabuleiro.getCor(i, j-1);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
                j--;
            }
        }
        if(d_x==(-d_y) & d_x<0){
            for(int i=x_atual-1;i>=(x_desejado);i--){
                cord=tabuleiro.getCor(i, j+1);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
                j++;
            }
        }
        if(d_x==(-d_y) & d_x>0){
            for(int i=x_atual+1;i<=(x_desejado);i++){
                cord=tabuleiro.getCor(i, j-1);
                if (cord==0){pode=true;}
                if(cord!=0 & cora!=cord){pode=true;brea=1;}
                if(cord==cora){pode=false;break;}
                if(brea==1 & i!=x_desejado){
                    pode=false;
                    break;
                }
                j--;
            }
        }
        return pode;
    }
    public void mover_bispo(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if(se_pode_bispo( x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), bispo);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }
    
    public boolean se_pode_cavalo(int x_atual,int y_atual,int x_desejado,int y_desejado){
        int d_x=x_desejado-x_atual;
        int d_y=y_desejado-y_atual;
        boolean pode=false;
        int cora=tabuleiro.getCor(x_atual,y_atual);
        int cord;
        int brea=0;
        cord=tabuleiro.getCor(x_desejado,y_desejado);
        if (cord!=cora){
            if (d_x==1 & d_y==2){
                pode=true;
            }
            if (d_x==(-1) & d_y==2){
                pode=true;
            }
            if (d_x==1 & d_y==(-2)){
                pode=true;
            }
            if (d_x==(-1) & d_y==(-2)){
                pode=true;
            }
            if (d_x==2 & d_y==1){
                pode=true;
            }
            if (d_x==(-2) & d_y==1){
                pode=true;
            }
            if (d_x==2 & d_y==(-1)){
                pode=true;
            }
            if (d_x==(-2) & d_y==(-1)){
                pode=true;
            }
        }
        return pode;
    }
    public void mover_cavalo(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if(se_pode_cavalo( x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), cavalo);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }

    public void mover_rainha(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if (se_pode_torre(x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)==true){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), rainha);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
        if (se_pode_bispo(x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)==true){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), rainha);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }

    public boolean se_pode_rei(int x_atual,int y_atual,int x_desejado,int y_desejado){
        int d_x=x_desejado-x_atual;
        int d_y=y_desejado-y_atual;
        boolean pode=false;
        int cora=tabuleiro.getCor(x_atual,y_atual);
        int cord;
        cord=tabuleiro.getCor(x_desejado,y_desejado);
        if (cord!=cora){
            if (d_x==1 & d_y==1){
                pode=true;
            }
            if (d_x==1 & d_y==(-1)){
                pode=true;
            }
            if (d_x==1 & d_y==0){
                pode=true;
            }
            if (d_x==0 & d_y==1){
                pode=true;
            }
            if (d_x==0 & d_y==(-1)){
                pode=true;
            }
            if (d_x==0 & d_y==0){
                pode=true;
            }
            if (d_x==(-1) & d_y==1){
                pode=true;
            }
            if (d_x==(-1) & d_y==(-1)){
                pode=true;
            }
            if (d_x==(-1) & d_y==0){
                pode=true;
            }
        }
        if(tabuleiro.getNome(x_desejado, y_desejado)==torre & cord==cora & cora==1){
            if( x_atual==0 & y_atual==4 & x_desejado==0 & y_desejado==7){
                pode=false;
                tabuleiro.poe_peca(1, 7, 1, rei);
                tabuleiro.tira_peca(x_desejado+1, y_desejado+1);
                tabuleiro.tira_peca(x_atual+1, y_atual+1);
                tabuleiro.poe_peca(1, 6, 1, torre);
            }
            if( x_atual==0 & y_atual==4 & x_desejado==0 & y_desejado==0){
                pode=false;
                tabuleiro.poe_peca(1, 3, 1, rei);
                tabuleiro.tira_peca(x_desejado+1, y_desejado+1);
                tabuleiro.tira_peca(x_atual+1, y_atual+1);
                tabuleiro.poe_peca(1, 4, 1, torre);
            }
        }
        if(tabuleiro.getNome(x_desejado, y_desejado)==torre & cord==cora & cora==2){
            if( x_atual==7 & y_atual==4 & x_desejado==7 & y_desejado==7){
                pode=false;
                tabuleiro.poe_peca(8, 7, 2, rei);
                tabuleiro.tira_peca(x_desejado+1, y_desejado+1);
                tabuleiro.tira_peca(x_atual+1, y_atual+1);
                tabuleiro.poe_peca(8, 6, 2, torre);
            }
            if( x_atual==7 & y_atual==4 & x_desejado==7 & y_desejado==0){
                pode=false;
                tabuleiro.poe_peca(8, 3, 2, rei);
                tabuleiro.tira_peca(x_desejado+1, y_desejado+1);
                tabuleiro.tira_peca(x_atual+1, y_atual+1);
                tabuleiro.poe_peca(8, 4, 2, torre);
            }
        }
        
        return pode;
    }
    public void mover_rei(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if (se_pode_rei(x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)==true){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), rei);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }
    public boolean se_pode_peao(int x_atual,int y_atual,int x_desejado,int y_desejado){
        int d_x=x_desejado-x_atual;
        int d_y=y_desejado-y_atual;
        boolean pode=false;
        int cora=tabuleiro.getCor(x_atual,y_atual);
        int cord;
        cord=tabuleiro.getCor(x_desejado,y_desejado);
        if(cord==0 & d_y==0){
            if (d_x==1 & cora==1){
                pode=true;
            }
            if(d_x==(-1) & cora==2){
                pode=true;
            }
        }
        if(cora!=cord & d_x==1 & cord!=0  & d_y==1){
            if(d_y==1){
                pode=true;
            }
            if(d_y==(-1)){
                pode=true;
            }
        }
        if(cora!=cord & d_x==1 & cord!=0  & d_y==(-1)){
            if(d_y==1){
                pode=true;
            }
            if(d_y==(-1)){
                pode=true;
            }
        }
        if(cora!=cord & d_x==(-1) & cord!=0 & d_y==1){
            if(d_y==1){
                pode=true;
            }
            if(d_y==(-1)){
                pode=true;
            }
        }
        if(cora!=cord & d_x==(-1) & cord!=0 & d_y==(-1)){
            if(d_y==1){
                pode=true;
            }
            if(d_y==(-1)){
                pode=true;
            }
        }
        if(cord==0 & x_atual==1 & d_y==0 & x_desejado==3){
            if( tabuleiro.getCor(2, y_atual)==0){
                pode=true;
            }
        }
        if(cord==0 & x_atual==6 & d_y==0 & x_desejado==4){
            if( tabuleiro.getCor(5, y_atual)==0){
                pode=true;
            }
        }
        return pode;
    }
    public void mover_peao(int x_atual,int y_atual,int x_desejado,int y_desejado){
        if (se_pode_peao(x_atual-1, y_atual-1, x_desejado-1, y_desejado-1)==true){
            tabuleiro.poe_peca(x_desejado, y_desejado, tabuleiro.getCor(x_atual-1,y_atual-1), peao);
            tabuleiro.tira_peca(x_atual, y_atual);
        }
    }

    public void printTabuleiro(){
        tabuleiro.printTabuleiro();
    }
    public int getCor(int x, int y){
        return tabuleiro.getCor(x, y);
    }
}