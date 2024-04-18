package net.online.school.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    // Прямоугольник с горизонтальными и вертикальными сторонами, задан двумя точками - левой верхней (xLeft, yTop)
    // и правой нижней (xRight, yBottom). На плоскости OXY ось X направлена вправо, ось Y - вниз.
    // Дана еще одна точка с координатами (x, y). Гарантируется, что xLeft < xRight и yTop < yBottom.
    // Метод должен возвращать true, если точка лежит внутри прямоугольника , иначе false.
    // Если точка лежит на границе прямоугольника, то считается, что она лежит внутри него.
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    //Возвращает сумму чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
    public int sum(int[] array) {
        int sum = 0;
        for(int elem : array) {
            sum += elem;
        }
        return sum;
    }

    //Возвращает произведение чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
    public int mul(int[] array) {
        if(array.length == 0) {
            return  0;
        }
        int mul = 1;
        for(int elem : array) {
            mul *= elem;
        }
        return mul;
    }

    //Возвращает минимальное из чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает Integer.MAX_VALUE.
    public int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int elem : array) {
            if(elem < min){
                min = elem;
            }
        }
        return  min;
    }

    //Возвращает максимальное из чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает Integer.MIN_VALUE.
    public int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int elem : array) {
            if(elem > max){
                max = elem;
            }
        }
        return  max;
    }

    //Возвращает среднее значение для чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
    public double average(int[] array) {
        double average = 0;
        if(array.length == 0) {
            return 0;
        }
        for(int elem : array) {
            average += elem;
        }
        return average / array.length;
    }

    //Возвращает true, если одномерный массив array строго упорядочен по убыванию, иначе false. Пустой одномерный массив считается упорядоченным.
    public boolean isSortedDescendant(int[] array) {
        if(array.length == 0 || array.length == 1) {
            return true;
        }
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]){
                return  false;
            }
        }
        return true;
    }

    //Возводит все элементы одномерного массива array в куб.
    public void cube(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    //Возвращает true, если в одномерном массиве array имеется элемент, равный value, иначе false.
    public boolean find(int[] array, int value) {
        for(int elem : array) {
            if(elem == value) {
                return  true;
            }
        }
        return  false;
    }

    //Переворачивает одномерный массив array, то есть меняет местами 0-й и последний, 1-й и предпоследний и т.д. элементы.
    public void reverse(int[] array) {
        int temp = 0;
        int count = array.length-1;
        for(int i = 0; i < array.length / 2; i ++) {
            temp = array[i];
            array[i] = array[count];
            array[count] = temp;
            count--;
        }
    }

    //Возвращает true, если одномерный массив является палиндромом, иначе false. Пустой массив считается палиндромом.
    public boolean isPalindrome(int[] array) {
        if(array.length == 0 || array.length == 1) {
            return true;
        }
        for(int i = 0; i < array.length / 2; i ++) {
            if(array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return  true;
    }

    //Возвращает сумму чисел, заданных двумерным массивом matrix.
    public int sum(int[][] matrix) {
        int sum = 0;
        for(int[] elem : matrix) {
            sum += sum(elem);
        }
        return sum;
    }

    //Возвращает максимальное из чисел, заданных двумерным массивом matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE.
    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int[] elem : matrix) {
            int temp = max(elem);
            if(max < temp){
                max = temp;
            }
        }
        return max;
    }

    //Возвращает максимальное из чисел, находящихся на главной диагонали квадратного двумерного массива matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE.
    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            if(max < matrix[i][i]){
                max = matrix[i][i];
            }
        }
        return max;
    }

    //Возвращает true, если все строки двумерного массива matrix строго упорядочены по убыванию, иначе false.
    // Пустая строка считается упорядоченной. Разные строки массива matrix могут иметь разное количество элементов.
    // При написании метода рекомендуется внутри него вызвать метод из п. 13.
    public boolean isSortedDescendant(int[][] matrix) {
        for(int[] elem : matrix) {
            if(!isSortedDescendant(elem)){
                return false;
            }
        }
        return true;
    }
}
