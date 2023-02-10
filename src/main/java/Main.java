import java.util.Arrays;

public class Main {

    // сложность O (n log n) - квазилинейная

    public static void main(String[] args) {
        int[] sortArray = sortingArray(new int[]{5000, 200, 23, 24, 2, 75, 76, 20, 35, 900, 3000, 2200, 10, 2400, 2500});
        int[] result = sortingArray(sortArray);
        System.out.println(Arrays.toString(result));

    }

    public static int[] sortingArray(int[] sortArray) {
        int[] a1 = Arrays.copyOf(sortArray, sortArray.length);
        int[] a2 = new int[sortArray.length];
        int[] a3 = mergeSort(a1, a2, 0, sortArray.length);
        return a3;
    }

    public static int[] mergeSort(int[] a1, int[] a2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return a1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort(a1, a2, startIndex, middle);
        int[] sorted2 = mergeSort(a1, a2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == a1 ? a2 : a1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
