public class Queue {
    Integer top, bottom = null;
    String[] arrayForQueue = new String[1];

    private Boolean queueIsEmpty(){
        return top == null;
    }

    private void resizeArrayQueue(int capacity){
        String[] holderArray = new String[capacity];
        for(int i = 0; i < arrayForQueue.length; i++)
            holderArray[i] = arrayForQueue[i];
        arrayForQueue = holderArray;
    }

    public void enqueue(String inputData){
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

    public String dequeue(){
        if(!queueIsEmpty()){
            if(top >= arrayForQueue.length - 1 && arrayForQueue[0] == null) top = 0;
            else{
                resizeArrayQueue(2 * arrayForQueue.length);
            }
            String itemToOutput = arrayForQueue[top];
            arrayForQueue[top] = null;
            if(top == bottom) {
                top = null;
                bottom = null;
                arrayForQueue = new String[1];
            }
            else {
                top++;
            }
            return itemToOutput;
        }
        else return "Queue is empty";
    }
}
