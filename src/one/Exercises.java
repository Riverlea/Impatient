package one;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RiverLea
 * @version 1.0
 * @since JDK 1.8
 * Date    2017/6/15 18:38
 */

public class Exercises {

    public static List<File> allFiles = new ArrayList<>();

    public static void main(String[] args) {

        File  file = new File("E:\\ideaspace\\Impatient");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.isDirectory());
//        File[]  dictionary = file.listFiles();
//        for(File f : dictionary)
//            System.out.println(f.getName());
        getFiles(file);
        for(File f : allFiles) {
            System.out.println(f.getName());
        }

    }

    public static void getFiles(File file) {
        if(file.isDirectory()) {
            allFiles.add(file);
            File[] tempFiles = file.listFiles();
            if(tempFiles != null) {
                for(File f : tempFiles) {
                    getFiles(f);
                }
            }
        } else {
            allFiles.add(file);
        }
    }

    @Test
    public void forEach() {
        String[] names = { "Peter", "River", "Snow" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));

        for (Runnable runnable : runners)
            new Thread(runnable).start();
    }

}
