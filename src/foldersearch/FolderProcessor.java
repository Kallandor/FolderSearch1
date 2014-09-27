/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldersearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author dlwilson
 */
public class FolderProcessor {

    private String path;
    private long size;
    private String name;

    public FolderProcessor(String p, long s, String n) {
        path = p;
        size = s;
        name = n;
    }
    
    public void setPath(String p){
        this.path = p;
    }
    
    public void setSize(long s){
        this.size = s;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public long getSize(){
        return this.size;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void doProcess() {

        File file = new File(getPath());
        File[] files = file.listFiles();
        ArrayList<FolderProcessor> outFiles = new ArrayList<FolderProcessor>();

        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                outFiles.addAll(doDirectory(currentFile, 0));
            }
        }
        for (Iterator<FolderProcessor> it = outFiles.iterator(); it.hasNext();) {
            FolderProcessor theFile = it.next();
            System.out.println(theFile.getName() +" "+ theFile.getSize());
        }
        System.out.println(outFiles.size());
    }

    private ArrayList doDirectory(File f, int counter) {
//        System.out.println("Directory Found :" + f.getAbsolutePath() + " " + f.lastModified());
        
        File[] files = f.listFiles();
        long date = 1406865600000L; //1377921600000L
        ArrayList<FolderProcessor> outFiles = new ArrayList<FolderProcessor>();

        for (File currentFile : files) {
            if (currentFile.lastModified() <= date) {
                try {

                    if (currentFile.isDirectory() && counter < 0) {
                        doDirectory(currentFile, counter++);
                    }else if(currentFile.isDirectory()){
                        FolderProcessor theFile = new FolderProcessor(currentFile.getAbsolutePath(), currentFile.lastModified(), currentFile.getName());
                        outFiles.add(theFile);
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return outFiles;
    }

//    private void doCheck(File c) {
//        System.out.println("Directory Readable :" + c.canRead());
//        File[] files = c.listFiles();
//        for (File currentFile : files) {
//            if (currentFile.canRead());
//            {
//                doDirectory(currentFile);
//            }

//        }
//    }
}
