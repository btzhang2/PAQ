/*Team Lonely_Island/2: Piotr Milewski, Edwin Mok
  APCS2 pd3
  HW32 -- Getting Past the Velvet Rope
  2017-04-19*/

import java.util.ArrayList;

public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>{

    private int _size;
    private ArrayList<T> _queue;
    
    public ArrayPriorityQueue(){
	_size = 0;
	_queue = new ArrayList<T>();
    }
    
    public void add( T x ){
	if ( isEmpty() ){
	    _queue.add(x);
	    _size++;
	}
	else {
	    //smaller int gets priority
	    int placeHolder = 0;
	    while (placeHolder < _size && x.compareTo(_queue.get(placeHolder)) < 0){
		placeHolder++;
	    }
	    _queue.add(placeHolder,x);
	    _size++;
	}	
    }

    public boolean isEmpty(){
	return _size == 0;
    }

    public T peekMin(){
	if ( isEmpty() ){
	    throw new IllegalStateException("queue is empty, cannot check from queue");
	}
	return _queue.get(_size-1);
    }

    public T removeMin(){
	if ( isEmpty() ){
	    throw new IllegalStateException("queue is empty, cannot remove from queue");
	}
	T ret = _queue.remove(_size-1);
	_size--;
	return ret;
    }

    public static void main(String[] args){
	ArrayPriorityQueue<String> a = new ArrayPriorityQueue<String>();

	//Test functionality with strings
	a.add("c");
	a.add("b");
	a.add("d");
	a.add("a");

	System.out.println(a.isEmpty());

	System.out.println(a.peekMin());
	
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());

	System.out.println(a.isEmpty());
	
	System.out.println();

	ArrayPriorityQueue<Integer> b = new ArrayPriorityQueue<Integer>();
	
	//Test functionality with integers
	b.add(7);
	b.add(4);
	b.add(5);
	b.add(1);

	System.out.println(b.isEmpty());

	System.out.println(b.peekMin());
	
	System.out.println(b.removeMin());
	System.out.println(b.removeMin());
	System.out.println(b.removeMin());
	System.out.println(b.removeMin());

	System.out.println(b.isEmpty());
	
	System.out.println();

	ArrayPriorityQueue<Double> c = new ArrayPriorityQueue<Double>();

	//Test functionality with doubles
	c.add(2.54);
	c.add(6.94);
	c.add(3.33);
	c.add(20.56);

	System.out.println(c.isEmpty());

	System.out.println(c.peekMin());
	
	System.out.println(c.removeMin());
	System.out.println(c.removeMin());
	System.out.println(c.removeMin());
	System.out.println(c.removeMin());

	System.out.println(c.isEmpty());

	System.out.println();
    }
}
