package oy.tol.tra;

/**
 * This class instantiates a queue implementing the {@code QueueInterface}.
 * 
 * @author Antti Juustila 
 */
public class QueueFactory {

   private QueueFactory() {
   }

   /**
    * Creates an instance of QueueInterface for Integer type.
    * @param capacity Number of elements the queue can hold.
    * @return The queue object.
    */
   //public static QueueInterface<Integer> createIntegerQueue(int capacity) {
      // TODO: Implement this when you have finished your QueueImplementation.
      // - Instantiates your queue implementation using Integer as template parameter, 
      //   with the given capacity,
      // - and return the object to the caller.
      // -- Check the earlier stack task how this is done
      
   //}

   public static QueueInterface<Integer> createIntegerQueue(int capacity) throws QueueAllocationException {
      // Ensure that capacity is at least 2
      if (capacity < 2) {
         throw new QueueAllocationException("Queue size must be at least 2");
      }

      // Return a new instance of QueueImplementation with the given capacity
      return new QueueImplementation<>(capacity);
   }

   /**
    * Creates an instance of QueueInterface for Integer type with the default capacity of 10.
    * @return The queue object.
    */
   public static QueueInterface<Integer> createIntegerQueue() {
      // Return a new instance of QueueImplementation with default capacity of 10
      return new QueueImplementation<>(10);
   }

   /**
    * Creates an instance of QueueInterface for Integer type.
    * Use the default constructor of the queue.
    * @return The queue object.
    */
   //  public static QueueInterface<Integer> createIntegerQueue() {
   //    // TODO: Implement this when you have finished your QueueImplementation.
   //    // - Instantiates your queue implementation using Integer as template parameter, 
   //    //   with default capacity,
   //    // - and return the object to the caller.
   //    // -- Check the earlier stack task how this is done
   //    
   // }

}