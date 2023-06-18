/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import java.io.FileDescriptor;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author david
 */
public class FileManager {
    
    final String bookingsPath = "test\\bookigns.csv";
    final String roomsPath = "test\\rooms.csv";
    final String statusPath = "test\\status.csv";
    final String recordPath = "test\\record.csv";
    
    /**
     * @deprecated 
     * @param index 
     */
    public void readFile(int index){
        try{
            InputStream inputStream = new FileInputStream("test\\Booking_hotel.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(index);
            
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            
            Row row;
            Cell cell;
            
            for (int i = firstRow+1; i <= lastRow; i++) {
                row = sheet.getRow(i);
                Cell [] cells = new Cell[row.getLastCellNum()+1];
                cells[0]= row.getCell(0);
                cells[1]= row.getCell(1);
                cells[2]= row.getCell(2);
                cells[3]= row.getCell(3);
                cells[4]= row.getCell(4);
                cells[5]= row.getCell(5);
                cells[6]= row.getCell(6);
                cells[7]= row.getCell(7);
                cells[8]= row.getCell(8);
                bookingReading(cells);
                
                
                              
            }
            
            inputStream.close();
            workbook.close();
            
        }catch(Exception e){
            System.out.println("Ocurrio un error --->"+e);
        }
        
    }
    
    public void writeFile(){
        try{
            
        }catch(Exception e){
            System.out.println("Ocurrio un error --->"+e);
        }
        
    }
    /**
     * @deprecated
     * @param cells 
     */
    private void bookingReading(Cell[] cells){
        System.out.println("ID: "+cells[0].getNumericCellValue()+" Nombre: "+ cells[1].getRichStringCellValue()+" Apellido: "+ cells[2].getRichStringCellValue()+" Email: "+cells[3].getRichStringCellValue()+ " Genero: "+ cells[4].getRichStringCellValue()+" Hab: "+cells[5].getRichStringCellValue()+ " Celular: "+ cells[6].getRichStringCellValue()+" Llegada: "+ cells[7].getDateCellValue()+" Salida: "+cells[8].getDateCellValue());
        
    }
    
    public void initializeProgram(){
               
        
    }
    
    public void readBookingsCSV(){
        try{
            
        BufferedReader br= toRead(bookingsPath);
        String line;
        String[] values;
        while((line = br.readLine()) != null){
            System.out.println(line);
            values = line.split(",");
            System.out.println(values[0]+"-"+values[values.length-1]);
        }
        }catch(IOException e){
            System.out.println("Error produced while reading: "+bookingsPath+"\n"+e.getMessage());
        } 
    }
    public void readRoomCSV(){
        
    }
    public void readStatusCSV(){
        
    }
    public void readRecordCSV(){
        
    }
    
    public BufferedReader toRead(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){            
            return br;
        }catch(IOException e){
            System.out.println("Error produced while trying to opne file: "+path+"\n"+e.getMessage());
        }
        return null;
    }
    
    public BufferedWriter toWrite(String path){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){            
            return bw;
        }catch(IOException e){
            System.out.println("Error produced while trying to opne file: "+path+"\n"+e.getMessage());
        }
        return null;
    }
    
    
    
}
