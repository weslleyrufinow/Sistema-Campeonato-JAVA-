package ap1;

public class Jogo {
    private Time TimeA = new Time(),TimeB = new Time();
    private Integer golsA = -1, golsB = -1;
    private String TimeAN = "vazio",TimeBN = "vazio";

    public String getTimeAN() {
        return TimeAN;
    }

    public void setTimeAN(String TimeAN) {
        this.TimeAN = TimeAN;
    }

    public String getTimeBN() {
        return TimeBN;
    }

    public void setTimeBN(String TimeBN) {
        this.TimeBN = TimeBN;
    }
   
    public Time getTimeA() {
        return TimeA;
    }

    public void setTimeA(Time TimeA) {
        this.TimeA = TimeA;
    }

    public Time getTimeB() {
        return TimeB;
    }

    public void setTimeB(Time TimeB) {
        this.TimeB = TimeB;
    }
    
    public void setGolsA(Integer n){
        golsA = n;
    }
    
    public Integer getGolsA(){
        return golsA;
    }
    
    public void setGolsB(Integer n){
        golsB = n;
    }
    
    public Integer getGolsB(){
        return golsB;
    }

}
