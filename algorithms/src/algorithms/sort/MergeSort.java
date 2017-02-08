package algorithms.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T> {
  private Class<?> clazz;

  public MergeSort(Class<?> clazz) {
    this.clazz = clazz;
  }

  public T[] sort(T[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  private T[] mergeSort(T[] arr, int start, int end) {
    if (start == end) {
      return Arrays.copyOfRange(arr, start, end + 1);
    }

    int middle = (start + end) / 2;
    T[] result = merge(mergeSort(arr, start, middle), mergeSort(arr, middle + 1, end));

    return result;
  }

  @SuppressWarnings("unchecked")
  private T[] merge(T[] left, T[] right) {
    int n = left.length;
    int m = right.length;
    T[] result = (T[]) Array.newInstance(clazz, m + n);
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      int compare = compare(left[i], right[j]);
      if (compare < 0) {
        result[k] = left[i];
        i++;
      } else {
        result[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < n) {
      result[k] = left[i];
      i++;
      k++;
    }

    while (j < m) {
      result[k] = right[j];
      j++;
      k++;
    }

    return result;
  }

  private int compare(T a, T b) {
    if (a instanceof Integer && b instanceof Integer) {
      return ((Integer) a).compareTo((Integer) b);
    } else if (a instanceof Float) {
      return ((Float) a).compareTo((Float) b);
    } else if (a instanceof Double) {
      return ((Double) a).compareTo((Double) b);
    } else if (a instanceof Character) {
      return ((Character) a).compareTo((Character) b);
    } else if (a instanceof String) {
      return ((String) a).compareTo((String) b);
    }
    return -1;
  }

}