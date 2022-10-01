package it.unibo.arrays;

class MyCircularArray {

    int[] array;
    private static int count; //index to go through the circular array

    MyCircularArray() {
        array = new int[10];
    }

    MyCircularArray(int size) {
        array = new int[size];
    }

    void add(final int elem) {
        array[count % array.length] = elem;             //Starts back from the beginning of the array if count is greater than the array length
        count++;
    }

    void reset() {
        for (int i = 0; i < array.length; i++) {       //Empty the array
            array[i] = 0;
        }
        count = 0;                                      //Reset the index
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.println(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {

        // 1) Creare un array circolare di dieci elementi
        MyCircularArray cArray = new MyCircularArray();
        // 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
        // dell'array circolare
        for (int i = 1; i <= 10; i++) {
            cArray.add(i);
        }
        cArray.printArray();
        // 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
        // dell'array circolare
        for (int i = 11; i <= 15; i++) {
            cArray.add(i);
        }
        cArray.printArray();
        // 4) Invocare il metodo reset
        cArray.reset();
        // 5) Stampare il contenuto dell'array circolare
        cArray.printArray();
        // 6) Aggiungere altri elementi a piacere e stampare il contenuto
        // dell'array circolare
        for (int i = 1; i <= 10; i++) {
            cArray.add(i);
        }
        cArray.printArray();
    }
}
