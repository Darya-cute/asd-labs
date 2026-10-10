// Разреженные матрицы
// Вариант 27
// Задача 27. Дана разреженная квадратная матрица(CRS). Повернуть матрицу на 180 градусов.

public class Main {
    public static void main (String[] args){
        int N = 3;

        int[] values = {1, 7, 3, 9}; // ненулевые значения слева-направо, сверху-вниз
        int[] colIndex = {0, 2, 0, 2}; // для каждого значения values - номер столбца
        int[] rowPtr = {0, 2, 2, 4}; // индекс для каждой строки values, последний - кол-во всех ненулевых эл-тов
        
        System.out.println("Было:");
        printCRS(N, values, colIndex, rowPtr);
        System.out.println();

        System.out.println("Стало:");
        int[][] rotated = rotate180(N, values, colIndex, rowPtr);
        printCRS(N, rotated[0], rotated[1], rotated[2]);   
    }
    public static void printCRS(int N, int[] values, int[] colIndex, int[] rowPtr) {
        for (int i=0; i < N; i++) {
            int start = rowPtr[i];
            int end = rowPtr[i+1];
            for (int j = 0; j < N; j++) {
                boolean found = false;
                for (int k = start; k < end; k++) {
                    if (colIndex[k] == j) {
                        System.out.print(values[k] + " ");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static int getValue(int[] values, int[] colIndex, int[] rowPtr, int i, int j) {        
        int start = rowPtr[i];
        int end = rowPtr[i+1];
        for (int k = start; k < end; k++) {
            if (colIndex[k] == j) {
                return values[k];
            }
        }
        return 0;
    }
    public static int[][] rotate180(int N, int[] values, int[] colIndex, int[] rowPtr) {
        int[] newValues   = new int[values.length];
        int[] newColIndex = new int[colIndex.length];
        int[] newRowPtr   = new int[N + 1];
        int pos = 0; // счетчик ненулевых записанных
        newRowPtr[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = getValue(values, colIndex, rowPtr, N - 1 - i, N - 1 - j); // новая переменная
                if (value != 0) {
                    newValues[pos] = value;
                    newColIndex[pos] = j;
                    pos++;
                }
            }
            newRowPtr[i + 1] = pos;
        }
        return new int[][] { newValues, newColIndex, newRowPtr };
    }
}
