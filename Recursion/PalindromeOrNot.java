class Main {
    public static void main(String[] args) {
        String s= "MADAM";
        int n=s.length();
        
        System.out.println(f(s,0,n));
    }
      public static boolean f(String s,int i,int n){
          if(i>=n/2){
              return true;
          }
         if (s.charAt(i) != s.charAt(n - i - 1)) {
              return false;
          }
          return f(s,i+1,n);
      }
       
}