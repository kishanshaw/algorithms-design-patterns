package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArrays {

    public List<Integer> mergeSortedArrays(List<List<Integer>> arr) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Triplet> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            minHeap.add(new Triplet(arr.get(i).get(0), i, 0));
        }
        while (!minHeap.isEmpty()) {
            Triplet node = minHeap.poll();
            result.add(node.getVal());
            int arrPos = node.getArrPos();
            int valPos = node.getValPos();
            valPos++;
            if (valPos < arr.get(arrPos).size()) {
                int val = arr.get(arrPos).get(valPos);
                minHeap.add(new Triplet(val, arrPos, valPos));
            }
        }
        return result;
    }

    static class Triplet implements Comparable<Triplet> {
        private int val;
        private int arrPos;
        private int valPos;

        public Triplet(int val, int arrPos, int valPos) {
            this.val = val;
            this.arrPos = arrPos;
            this.valPos = valPos;
        }

        @Override
        public int compareTo(Triplet triplet) {
            return Integer.compare(this.getVal(), triplet.getVal());
        }

        public int getVal() {
            return val;
        }

        public int getArrPos() {
            return arrPos;
        }

        public int getValPos() {
            return valPos;
        }
    }
}
