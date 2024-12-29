// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer prev;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.itr = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(prev != null){
            return prev;
        }
        if(itr.hasNext()){
            prev = itr.next();
            return prev;
        }
        return null;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(prev != null){
            Integer tmp = prev;
            prev = null;
            return tmp;
        }
        if(itr.hasNext()){
            return itr.next();
        }
	    return null;
	}
	
	@Override
	public boolean hasNext() {
        if(prev != null) return true;
	    return itr.hasNext();
	}
}