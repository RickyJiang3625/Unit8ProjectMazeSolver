import java.util.ArrayList;
public class Maze {
    private int currentCol;
    private int currentRow;
    private String[][] maze;
    public Maze(String[][] m){
        maze=m;
    }

    private boolean validLeft(){
        if(currentCol-1>=0 && maze[currentRow][currentCol-1].equals(".") ){
            return true;
        }
        else{
            return false;
        }

    }
    private boolean validRight(){
        if(currentCol+1< maze[0].length && maze[currentRow][currentCol+1].equals(".")){
            return true;
        }
        else{
            return false;
        }

    }
    private boolean validUp(){
        if(currentRow-1>0 && maze[currentRow-1][currentCol].equals(".") ){
            return true;
        }
        else{
            return false;
        }

    }
    private boolean validDown(){
        if(currentRow+1< maze.length && maze[currentRow+1][currentCol].equals(".") ){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean deadEnd(){
        if(!validDown() && !validUp() && !validLeft() && !validRight()){
        return true;
        }
        else{
            return false;
        }
    }
    public String solve() {
        String path = "(0,0)--->";
        int endCol= maze[0].length-1;
        int endRow= maze.length-1;
        maze[currentRow][currentCol] = ">";
        while (currentCol != endCol || currentRow != endRow) {
            if (validLeft()) {
                currentCol = currentCol - 1;
                maze[currentRow][currentCol] = ">";

                path += "(" + currentRow + "," + currentCol + ")--->";

            } else if (validRight()) {

                currentCol = currentCol + 1;
                maze[currentRow][currentCol] = ">";
                path += "(" + currentRow + "," + currentCol + ")--->";
            } else if (validUp()) {

                currentRow = currentRow - 1;
                maze[currentRow][currentCol] = ">";
                path += "(" + currentRow + "," + currentCol + ")--->";
            } else if(validDown()){

                currentRow = currentRow + 1;
                maze[currentRow][currentCol] = ">";
                path += "(" + currentRow + "," + currentCol + ")--->";
            }
            if(deadEnd()) {
               maze[currentRow][currentCol]="X";
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        if (maze[i][j].equals(">")) {
                            maze[i][j] = ".";
                        }
                    }
                }
                currentCol = 0;
                currentRow = 0;
                path = "(0,0)--->";

            }
           System.out.println();
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println();


            }

        }
        path = path.substring(0, path.length() - 4);
        return path;}}