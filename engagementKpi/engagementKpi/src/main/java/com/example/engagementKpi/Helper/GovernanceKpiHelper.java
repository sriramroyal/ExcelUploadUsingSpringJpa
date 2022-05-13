package com.example.engagementKpi.Helper;

import com.example.engagementKpi.Entity.GovernanceKpi;
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

public class GovernanceKpiHelper {
    public static String regexonString(String str,boolean flag){
        if (flag==false){
            str=str.replaceAll("[^a-zA-Z0-9]&&[#+./,]","");
        }
        else {
            str=str.replaceAll("[^a-zA-Z0-9]","");
        }
        return str;
    }
    public static boolean CheckFile(MultipartFile file) {

        String contentType = file.getContentType();
        String FileName = file.getOriginalFilename();
        System.out.println(FileName);
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }
    public static List<GovernanceKpi> ExcelToList(InputStream is) {
        List<GovernanceKpi> list = new ArrayList<>();

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
                GovernanceKpi governanceKpi=new GovernanceKpi();
                while (cells.hasNext()) {
                    Cell cell = cells.next();


                    switch (cid) {
                        case 0:
                            governanceKpi.setId(cell.getStringCellValue());
                            break;
                        case 1:
                            governanceKpi.setWeekEnding(cell.getStringCellValue());
                            break;
                        case 2:
                            governanceKpi.setProjectId((long) cell.getNumericCellValue());
                            break;
                        case 3:
                            governanceKpi.setTeamMeeting((int)cell.getNumericCellValue());
                            break;
                        case 4:
                            governanceKpi.setTeamMeetingAvg((float) cell.getNumericCellValue());
                            break;
                        case 5:
                            governanceKpi.setStakeHolderMeeting((int)cell.getNumericCellValue());
                            break;
                        case 6:
                            governanceKpi.setStakeHolderMeetingAvg((float) cell.getNumericCellValue());
                            break;
                        case 7:
                            governanceKpi.setExecConnect((int)cell.getNumericCellValue());
                            break;
                        case 8:
                            governanceKpi.setExecConnectAvg((float) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(governanceKpi);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
