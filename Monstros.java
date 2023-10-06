public abstract class Monstros {

protected int PV_Monstro, Forca_Monstro, Defesa_Monstro, Agilidade_Monstro, FatorDeDano_Monstro;

void setPVMonstro(int PVMONSTRO){

    this.PV_Monstro = PVMONSTRO;
}

int getPVMONSTRO(){

    return PV_Monstro;
}

void setForcaMonstro(int FORCAMONSTRO){

    this.Forca_Monstro = FORCAMONSTRO;

}

int getForcaMonstro(){

    return Forca_Monstro;
}


void setDefesaMonstro(int DEFESAMONSTRO){

    this.Defesa_Monstro = DEFESAMONSTRO;
}

int getDEFESAMONSTRO(){

    return Defesa_Monstro;
}

void setAgilidadeMonstro(int AGILIDADEMONSTRO){

    this.Agilidade_Monstro = AGILIDADEMONSTRO;

}
int getAgilidadeMonstro(){

    return Agilidade_Monstro;
}
}
