package com.example.engagementKpi.Helper;

import com.example.engagementKpi.Entity.InnovationKpi;
import com.example.engagementKpi.Entity.Kpi;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InnovationHelper {
    public static String regexonString(String str,boolean flag){
        if (flag==false){
            str=str.replaceAll("[^a-zA-Z0-9]&&[#+./,]","");
        }
        else {
            str=str.replaceAll("[^a-zA-Z0-9]","");
        }
        return str;
    }
    public static boolean CheckFile(MultipartFile file){

        String contentType = file.getContentType();
        String FileName=file.getOriginalFilename();
        System.out.println(FileName);
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }
    public static List<InnovationKpi> ExcelToList(InputStream is) {
        List<InnovationKpi> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
//            XSSFName fileName=workbook.getName();
            System.out.println(sheet);
            DataFormatter formatter = new DataFormatter();
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                InnovationKpi innovationKpi=new InnovationKpi();
                while (cells.hasNext()) {
                    Cell cell = cells.next();


                    switch (cid) {
                        case 0:
                            innovationKpi.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            innovationKpi.setWeekEnding(cell.getStringCellValue());
                            break;
                        case 2:
                            innovationKpi.setProjectId((long) cell.getNumericCellValue());
                            break;
                        case 3:
                            innovationKpi.setImprovements((int)cell.getNumericCellValue());
                            break;
                        case 4:
                            innovationKpi.setRefactoring((int)cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(innovationKpi);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
