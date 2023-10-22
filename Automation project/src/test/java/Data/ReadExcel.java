package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    static FileInputStream fis = null;
    public FileInputStream getFileInputStream()
    {
        String filepath = System.getProperty("user.dir")+"\\src\\test\\java\\Data\\userdata.xlsx";
        File srcFile = new File(filepath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e )
        {
            System.out.println("Error Occurred :"+e.getMessage());
        }

        return fis;
    }
    public Object[][] getexcelData() throws IOException {

         fis = getFileInputStream();
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet mysheet=wb.getSheet("Sheet1");
        int number_of_rows=mysheet.getPhysicalNumberOfRows();
        int number_ofcolumns=mysheet.getRow(0).getLastCellNum();
        String[][]myarray=new String[number_of_rows-1][number_ofcolumns];
        for(int i=1;i<number_of_rows;i++)
        {
            for(int j=0;j<number_ofcolumns;j++)
            {
                XSSFRow row=mysheet.getRow(i);
                myarray[i-1][j]=row.getCell(j).toString();
            }
        }

        wb.close();
        return myarray;
    }
    public static void main(String[] args) throws IOException {
        ReadExcel readExcel=new ReadExcel();
        System.out.println(readExcel.getexcelData());
    }
    }

