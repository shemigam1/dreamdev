package week1.day3;

public class ThreeByThree{
     static void main(String... args){
        char[][] matrix = {{'X', 'O', 'X'}, {'O', 'O', 'X'}, {'X', 'X', 'O'}};

        for (char[]row : matrix) {
            for (int ch : row){
                if (Character.toUpperCase(ch) == 'X') {
                    System.out.print('1');
                }else if (Character.toUpperCase(ch) == 'O'){
                    System.out.print('0');
                } else System.out.print('#');
            }
            System.out.println();
        }
    }
}