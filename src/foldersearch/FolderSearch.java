/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldersearch;

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
       FolderProcessor p = new FolderProcessor("C:\\Pathfinder RPG", 0, "");
       p.doProcess();
    }
       
}
