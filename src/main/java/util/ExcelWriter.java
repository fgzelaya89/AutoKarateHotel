package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExcelWriter {


    public static boolean writeToExcel(String data) {
        String filePath = "src/main/resources/output.xlsx";
        try {
            writeToExcel(data, filePath);
            System.out.println("Archivo Excel creado exitosamente.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean writeToExcelIdTestCase(String data, String idTestCase) {
        String filePath = "src/main/resources/output.xlsx";
        try {
            writeToExcel(data, filePath);
            System.out.println("Archivo Excel creado exitosamente.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static void deleteFileIfExists(String filePath) {
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("El archivo '" + file.getName() + "' fue eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo '" + file.getName() + "'.");
            }
        } else {
            System.out.println("El archivo '" + file.getName() + "' no existe en la ruta especificada.");
        }
    }

    public static void writeToExcel(String data, String filePath) throws IOException {
        Workbook workbook;
        File file = new File(filePath);

        // Verificar si el archivo ya existe
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = new XSSFWorkbook();
        }

        // Verificar si la hoja ya existe antes de crearla
        Sheet sheet = workbook.getSheet("Data");
        if (sheet == null) {
            sheet = workbook.createSheet("Data");
        } else {
            // Obtener la última fila ocupada
            int lastRowNum = sheet.getLastRowNum();
            // Comenzar desde la siguiente fila disponible
            int nextRowNum = lastRowNum + 1;
            // Asegurarse de no exceder el límite de filas
            if (nextRowNum >= Short.MAX_VALUE) {
                throw new IOException("Excedido el límite de filas en la hoja de cálculo.");
            }
        }

        String[] lines = data.split("\n");

        // Obtener la siguiente fila disponible
        int rowNum = sheet.getLastRowNum() + 2;

        for (String line : lines) {
            String[] cells = line.trim().split("\\|");
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String cellData : cells) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellData);
            }
            // Aplicar formato condicional a la fila
            applyRowConditionalFormatting(row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }

    public static void writeToExcelTestFail(String data, String filePath) throws IOException {
        Workbook workbook;
        File file = new File(filePath);

        // Verificar si el archivo ya existe
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
        } else {
            workbook = new XSSFWorkbook();
        }

        // Verificar si la hoja ya existe antes de crearla
        Sheet sheet = workbook.getSheet("TestFail");
        if (sheet == null) {
            sheet = workbook.createSheet("TestFail");
        } else {
            // Obtener la última fila ocupada
            int lastRowNum = sheet.getLastRowNum();
            // Comenzar desde la siguiente fila disponible
            int nextRowNum = lastRowNum + 1;
            // Asegurarse de no exceder el límite de filas
            if (nextRowNum >= Short.MAX_VALUE) {
                throw new IOException("Excedido el límite de filas en la hoja de cálculo.");
            }
        }

        String[] lines = data.split("\n");

        // Obtener la siguiente fila disponible
        int rowNum = sheet.getLastRowNum() + 1;

        for (String line : lines) {
            String[] cells = line.trim().split("\\|");
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;
            for (String cellData : cells) {
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue(cellData);
            }
            // Aplicar formato condicional a la fila
            applyRowConditionalFormatting(row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }

    public static void applyRowConditionalFormatting(Row row) {
        boolean isTrue = false;
        boolean LOG_INFORMATIVO = false;
        boolean EQUALS=false;
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() == CellType.STRING && "true".equals(cell.getStringCellValue().toLowerCase())) {
                isTrue = true;
                break;
            } else if (cell != null && cell.getCellType() == CellType.STRING && "resultado".equals(cell.getStringCellValue().toLowerCase())) {
                isTrue = true;
                break;
            } else if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().toLowerCase().split(":")[0].equalsIgnoreCase("true")) {
                isTrue = true;
                break;
            } else if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().toLowerCase().split(":")[0].equalsIgnoreCase("EQUALS")) {
                isTrue = true;
                EQUALS=true;
                break;
            } else if (cell != null && cell.getCellType() == CellType.STRING && cell.getStringCellValue().toLowerCase().split(":")[0].equalsIgnoreCase("LOG INFORMATIVO")) {
                isTrue = true;
                LOG_INFORMATIVO = true;
                break;
            }
        }
        CellStyle style = row.getSheet().getWorkbook().createCellStyle();
        if (isTrue) {
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        } else {
            style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        }
        if (LOG_INFORMATIVO) {
            style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        }

        if (EQUALS) {
            style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE1.getIndex());
        }
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null) {
                cell.setCellStyle(style);
            }
        }
    }
}

