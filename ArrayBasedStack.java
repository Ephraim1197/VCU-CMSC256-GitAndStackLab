import java.util.EmptyStackException;
import java.util.Arrays;
public class  ArrayBasedStack<T> implements StackInterface<T>{


   T[] data;
   int topOfStack;
   int INITIAL_CAPACITY=5;   
   boolean initialized;
   
   public ArrayBasedStack(){
      @SuppressWarnings("Unchecked")
      T[] tempData=(T[]) new Object[INITIAL_CAPACITY];
      data=tempData;
      initialized=true;
      topOfStack=-1;
   }
   
   public ArrayBasedStack(int initialCap){
      
      if(initialCap<0){
         throw new IllegalArgumentException();
      }
      else{
      @SuppressWarnings("Unchecked")
      T[] tempData=(T[]) new Object[initialCap];
      data=tempData;
      initialized=true;
      topOfStack=-1;
      }
   
   }
      
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry){
      topOfStack++;
      if(topOfStack>=data.length-1){
         expandArray();
      }
      data[topOfStack]=newEntry;
     
      
   
   }
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop(){
      if(isEmpty()){
         throw new EmptyStackException();
      }
      T tempData=data[topOfStack];
      topOfStack--;
      return tempData;
      
   
   }
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek(){
      if(isEmpty()){
         throw new EmptyStackException();
      }
       return data[topOfStack];
   
   
   }
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      if(topOfStack<0){
         return true;
      }
      else
      return false;
   
   }  
   /** Removes all entries from this stack. */
   public void clear(){
      topOfStack=-1;
   }
   private void expandArray(){
      data=Arrays.copyOf(data,data.length+5);
   
   }


   

}