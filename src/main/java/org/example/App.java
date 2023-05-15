package org.example;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Hello World!");

        FileInputStream file = new FileInputStream(new File("C:\\Users\\reddy\\Downloads\\B&M DMOG Data.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("B&M DMOG Data");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/citrusleaf", "root", "password");
        int rowCount = sheet.getLastRowNum();
        System.out.println(rowCount);

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            // get cell values as strings
            String email = row.getCell(0).getStringCellValue();

            Double mobile = row.getCell(1).getNumericCellValue();
            String category = row.getCell(2).getStringCellValue();
            Double custid = row.getCell(3).getNumericCellValue();
            // insert values into database
            String sql = "INSERT INTO dmogdata4 (MOBILENO,CATEGORY,CUST_ID,EMAILID) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1,mobile);
            statement.setString(2,category);
            statement.setDouble(3,custid);
           statement.setString(4,email);
//            statement.setString(1, col1);
//            statement.setDouble(2, col2);
//            statement.setString(3, col3);
//            statement.setDouble(4, col4);
            statement.executeUpdate();
        }
        conn.close();
        workbook.close();
        file.close();
    }
}

























