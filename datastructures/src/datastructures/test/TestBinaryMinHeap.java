package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.heap.BinaryHeap;
import datastructures.heap.BinaryMinHeap;
import datastructures.util.InputUtil;

public class TestBinaryMinHeap {

  BinaryHeap<Integer> binaryMinHeap;

  public TestBinaryMinHeap() {
    binaryMinHeap = new BinaryMinHeap<Integer>(Integer.class);
  }

  private void buildMinHeap(String[] input) {
    for (String line : input) {
      if (line.startsWith("insert")) {
        String[] values = line.split(" ")[1].split(":");
        if (values.length == 1) {
          System.out.println("Inserting " + values[0] + " into Min Heap");
        } else {
          System.out.println("Inserting bunch of values into Min Heap");
        }
        for (String value : values) {
          binaryMinHeap.insert(Integer.parseInt(value));
        }
      } else if (line.startsWith("buildHeap")) {
        String[] values = line.split(" ")[1].split(":");
        System.out.println("Building a MinHeap from Unsorted Array");
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
        binaryMinHeap.buildHeap(arr);
      } else if (line.startsWith("peek")) {
        System.out.println("Mininum from Heap: " + binaryMinHeap.peek());
      } else if (line.startsWith("extractAll")) {
        int size = binaryMinHeap.size();
        System.out.println("Extract Min From Heap for n times: ");
        for (int i = 0; i < size; i++) {
          System.out.print(binaryMinHeap.extract() + " ");
        }
        System.out.println("\n");
      } else if (line.startsWith("extract")) {
        System.out.println("Extract Min From Heap: " + binaryMinHeap.extract());
      } else if (line.startsWith("print")) {
        binaryMinHeap.print();
      } else if (line.startsWith("sort")) {
        String[] values = line.split(" ")[1].split(":");
        Integer[] arr = new Integer[values.length];
        System.out.print("Sorting Array: [ ");
        for (int i = 0; i < values.length; i++) {
          System.out.print(values[i] + " ");
          arr[i] = Integer.parseInt(values[i]);
        }
        System.out.println("] (In Reverse)");
        binaryMinHeap.sort(arr);
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    TestBinaryMinHeap testBinaryMinHeap = new TestBinaryMinHeap();
    String[] input = InputUtil.readContents("test_binary_heap");
    testBinaryMinHeap.buildMinHeap(input);
  }
}
