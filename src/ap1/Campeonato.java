package ap1;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Campeonato {    
    public String nome = "Campeonato X";
    
    public void setNomeCampeonato(String nome){
        this.nome = nome;
    }
    
    public String getNomeCampeonato(){
        return nome;
    }
    
    public void inserirParticipante(Time times[], Participantes participantes[]) {
        Campeonato campeonato = new Campeonato();
        Scanner teclado = new Scanner(System.in);
        int i;
        String s;
        for(i = 0; i<times.length; i++){
            System.out.printf("Nome do time %d: \n", i+1);
            s = teclado.next();
            times[i].setNome(s);
            participantes[i].setTime(times[i]);
            campeonato.setDadosParticipantesAleat(participantes[i]);
        }

        campeonato.menu();
    }

    public void inserirJogo(Jogo jogo[],Participantes p[]) {
        Campeonato c = new Campeonato();
        String sta,stb;
        Scanner teclado = new Scanner(System.in);
        int aux,auxb,i = 0;
        boolean achou = false;

        System.out.println("Time A: ");
        sta = teclado.next();
        System.out.println("Time B: ");
        stb = teclado.next();
        
        auxb = c.buscaTimes(p, sta, stb);
        if(auxb == 1){
            aux = c.buscaJogo(jogo, sta, stb);

            if(aux == -1){
                while( (i != jogo.length) && (achou == false) ){
                    if("vazio".equalsIgnoreCase(jogo[i].getTimeAN().intern())){
                        System.out.println("Gols de A:");
                        jogo[i].setTimeAN(sta);                
                        jogo[i].setGolsA(teclado.nextInt());

                        System.out.println("Gols de B:");            
                        jogo[i].setTimeBN(stb);
                        jogo[i].setGolsB(teclado.nextInt());
                        achou = true;
                    }
                    i++;
                }
            }
        }else{
            System.out.println("Um dos times não foi encontrado");
        }
        
        c.menu();
    }
    
    public void inserirResultado(Participantes p[]){        
        Campeonato c = new Campeonato();
        Scanner teclado = new Scanner(System.in);
        String ta,tb,auxs1,auxs2;
        int i = 0,aux1,aux2,tam = p.length, ga,gb;
        boolean achou = false;
        
        System.out.println("Time A:");
        ta = teclado.next();
        aux1 = c.buscaTime(p,ta);
        
        System.out.println("Time B:");
        tb = teclado.next();
        aux2 = c.buscaTime(p,tb);
        
        if( (aux1 != -1) && (aux2 != -1) ){
            
            System.out.println("Gols A:");
            ga = teclado.nextInt();         

            System.out.println("Gols B:");
            gb = teclado.nextInt();            
            
            while( (i != tam) && (achou == false) ){   
            
                auxs1 = p[i].getTime().getNome().intern();       

                if( auxs1.equalsIgnoreCase(ta) ){                    
                    p[i].setGolsPro(ga);                  
                    achou = true;
                }                            
                
                i++;
            }
            achou = false; i = 0;
            while( (i != tam) && (achou == false) ){   
                            
                auxs2 = p[i].getTime().getNome().intern();
                
                if( auxs2.equalsIgnoreCase(tb) ){                    
                    p[i].setGolsPro(gb);                  
                    achou = true;
                }                
                
                i++;
            }              
            
        }        
        
    }
    
    public void classificacao(Participantes participantes[]) {
        Campeonato c = new Campeonato();
        c.classificar(participantes);
    }
    
    public void removerJogo(Participantes p[],Jogo j[]) {
        Campeonato c = new Campeonato();
        Scanner teclado = new Scanner(System.in);
        String ta,tb,auxs1,auxs2;
        int i = 0,aux1,aux2,tam = j.length;
        boolean achou = false;
        
        System.out.println("Time A:");
        ta = teclado.next();
        aux1 = c.buscaTime(p,ta);
        
        System.out.println("Time B:");
        tb = teclado.next();
        aux2 = c.buscaTime(p,tb);
        
        if( (aux1 != -1) && (aux2 != -1) ){
            
            while( (i != tam) && (achou == false) ){         
            
                auxs1 = j[i].getTimeAN().intern();
                auxs2 = j[i].getTimeBN().intern();

                if( auxs1.equalsIgnoreCase(ta) && auxs2.equalsIgnoreCase(tb) ){                    
                    j[i].setTimeAN("vazio");
                    j[i].setGolsA(-1);
                    
                    j[i].setTimeBN("vazio");
                    j[i].setGolsB(-1);
                    System.out.println("Remocao feita");
                    achou = true;
                }
                i++;
            }          
            
        }
        
    }
    
    public void menu(){        
        System.out.println("0.sair");
        System.out.println("1.Inserir Participante");
        System.out.println("2.Inserir Jogo");
        System.out.println("3.Inserir Resultado");
        System.out.println("4.Classificação");
        System.out.println("5.Remover Jogo");
        System.out.println("6.Imprimir jogos");
        System.out.println("7.Imprimir Times Participantes");
        System.out.println("Esperando comando:...");
        System.out.println("*--------------------*");
    }      
    
    private int buscaTimes(Participantes p[],String a, String b){
        int r = 0, ra = 0,rb = 0,i = 0, tam = p.length;
        boolean achou = false;
        String aux;

            while( (i != tam) && (achou == false) ){         
            
                aux = p[i].getTime().getNome();

                if( aux.equalsIgnoreCase(a.intern()) ){
                    //System.out.println("Time A encontrado");
                    ra = 1;
                    achou = true;
                }
                i++;
            }                        
            i = 0; achou = false;
            
            while( (i != tam) && (achou == false) ){       

                aux = p[i].getTime().getNome();

                if( aux.equalsIgnoreCase(b.intern()) ){
                    //System.out.println("Time B encontrado");
                    rb = 2;
                    achou = true;
                }
                i++;
            }          
            
            if( (ra!=0) && (rb!=0) ){
                r = 1;
            }
            
    return r;}

    private int buscaTime(Participantes p[],String a){
        int r = -1,i = 0, tam = p.length;
        boolean achou = false;
        String aux;

            while( (i != tam) && (achou == false) ){         
            
                aux = p[i].getTime().getNome();

                if( aux.equalsIgnoreCase(a.intern()) ){                    
                    r = i;
                    achou = true;
                }
                i++;
            }
            
            if(achou == false){
                System.out.println("Time nao encontrado");
            }else{
                System.out.println("Time encontrado");
            }

    return r;}
    
    private int buscaJogo(Jogo p[],String a, String b){
        int r = -1,i = 0, tam = p.length;
        boolean achou = false;
        String auxa, auxb;

            while( (i != tam) && (achou == false)){         
            
            auxa = p[i].getTimeAN();
            auxb = p[i].getTimeBN();
           
            if( ( a.equalsIgnoreCase(auxa.intern()) ) && ( b.equalsIgnoreCase(auxb.intern()) ) ){
                System.out.println("jogo já existe");
                r = 1;
                achou = true;
            }           
           
            i++;
        }
            if(achou == false){
                System.out.println("Jogo nao encontrado");
            }
    return r;}             

    public Time[] criaTimes(Time time[]){
        int i;
        for(i = 0; i < time.length; i++){
            time[i] = new Time();
            //time[i].setNome("time "+ (i+1));
            //System.out.println(time[i].getNome());
            }
    return time;}

    public Jogo[] criaJogos(Jogo jogos[]){
        int i;
        for(i = 0; i < jogos.length; i++){
            jogos[i] = new Jogo();
            }
    return jogos;}
    
    public Participantes[] criaParticipantes(Participantes participantes[]){
        int i;
        for(i = 0; i < participantes.length; i++){
            participantes[i] = new Participantes();
            }
    return participantes;}

    private void setDadosParticipantesAleat(Participantes participantes){
        Random random = new Random();
        
        int aux = random.nextInt(5);
        participantes.setJogos(aux);
        
        aux = random.nextInt(5);
        participantes.setVitoria(aux);
        
        aux = random.nextInt(5);           
        participantes.setEmpate(aux);
        
        aux = random.nextInt(5);  
        participantes.setDerrota(aux);
        
        aux = random.nextInt(5);
        participantes.setPontos(aux);
        
        aux = random.nextInt(5);            
        participantes.setGolsPro(aux);
        
        aux = random.nextInt(5); 
        participantes.setGolsContra(aux);        
    }
    
    private void setDadosParticipantes(Participantes participantes){
        Random random = new Random();
        
        
        int aux = random.nextInt(10);
        participantes.setJogos(0);
                
        participantes.setVitoria(0);
                
        participantes.setEmpate(0);
                
        participantes.setDerrota(0);
       
        participantes.setPontos(aux);
                
        participantes.setGolsPro(0);
                
        participantes.setGolsContra(0);        
    }    
    
    public void ImprimirTimesParticipantes(Participantes participantes[]){
        int i;
        for(i = 0; i < participantes.length; i++){
            System.out.printf("Nome: %15s", participantes[i].getTime().getNome());
            System.out.print(" | Pontos: " + participantes[i].getPontos());
            System.out.print(" | Gols Pro: " + participantes[i].getGolsPro());
            System.out.print(" | Gols Contra: " + participantes[i].getGolsContra());            
            System.out.print(" | Jogos: " + participantes[i].getJogos());
            System.out.print(" | Vitorias: " + participantes[i].getVitoria());
            System.out.print(" | Empates: " + participantes[i].getEmpate());
            System.out.print(" | Derrotas: " + participantes[i].getDerrota());

            System.out.printf("\n");
        }   

    }
    
    public void ImprimirJogos(Jogo participantes[]){
        int i;
        for(i = 0; i < participantes.length; i++){
            System.out.printf(" jogo : %15s", participantes[i].getTimeAN() );
            System.out.printf(" vs %15s",participantes[i].getTimeBN()) ;
            System.out.print(" | Placar : " + participantes[i].getGolsA() + " x " + participantes[i].getGolsB()) ;
            System.out.printf("\n");
        }   

    }               
    
private void classificar(Participantes participantes[]){
        Campeonato c = new Campeonato();
        Participantes p[] = new Participantes[participantes.length];      
        p = c.criaParticipantes(p);            
        
        for(int i = 0; i < participantes.length; i++) {
            p[i].setTime(participantes[i].getTime());
            p[i].setJogos(participantes[i].getJogos());
            p[i].setVitoria(participantes[i].getVitoria());
            p[i].setEmpate(participantes[i].getEmpate());
            p[i].setDerrota(participantes[i].getDerrota());
            p[i].setPontos(participantes[i].getPontos());
            p[i].setGolsPro(participantes[i].getGolsPro());
            p[i].setGolsContra(participantes[i].getGolsContra());
        }
        
        Arrays.sort(p, (b, a) -> {
            int pa = a.getPontos();
            int pb = b.getPontos();
            return pa == pb ?  a.getGolsPro() - b.getGolsPro() : pa - pb;
         });                
        
        System.out.println("*********************Times*********************");
        c.ImprimirTimesParticipantes(participantes);
        System.out.println("*****************Classificacao*****************");
        c.ImprimirTimesParticipantes(p);
        System.out.println("***********************************************");
    }    
    
    
}
