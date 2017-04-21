/*Team Lonely_Island/2: Piotr Milewski, Edwin Mok
  APCS2 pd3
  HW32 -- Getting Past the Velvet Rope
  2017-04-19*/

import java.util.ArrayList;

public class ArrayPriorityQueue<T> implements PriorityQueue<T>{

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
	ArrayPriorityQueue<Comparable> a = new ArrayPriorityQueue<Comparable>();

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

	//Test functionality with integers
	a.add(7);
	a.add(4);
	a.add(5);
	a.add(1);

	System.out.println(a.isEmpty());

	System.out.println(a.peekMin());
	
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());

	System.out.println(a.isEmpty());
	
	System.out.println();

	//Test functionality with doubles
	a.add(2.54);
	a.add(6.94);
	a.add(3.33);
	a.add(20.56);

	System.out.println(a.isEmpty());

	System.out.println(a.peekMin());
	
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());
	System.out.println(a.removeMin());

	System.out.println(a.isEmpty());

	System.out.println();
    }
}
