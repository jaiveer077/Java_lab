import java.util.Scanner;

public class assignment1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // int year; 
        // System.out.println("Enter the year to check: ");
        // year=sc.nextInt();

        // if(year%400==0||((year%100!=0)&&(year%4==0))){
        //     System.out.println(year+" is a leap year!");
        // } else {
        //     System.out.println(year+" is not a leap year!");
        // }

        // char ch;
        // System.out.println("Enter the character to check: ");
        // ch=sc.next().charAt(0);
        // if((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')){
        //     System.out.println("Character is a alphabet!");
        // } else {
        //     System.out.println("Character is not alphabet!");
        // }
        
        // int num;
        // System.out.println("Enter the number: ");
        // num=sc.nextInt();
        // int ans=factorial(num);
        // System.out.println("Result: "+ans);

        // int a=0,b=1;
        // int x;
        // System.out.println("Enter the value of n for fibonacci: ");
        // x=sc.nextInt();
        // int temp=0;
        // System.out.println(a);
        // System.out.println(b);
        // while(temp<=x){
        //     temp=a+b;
        //     a=b;
        //     b=temp;
        //     System.out.println(temp);
        // }

        // int m,n;
        // System.out.print("Enter two numbers to find (gcd): ");
        // m=sc.nextInt(); n=sc.nextInt();

        // int ans=gcd(m,n);
        // System.out.println("Answer: "+ans);

        // int other_ans=lcm(m,n);
        // System.out.println("Answer: "+other_ans);

        // int number=0;
        // System.out.print("Enter the number to count digits: ");
        // number=sc.nextInt();

        // int temp=number,count=0;
        // while(temp!=0){
        //     int digit=temp%10;
        //     count++;
        //     temp/=10;
        // }

        // System.out.println("Number of digits: "+count);

        // temp=number;
        // int rev=0;
        // while(temp!=0){
        //     int digit=temp%10;
        //     rev=rev*10+digit;
        //     temp/=10;
        // }
        // System.out.println(rev);

        // String s;
        // s=sc.nextLine();
        // if(palindrome(s)){
        //     System.out.println("Yes!");
        // } else {
        //     System.out.println("No!");
        // }

        // int base,exponent;
        // System.out.println("Enter the value of base and exponenet: ");
        // base=sc.nextInt();
        // exponent=sc.nextInt();
        // // using in built function
        // double result=Math.pow(base,exponent);
        // System.out.println(result);

        // double res=1;
        // for(int i=0;i<exponent;i++){
        //     res*=base;
        // }
        // System.out.println(res);
        // sc.close();
        // System.exit();
    }
    // static boolean palindrome(String s){
    //     int i=0,j=s.length()-1;
    //     while(i<=j){
    //         if(s.charAt(i)!=s.charAt(j)) return false;
    //         i++;
    //         j--;
    //     }
    //     return true; 
    // }
    // static int lcm(int a,int b){
    //     return (a*b)/gcd(a,b);
    // }
    // static int gcd(int a,int b){
    //     if(b==0) return a;
    //     return gcd(b,a%b);
    // }
    // static int factorial(int n){
    //     int res=1;
    //     for(int i=1;i<=n;i++){
    //         res=res*i;
    //     }
    //     return res;
    // }
}
