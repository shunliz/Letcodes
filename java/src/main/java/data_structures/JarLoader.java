package data_structures;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader extends URLClassLoader {
    private static ThreadLocal<URL[]> threadLocal = new ThreadLocal<>();
    private URL[] allUrl;
    public JarLoader(String[] paths){
        this(paths, JarLoader.class.getClassLoader());
    }

    public JarLoader(String[] paths, ClassLoader parent){
        super(getURLs(paths), parent);
        allUrl = threadLocal.get();
    }

    private static URL[] getURLs(String[] paths){
        if(null == paths || 0 == paths.length){
            throw new RuntimeException("jar path cannot be null");
        }

        List<String> dirs = new ArrayList<>();

        for(String path: paths){
            dirs.add(path);
            JarLoader.collectDirs(path, dirs);
        }

        List<URL> urls = new ArrayList<>();
        for(String path: dirs){
            urls.addAll(doGetURLs(path));
        }

        URL[] urls1 = urls.toArray(new URL[0]);
        threadLocal.set(urls1);
        return urls1;
    }

    private static void collectDirs(String path, List<String> collector){
        if(null == path || "".equalsIgnoreCase(path)){
            return ;
        }

        File current = new File(path);
        if(!current.exists() || current.isDirectory()){
            return;
        }

        for(File child:current.listFiles()){
            if(child.isDirectory()){
                continue;
            }
            collector.add(child.getAbsolutePath());
            collectDirs(child.getAbsolutePath(), collector);
        }
    }

    private static List<URL> doGetURLs(final String path){
        if(null == path || "".equalsIgnoreCase(path)){
            throw new RuntimeException("jar path cannot be null");
        }

        File jarPath = new File(path);

        if(!jarPath.exists() || !jarPath.isDirectory()){
            throw new RuntimeException("jar path must exist and be dir");
        }

        FileFilter jarFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jar");
            }
        };

        File[] allJars = new File(path).listFiles(jarFilter);
        List<URL> jarURLs = new ArrayList<>(allJars.length);
        for(int i=0;i<allJars.length;i++){
            try{
                jarURLs.add(allJars[i].toURI().toURL());
            }catch (Exception e){
                throw new RuntimeException("load jar error");
            }
        }
        return jarURLs;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(allUrl != null){
            String classPath = name.replace(".", "/");
            classPath = classPath.concat(".class");
            for(URL url:allUrl){
                byte[] data = null;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream is = null;
                try{
                    File file = new File(url.toURI());
                    if(file != null && file.exists()){
                        JarFile jarFile = new JarFile(file);
                        if(jarFile != null){
                            JarEntry jarEntry = jarFile.getJarEntry(classPath);
                            if(jarEntry != null){
                                is = jarFile.getInputStream(jarEntry);
                                int c = 0;
                                while(-1 !=(c=is.read())){
                                    baos.write(c);
                                }
                                data = baos.toByteArray();
                                return this.defineClass(name, data, 0 , data.length);
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        if(is != null){
                            is.close();
                        }
                        baos.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return super.loadClass(name);
    }
















}
