class calculator{
    public int add(int num1, int num2){
        int r= num1+num2;
        System.out.println(r);
        return r;
    }
}
public class teleusko {
    public static void main(String args[]){
        // int num1=2,num2=3;
        // int r=num1+num2;
        // float num=5.6f; //float
        // char c='k';
        // boolean b=true;
        // long=8728L;
        //int num=100_00_000; 
       // int a=90111;
        //  short d=2;
        // d=(byte)a;

        // byte e=127;
        // int a=1222;
        // byte w= (byte)a;
        // float f= 4.5f;
        // int x= (int)f;
        // System.out.println(w);
        // int n=4;
        // char result= n%4==0?'Y':'N';
        // System.out.println(result);

        // int n=1;
        // switch(n){
        //     case 1: System.out.println("Monday"); break;
        //     case 2: System.out.println("Tuesday"); break;
        //     case 3: System.out.println("Wednesday");break;
        //     case 4: System.out.println("Thursday");break;
        //     case 5: System.out.println("Friday");break;
        //     case 6: System.out.println("Saturday");break;
        //     default: System.out.println("Sunday");break;
        // }
        
        calculator calc= new calculator();
        calc.add(4,3);

    }
}
