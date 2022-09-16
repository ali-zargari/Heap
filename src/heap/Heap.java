package heap;

public class Heap {
	
	private int[] data;
	private int heapSize;
	
	public Heap(int[] data,int heapSize) {
		this.data = data;
		this.heapSize = heapSize;
	}
	
	public void setHeapSize(int i) {
		heapSize = i;
	}
	
	public int getHeapSize() {
		return heapSize;
	}
	
	//return the parent of ith element in the array.
	//should return -1 if the ith element is the root of the heap
	public int parent(int i) {
		if(data[i] == data[0])
			return -1;

		return ((i-1)/2);
	}
	
	//returns the index of the left child of the ith element in the array
	//for leaves the index will be greater than the heapSize

	public int left(int i) {
		if(((2*i)+1) >= heapSize)
			return i;
		return ((2*i)+1);
	}
	
	//returns the index of the right child of the ith element in the array
	//for leaves the index will be greater than the heapSize
	public int right(int i) {
		if(((2*i)+2) >= heapSize)
			return i;
		return ((2*i)+2);
		
	}
	
	//modifies the data array so that the tree rooted at the loc element
	//is a max heap.
	//Assumes that the trees rooted at the left and right children of loc
	//are max heaps
	public void maxHeapify(int loc) {
		int left = left(loc);
		int right = right(loc);
		int largest = Integer.MIN_VALUE;

		if(left <= heapSize && data[left] > data[loc]){
			largest = left;
		} else {
			largest = loc;
		}

		if(right <= heapSize && data[right] > data[largest]){
			largest = right;
		}

		if(largest != loc){
			int temp = data[loc];
			data[loc] = data[largest];
			data[largest] = temp;

			maxHeapify(largest);
		}

	}
	

	//converts the data array to an array that represents a max heap of size HeapSize
	public void buildMaxHeap() {
		for(int i = ((heapSize)/2) ; i >= 0; i--){
			maxHeapify(i);
		}
		
	}
	
	//helper method for debugging and printing
	public String toString() {
		String s = "[";
		for(int i=0;i<heapSize;i++) {
			s = s + data[i]+",";
		}
		return s.substring(0,s.length()-1)+"]";
	}


}
