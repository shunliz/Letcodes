package data_structures;

public final  class ClassLoaderSwapper {
    private ClassLoader storeClassLoader = null;
    private ClassLoaderSwapper(){

    }

    public static ClassLoaderSwapper newCurrentThreadClassLoaderSwapper(){
        return new ClassLoaderSwapper();
    }

    public ClassLoader setCurrentThreadClassLoader(ClassLoader classLoader){
        this.storeClassLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(classLoader);
        return this.storeClassLoader;
    }

    public ClassLoader restoreCurrentThreadClassLoader(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.storeClassLoader);
        return classLoader;
    }

}
