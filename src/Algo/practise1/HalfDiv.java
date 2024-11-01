package Algo.practise1;

public class HalfDiv {

    public HalfDiv() {
        halfDiv(0.0,1.0);
    }

    private Double f(Double x){
        return Math.pow(Math.E,x-1)-Math.pow(x,3)-x;
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
        HalfDiv halfDiv=new HalfDiv();
    }
}
