//import com.sun.deploy.util.ArrayUtil;
//
//import javax.lang.model.type.PrimitiveType;
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Random;
//
///**
// * Created by garthtee on 2/11/16.
// */
//public class testing {
//
//    private static int bubbleOrgSwaps, bubbleEnhSwaps, selectionSwaps, insertionSwaps = 0;
//    private static int bubbleOrgCount, bubbleEnhCount, selectionCount, insertionCount = 0;
//
//
//    public static void main(String [] args) {
//
//        int[] list = new int[]{1,2,3};
//        // bubble original swaps and counts
////        getBubbleSortAlgorithmOriginal(list);
////
////        System.out.println(bubbleOrgCount);
////        System.out.println(bubbleOrgSwaps);
//
//       // bubble original swaps and counts
//
//
////        getSelectionSortAlgorithm(list);
////        System.out.println("Selection count = " + selectionCount);
////        System.out.println("Selection swaps = " + selectionSwaps);
//        getInsertionSortAlgorithm(list);
//        System.out.println("Insertion count = " + insertionCount);
//        System.out.println("Insertion swaps = " + insertionSwaps);
//
//
//
//
//    }
//
//    static int[] getBubbleSortAlgorithmOriginal(int[] list) {
//        int temp;
//        for(int i = 0; i < list.length-1; i++){
//            bubbleOrgCount++; //
//            for(int j = 0; j < list.length-1; j++){
//                if(list[j] > list[j+1]){
//                    temp = list[j];
//                    list[j] = list[j+1];
//                    list[j+1] = temp;
//                    bubbleOrgSwaps++; //
//                }
//            }
//        }
//        return list;
//    }
//
//    static int[] getBubbleSortAlgorithmEnhanced(int[] list) {
//        int temp;
//        boolean sorted = false;
//        for(int i = 0; i < list.length-1 && !sorted; i++){ // "&& !sorted" : End if the array is sorted
//            sorted = true;
//            for(int j = 0; j < list.length-1-i; j++)	{
//                bubbleEnhCount++; //
//                if(list[j] > list[j+1]){
//                    temp = list[j];
//                    list[j] = list[j+1];
//                    list[j+1] = temp;
//                    sorted = false; // If a swap occurs, the array wasn't sorted
//                    bubbleEnhSwaps++; //
//
//                }
//            }
//        }
//        return list;
//    }
//
//    static int[] getSelectionSortAlgorithm(int[] list) {
//        for (int i = 0; i < list.length - 1; i++)      // start at the beginning of the whole array
//        {
//            selectionCount++; //
////            System.out.println("i is: " + i);
//            int minimum = i;    // (1) default value of the 1st element index � use this to test against every other element.
//            for (int j = i + 1; j < list.length; j++)      // (2) loop from the beginning of unsorted zone to the end of the array.
//            {
//
//                if (list[j] < list[minimum]){   // compare current element to minimum
//                    minimum = j;    // if it's lower, it becomes the new minimum
//                    selectionSwaps++; //
//                }
//            }
//
//            // swap the two values
//
//            int temp = list[i];
//            list[i] = list[minimum];
//            list[minimum] = temp;
//
//        }
//        return list;
//
//    }
//
//    static int[] getInsertionSortAlgorithm(int[] list) {
//        for (int i = 1; i < list.length; i++) {
//            insertionCount++; //
//            int next = list[i];
//            // find the insertion location while moving all larger element up
//            int j = i;
//            while (j > 0 && list[j - 1] > next) {
//                list[j] = list[j - 1];
//                j--;
//                insertionSwaps++; //
//            }
//            // insert the element
//            list[j] = next;
//        }
//        return list;
//    }
//}
