/*
 *
 *
 *   Aluno:
 *   Antonio Weslley Sylvio Moreira Rufino
*/
package ap1;
import java.util.Scanner;

//Existe um metodo que insere dados aleatorios ao criar um time, basta ir no metodo inserirParticipante
// e trocar setDadosParticipantes por setDadosParticipantesAleat


//A inserção de dados apenas insere o numero de gols como na imagem do sistema
// mas pode ser alterado colocando os campos para os demais atributos
public class AP1 {
    public static void main(String[] args) {        
        int button,wh = 1;
        int tam = 3;
        Scanner teclado = new Scanner(System.in);
        Campeonato campeonato = new Campeonato();
        
        Time times[] = new Time[tam];
        times = campeonato.criaTimes(times);
        
        Jogo jogos[] = new Jogo[(times.length * (times.length-1))];
        jogos = campeonato.criaJogos(jogos);
        
        Participantes participantes[] = new Participantes[tam];                 
        participantes = campeonato.criaParticipantes(participantes);
        
        campeonato.menu();
        
        while(wh == 1){

            button = teclado.nextInt();

            switch (button){
              case 0://Sair
                    System.out.println("Saindo...");
                    wh = 0;
                break;
              case 1://Inserir Participante
                  campeonato.menu();
                  campeonato.inserirParticipante(times, participantes);
                break;
              case 2://Inserir Jogo
                  campeonato.menu();
                  campeonato.inserirJogo(jogos, participantes);                  
                break;
              case 3://Inserir Resultado
                  campeonato.menu();
                  campeonato.inserirResultado(participantes);
                  campeonato.menu();
                break;        
              case 4://Classificação
                  campeonato.menu();                  
                  campeonato.classificacao(participantes);        
                  campeonato.menu();
                break;
              case 5://Remover Jogo
                  campeonato.menu();
                  campeonato.removerJogo(participantes,jogos);
                  campeonato.menu();
                break;
              case 6://Imprimir jogos
                    campeonato.menu();
                    campeonato.ImprimirJogos(jogos);
                    campeonato.menu();
                break;        
              case 7://Imprimir times e participantes
                    campeonato.menu();
                    campeonato.ImprimirTimesParticipantes(participantes);
                    campeonato.menu();
                break;        
              default:
                  System.out.println("Valor Invalido");
                      }        
            }
    }
}
