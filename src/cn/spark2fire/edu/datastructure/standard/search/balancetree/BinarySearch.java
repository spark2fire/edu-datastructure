package cn.spark2fire.edu.datastructure.standard.search.balancetree;


/**
 * Author: Leon@spark2fire.cn
 * QQ Group: 493306318
 * Date: 2021/10/17
 */
 public class BinarySearch {

    public int search(Integer[] array, Integer data, int idx) {
        if (idx == 1) {
            // length - 1, right和left都可以取到
            return search(array, 0, array.length - 1, data);
        } else {
            return cursiveSearch(array, 0, array.length - 1, data);
        }

    }

    public void multipleSearch(Integer[] array, Integer data) {
        multiCursive(array, 0, array.length - 1, data);
    }

    private int cursiveSearch(Integer[] array, int left, int right, Integer data) {
        // 注意点
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == data) {
            return mid;
        } else if (data < array[mid]) {
            // 一个注意点
            return cursiveSearch(array, left, mid - 1, data);
        } else {
            return cursiveSearch(array, mid + 1, right, data);
        }
    }

    private int search(Integer[] array, int left, int right, Integer data) {
        if (data < array[left] && data > array[right]) {
            return -1;
        }
        int mid;
        // 要留有等于, 不然永远找不到
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == data) {
                return mid;
            } else if (data < array[mid]) {
                // 一个注意点
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private void multiCursive(Integer[] array, int left, int right, Integer data) {
        // 注意点
        if (left > right) {
            return;
        }
        int mid = (left + right) / 2;
        if (array[mid] == data) {
            System.out.println(mid);
            int temp = mid;
            while (temp < right) {
                if (array[++temp] == data) {
                    System.out.println(temp);
                } else {
                    break;
                }
            }
            temp = mid;
            while (temp > left) {
                if (array[--temp] == data) {
                    System.out.println(temp);
                } else {
                    break;
                }
            }
        } else if (data < array[mid]) {
            // 一个注意点
            multiCursive(array, left, mid - 1, data);
        } else {
            multiCursive(array, mid + 1, right, data);
        }
    }
}
