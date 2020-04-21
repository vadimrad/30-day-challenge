/*
Day 21

Leftmost Column with at Least a One
Solution
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
*/
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class D21 {
    int result = Integer.MAX_VALUE;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int n = dims.get(0);
        int m = dims.get(1);
        //int result = -1;
        int column = m - 1;
        
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                if (result < Integer.MAX_VALUE) {
                    column = result - 1;
                }
            }
            binarySearch(i, column, binaryMatrix);
            if (result == 0) {
                return result;
            }
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private void binarySearch(int i, int end, BinaryMatrix binaryMatrix) {
        int start = 0;
        while (start <= end) {
            int mid = end - (end - start)/2;
            if (binaryMatrix.get(i, mid) == 1) {
                 if (mid == 0) {
                    result = 0;
                    break;
                } else {
                     result = Math.min(result, mid);
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        
    }
}
