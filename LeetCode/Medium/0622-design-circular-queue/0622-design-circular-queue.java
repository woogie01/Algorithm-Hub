 public class MyCircularQueue {
        int[] q;
        int front = 0;
        int rear = -1;
        int len = 0;

        public MyCircularQueue(int k) {
            this.q = new int[k];
        }

        public boolean enQueue(int value) {
            if (!this.isFull()) {
                this.rear = (this.rear + 1) % this.q.length;
                this.q[rear] = value;
                this.len++;
                return true;
            }
            return false;
        }
        
        public boolean deQueue() {
            if (!this.isEmpty()) {
                this.front = (this.front + 1) % this.q.length;
                this.len--;
                return true;
            }
            return false;
        }
        
        public int Front() {
            return (this.isEmpty()) ? -1 : this.q[this.front];
        }

        public int Rear() {
            return (this.isEmpty()) ? -1 : this.q[this.rear];
        } 

        public boolean isEmpty() {
            return this.len == 0;
        }

        public boolean isFull() {
            return this.len == this.q.length;
        }
    }