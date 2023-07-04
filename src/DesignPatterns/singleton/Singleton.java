package DesignPatterns.singleton;

public final class Singleton {
    private static Singleton instance;
    public String name;

    private Singleton(String name) {
        this.name = name;
    }

    public static Singleton getInstance(String name) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }

        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(name);
            }
            return instance;
        }
    }
}
