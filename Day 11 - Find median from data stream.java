class MedianFinder {
    
    public PriorityQueue<Integer> minHeap,maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    public void addNum(int num) {
        if(minHeap.size()==maxHeap.size()){
            minHeap.add(num);//comment 
            maxHeap.add(minHeap.poll());
        }
        else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    } 
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }    
    }
}//computer 

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
