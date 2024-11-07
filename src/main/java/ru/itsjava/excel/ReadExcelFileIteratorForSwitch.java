package ru.itsjava.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Objects;


public class ReadExcelFileIteratorForSwitch {
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
                            if (row == null) {
                                rowIterator.next();
                            } else {
                                short minColIdx = row.getFirstCellNum();
                                short maxColIdx = row.getLastCellNum();
                                for (short i = minColIdx; i < maxColIdx; i++) {
                                    Cell cell = row.getCell( i );
                                    if (cell != null) {
                                        String form = formatter.formatCellValue( cell );
                                        String formFormula = formatter.formatCellValue( cell, evaluator );
                                        DecimalFormat df = new DecimalFormat("###.###"); // Задаем кол-во знаков округления.
                                        switch (cell.getCellType()) {
                                            case FORMULA -> {
                                                switch (evaluator.evaluateFormulaCell( cell )) {
                                                    case BOOLEAN:
                                                        if (i != row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                            System.out.print( cell.getBooleanCellValue() + "\t" );
                                                        } else if (i == row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                            System.out.println( cell.getBooleanCellValue() );
                                                        } else if (i != row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                            System.out.print( "\t" );
                                                        } else if (i == row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                            System.out.println();
                                                        }
                                                        break;
                                                    case NUMERIC:
                                                        if (!DateUtil.isCellDateFormatted( cell )) {
                                                            if (i != row.getLastCellNum() - 1 && cell.getNumericCellValue() != 0) {
                                                                if (cell.getCellStyle().getDataFormatString().contains( "%" )) {
                                                                    // Detect Percent Values
                                                                    double value = (cell.getNumericCellValue() * 100);
                                                                    System.out.print( df.format(value) + "%" + "\t" );
                                                                } else {
                                                                    System.out.print( df.format(cell.getNumericCellValue()) + "\t" );
                                                                }
                                                            } else if (i == row.getLastCellNum() - 1 && cell.getNumericCellValue() != 0) {
                                                                if (cell.getCellStyle().getDataFormatString().contains( "%" )) {
                                                                    // Detect Percent Values
                                                                    double value = (cell.getNumericCellValue() * 100);
                                                                    System.out.println( df.format(value) + "%" + "\t" );
                                                                } else {
                                                                    System.out.println( df.format(cell.getNumericCellValue()) + "\t" );
                                                                }
                                                            } else if (i != row.getLastCellNum() - 1 && cell.getNumericCellValue() == 0) {
                                                                System.out.print( "\t" );
                                                            } else if (i == row.getLastCellNum() - 1 && cell.getNumericCellValue() == 0) {
                                                                System.out.println();
                                                            }
                                                        } else {
                                                            CellDateFormatter cellDateFormatter = new CellDateFormatter( "mmmm" );
                                                            if (i != row.getLastCellNum() - 1 && cell.getDateCellValue() != null) {
                                                                System.out.print( cellDateFormatter.format( cell.getDateCellValue() ) + "\t" );
                                                            } else if (i == row.getLastCellNum() - 1 && cell.getDateCellValue() != null) {
                                                                System.out.println( cellDateFormatter.format( cell.getDateCellValue() ) );
                                                            } else if (i != row.getLastCellNum() - 1 && cell.getDateCellValue() == null) {
                                                                System.out.print( "\t" );
                                                            } else if (i == row.getLastCellNum() - 1 && cell.getDateCellValue() == null) {
                                                                System.out.println();
                                                            }
                                                        }
                                                        break;
                                                    case STRING:
                                                        if (i != row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                            System.out.print( formFormula + "\t" );
                                                        } else if (i == row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                            System.out.println( formFormula );
                                                        } else if (i != row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                            System.out.print( "\t" );
                                                        } else if (i == row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                            System.out.println();
                                                        }
                                                        break;
                                                    case BLANK, ERROR, _NONE:
                                                        if (i != row.getLastCellNum() - 1) {
                                                            System.out.print( "\t" );
                                                        } else if (i == row.getLastCellNum() - 1) {
                                                            System.out.println();
                                                        }
                                                        break;
                                                }
                                            }
                                            case NUMERIC -> {
                                                if (!DateUtil.isCellDateFormatted( cell )) {
                                                    if (i != row.getLastCellNum() - 1 && cell.getNumericCellValue() != 0) {
                                                        if (cell.getCellStyle().getDataFormatString().contains( "%" )) {
                                                            // Detect Percent Values
                                                            double value = (cell.getNumericCellValue() * 100);
                                                            System.out.print( df.format(value) + "%" + "\t" );
                                                        } else {
                                                            System.out.print( df.format(cell.getNumericCellValue()) + "\t" );
                                                        }
                                                    } else if (i == row.getLastCellNum() - 1 && cell.getNumericCellValue() != 0) {
                                                        if (cell.getCellStyle().getDataFormatString().contains( "%" )) {
                                                            // Detect Percent Values
                                                            double value = (cell.getNumericCellValue() * 100);
                                                            System.out.println( df.format(value) + "%" + "\t" );
                                                        } else {
                                                            System.out.println( df.format(cell.getNumericCellValue()) + "\t" );
                                                        }
                                                    } else if (i != row.getLastCellNum() - 1 && cell.getNumericCellValue() == 0) {
                                                        System.out.print( "\t" );
                                                    } else if (i == row.getLastCellNum() - 1 && cell.getNumericCellValue() == 0) {
                                                        System.out.println();
                                                    }
                                                } else {
                                                    CellDateFormatter cellDateFormatter = new CellDateFormatter( "yyyy" );
                                                    if (i != row.getLastCellNum() - 1 && cell.getDateCellValue() != null) {
                                                        System.out.print( cellDateFormatter.format( cell.getDateCellValue() ) + "\t" );
                                                    } else if (i == row.getLastCellNum() - 1 && cell.getDateCellValue() != null) {
                                                        System.out.println( cellDateFormatter.format( cell.getDateCellValue() ) );
                                                    } else if (i != row.getLastCellNum() - 1 && cell.getDateCellValue() == null) {
                                                        System.out.print( "\t" );
                                                    } else if (i == row.getLastCellNum() - 1 && cell.getDateCellValue() == null) {
                                                        System.out.println();
                                                    }
                                                }
                                                break;
                                            }
                                            case STRING -> {
                                                if (i != row.getLastCellNum() - 1 && !Objects.equals( cell.getStringCellValue(), "" )) {
                                                    System.out.print( cell.getStringCellValue() + "\t" );
                                                } else if (i == row.getLastCellNum() - 1 && !Objects.equals( cell.getStringCellValue(), "" )) {
                                                    System.out.println( cell.getStringCellValue() );
                                                } else if (i != row.getLastCellNum() - 1 && Objects.equals( cell.getStringCellValue(), "" )) {
                                                    System.out.print( "\t" );
                                                } else if (i == row.getLastCellNum() - 1 && Objects.equals( cell.getStringCellValue(), "" )) {
                                                    System.out.println();
                                                }
                                                break;
                                            }
                                            case BOOLEAN -> {
                                                if (i != row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                    System.out.print( cell.getBooleanCellValue() + "\t" );
                                                } else if (i == row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                                    System.out.println( cell.getBooleanCellValue() );
                                                } else if (i != row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                    System.out.print( "\t" );
                                                } else if (i == row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                                    System.out.println();
                                                }
                                                break;
                                            }
                                            case BLANK, ERROR, _NONE -> {
                                                if (i != row.getLastCellNum() - 1) {
                                                    System.out.print( "\t" );
                                                } else if (i == row.getLastCellNum() - 1) {
                                                    System.out.println();
                                                }
                                                break;
                                            }
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
//        readExcelFile( "src/main/resources/20241024_sib_ppp_consumer_type.xls" );
        readExcelFile( "D:/Сергеев Я.Б/отчеты АТС/Потребление ГТП ОЭК 2024.xlsx" );
//        readExcelFile( "d:/Сергеев Я.Б/топливные/2012/Топливные составляющие_2012.xls" );
//        readExcelFile( "p:/Trading/Направление планирования и трейдинга/soft/OtchetNew2ЦЗ+_t.xlsb" );
    }
}
