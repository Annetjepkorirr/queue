fun main() {
    var q  = Queue(6)
    q.enqueue(4)
    q.enqueue(5)
    q.enqueue(6)
    q.enqueue(7)
    q.dequeue()
    q.dequeue()
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    q.enqueue(4)
    q.enqueue(5)
    q.enqueue(6)
    q.enqueue(7)
    q.display()
//    println(q.peek())

}

//FIFO
//front ....rear method,...they always point to the current index and in each step, the rear moves one more step ,pointing to the next available slot, when adding items
//if rear is equals to the value of queue, it is then full
//Adds items to the queue -enqueue...IT IS FIXED IN SIZE
//removes item to the queue - dequeue
//what item is infront of the queue without dequeuing it - peek
//display all items currently in the queue - display()
//when item is full - isFull()
//isEmpty -  when queue is empty
//the maximum number a queue can hold

class Queue(var capacity : Int){
    var data = IntArray(capacity)  //data array that holds
    var front = 0 //points to the 0index of the  data array
    var rear  = 0

    fun enqueue(item:Int){
        if (isFull()){  //check if it is full
            println("queue is full") //if full, errorout and exit
            return
        }
        data[rear] = item
        rear++ //moves rear ahead by one position
    }

    fun dequeue():Int?{
        if (isEmpty()){
            println("queue is empty")
            return null
        }
        var removed = data[front]
        for (i in front until rear-1){ //until is exclusive
            data[i] = data[i+1] //occupied by data at index(i)plus 1
        }
        rear--
        return removed

    }

    fun isEmpty():Boolean{
        return  rear == front  //this means that the queue is empty
    }

    fun isFull():Boolean{
        return  rear == capacity

    }

    fun peek():Int?{
        if (isEmpty()){
            return  null
        }
        return data[front]

    }

    fun display(){
        if (isEmpty()){
            println("queue is empty")
        }
        for (i in front until rear){
            println()
        }

    }
}