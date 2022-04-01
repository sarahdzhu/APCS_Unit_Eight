import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer
{

    private int[][] grid;

    public MapDataDrawer(String filename, int rows, int cols) throws FileNotFoundException {
        Scanner scan= new Scanner(new File(filename));
        grid= new int [rows][cols];
        for(int row=0; row< rows; row++){
            for(int col=0; col< cols; col++){
                grid[row][col]= scan.nextInt();
            }
        }


        // initialize grid
        //read the data from the file into the grid
        //nested loops

    }

    /**
     * @return the min value in the entire grid
     */
    public int findMinValue() {
        int min = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < min) {
                    min = grid[i][j];
                }
            }
        }
        return min;
    }
    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue() {
        int max = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public int indexOfMinInCol(int col){
        int minCol= grid[0][col];
        int minIndex=0;
        for(int i=0; i< grid.length; i++ ) {
            if (grid[i][col] < minCol) {

                minCol = grid[i][col];


                minIndex = i;
            }
        }

        return minIndex;
    }

    public void drawMap(Graphics g){
        for(int row=0; row<grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int pix = grid[row][col];
                double newPix= (double)(pix)-1099;
                int newMax= 4334-1099;
                int c= (int)((newPix/newMax)*255);
                g.setColor(new Color(c, c, c));
                g.fillRect(col,row,1,1);


            }


        }
    }






    public int drawLowestElevPath(Graphics g, int row){
        int currentRow = row;
        int elevation = 0;
        g.fillRect(0, row, 1, 1);
        for (int col = 1; col < grid[0].length; col++) {
            int current = grid[currentRow][col - 1];

            if (currentRow == 0) {
                int forward = grid[currentRow][col];
                int down = grid[currentRow + 1][col];
                if (Math.abs(current - forward) < Math.abs(current - down)) {
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - forward);
                }
                else if (Math.abs(current - down) < Math.abs(current - forward)) {
                    currentRow+=1;
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - down);
                }
                else {
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - forward);
                }
            }
            else if (currentRow < grid.length-1) {
                int forward = grid[currentRow][col];
                int up = grid[currentRow - 1][col];
                int down = grid[currentRow + 1][col];
                if (Math.abs(current - forward) < Math.abs(current - up) && Math.abs(current - forward) < Math.abs(current - down)) {
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - forward);
                }
                else if (Math.abs(current - up) < Math.abs(current - forward) && Math.abs(current - up) < Math.abs(current - down)) {
                    currentRow-=1;
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - up);
                }
                else if (Math.abs(current - down) < Math.abs(current - up) && Math.abs(current - down) < Math.abs(current - forward)) {
                    currentRow+=1;
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - down);
                }
                else {
                    if (Math.abs(current - forward) == Math.abs(current - up) || Math.abs(current - forward) == Math.abs(current - down)) {
                        g.fillRect(col, currentRow, 1, 1);
                        elevation+= Math.abs(current - forward);
                    }
                    else {
                        int flip = (int)(Math.random() * 2) + 1;
                        if (flip == 1) {
                            currentRow+=1;
                            g.fillRect(col, currentRow, 1, 1);
                            elevation+= Math.abs(current - down);
                        }
                        else {
                            currentRow-=1;
                            g.fillRect(col, currentRow, 1, 1);
                            elevation+= Math.abs(current - up);
                        }
                    }
                }
            }
            else {
                int forward = grid[currentRow][col];
                int up = grid[currentRow - 1][col];
                if (Math.abs(current - forward) < Math.abs(current - up)) {
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - forward);
                }
                else if (Math.abs(current - up) < Math.abs(current - forward)) {
                    currentRow-=1;
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - up);
                }
                else {
                    g.fillRect(col, currentRow, 1, 1);
                    elevation+= Math.abs(current - forward);
                }
            }
        }
        return elevation;
    }
    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */


    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        int value = drawLowestElevPath(g, 0);
        int index = 0;
        int temp = 0;
        for (int row = 1; row < grid.length-1; row++) {
            if (drawLowestElevPath(g, row) < drawLowestElevPath(g, (row+1))) {
                temp = drawLowestElevPath(g, row);
                if(temp<value) {
                    value = temp;
                    index = row;
                }
            }
            else if (drawLowestElevPath(g, row) > drawLowestElevPath(g, (row+1))) {
                temp = drawLowestElevPath(g, (row + 1));
                if(temp<value) {
                    value = temp;
                    index = row;
                }
            }
        }
        return index;
    }
}