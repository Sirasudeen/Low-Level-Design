
public class ThreadSafeLazySingleton {
    
    public static ThreadSafeLazySingleton instance;

    public static synchronized  ThreadSafeLazySingleton getInstance()
    {
        if(instance == null)
        {
            instance = new ThreadSafeLazySingleton();
        }
        return instance;
    }
}
