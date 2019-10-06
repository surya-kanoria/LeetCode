import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(11, Comparator.reverseOrder());

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (min.size() == max.size()) {
            max.offer(num);
            int n = max.poll();
            min.offer(n);
        } else {
            min.offer(num);
            int n = min.poll();
            max.offer(n);
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return ((double) min.peek() + (double) max.peek()) / 2;
        } else {
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */