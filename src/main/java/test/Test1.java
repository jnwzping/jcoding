package test;

public class Test1 {
   public int rep(int[] arr){
    int x = 0;
    for(int y=1;y<arr.length;y++){
      if(arr[x]!=arr[y]){
          if(x!=0) {
              arr[x] = arr[y];
          }
          x++;
      }
    }
    return x;
   }

  public static void main(String[] args) {
    int[] x = {1,1,2,2,2,3};
      new Test1().rep(x);
      System.out.println("");
  }
}
