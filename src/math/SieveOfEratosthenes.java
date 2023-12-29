package math;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 50;
        boolean prime[] = new boolean[n + 1];
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i <= n; i++){
            prime[i] = true;
        }

        for(int p = 2; p * p <= n; p++){
            if(prime[p] == true){
                for(int i = p * p; i <= n; i += p){
                    prime[i] = false;
                }
            }
        }

        for(int i = 2; i <= n; i++){
            if(prime[i] == true){
                System.out.print(i + " ");
            }
        }
    }
}
