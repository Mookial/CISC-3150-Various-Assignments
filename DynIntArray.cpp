#include <stdexcept>
#include <iostream>

using namespace std;

class DynIntArray {
    
    friend ostream& operator <<(ostream &os, const DynIntArray &d);
    
public:
        DynIntArray(int capacity) : arr(new int[capacity]), capacity(capacity), size(0) 
        {
            if(!arr) { throw runtime_error("Memory not given for new pointer array!"); }
    	}
		~DynIntArray();
		int get(int i);
		void set(int i, int x);
		virtual void push(int x);
		int getSize() { return size; }
		
protected:
		int size;
		int capacity;
		
private:
		int *arr;
};

ostream& operator <<(ostream &os, const DynIntArray &d) {
        os << "{";
            for (int i = 0; i < d.size; i++)
                os << d.arr[i] << (i < d.size-1 ? ", " : "");
    	os << "}";
        
		return os;
}

DynIntArray::~DynIntArray() {
	delete [] arr;
}

int DynIntArray::get(int i) {
	if(i < 0 || i >= size)
		throw runtime_error("Index is out of bounds!");
		
	return arr[i];
}

void DynIntArray::set(int i, int x) {
	if(i < 0 || i >= size)
		throw runtime_error("Index is out of bounds!");

	arr[i] = x;
}

void DynIntArray::push(int x) {
	if(size == capacity) {
        capacity *= 2;
		int *newArr = new int[capacity];
		
		if(!newArr) { throw runtime_error("Memory not given for new pointer array!"); }
		
        for (int i = 0; i < size; i++)
    	    newArr[i] = arr[i];
		
		delete [] arr;
		
        arr = newArr;
		
		arr[size] = x;
        size++;
	}

	else {
		arr[size] = x;
        size++;
	}	
}

class DynIntArrayWithLimit : public DynIntArray {

public:
	DynIntArrayWithLimit(int capacity, int lim)
    : DynIntArray(capacity)
    {
        limit = lim;
    }
    
	virtual void push(int x) 
	{
		if(size == limit) { 
			throw runtime_error("\nArray limit has been reached!");
		}
        DynIntArray::push(x);
	}
protected:
	int limit;
};


int main() {
	DynIntArrayWithLimit d(50, 100);
	
	for(int i = 0; i < 50; i++)
		d.push(i);
	
    cout << "Size of first array: " << d.getSize() << "\n";	
	cout << d;
    
    /* Pushes 51 which then doubles the array size */
    d.push(50);
    
    cout << "\n\nSize of second array: " << d.getSize() << "\n";
    cout << d;
    
	for(int i = d.getSize(); i < 100; i++)
    	d.push(i);
        
    cout << "\n\nSize of third array: " << d.getSize() << "\n";
    cout << d;
    
    /* Throws exception here because size becomes 101, which is 
    greater than limit */
    d.push(100);        
    
	return 0;
}
