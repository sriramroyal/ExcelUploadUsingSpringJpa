package com.example.engagementKpi.Helper;


import com.example.engagementKpi.Entity.Kpi;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class KpiHelper {
    private static String myName;
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
    public static boolean gotIt(MultipartFile file) {
        myName=file.getOriginalFilename();

        return false;
    }
    public static List<Kpi> ExcelToList(InputStream is) {
        List<Kpi> list = new ArrayList<>();

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

                Kpi kpi=new Kpi();
                while (cells.hasNext()) {
                    Cell cell = cells.next();


                    switch (cid) {
                        case 0:
                            kpi.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            kpi.setWeekEnd(cell.getStringCellValue());
                            break;
                        case 2:
                            kpi.setProjectId((long) cell.getNumericCellValue());
                            break;
                        case 3:
                            kpi.setResignation((int)cell.getNumericCellValue());
                            break;
                        case 4:
                            kpi.setResignationWithdraw((int)cell.getNumericCellValue());
                            break;
                        case 5:
                            kpi.setAmberScore((int)cell.getNumericCellValue());
                            break;
                        case 6:
                            kpi.setAmberScoeAvg((int)cell.getNumericCellValue());
                        default:
                            break;
                    }
                    cid++;
                }
//                System.out.println(" Id: " +kpi.getId()+" \n");
//                System.out.println(" Week: " +kpi.getWeekEnd()+" \n");
//                System.out.println("ProjectId: "+kpi.getProjectId()+" \n");
//                System.out.println("Resignation: "+kpi.getResignation()+" \n");
//                System.out.println("Reswithdraw: "+kpi.getResignationWithdraw()+" \n");
//                System.out.println("Amberscore: "+kpi.getAmberScore()+" \n");
//                System.out.println("AmberscoreAvg "+kpi.getAmberScoeAvg()+" \n");
                list.add(kpi);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}

