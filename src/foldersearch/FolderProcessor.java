/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldersearch;

import java.io.File;

/**
 *
 * @author dlwilson
 */
public class FolderProcessor
{

    private String path;

    public FolderProcessor(String p)
    {
        path = p;
    }

    public void doProcess()
    {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File currentFile : files)
        {
            if (currentFile.isDirectory())
            {
                doDirectory(currentFile);
            }
        }

    }

    private void doDirectory(File f)
    {
        System.out.println("Directory Found :" + f.getAbsolutePath() + " " + f.lastModified());
        File[] files = f.listFiles();
        long date = 1377921600000L;

        for (File currentFile : files)
        {
            if (currentFile.lastModified() <= date)
                
                    try
            {

                if (currentFile.isDirectory())
                {
                    doDirectory(currentFile);
                }
            }
            catch (Exception e)
            {
                System.err.println("Error, carrying on");
            }
        }
        
    }

    private void doCheck(File c)
    {
        System.out.println("Directory Readable :" + c.canRead());
        File[] files = c.listFiles();
        for (File currentFile : files)
        {
            if (currentFile.canRead());
            {
                doDirectory(currentFile);
            }

        }
    }
}
