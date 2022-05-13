package com.example.engagementKpi.Helper;

import com.example.engagementKpi.Entity.ExecutionExcellance;
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

public class ExecutionHelper {
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
    //    public static boolean gotIt(MultipartFile file) {
//        myName=file.getOriginalFilename();
//
//        return false;
//    }
    public static List<ExecutionExcellance> ExcelToList(InputStream is) {
        List<ExecutionExcellance> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
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

                ExecutionExcellance executionExcellance=new ExecutionExcellance();
                while (cells.hasNext()) {
                    Cell cell = cells.next();


                    switch (cid) {
                        case 0:
                            executionExcellance.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            executionExcellance.setWeekEnding(cell.getStringCellValue());
                            break;
                        case 2:
                            executionExcellance.setProjectId((long) cell.getNumericCellValue());
                            break;
                        case 3:
                            executionExcellance.setCommittedStories((int)cell.getNumericCellValue());
                            break;
                        case 4:
                            executionExcellance.setActualStories((int)cell.getNumericCellValue());
                            break;
                        case 5:
                            executionExcellance.setVelocity((int)cell.getNumericCellValue());
                            break;
                        case 6:
                            executionExcellance.setVelocityAvg((int)cell.getNumericCellValue());
                            break;
                        case 7:
                            executionExcellance.setSayDoRatio((float) cell.getNumericCellValue());
                            break;
                        case 8:
                            executionExcellance.setSayDoRatioAvg((float) cell.getNumericCellValue());
                            break;
                        case 9:
                            executionExcellance.setDefectsUAT((float) cell.getNumericCellValue());
                            break;
                        case 10:
                            executionExcellance.setDefectsUATAvg((float) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(executionExcellance);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
