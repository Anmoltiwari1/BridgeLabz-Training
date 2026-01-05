import java.util.*;

class CircularBuffer {
    int[] buffer;
    int size, front, rear, count;
    
    CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }
    
    void insert(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;
        
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size; // Overwrite oldest
        }
    }
    
    List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(front + i) % size]);
        }
        return result;
    }
}

public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("Buffer after inserting 1,2,3: " + buffer.getBuffer());
        
        buffer.insert(4);
        System.out.println("Buffer after inserting 4: " + buffer.getBuffer());
        
        buffer.insert(5);
        System.out.println("Buffer after inserting 5: " + buffer.getBuffer());
    }
}