import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.io.IOException;

public class Batalha extends Jogador{

private int NumeroDeRodadas = 0;

final String pasta_temporaria = "temp/";

String resultadoDaPartida;
public static ArrayList<String> mArrayList = new ArrayList<>(5);
LocalDate Hora_Da_Partida = LocalDate.now();

public void Batalhar(){

    try{ 
         
      try{ 

        try{ 

    Scanner inp = new Scanner(System.in);
    Random rolagemDados = new Random();
    Jogador_Ainda_Vivo = true;

    System.out.println("Qual sera  o Nome do Heroi");
    String nomeHeroi = inp.nextLine();

    System.out.println("Saudacoes usuario, [1] Para Guerreiro [2] Para Barbaro [3] Para Paladino");
    String Escolha_Jogador = inp.next();

    switch(Escolha_Jogador){

        case "1":

        setPVJogador(12);
        setForcaJogador(4);
        setAgilidadeJogador(3);
        setDefesaJogador(3);
        int rolagem1_1 = (rolagemDados.nextInt(4) + 1);
        int rolagem2_2 = (rolagemDados.nextInt(4) +1);
        FatorDeDano = rolagem1_1 + rolagem2_2;
        break;

        case "2":

        setPVJogador(13);
        setForcaJogador(6);
        setAgilidadeJogador(3);
        setDefesaJogador(1);
        int rolagem1_2 = (rolagemDados.nextInt(6) + 1);
        int rolagem1_3 = (rolagemDados.nextInt(6) +1);
        FatorDeDano =  rolagem1_2 + rolagem1_3;
        break;

        case "3":

        setPVJogador(12);
        setForcaJogador(4);
        setAgilidadeJogador(3);
        setDefesaJogador(3);
        int rolagem1 = (rolagemDados.nextInt(4) + 1);
        int rolagem2 = (rolagemDados.nextInt(4) +1);
         FatorDeDano =  rolagem1 + rolagem2;
        break;
    }
    
int randomizarInimigo = rolagemDados.nextInt(5);

    if(randomizarInimigo == 1){

        System.out.println("Voce vai lutar contra um Morto-Vivo");

        setPVMonstro(25);
        setForcaMonstro(4);
        setDefesaMonstro(0);
        setAgilidadeMonstro(1);
        int rolagem1 = (rolagemDados.nextInt(4) + 1);
        int rolagem2 = (rolagemDados.nextInt(4) +1);
        FatorDeDano_Monstro =  rolagem1 + rolagem2;
    }
    else if(randomizarInimigo == 2){

        System.out.println("Voce vai lutar contra um Orc");
        setPVMonstro(20);
        setForcaMonstro(6);
        setDefesaMonstro(2);
        setAgilidadeMonstro(2);
        FatorDeDano_Monstro = (rolagemDados.nextInt(8) +1);
    }    
    else if(randomizarInimigo == 3){

        System.out.println("Voce vai lutar contra um Kobold");
        setPVMonstro(20);
        setForcaMonstro(4);
        setDefesaMonstro(2);
        setAgilidadeMonstro(4);
        int rolagem1 = (rolagemDados.nextInt(2) +1);
        int rolagem2 = (rolagemDados.nextInt(2) +1);
        int rolagem3 = (rolagemDados.nextInt(2) +1);
        FatorDeDano_Monstro =  rolagem1 + rolagem2 + rolagem3;
    }

    String HorapartidaConvertido = Hora_Da_Partida.toString();
    String RodadaConvertido = Integer.toString(NumeroDeRodadas);


    mArrayList.add("Nome: "+nomeHeroi);
    mArrayList.add("Classe: "+AcharNomeClasse(Escolha_Jogador));
    mArrayList.add("Inimigo:"+AUXRetornoNomeInimigo(randomizarInimigo));
    mArrayList.add("DiaDaLuta: "+HorapartidaConvertido);
    mArrayList.add("Rodadas:"+ RodadaConvertido);

    String pastaTemp = System.getProperty("java.io.tmpdir");
    File ArquivoTemp = File.createTempFile(nomeHeroi+".csv", ".csv", new File(pastaTemp));
    Path caminho = ArquivoTemp.toPath();
    
    FileWriter fw = new FileWriter(ArquivoTemp, true);

        fw.append(String.format(";"+ mArrayList));

        fw.close();

    while(Jogador_Ainda_Vivo){

        NumeroDeRodadas++;
        System.out.println("Numero de rodadas foi de: " + NumeroDeRodadas);

    int IniciativaJogador = rolagemDados.nextInt(10) + getAgilidadeJogador();
    int IniciativaMonstro = rolagemDados.nextInt(10) + getAgilidadeMonstro();

    if(IniciativaJogador > IniciativaMonstro){

       int FatorDeAtaque = rolagemDados.nextInt(10) + getForcaJogador();
       int FatorDefesaMonstro = rolagemDados.nextInt(10) + getAgilidadeMonstro() + getDEFESAMONSTRO();
        
        if(FatorDeAtaque > FatorDefesaMonstro){

        int danoCausado = rolagemDados.nextInt(FatorDeDano) + getForcaJogador();

        PV_Monstro -= danoCausado;

            System.out.println("O monstro recebeu  " + danoCausado + " Pontos de dano");            
}
}
    else { 
    System.out.println("o monstro esquiva e tenta acertar o jogador");
}

    if(IniciativaMonstro > IniciativaJogador){

    int  Fator_De_Ataque_Monstro = rolagemDados.nextInt(10) + getForcaMonstro();
    int Fator_De_Defesa_Jogador = rolagemDados.nextInt(10) + getAgilidadeJogador() + getDefesaJogador();

        if(Fator_De_Ataque_Monstro > Fator_De_Defesa_Jogador){

        int Dano_Causado_No_Jogador = rolagemDados.nextInt(FatorDeDano_Monstro) + getForcaMonstro();

            Pv_Jogador -= Dano_Causado_No_Jogador;

            System.out.println("O Heroi recebeu " + Dano_Causado_No_Jogador + " Pontos de Dano");
        }
        else {

                System.out.println("O Heroi esquivou");
        }
}
    if(PV_Monstro == 0){

        System.out.println("O monstro morreu, logo o heroi venceu");

        resultadoDaPartida = "Vitoria";
    
            return;
    }

    if(Pv_Jogador <= 0){

        System.out.println("Heroi faleceu, logo  O monstro venceu");
        Jogador_Ainda_Vivo = false;
        return;
    }
    if(IniciativaJogador == IniciativaMonstro ){

        System.out.println("Empate na rolagem da  Iniciativa ");
        System.out.println("-------------------------------");
        System.out.println("Rolando novamente");
    }
      
    }        
    }
    catch(NullPointerException exception){

        System.out.println("Erro na execucao do programa" + exception.getMessage());
    }
}
catch(IOException exception){

    System.out.println("Houve um erro na execucao do programa, tente novamente" + exception.getMessage());
}
}
    catch(Exception exception){

        System.out.println("Houve um erro na Execucao do programa." + exception.getMessage());
   
    } 
} //Fim metodo

public  String AUXRetornoNomeInimigo(int randomizarInimigo){
switch(randomizarInimigo){

    case 1:

    return "Morto vivo";
    
    case 2:

    return "Orc";

    case 3: 

    return "Kobold";

    default:

    return ";";
    }
}
    public String AcharNomeClasse(String Escolha_Jogador){

    switch(Escolha_Jogador){ 
    case "1":

    return "Guerreiro";

    case "2":

    return "Barbaro";

    case "3":

    return "Paladino";


    default:

    return "Nao escolheu nada";
}
}
} // FIM classe
