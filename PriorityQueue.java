public interface PriorityQueue<L> {

    public void add(L x);

    public boolean isEmpty();

    public L peekMin();

    public L removeMin();

}
