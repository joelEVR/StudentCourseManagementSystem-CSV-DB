/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.cst8288Lab2.services;

import java.io.IOException;
import java.util.List;


public interface FileProcessor {

    public List<String> readLines(String filename) throws IOException;

    public void writeFile(String data, String filename);
}
