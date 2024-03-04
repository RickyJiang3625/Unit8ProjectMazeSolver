import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("data/maze1");
        System.out.println(solver(maze));

    }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }
    public static String solver(String[][] maze){
        String path="(0,0)--->";
        int endRow=maze.length-1;
        int endCol=maze[maze.length-1].length-1;
        int col=0;
        int row=0;

        while(col!=endCol || row!=endRow){

            if(col-1 >0 && maze[row][col-1].equals(".") && !maze[row][col-1].equals("X")){
                maze[row][col]="X";
                col=col-1;
                path+="("+row+","+col+")--->";

            }
            else if(col+1 < maze[0].length && maze[row][col+1].equals(".") && !maze[row][col+1].equals("X") ){
                maze[row][col]="X";
                col=col+1;
                path+="("+row+","+col+")--->";
            }

            else if(row-1>0 && maze[row-1][col].equals(".") && !maze[row-1][col].equals("X")){
                maze[row][col]="X";
                row = row - 1;
                path+="("+row+","+col+")--->";
            }


            else {
                maze[row][col]="X";
                row=row+1;
                path+="("+row+","+col+")--->";
            }


        }
        path=path.substring(0,path.length()-4);


        return path;
    }
}
