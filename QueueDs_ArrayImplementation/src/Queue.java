public class Queue <Item>{
    Integer top, bottom = null;
    Item[] arrayForQueue = (Item[]) new Object[1];

    private Boolean queueIsEmpty(){
        return top == null;
    }

    private void resizeArrayQueue(int capacity){
        Item[] holderArray = (Item[]) new Object[capacity];
        for(int i = 0; i < arrayForQueue.length; i++)
            holderArray[i] = arrayForQueue[i];
        arrayForQueue = holderArray;
    }

    public void enqueue(Item inputData){
        if(bottom == null && top == null){
            bottom = 0;
            top = 0;
            arrayForQueue[bottom] = inputData;
        }
        else {
            bottom = bottom + 1;
            arrayForQueue[bottom] = inputData;
        }

        /**make the bottom of the queue point to the first**/
        if(bottom >= arrayForQueue.length - 1 && arrayForQueue[0] == null) bottom = 0;
        else{
            resizeArrayQueue(2 * arrayForQueue.length);
        }
    }

    public Item dequeue(){
        if(!queueIsEmpty()){
            if(top >= arrayForQueue.length - 1 && arrayForQueue[0] == null) top = 0;
            else{
                resizeArrayQueue(2 * arrayForQueue.length);
            }
           Item itemToOutput = arrayForQueue[top];
            arrayForQueue[top] = null;
            if(top == bottom) {
                top = null;
                bottom = null;
                arrayForQueue = (Item[])new Object[1];
            }
            else {
                top++;
            }
            return itemToOutput;
        }
        else return null;
    }
}
