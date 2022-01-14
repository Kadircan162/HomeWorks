package com.cybertek.utilities;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils extends XSSFSheet{

    public static void getRowCount(){
        try {

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook("C:\\Users\\arate\\git\\HomeWorks\\EU3TestNGSelenium\\RigestrationData");
           // XSSFSheet xssfSheet = new XSSFSheet("Register");

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }
}
