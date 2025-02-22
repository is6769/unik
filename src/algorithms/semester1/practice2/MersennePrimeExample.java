package algorithms.semester1.practice2;

public class MersennePrimeExample
{
    //function that checks if the given number is Mersenne prime or not
    public static boolean isMersennePrime(int N)
    {
        for (int i = 2; i <= Math.sqrt(N); i++)
        {
            if (N%i == 0)
                return false;
        }
        return true;
    }
    //driver code
    public static void main(String args[])
    {
        System.out.println("n" +"\t"+ "2^n-1 \n");
//loop starts from 2 and execute untill the condition i<=100 becomes false
        for (int i =2; i<=34; i++)
        {
//recursively called function
            if (isMersennePrime(i) && isMersennePrime((int) (Math.pow(2, i)-1)))
            {
//prints all the Mersenne prime
                System.out.println(i +"\t" + (int)(Math.pow(2, i)-1));
            }
        }
    }
}