package algorithms.practice1;

public class ChordMethod {

    public ChordMethod() {
        chordM(0.0,1.0);
        halfDiv(0.0,1.0);
    }

    private Double f(Double x){
        return Math.pow(Math.E,x-1)-Math.pow(x,3)-x;
    }

    /**
     *
     * @param currentX - в данном случае не фиксировнная точка,которая постоянно меняется
     * @param fixatedX - фиксированная точка
     */
    private void chordM(Double currentX,Double fixatedX){
        Double nextX=currentX-((fixatedX-currentX)*(f(currentX))/(f(fixatedX)-f(currentX)));
        if (Math.abs(nextX-currentX)<=0.00001){
            System.out.println(nextX);
            return;
        }
        chordM(nextX,fixatedX);
    }

    private void halfDiv(Double start,Double end){
        Double mid=start+(end-start)/2;
        if(Math.abs(end-start)<=0.00001){
            System.out.println(start);
            return;
        }
        else if (f(mid)*f(start)<0){
            halfDiv(start,mid);
        }else{
            halfDiv(mid,end);
        }
    }

    public static void main(String[] args) {
        ChordMethod chordMethod = new ChordMethod();
    }
}
