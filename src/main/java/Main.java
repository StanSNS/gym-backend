import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    static class Person {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) throws IOException {
//        String filePath = "C:\\Users\\stanimir.sergev\\Downloads\\distro_sila_2024_03_26_11_43_03.xlsx";
//
//        FileInputStream fis = new FileInputStream(new File(filePath));
//
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//
//        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming first sheet
//
//        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
//            XSSFRow row = sheet.getRow(i);
//            if (row != null) {
//
//                System.out.println("SKU: " + row.getCell(0));
//                System.out.println("ProductIDSila: " + row.getCell(1));
//                System.out.println("Name: " + row.getCell(2));
//                System.out.println("Taste: " + row.getCell(3));
//                System.out.println("Original price: " + row.getCell(4));
//                System.out.println("Discount: " + row.getCell(5));
//                System.out.println("Reduced price: " + row.getCell(6));
//                System.out.println("Barcode: " + row.getCell(7));
//                System.out.println("Availability: " + row.getCell(8));
//
//                System.out.println();
//
//            }
//        }

//        fis.close();
//        workbook.close();


//        Person ivan1 = new Person();
//        ivan1.setName("Ivan");
//
//        Person ivan2 = new Person();
//        ivan2.setName("Ivan");
//
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(ivan1);
//
//        System.out.println(people.contains(ivan2));



    }
}
