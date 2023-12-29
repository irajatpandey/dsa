package math;

public class SegmentedSieve {
    public static void generatePrime(boolean primes[], int b){
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i <= b; i++){
            primes[i] = true;
        }

        for(int p = 2; p * p <= b; p++){
            if(primes[p] == true){
                for(int i = p * p; i <= b; i = i + p){
                    primes[i] = false;
                }
            }
        }

        for(int i = 0; i <= b; i++){
            if(primes[i] == true){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int a = 22, b = 51;
        boolean primes[] = new boolean[b + 1];
        generatePrime(primes, b);

        boolean rangePrime[] = new boolean[b - a + 1];
        for(int i = 0; i < rangePrime.length; i++){
            rangePrime[i] = true;
        }
        for(int i = 2; i < primes.length; i++){
            if(primes[i] == true) {
                int multiple = (int) Math.ceil(((a * 1.0) / i));
                System.out.println("Multple " + multiple);
                System.out.println("prime " + i);
                if (multiple == 1) {
                    multiple++;
                }
                int startingIndex = multiple * i - a;
                System.out.println("startingIndex " + startingIndex);
                for(int j = startingIndex; j < rangePrime.length; j += i){
                    rangePrime[j] = false;
                    //System.out.println(rangePrime[j]);
                }
            }

        }

        for(int i = 0; i < rangePrime.length; i++){
            if(rangePrime[i] == true && i + a != 1)
                System.out.print(i + a + " ");
        }


    }
}
