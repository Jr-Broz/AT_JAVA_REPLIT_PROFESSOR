public abstract class Jogador extends Monstros {
    
protected int Pv_Jogador, Forca_Jogador, Agilidade_Jogador, Defesa_Jogador, FatorDeDano;
Boolean Jogador_Ainda_Vivo;

    void setPVJogador(int  PVJOGADOR){

        this.Pv_Jogador = PVJOGADOR;
    }

    int getPVJOGADOR(){

        return Pv_Jogador;
    }
    
    void setForcaJogador(int FORCAJOGADOR){

        this.Forca_Jogador = FORCAJOGADOR;
    }

    int getForcaJogador(){

        return Forca_Jogador;

    }

    void setDefesaJogador(int DEFESAJOGADOR){

        this.Defesa_Jogador = DEFESAJOGADOR;
    }

    int getDefesaJogador(){

        return Defesa_Jogador;
    }

    void setAgilidadeJogador(int AGILIDADEJOGADOR){
       
        this.Agilidade_Jogador = AGILIDADEJOGADOR;
    }

    int getAgilidadeJogador(){

        return Agilidade_Jogador;
    }
}
