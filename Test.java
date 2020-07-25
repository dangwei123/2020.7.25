其中系数aj都是整数满足0≤aj≤1000且至少有两个系数严格大于0，分别将n=1,n=2,n=3n...代入以上函数可以得到一个无穷长度的整数序列，即用8个系数a7,a6...a0
可以唯一确定一个无穷长度的整数序列，现在给出k个通过以上方法定义的无穷序列，你需要求出将这些序列所有数字放在一起后，
第n小的数字是多少？
第一行包含一个整数k,1≤k≤104

接下来k行，每行包含8个整数a7,a6,.....a0,表示一个函数的系数，0≤aj≤1000

最后一行包含一个整数n,1≤n≤105
import java.util.*;
public class Main{
    public static long getSum(int[] arr,int n){
        long sum=0;
        for(int i=0;i<8;i++){
            sum+=arr[i]*Math.pow(n,7-i);
        }
        return sum;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int k=sc.nextInt();
            int[][] arr=new int[k][8];
            for(int i=0;i<k;i++){
                for(int j=0;j<8;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int n=sc.nextInt();
            long[] value=new long[k];
            int[] index=new int[k];
            Arrays.fill(index,1);
            for(int i=0;i<k;i++){
                value[i]=getSum(arr[i],1);
            }
            long ret=0;
            for(int i=0;i<n;i++){
                long min=Long.MAX_VALUE;
                int minIndex=0;
                for(int j=0;j<k;j++){
                    if(value[j]<min){
                        min=value[j];
                        minIndex=j;
                    }
                }
                ret=min;
                index[minIndex]++;
                value[minIndex]=getSum(arr[minIndex],index[minIndex]);
            }
            System.out.println(ret);
        }
    }
}