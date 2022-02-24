import java.sql.Array;

public class FourByFour {
    public static void main(String [] args) {
//code to define an initially empty int 2D array, minimum size 4x4
int  [][] s = new int [4][4];
//code to output all original values
        System.out.println(s[0][0]);
        System.out.println(s[0][1]);
        System.out.println(s[0][2]);
        System.out.println(s[0][3]);
        System.out.println(s[1][0]);
        System.out.println(s[1][1]);
        System.out.println(s[1][2]);
        System.out.println(s[1][3]);
        System.out.println(s[2][0]);
        System.out.println(s[2][1]);
        System.out.println(s[2][2]);
        System.out.println(s[2][3]);
        System.out.println(s[3][0]);
        System.out.println(s[3][1]);
        System.out.println(s[3][2]);
        System.out.println(s[3][3]);
//code to change half the values to even positive numbers
        s[0][0]=2;
        s[0][1]=4;
        s[0][2]=6;
        s[0][3]=8;
        s[1][0]=10;
        s[1][1]=12;
        s[1][2]=14;
        s[1][3]=16;

//and the other half to negative odd numbers
        s[2][0]=-1;
        s[2][1]=-3;
        s[2][2]=-5;
        s[2][3]=-7;
        s[3][0]=-9;
        s[3][1]=-11;
        s[3][2]=-13;
        s[3][3]=-15;

//code to output a blank line separating output sets
        System.out.println();

//code to output all array elements
        System.out.print(s[0][0]+" ");
        System.out.print(s[0][1]+" ");
        System.out.print(s[0][2]+" ");
        System.out.println(s[0][3]);
        System.out.print(s[1][0]+" ");
        System.out.print(s[1][1]+" ");
        System.out.print(s[1][2]+" ");
        System.out.println(s[1][3]);
        System.out.print(s[2][0]+" ");
        System.out.print(s[2][1]+" ");
        System.out.print(s[2][2]+" ");
        System.out.println(s[2][3]);
        System.out.print(s[3][0]+" ");
        System.out.print(s[3][1]+" ");
        System.out.print(s[3][2]+" ");
        System.out.println(s[3][3]);
    }
}

