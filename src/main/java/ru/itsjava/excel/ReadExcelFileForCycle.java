package ru.itsjava.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import static org.apache.poi.ss.usermodel.CellType.FORMULA;


public class ReadExcelFile {
    public static void readExcelFile(String filePathName) {
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

                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    /* Интерфейс, включающий методы для работы на листе excel.
                     * */
                    Sheet sheet = workbook.getSheetAt( i );
                    int numberOfRows = sheet.getLastRowNum(); //почему не считает нулевую строку?
                    for (int j = 0; j < numberOfRows; j++) {
                        Row row = sheet.getRow( j );
                        if (row == null) {
                            j++;
                            numberOfRows++;
                        } else {
                            short minColIdx = row.getFirstCellNum();
                            short maxColIdx = row.getLastCellNum();
                            for (short k = minColIdx; k < maxColIdx; k++) {
                                Cell cell = row.getCell( k );
                                String form = formatter.formatCellValue( cell );
                                String formFormula = formatter.formatCellValue( cell, evaluator );
                                if (cell != null) {

                                    /* Этот блок печает тип ячейки
                                    * if (k == row.getLastCellNum() - 1) {
                                    System.out.println( cell.getCellType() );
                                } else {
                                    System.out.print( cell.getCellType() + "\t" );
                                }
                                    * */

                                    if (cell.getCellType() == FORMULA) {

                                        if (k != row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                            System.out.print( formFormula + "\t" );
                                        } else if (k == row.getLastCellNum() - 1 && !Objects.equals( formFormula, "" )) {
                                            System.out.println( formFormula );
                                        } else if (k != row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                            System.out.print( "\t" );
                                        } else if (k == row.getLastCellNum() - 1 && Objects.equals( formFormula, "" )) {
                                            System.out.println();
                                        }

                                    } else {
                                        if (k != row.getLastCellNum() - 1 && !Objects.equals( form, "" )) {
                                            System.out.print( form + "\t" );
                                        } else if (k == row.getLastCellNum() - 1 && !Objects.equals( form, "" )) {
                                            System.out.println( form );
                                        } else if (k != row.getLastCellNum() - 1 && Objects.equals( form, "" )) {
                                            System.out.print( "\t" );
                                        } else if (k == row.getLastCellNum() - 1 && Objects.equals( form, "" )) {
                                            System.out.println();
                                        }
                                    }
                                }


//                            switch (cell.getCellType()) {
//                                case STRING -> {
//
//                                    str = cell.getStringCellValue();
//                                    if (k != row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                        System.out.print( str + "\t" );
//                                    } else if (k == row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                        System.out.println( str );
//                                    } else if (k != row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                        System.out.print( "\t" );
//                                    } else if (k == row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                        System.out.println();
//                                    }
//
//                                    break;
//                                }
//
//                                case FORMULA -> {
//                                    if (!DateUtil.isCellDateFormatted( cell )) {
//                                        str = cell.getStringCellValue();
//                                        if (k != row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                            System.out.print( str + "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                            System.out.println( str );
//                                        } else if (k != row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                            System.out.print( "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                            System.out.println();
//                                        }
//                                    } else {
//                                        date = cell.getDateCellValue();
//                                        if (k != row.getLastCellNum() - 1 && date != null) {
//                                            System.out.print( date + "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num != null) {
//                                            System.out.println( date );
//                                        } else if (k != row.getLastCellNum() - 1 && num == null) {
//                                            System.out.print( "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num == null) {
//                                            System.out.println();
//                                        }
//                                    }
//
//                                    break;
//                                }
//
//                                case NUMERIC -> {
//                                    if (!DateUtil.isCellDateFormatted( cell )) {
//                                        num = cell.getNumericCellValue();
//                                        if (k != row.getLastCellNum() - 1 && num != 0) {
//                                            System.out.print( num + "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num != 0) {
//                                            System.out.println( num );
//                                        } else if (k != row.getLastCellNum() - 1 && num == 0) {
//                                            System.out.print( "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num == 0) {
//                                            System.out.println();
//                                        }
//                                    } else {
//                                        date = cell.getDateCellValue();
//                                        if (k != row.getLastCellNum() - 1 && date != null) {
//                                            System.out.print( date + "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num != null) {
//                                            System.out.println( date );
//                                        } else if (k != row.getLastCellNum() - 1 && num == null) {
//                                            System.out.print( "\t" );
//                                        } else if (k == row.getLastCellNum() - 1 && num == null) {
//                                            System.out.println();
//                                        }
//                                    }
//                                    break;
//                                }
//
//
//                            }
//                            if (DateUtil.isCellDateFormatted( row.getCell( k ) )) {
//                                date = row.getCell( k ).getDateCellValue();
//                                if (k != row.getLastCellNum() - 1 && date != null) {
//                                    System.out.print( date + "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && num != null) {
//                                    System.out.println( date );
//                                } else if (k != row.getLastCellNum() - 1 && num == null) {
//                                    System.out.print( "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && num == null) {
//                                    System.out.println();
//                                }
//                            } else if (row.getCell( k ).getCellType() == CellType.STRING) {
//                                str = sheet.getRow( j ).getCell( k ).getStringCellValue();
//                                if (k != row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                    System.out.print( str + "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && !Objects.equals( str, "" )) {
//                                    System.out.println( str );
//                                } else if (k != row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                    System.out.print( "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && Objects.equals( str, "" )) {
//                                    System.out.println();
//                                }
//                            } else {
//                                num = row.getCell( k ).getNumericCellValue();
//                                if (k != row.getLastCellNum() - 1 && num != 0) {
//                                    System.out.print( num + "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && num != 0) {
//                                    System.out.println( num );
//                                } else if (k != row.getLastCellNum() - 1 && num == 0) {
//                                    System.out.print( "\t" );
//                                } else if (k == row.getLastCellNum() - 1 && num == 0) {
//                                    System.out.println();
//                                }
//                            }
//                            }
                            }
                        }
                    }
                }
            }
        } catch (
                IOException e) {
            throw new RuntimeException( e );
        }

    }

    public static void main(String[] args) {
//        readExcelFile( "src/main/resources/20240301_TERGEKXI_GOMSKE11_sell_norem.xls" );
//        readExcelFile( "src/main/resources/20241024_sib_ppp_consumer_type.xls" );
//        readExcelFile( "D:/Сергеев Я.Б/отчеты АТС/Потребление ГТП ОЭК 2024.xlsx" );
//        readExcelFile( "d:/Сергеев Я.Б/топливные/2012/Топливные составляющие_2012.xls" );
//        readExcelFile( "p:/Trading/Направление планирования и трейдинга/soft/OtchetNew2ЦЗ+_t.xlsb" );
    }
}
