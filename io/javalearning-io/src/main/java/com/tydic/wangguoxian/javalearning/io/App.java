package com.tydic.wangguoxian.javalearning.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File path = new File(".");
        System.out.println("canExecute:"+path.canExecute());
        System.out.println("canRead:"+path.canRead());
        System.out.println("getAbsolutePath:"+path.getAbsolutePath());
        try {
            System.out.println("getCanonicalPath:"+path.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("getName:"+path.getName());
        System.out.println("getParent:"+path.getParent());
        System.out.println("toString:"+path.toString());
        System.out.println("pathSeparator:"+path.pathSeparator);
        System.out.println("exists:"+path.exists());
        System.out.println("getFreeSpace:"+path.getFreeSpace());
        System.out.println("getTotalSpace:"+path.getTotalSpace());
        System.out.println("getUsableSpace:"+path.getUsableSpace());
        System.out.println("isDirectory:"+path.isDirectory());
        System.out.println("hashCode:"+path.hashCode());
        try {
            System.out.println("createNewFile:"+path.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("list:"+path.list());
//        System.out.println("list:"+path.listFiles());
//        System.out.println("list:"+path.list());

        String[] list = path.list();
        for (String ele:
             list) {
            System.out.println("listele:"+ele);
        }
        String[] listByName = path.list(new DirFilter(
                "pom.xml"
        ));
        for (String ele:
                listByName) {
            System.out.println("listByNameEle:"+ele);
        }
        File[] listFiles = path.listFiles();
        for (File ele:
             listFiles) {
            System.out.println("listFilesEle:"+ele.toString());
        }

    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}