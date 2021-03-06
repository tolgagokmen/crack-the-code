package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.heap.BinaryHeap;
import datastructures.heap.BinaryMaxHeap;
import datastructures.util.InputUtil;

public class TestBinaryMaxHeap {

  BinaryHeap<Integer> binaryMaxHeap;

  public TestBinaryMaxHeap() {
    binaryMaxHeap = new BinaryMaxHeap<Integer>(Integer.class);
  }

  private void buildMaxHeap(String[] input) {
    for (String line : input) {
      if (line.startsWith("insert")) {
        String[] values = line.split(" ")[1].split(":");
        if (values.length == 1) {
          System.out.println("Inserting " + values[0] + " into Max Heap");
        } else {
          System.out.println("Inserting bunch of values into Max Heap");
        }
        for (String value : values) {
          binaryMaxHeap.insert(Integer.parseInt(value));
        }
      } else if (line.startsWith("buildHeap")) {
        String[] values = line.split(" ")[1].split(":");
        System.out.println("Building a MaxHeap from Unsorted Array");
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
        binaryMaxHeap.buildHeap(arr);
      } else if (line.startsWith("peek")) {
        System.out.println("Maximum from Heap: " + binaryMaxHeap.peek());
      } else if (line.startsWith("extractAll")) {
        int size = binaryMaxHeap.size();
        System.out.println("Extract Max From Heap for n times: ");
        for (int i = 0; i < size; i++) {
          System.out.print(binaryMaxHeap.extract() + " ");
        }
        System.out.println("\n");
      } else if (line.startsWith("extract")) {
        System.out.println("Extract Max From Heap: " + binaryMaxHeap.extract());
      } else if (line.startsWith("print")) {
        binaryMaxHeap.print();
      } else if (line.startsWith("sort")) {
        String[] values = line.split(" ")[1].split(":");
        Integer[] arr = new Integer[values.length];
        System.out.print("Sorting Array: [ ");
        for (int i = 0; i < values.length; i++) {
          System.out.print(values[i] + " ");
          arr[i] = Integer.parseInt(values[i]);
        }
        System.out.println("]");
        binaryMaxHeap.sort(arr);
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    TestBinaryMaxHeap testBinaryMaxHeap = new TestBinaryMaxHeap();
    String[] input = InputUtil.readContents("test_binary_heap");
    testBinaryMaxHeap.buildMaxHeap(input);
  }
}
