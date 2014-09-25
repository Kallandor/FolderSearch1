/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldersearch;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author dlwilson
 */
public class FolderSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String path = "C:\\Pathfinder RPG";
        String pattern = "MM/dd/yyyy";
        int d = 0;
        SimpleDateFormat sdf;
                
        File file = new File(path);
        File[] files = file.listFiles();
        boolean isDirectory = file.isDirectory();
        
        sdf = new SimpleDateFormat("MM/dd/yyyy");
        
        for (int i = 0; i < files.length; i++)
        {
            System.out.println(files[i] + " " + sdf.format(file.lastModified()));
        }
        
//        System.out.println(file.list());
    }
    
}
