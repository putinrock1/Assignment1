package model;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import utils.BinarySearchTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Excel reading reference:
 * https://github.com/csc202/ReadExcelFile/blob/master/ImportExcelDemo/src/ReadExcel.java
 */
public class HospitalDB {
    private String filename = "/Users/surya/IdeaProjects/csc202/Assignment1/hospitals.xls";
    BinarySearchTree<Hospital> list = new BinarySearchTree<Hospital>();

    private Location comparableLocation;

    public BinarySearchTree<Hospital> getList() {
        return list;
    }

    public HospitalDB() throws Exception {
        this.load();
    }

    public HospitalDB(Location location) throws Exception {
        this.comparableLocation = location;

        this.load();
    }


    public void load() throws Exception {
        List sheetData = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(this.filename);

            HSSFWorkbook workbook = new HSSFWorkbook(fis);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();

            // remove header row
            rows.next();

            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                String name = ((Cell) cells.next()).getStringCellValue();
                String address = ((Cell) cells.next()).getStringCellValue();
                double latitude = ((Cell) cells.next()).getNumericCellValue();
                double longitude = ((Cell) cells.next()).getNumericCellValue();
                String phone = String.valueOf(((Cell) cells.next()).getNumericCellValue());
                String image = ((Cell) cells.next()).getStringCellValue();

                Location loc = new Location(latitude, longitude);

                if (this.comparableLocation != null) {
                    loc.addComparableLocation(this.comparableLocation);
                }

                this.list.add(new Hospital(address, image, loc, name, phone));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}
