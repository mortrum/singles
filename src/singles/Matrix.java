package singles;

public class Matrix {
    public Box[][] matrix;

    Matrix(int[][] t){
        matrix = new Box[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (t[i][j] == 1){
                    matrix[i][j] = Box.NUM1;
                }
                if (t[i][j] == 2){
                    matrix[i][j] = Box.NUM2;
                }
                if (t[i][j] == 3){
                    matrix[i][j] = Box.NUM3;
                }
                if (t[i][j] == 4){
                    matrix[i][j] = Box.NUM4;
                }
                if (t[i][j] == 5){
                    matrix[i][j] = Box.NUM5;
                }
            }
        }


    }
    Box get(Coord coord) {
        if (Ranges.inRange(coord))
            return matrix[coord.x][coord.y];
        return null;
    }
    void set(Coord coord, Box box) {
        if (Ranges.inRange(coord))
            matrix[coord.x][coord.y] = box;
    }

}
