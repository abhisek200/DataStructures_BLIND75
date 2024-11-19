package com.abpanda.OneDimensionalArrays;

public class SingleDimensionalArray {
    int arr[];
    public SingleDimensionalArray(int arrLength){
        arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.MIN_VALUE;
        }
    }
    public void insert(int location, int insertValue){
        try{
            if(arr[location]==Integer.MIN_VALUE){
                arr[location]=insertValue;
                System.out.println("Value inserted in the given location!");
            }
            else {
                System.out.println("Some Value already present at the index!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You are off limits from ArrayLength !");
        }
    }

    public void traversalArray(){
        try{
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
        }catch (Exception e){
            System.out.println("Array No Longer Exists.");
        }
    }

    public void searchInArray(int valueToSearch){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==valueToSearch){
                System.out.println("Value matched in Array : "+arr[i]);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found.");
    }

    public void deleteElement(int indexInput){
        try{
            arr[indexInput] = Integer.MIN_VALUE;
            System.out.println("Value has been deleted successfully!");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The index is out of array!!");
        }
    }
}
