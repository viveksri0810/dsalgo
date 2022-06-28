import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        impleheapsort();
    }

    static void pattern20(){
        int n=4;
        for(int i=1;i<=n;i++){
            int k=i;
            for(int j=n;j>0;j--){
                if(j>i){
                    System.out.print(" ");
                }else {
                    System.out.print(k);
                    k++;
                }
            }
            System.out.println();
        }
    }


    static void findCharIsUpperCaseOrLowerCase(){
       String rex1="[a-z]";
       String rex2="[A-Z]";
       String s="p";

        Pattern pattern=Pattern.compile(rex1);
        Matcher matcher=pattern.matcher(s);
        boolean b=matcher.matches();

        Pattern pattern1= Pattern.compile(rex1);
        Matcher matcher1=pattern1.matcher(s);
        boolean b1=matcher1.matches();

        if(b1){

            System.out.println(1);
        }
        else if(b){

            System.out.println(0);
        }
        else{
            System.out.println(-1);
        }
    }

    //implementing heap sort
    static void impleheapsort(){
        int[] arr ={60,60,-1,-1,-1,-1,10,20,15,30,15,1,30,40};
        for(int l= arr.length-1;l>0;l--){
            maxheap(arr,l);
            int temp=arr[0];
            arr[0]=arr[l];
            arr[l]=temp;
        }

        Arrays.stream(arr).forEach(a-> System.out.print(a + " "));

    }


    static void maxheap(int [] arr,int len){


        for(int i=1;i<=len;i++){

            int index=i;

            while(index>0  && arr[index]>arr[(index-1)/2]){
                int temp=arr[index];
                arr[index]=arr[(index-1)/2];
                arr[(index-1)/2]=temp;
                index=(index-1)/2;
            }
        }


        Arrays.stream(arr).forEach(a-> System.out.print(a + " "));
        System.out.println();
    }


    static void adjustheap(int[] arr,int index,int len) {
        int indexRight = 0;
        if (index < len) {
            int indexLeft = 2 * index + 1;
            indexRight = 2 * index + 2;
            int temp;
            if (indexLeft <= len && indexRight <= len) {
                if (arr[indexLeft] > arr[indexRight]) {
                    temp = indexLeft;
                } else {
                    temp = indexRight;
                }
            } else if (indexRight >= len) {
                temp = indexLeft;
            } else {
                temp = index;
            }

            if (arr[index] < arr[temp]) {
                int temp2 = arr[index];
                arr[index] = arr[temp];
                arr[temp] = temp2;
            }

            adjustheap(arr, temp, len);
        }


        while (indexRight < arr.length) {
            int indexLeft=0;
            int temp;
            if (arr[indexLeft] > arr[indexRight]) {
                temp = indexLeft;
            } else {
                temp = indexRight;
            }
            while (arr[index] < arr[temp]) {
                int temp2 = arr[index];
                arr[index] = arr[temp];
                arr[temp] = temp2;
                index = temp;
            }
            indexRight = 2 * index + 2;
        }
    }


    static void quickSortImpl(){
        int[] arr = {3,5,2,13,14};
        int low=0;
        int high=arr.length-1;
        quickSort(arr,low,high);

        Arrays.stream(arr).forEach(a-> System.out.print(a+" "));
    }

    static void quickSort(int [] arr,int low,int high){
        int partionIndex;
        if(low<high){
            partionIndex=partioning(arr,low,high);
            quickSort(arr,low,partionIndex-1);
            quickSort(arr,partionIndex+1,high);
        }
    }

    static int partioning(int[] arr,int low,int high){
        int pivot=arr[low];
        int i=low+1;
        int j=high;
        while (i<j){
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        Arrays.stream(arr).forEach(a-> System.out.print(a+" "));
        System.out.println();
        return j;
    }


    static void partition(){
        int[] arr = {161,152,153,156,161,175,154,180,178};

        int i=1;
        int j=arr.length-1;
        while(j>i) {

            while (arr[i] <= arr[0]) {
                i++;
            }
            while (arr[j] >= arr[0]) {
                j--;
            }

            int temp;
            if (j < i) {
                temp = arr[0];
                arr[0] = arr[j];
            }else {
                temp = arr[i];
                arr[i]=arr[j];
            }
            arr[j] = temp;
        }

        Arrays.stream(arr).forEach(a-> System.out.print(a+ " "));
    }


    static void mergesortexecute(){
        int[] arr = {1, 4, 6, 7, 5,2, 3, 4, 5};
//        int mid = 3;
        int low = 0;
        int high = arr.length-1;
        mergesort(arr, low, high);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }



    static void mergesort(int[] arr,int low,int high){
        if(low<high){
            int mid =(low+high)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }


    static void merge(int @NotNull [] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid & j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid || j <= high) {

            if (i <= mid) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        System.arraycopy(temp, low,arr,low,high+1-low);

    }


    static void merging3() {
        int[] arr = {1, 4, 6, 7, 2, 3, 4, 5};
        int mid = 3;
        int low = 1;
        int high = 6;

        int i = low;
        int j = mid + 1;
        int k = low;

        int[] temp = new int[high + 1];

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid || j <= high) {
            if (i <= mid) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        System.arraycopy(temp, low, arr, low, high + 1 - low);

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

    }

    static void merging2() {
        int[] arr = {6, 8, 9, 13, 22, 2, 4, 5, 6, 7, 8};
        int[] temp = new int[arr.length];
        int mid = 0;
        while (arr[mid + 1] > arr[mid]) {
            mid++;
        }
        int j = mid + 1;
        int high = arr.length - 1;
        int low = 0;
        int k = 0;

        while (low <= mid && j <= high) {
            if (arr[low] < arr[j]) {
                temp[k] = arr[low];
                low++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (low <= mid || j <= high) {

            if (low <= mid) {
                temp[k] = arr[low];
                low++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        Arrays.stream(temp).forEach(a -> System.out.print(a + " "));


    }


    static void merging1() {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8};

        int m = arr1.length;
        int n = arr2.length;
        int[] newarr = new int[m + n];

        int i, j, k;
        i = j = k = 0;


        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                newarr[k] = arr1[i];
                i++;
            } else {
                newarr[k] = arr2[j];
                j++;
            }
            k++;
        }


        while (i < m || j < n) {
            if (i < m) {
                newarr[k] = arr1[i];
                i++;
            } else {
                newarr[k] = arr1[j];
                j++;
            }
            k++;
        }

        Arrays.stream(newarr).forEach(a -> System.out.print(a + " "));

    }

    static void merging() {
        int[] arr = {7, 9, 18, 19, 22, 23, 24, 1, 6, 9, 11, 15, 17, 18, 19};
        int[] temp = new int[arr.length];


        int first = 0;
        int tempmiddle = 6; //arr.length/2;
        int middle = 6; //arr.length/2; //4
        int last = arr.length - 1;
        int j = 0;
        while (middle + 1 <= last) {
            if (arr[first] <= arr[middle + 1]) {
                temp[j] = arr[first];
                first++;
            } else {
                temp[j] = arr[middle + 1];
                middle++;
            }
            j++;
        }
        while (first <= tempmiddle) {
            temp[j] = arr[first];
            first++;
            j++;
        }


        Arrays.stream(temp).forEach(a -> System.out.print(a + " "));
    }


    static void insertionsortforstring() {

        String[] names = {"deepak", "vivek", "nanay", "manjula", "abhjit", "vivek0"};

        for (int i = 1; i < names.length; i++) {
            String temp = names[i];
            int index = i;

            for (int j = i - 1; j >= 0; j--) {
                if (temp.compareTo(names[j]) < 0) {
                    names[index] = names[j];
                    index--;
                } else {
                    break;
                }
            }

            names[index] = temp;
        }

        Arrays.stream(names).forEach(a -> System.out.print(a + " "));

    }


    static void insertionsort() {


        int[] arr = {5, 1, 6, 2, 4};
        int l = arr.length;

        for (int i = 1; i < l; i++) {

            int temp = arr[i];
            int index = i;

            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) {
                    arr[index] = arr[j];
                    index--;
                } else {
                    break;
                }
            }
            arr[index] = temp;
        }

        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

    static void selectionsort() {

        int[] arr = {38, 52, 9, 2, 2, 2, 2, 2, 18, 3, 3, 3, 3, 6, 1, 62, 13};

        for (int i = arr.length - 1; i > 1; i--) {

            //for fidning max num
            int l = 0;
            for (int j = 1; j < i; j++) {
                if (arr[l] < arr[j]) {
                    l = j;
                }
            }

            if (arr[i] < arr[l]) {
                int temp = arr[i];
                arr[i] = arr[l];
                arr[l] = temp;
            }

            for (int a : arr) System.out.print(a + " ");
            System.out.println();
        }


    }


    static void bubblesortstring() {

        String[] names = {"deepak", "vivek", "nanay", "manjula", "abhjit", "vivek0"};


        for (int i = 0; i < names.length; i++) {
            boolean flag = false;
            for (int j = 0; j < names.length - 1 - i; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (String str : names) {
            System.out.print(str + " ");
        }


    }


    static void bubblesort() {

        int[] arr = {36, 19, 29, 12, 5};
        for (int i = 0; i < arr.length; i++) {
            boolean bol = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    bol = true;
                }
            }

            if (!bol) {
                break;
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


    static void sortting() {
        int[] arr = {2, 4, 5, 3, 9, 6};
        Arrays.sort(arr);
        for (int ar : arr) System.out.println(ar);

    }


    static void print3darrayusigwhileloop() {
        int[][][] arr = {{{1, 2, 3, 4}, {1,}}, {{3, 4, 5}, {0, 0, 0}}};


        for (int[][] a1 : arr) {
            for (int[] a2 : a1) {
                for (int a : a2) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
    }


    static void print3darray() {

        int[][][] a = {{{1, 2, 3}}, {{4, 5, 6}}};

        for (int[][] ints : a) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.println(i + " ");
                }
            }
        }
    }


    static void pattern123(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= 3; j++) {
                    count = count + 1;
                    System.out.print(count + " ");
                }
            } else {
                int temp = count;
                for (int j = count + 3; j > temp; j--) {
                    count = count + 1;
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    static void pattern122(int n) {
        int a = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n / 2 + 1); j++) {
                System.out.print(a);
                if (i % 2 == 0) {
                    a--;
                } else {
                    a++;
                }
            }
            if (i % 2 != 0) {
                a += n / 2;
            } else {
                a += (n / 2) + 2;
            }
            System.out.println();
        }
    }

    static void pattern121(int n) {
        for (int i = 1; i <= n; i++) {
//            int a=n-1;
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num = num + n - j;
//                a--;
            }
            System.out.println();

        }

    }

    static void pattern120(int n) {


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void pattern119(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i + j == n + 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void pattern118(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 2 * n; j++) {
                if (j == i || j == (2 * n) - i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();

        }
    }

    static void pattern117(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j < i * 2; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }


    }


    static void pattern116(int n) {
        int m = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }


            m -= 2;

            System.out.println();
        }
    }


    static void pattern115(int n) {
        int a = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= a; j++) {
                System.out.print("* ");
            }
            a += 2;
            System.out.println();
        }
    }

    static void pattern114(int n) {

        int a = n - 1;
        int b = 1;

        for (int i = 1; i <= 2 * n - 1; i++) {

            for (int j = 1; j <= a; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= b; j++) {
                System.out.print("* ");
            }

            if (i < n) {
                a--;
                b++;
            } else {
                a++;
                b--;
            }
            System.out.println();

        }


    }


    static void pattern113(int n) {
        int a = 1;
        for (int i = 1; i <= (n + (n - 1)); i++) {

            for (int j = 1; j <= a; j++) {
                System.out.print("* ");
            }
            if (i < n) {
                a++;
            } else {
                a--;
            }
            System.out.println();
        }

    }

    static void pattern112(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern111(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void armstrongno(int n) {
        int temp = n;
        int sum = 0;
        int length = 0;
        int temp2 = n;
        while (temp2 > 0) {
            temp2 = temp2 / 10;
            length++;
        }


        while (temp > 0) {
            int c = temp % 10;
            sum = sum + (int) Math.pow(c, length);
            temp /= 10;
        }

        if (n == sum) {
            System.out.print(n + " ");
        }

    }


    static void greaterOfThreeNum2(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                System.out.println("a is greater.");
            } else {
                System.out.println("c is greater.");
            }
        } else {
            if (b > c) {
                System.out.println("b is greater.");
            } else {
                System.out.println("c is greater.");
            }
        }
    }

    static void greaterOfThreeNum(int a, int b, int c) {
        if (a > b && a > c) {
            System.out.println(a + " is greater.");
        } else if (b > c && b > a) {
            System.out.println(b + " is greater.");
        } else {
            System.out.println(c + " is greater.");
        }
    }


    static void greateroftwonum(int a, int b) {
        if (a > b) {
            System.out.println(a + " is greater.");
        } else {
            System.out.println(b + " is greater.");
        }
    }


    static void add(int a, int b) {
        int c = a * b;
        System.out.println(c);
    }


    static void pattern15(int n) {

        int fs = n / 2;
        int ss = 1;
        for (int i = 1; i <= n; i++) {
            int a = i;

            for (int j = 1; j <= fs; j++) {
                System.out.print(". ");
            }

            for (int j = 1; j <= ss; j++) {
                System.out.print(a + " ");
                if (j <= ss / 2) {
                    a++;
                } else {
                    a--;
                }
            }


            if (i <= n / 2) {
                fs--;
                ss += 2;
            } else {
                fs++;
                ss -= 2;
            }

            System.out.println();
        }
    }

    static void table14(int n) {

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " * " + n + " = " + i * n);
        }
    }


    static void pattern13(int n) {
        for (int i = 0; i < n; i++) {
            int comb = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(comb + "\t");
                comb = comb * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    static void pattern12(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                int c = a + b;
                a = b;
                b = c;
            }
            System.out.println();
        }
    }

    static void pattern11(int n) {
        int m = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" " + m);
                m++;
            }
            System.out.println();
        }

    }

    static int recursivefactorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * recursivefactorial(num - 1);

    }

    static void iteratingfact(int num) {
        //54321
        int fact = num;
        if (num == 0) {
            System.out.println(fact);
            return;
        }
        while (num > 1) {
            fact = fact * (num - 1);
            num--;
        }

        System.out.println("factorial : " + fact);
    }


// she'll short


    static void shellsort(int[] arr) {
        int a = 0;
        int l = arr.length - 1;
        for (int i = (l + 1) / 2; i > 0; i = i / 2) {
            for (int j = i; j <= l; j++) {
                int unsortedarraystarting = arr[j];
                int k = j;
                for (int m = j - i; m >= 0 && arr[m] > unsortedarraystarting; m = m - i) {
                    arr[k] = arr[m];
                    k = k - i;
                    a++;
                }
                arr[k] = unsortedarraystarting;
            }
        }
        System.out.println(a);
    }


    static void shellsort2(int[] intArray) {
        int a = 0;
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                    a++;
                }
                intArray[j] = newElement;
            }
        }
        System.out.println(a);
    }


//insertion shot

    static void insertionsort(int[] arr) {
        int a = 0;
        int l = arr.length - 1;
        for (int i = 1; i <= l; i++) {
            int temp = arr[i];
            int n = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[n] = arr[j];
                    n--;
                }
                a++;
            }
            arr[n] = temp;
        }
        System.out.println(a);
    }

    static int[] bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr.length - j - 1; k++) {
                int temp;
                if (arr[k] > arr[k + 1]) {
                    temp = arr[k + 1];
                    arr[k + 1] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        return arr;
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[temp] < arr[j]) {
                    temp = j;
                }
            }
            int temp1 = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[temp];
            arr[temp] = temp1;
        }
        return arr;
    }


    static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//########brut force
//        boolean bol=false;
//
//        for (int i=0;i< intArray.length;i++){  //O(n)
//            for(int j=1+i;j< intArray.length;j++){  // O(n)
//                if(intArray[i]+intArray[j]==8) { //O(1)
//                    bol = true;  // O(1)
//                }
//            }
//            if(bol==true){ //0(1)
//                break;
//            }
//        }
//        System.out.println(bol);  // time complexity 0(1)

//########optimizing

//        boolean bol1=false;
//        int start=0;
//        int end= intArray.length-1;
//        while (start<end){
//            if(intArray[start]+intArray[end]==8){
//                bol1=true;
//                break;
//            } else if (intArray[start]+intArray[end]<8){
//                start++;
//            }else {
//                end--;
//            }
//        }
//        System.out.println(bol1);

//####appliying bubble sort


}
