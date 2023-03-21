package com.knowledgeTest.hotLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileClassLoader extends ClassLoader{
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java")) {
            return getSystemClassLoader().loadClass(name);
        }
        Class cls = null;
        File classF = new File(fileName);
        try {
            cls = instantiateClass(name, new FileInputStream(classF), classF.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) throws IOException {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        return defineClass(name, raw, 0, raw.length);
    }
}
