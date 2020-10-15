package typesofsort;


import java.util.Arrays;

public class Sort1 {


    public static void main(String[] args) {
        Sort1 s1 = new Sort1();
        int[] arrayIncrease = {1,2,3,4,5,6,7,8,9,10};
        int[] arrayRandom = {12,5,64,48,4,8,9,54,20,14,15};


        s1.printarray(arrayIncrease);
        //s1.bubbleSort(arrayRandom);
        s1.SelectionSort(arrayRandom);
    }

    private void printarray(int[] array) {
        for (int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    private void swap(int[] array, int ind1, int ind2){
        // 1><2
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
    //Bubble
    private void bubbleSort(int[] array){
        boolean needIteraration = true;
        while(needIteraration){
            needIteraration = false;
            for(int i = 1; i<array.length; i++){
                if (array[i]<array[i-1]){
                    swap(array,i,i-1);
                    needIteraration = true;
                }

            }
        }
        System.out.println("Bubble Sort: " +Arrays.toString(array));

    }
    //Selection
    private void SelectionSort(int[] array){
         for (int i = 0; i<array.length; i++){
             int minId = i;
             for (int a = i; a<array.length; a++){
                 if (array[a] < array[minId]){
                     minId = a;
                 }
             }
             swap(array,i,minId);
         }
        System.out.println("Selection sort: "+Arrays.toString(array));
    }


}
