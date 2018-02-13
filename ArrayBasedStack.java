import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T>
{
   private final int INITIAL_CAPACITY = 5;
   
   T[] data;
   private int topOfStack;
   private boolean initialized;
   
   public ArrayBasedStack()
   {
      topOfStack = -1;
      data = (T[]) new Object[INITIAL_CAPACITY];
   }//end default constructor
   
   
   
   public ArrayBasedStack(int cap)
   {
      if (cap > 0)
      {
         @SuppressWarnings("unchecked")
         T[] tempData = (T[]) new Object[cap];
         data = tempData;
         topOfStack = -1;
         initialized = true;
      }
      else
      {
         throw new IllegalArgumentException("Invalid size");
      }
      
      
   }//end constructor
   
   private void expandArray()
   {
      data = Arrays.copyOf(data, 2 * data.length); 
   }
   
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry)
   {
      if(topOfStack == data.length - 1)
      {
         this.expandArray();
      }
      topOfStack++;
      data[topOfStack] = newEntry;  
   }//end push
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop()
   {
      if (this.isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         T temp = data[topOfStack];
         data[topOfStack] = null;
         topOfStack--;
         return temp;
      }
   }
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek()
   {
      if (this.isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         return data[topOfStack];
      }
   }
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty()
   {
      if(topOfStack < 0)
      {
         return true;
      }
      return false;
   }
  
   /** Removes all entries from this stack. */
   public void clear()
   {
      if (this.isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         while(!this.isEmpty())
         {
            this.pop();
         }
      }
   }
   
   
   
}//end class