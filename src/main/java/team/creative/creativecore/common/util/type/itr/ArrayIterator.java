package team.creative.creativecore.common.util.type.itr;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    
    public final T[] content;
    private int index;
    
    public ArrayIterator(T... content) {
        this.content = content;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < content.length;
    }
    
    @Override
    public T next() {
        T result = content[index];
        index++;
        return result;
    }
    
}
