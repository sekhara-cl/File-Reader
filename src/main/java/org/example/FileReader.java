package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class FileReader {
    public static void main(String[] args) throws IOException, SQLException {


        FileInputStream file = new FileInputStream(new File("C:\\Users\\reddy\\Downloads\\B&M DMOG Data(insert).xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("B&M DMOG Data");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/citrusleaf", "root", "password");

        int newTableColumns = sheet.getRow(0).getLastCellNum();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM dmogdata  WHERE CUST_ID = 504052067");

        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            // get cell values as strings

            Double col2 = row.getCell(0).getNumericCellValue();
            String col3 = row.getCell(1).getStringCellValue();
            Double col4 = row.getCell(2).getNumericCellValue();
            // insert values into database
            String sql = "INSERT INTO dmogdata2 (MOBILENO,CATEGORY,CUST_ID) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, col2);
            statement.setString(2, col3);
            statement.setDouble(3, col4);
            statement.executeUpdate();
        }
        conn.close();
        workbook.close();
        file.close();

//        int exitsTableCount = rs.getMetaData().getColumnCount();
//        System.out.println(exitsTableCount);
//        System.out.println(newTableColumns);
//        int rowCount=10;
//        if(newTableColumns<exitsTableCount){
//
//            for (int i = 0; i <= rowCount; i++) {
//                Row row = sheet.getRow(i);
//                // get cell values as strings or number
//
//                Double col2 = row.getCell(0).getNumericCellValue();
//                System.out.println(col2);
//                String col3 = row.getCell(1).getStringCellValue();
//                Double col4 = row.getCell(2).getNumericCellValue();

//        }
//
//
//
//    }
}}
