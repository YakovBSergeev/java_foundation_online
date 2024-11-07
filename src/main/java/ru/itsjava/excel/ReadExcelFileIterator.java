package ru.itsjava.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

import static org.apache.poi.ss.usermodel.CellType.FORMULA;


public class ReadExcelFileIterator {
    public static void readExcelFile(String filePathName) {
        long time = System.nanoTime();
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream file = new FileInputStream( filePathName );

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (filePathName.toLowerCase().endsWith( "xlsx" )) {
                workbook = new XSSFWorkbook( file );
            } else if (filePathName.toLowerCase().endsWith( "xls" )) {
                workbook = new HSSFWorkbook( file );
            }
            if (workbook != null) {
                /* Создаем класс FormulaEvaluator , который позволяет нам вычислять результаты формул на листах Excel.
                 * Класс FormulaEvaluator предоставляет метод, называемый оценкой FormulaCell ,
                 * который оценивает значение ячейки для заданного объекта Cell и возвращает объект CellType, представляющий тип данных значения ячейки.
                 * */
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

                /* DataFormatter - это класс для форматирования значений ячеек на основе их типа данных.
                 Он автоматически применяет подходящее форматирование для разных типов значений ячеек, таких как даты, числа и логические значения.
                 Класс полезен при чтении значений ячеек, чтобы обеспечить согласованное форматирование и избежать несовпадений типов данных.
                 * */
                DataFormatter formatter = new DataFormatter();
                Iterator<Sheet> sheetIterator = workbook.iterator();
                while (sheetIterator.hasNext()) {
                    Sheet sheet = sheetIterator.next();
                    if (sheet != null) {
                        Iterator<Row> rowIterator = sheet.iterator();
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
//                            if (row == null) {
//                                rowIterator.next();
//                            } else {
                            for (Cell cell : row) {
                                if (cell != null) {
                                    String form = formatter.formatCellValue( cell );
                                    String formFormula = formatter.formatCellValue( cell, evaluator );

                                    /* Печать адреса ячейки
                                     * */
                                    CellReference cellRef = new CellReference( row.getRowNum(), cell.getColumnIndex() );
                                    System.out.print( cellRef.formatAsString() + ": " );

                                    if (cell.getCellType() == FORMULA) {
                                        if (cell.getColumnIndex() != row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                            System.out.print( formFormula + "\t" );
                                        } else if (cell.getColumnIndex() == row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                            System.out.println( formFormula );
                                        } else if (cell.getColumnIndex() != row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                            System.out.print( "\t" );
                                        } else if (cell.getColumnIndex() == row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                            System.out.println();
                                        }
                                    } else {
                                        if (cell.getColumnIndex() != row.getLastCellNum() - 1 && !Objects.equals( form, "" )) {
                                            System.out.print( form + "\t" );
                                        } else if (cell.getColumnIndex() == row.getLastCellNum() - 1 && !Objects.equals( form, "" )) {
                                            System.out.println( form );
                                        } else if (cell.getColumnIndex() != row.getLastCellNum() - 1 && Objects.equals( form, "" )) {
                                            System.out.print( "\t" );
                                        } else if (cell.getColumnIndex() == row.getLastCellNum() - 1 && Objects.equals( form, "" )) {
                                            System.out.println();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (
                IOException e) {
            throw new RuntimeException( e );
        }
        System.out.println( (System.nanoTime() - time) / 1000000 );
    }

    public static void main(String[] args) {
//        readExcelFile( "src/main/resources/20240301_TERGEKXI_GOMSKE11_sell_norem.xls" );
        readExcelFile( "src/main/resources/20241024_sib_ppp_consumer_type.xls" );
//        readExcelFile( "D:/Сергеев Я.Б/отчеты АТС/Потребление ГТП ОЭК 2024.xlsx" );
//        readExcelFile( "d:/Сергеев Я.Б/топливные/2012/Топливные составляющие_2012.xls" );
//        readExcelFile( "p:/Trading/Направление планирования и трейдинга/soft/OtchetNew2ЦЗ+_t.xlsb" );
    }
}
