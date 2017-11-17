import java.util.*;

public class ComplexArraySort{
    
    boolean notAPrime = false;
    int ssCount = 0;
    int bsCount = 0;
    int randomNum;
    int randomPrime;
    int middle;
    
    public ComplexArraySort(){
        int count = 0;
        int[] num = new int[50];
        
        while(count < 50){
            int random = (int)(Math.random() * 200 + 1);
            
            if(isAPrime(random) == false){
               num[count] = random;
               count ++;
            }
        
        }
        
        System.out.println("Array: " + Arrays.toString(num));
        
        sequentialSearch(num);
        
    }
    
    public void sequentialSearch(int[] a){
    
        ArrayList<Integer> allPrimes = new ArrayList<Integer>();
        
        for(int i = 2; i <= 200; i++){
            if(isAPrime(i) == false){
                allPrimes.add(i);
            }
        }
        
        randomNum = (int)(Math.random() * allPrimes.size() + 1);
        randomPrime = allPrimes.get(randomNum);

        System.out.println("Sequential Search - Searching For " + randomPrime);
        
        boolean found = false;
        int spot = 0;
        
        for(int i = 0; i < a.length; i++){
            ssCount ++;
            if(a[i] == randomPrime){
                spot = i;
                found = true;
            }
        }
        
        if(found == true){
            System.out.println("Found it! Spot: " + spot);
        }else{
            System.out.println("Did Not Find It.");
        }
        
        System.out.println("Sequential Search Iterations: " + ssCount);
        
        insertionSort(a);
        
    }
    
    
    public void insertionSort(int[] a){
        
        for(int i = 1; i < a.length; i ++){
            
            int key = a[i];
            int j = i;
            
            while(j > 0 && a[j - 1] > key){
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
        
        System.out.println("Sorted: " + Arrays.toString(a));
        
        binarySearch(a);
    }
    
    public int binarySearch(int[] a){
        System.out.println("Binary Search - Searching For " + randomPrime);
        
        int high = a.length;
        int low = 0;

        boolean found = false;
        
        while(low <= high){
            middle = (high + low)/2;
            if(randomPrime > a[middle]){
                low = middle + 1;
                middle = (high + low)/2;
            }else if(randomPrime < a[middle]){
                high = middle - 1;
                middle = (high + low)/2;
            }else{
                low = 100000;
                found = true;
                //return middle;
            }
            bsCount ++;
        }
        
        if(found == true){
            System.out.println("Found it! Spot: " + middle);
        }else{
            System.out.println("Did Not Find It.");
        }
        
        System.out.println("Binary Search Iterations: " + bsCount);
       
        return -1;
    }
    
    public boolean isAPrime(int y)
    {
       notAPrime=false;
       int num=2;
       
       while(num<y){//can do y/2
           
           if(y%num==0)
              notAPrime=true;
              num++;
        }
        return notAPrime;
    }
    
    
}

