public class ThreeByThree {
    public static void main(String [] args){

//code to define an initially empty double
//2D array size 3x3

        double [][] list = new double[3][3];

//code to output all original values
        System.out.println(list[0][0]);
        System.out.println(list[0][1]);
        System.out.println(list[0][2]);
        System.out.println(list[1][0]);
        System.out.println(list[1][1]);
        System.out.println(list[1][2]);
        System.out.println(list[2][0]);
        System.out.println(list[2][1]);
        System.out.println(list[2][2]);

//code to change five of the values to positive
        list[0][2]= 9.12;
        list[2][1]= 7.3;
        list[2][0]= 5.2;
        list[1][0]= 4.8;
        list[1][2]= 3.9;


//and the other four to negative
        list[0][1]= -8.5;
        list[2][0]= -4.3;
        list[2][2]=-2.0;
        list[0][0]= -7.4;



//code to output a blank line separating output sets
        System.out.println();

        System.out.println(list);
//code to output all array elements
    }
}

