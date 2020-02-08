public class CountPrimes{

    public int primeCount(int n){
        int count =0;
        boolean[] isPrime = new boolean[n];
        for(int i=0; i<n; i++){
            isPrime[i] = true;
        }
        for(int i=2; i*i<n; i++){
            if(isPrime[i]){
                for(int j=i; j*i < n; j++){
                    isPrime[i*j] = false;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.primeCount(1234567543));
    }
}