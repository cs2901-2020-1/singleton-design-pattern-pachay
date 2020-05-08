public class ChocolateBoilerSingleton {
    private boolean empty;
    private boolean boiled;
    private static volatile ChocolateBoilerSingleton instance;

    private ChocolateBoilerSingleton() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton getInstance() {
        if (instance == null) {
            synchronized (ChocolateBoilerSingleton.class) {
                if (instance == null) {
                    instance = new ChocolateBoilerSingleton();
                }
            }
        }
        return instance;
    }

    public void fill(){
        synchronized (ChocolateBoilerSingleton.class) {
            if (isEmpty()) {
                boiled = false;
                empty = false;
            }
        }
    }

    public void drain(){
        synchronized (ChocolateBoilerSingleton.class) {
            if (!isEmpty() && isBoiled()) {
                //drain the boiled milk and chocolate
                empty = true;
            }
        }
    }

    public void boil(){
        synchronized (ChocolateBoilerSingleton.class) {
            if (!isEmpty() && !isBoiled()) {
                //bring the contents to a boil
                boiled = true;
            }
        }
    }

    public boolean isEmpty(){
        synchronized (ChocolateBoilerSingleton.class) {
            return empty;
        }
    }

    public boolean isBoiled(){
        synchronized (ChocolateBoilerSingleton.class) {
            return boiled;
        }
    }

}