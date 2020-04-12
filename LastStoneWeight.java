class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int i : stones) {
            queue.add(i);
        }
        
        while(queue.size() > 1) {
            int s1 = queue.remove();
            int s2 = queue.remove();
            if (s1 != s2) {
                queue.add(Math.abs(s1 - s2));
            }
        }
        
        return queue.size() == 0 ? 0 : queue.poll();
    }
}
