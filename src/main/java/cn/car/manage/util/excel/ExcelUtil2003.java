package cn.car.manage.util.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil2003 {

	private HSSFWorkbook xlsWorkBook;
	private HSSFSheet xlsSheet;
	private HSSFRow xlsRow;

	private HSSFCellStyle headerStyle;
	private HSSFCellStyle attributeStyle;

	public HSSFWorkbook getXlsWorkBook() {
		return xlsWorkBook;
	}

	public void setXlsWorkBook(HSSFWorkbook xlsWorkBook) {
		this.xlsWorkBook = xlsWorkBook;
	}

	public HSSFSheet getXlsSheet() {
		return xlsSheet;
	}

	public void setXlsSheet(HSSFSheet xlsSheet) {
		this.xlsSheet = xlsSheet;
	}

	public void setXlsSheet(String sheeetName) {
		this.xlsSheet = xlsWorkBook.getSheet(sheeetName);
	}

	public HSSFRow getXlsRow() {
		return xlsRow;
	}

	public void setXlsRow(HSSFRow xlsRow) {
		this.xlsRow = xlsRow;
	}

	public void setXlsRow(int rowNum) {
		this.xlsRow = this.xlsSheet.getRow(rowNum);
	}

	public HSSFCellStyle getHeaderStyle() {
		return headerStyle;
	}

	public void setHeaderStyle(HSSFCellStyle headerStyle) {
		this.headerStyle = headerStyle;
	}

	public HSSFCellStyle getAttributeStyle() {
		return attributeStyle;
	}

	public void setAttributeStyle(HSSFCellStyle attributeStyle) {
		this.attributeStyle = attributeStyle;
	}

	/**
	 * 
	 * @Description: 创建一个工作簿
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:43:13
	 * @return
	 */
	public ExcelUtil2003 createWorkBook() {
		xlsWorkBook = new HSSFWorkbook();
		return this;
	}

	/**
	 * @Description: 读取指定文件的工作薄
	 * @User: CPC
	 * @Date: 2015年8月26日 上午10:52:47
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public ExcelUtil2003 readWorkBook(String fileName) throws IOException {

		FileInputStream fis = null;
		fis = new FileInputStream(fileName);
		xlsWorkBook = new HSSFWorkbook(fis);

		return this;
	}

	/**
	 * 
	 * @Description: 读取指定文件的工作薄
	 * @User: CPC
	 * @Date: 2015年8月26日 上午10:53:21
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public ExcelUtil2003 readWorkBook(InputStream is) throws IOException {

		xlsWorkBook = new HSSFWorkbook(is);

		return this;
	}

	/**
	 * 
	 * @Description: 根据sheet下标获取当前sheet表格
	 * @User: CPC
	 * @Date: 2015年8月26日 上午10:54:25
	 * @param index
	 * @return
	 */
	public ExcelUtil2003 getSheet(int index) {

		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook is null");
		}

		xlsSheet = xlsWorkBook.getSheetAt(index);

		return this;
	}

	/**
	 * 
	 * @Description: 根据sheet的名称获取sheet页
	 * @User: CPC
	 * @Date: 2015年8月26日 上午10:55:35
	 * @param name
	 * @return
	 */
	public ExcelUtil2003 getSheet(String name) {

		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook is null");
		}

		xlsSheet = xlsWorkBook.getSheet(name);

		return this;

	}

	/**
	 * 
	 * @Description: 获取sheet页数
	 * @User: CPC
	 * @Date: 2015年10月16日 下午2:53:25
	 * @return
	 */
	public int getSheetCount() {
		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook is null");
		}
		return xlsWorkBook.getNumberOfSheets();
	}

	/**
	 * 
	 * @Description: 创建一个sheet表
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:43:41
	 * @param sheetName
	 * @return
	 */
	public ExcelUtil2003 createSheet(String sheetName) {

		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook of excel is null.");
		}

		xlsSheet = xlsWorkBook.createSheet(sheetName);

		return this;
	}

	/**
	 * 
	 * @Description: 创建一行单元格
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:48:34
	 * @param rowNum
	 * @return
	 */
	public ExcelUtil2003 createRow(int rowNum) {

		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		xlsRow = xlsSheet.createRow(rowNum);

		return this;
	}

	/**
	 * 
	 * @Description: 创建一行单元格
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:57:57
	 * @param rowNum
	 * @param cells
	 * @param startCell
	 * @return
	 */
	public ExcelUtil2003 createRow(int rowNum, List<String> cells, int startCell) {

		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		HSSFRow xlsRow = xlsSheet.createRow(rowNum);
		if (xlsRow == null) {
			throw new RuntimeException("Get " + rowNum + " row failure.");
		}

		HSSFCell xlsCell = null;

		for (int i = 0; i < cells.size(); i++) {
			xlsCell = xlsRow.createCell(startCell + i);
			xlsCell.setCellValue(cells.get(i));
		}

		return this;
	}

	/**
	 * 
	 * @Description: 设置已存在的一行单元格
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:59:43
	 * @param rowNum
	 * @param cells
	 * @param startCell
	 * @return
	 */
	public ExcelUtil2003 setRow(int rowNum, List<String> cells, int startCell) {

		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		HSSFRow xlsRow = xlsSheet.getRow(rowNum);
		if (xlsRow == null) {
			throw new RuntimeException("Get " + rowNum + " row failure.");
		}

		HSSFCell xlsCell = null;

		for (int i = 0; i < cells.size(); i++) {
			xlsCell = xlsRow.createCell(startCell + i);
			xlsCell.setCellValue(cells.get(i));
		}

		return this;
	}

	/**
	 * 
	 * @Description: 获取指定行
	 * @User: CPC
	 * @Date: 2015年8月26日 上午11:01:04
	 * @param rowIndex
	 * @return
	 */
	public ExcelUtil2003 getRow(int rowIndex) {

		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		xlsRow = xlsSheet.getRow(rowIndex);

		return this;
	}

	/**
	 * 
	 * @Description: 创建一个单元格并写入值
	 * @User: CPC
	 * @Date: 2015年8月19日 下午2:50:11
	 * @param cellNum
	 * @param value
	 * @return
	 */
	public ExcelUtil2003 createCell(int columnNum, Object value) {

		if (xlsRow == null) {
			throw new RuntimeException("The row of sheet is null.");
		}

		HSSFCell xlsCell = xlsRow.createCell(columnNum);
		if (xlsCell == null) {
			throw new RuntimeException("Create cell of column " + columnNum + " failure.");
		}

		xlsCell.setCellValue(value.toString());

		return this;
	}

	/**
	 * 
	 * @Description: 获取指定行的所有单元格的内容
	 * @User: CPC
	 * @Date: 2015年8月26日 上午11:05:34
	 * @return
	 */
	public List<String> getCells() {

		if (xlsRow == null) {
			throw new RuntimeException("The row of sheet is null.");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<String> cells = new ArrayList<String>();
		HSSFCell xlsCell = null;

		for (int i = xlsRow.getFirstCellNum(); i < xlsRow.getLastCellNum(); i++) {
			xlsCell = xlsRow.getCell(i);
			if (xlsCell != null) {

				switch (xlsCell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					// 如果当前单元格内容这日期格式
					if (DateUtil.isCellDateFormatted(xlsCell)) {
						double value = xlsCell.getNumericCellValue();
						Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
						cells.add(sdf.format(date));
					}else{
						cells.add(String.valueOf(xlsCell.getStringCellValue()));
					}
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					cells.add(String.valueOf(xlsCell.getBooleanCellValue()));
					break;
				case Cell.CELL_TYPE_ERROR:
					break;
				case Cell.CELL_TYPE_STRING:
					cells.add(xlsCell.getStringCellValue());
					break;
				default:

				}
			} else {
				cells.add("");
			}
		}

		return cells;
	}

	/**
	 * 
	 * @Description: 获取当前sheet中所有有数据的单元格的内容
	 * @User: CPC
	 * @Date: 2015年8月26日 上午11:21:40
	 * @return
	 */
	public List<List<String>> getSheetCells() {

		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		List<List<String>> sheetCells = new ArrayList<List<String>>();

		for (int i = xlsSheet.getFirstRowNum(); i < xlsSheet.getLastRowNum(); i++) {
			xlsRow = xlsSheet.getRow(i);
			if (xlsRow != null) {
				sheetCells.add(getCells());
			}
		}

		return sheetCells;
	}

	public List<List<String>> getSheetCells(HSSFSheet xssfSheet) {
		List<List<String>> sheetCells = new ArrayList<List<String>>();

		for (int i = xssfSheet.getFirstRowNum(); i <= xssfSheet.getLastRowNum(); i++) {
			xlsRow = xssfSheet.getRow(i);
			if (xlsRow != null) {
				sheetCells.add(getCells());
			}
		}
		return sheetCells;
	}

	/**
	 * 
	 * @Description: 将表格写入文件
	 * @User: CPC
	 * @Date: 2015年8月19日 下午3:04:58
	 * @param fileName
	 * @return
	 */
	public ExcelUtil2003 writeToFile(String fileName) {

		FileOutputStream fos = null;
		try {

			fos = new FileOutputStream(fileName.trim());
			xlsWorkBook.write(fos);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				xlsWorkBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return this;
	}

	/**
	 * 
	 * @Description: 将excel写入到一个输出流中
	 * @User: CPC
	 * @Date: 2015年8月25日 上午9:10:00
	 * @param outputStream
	 * @return
	 * @throws IOException
	 */
	public ExcelUtil2003 writeToOutputStream(OutputStream outputStream) throws IOException {

		if (outputStream == null) {
			throw new RuntimeException("OutputStream is null");
		}

		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook of excel is null");
		}

		xlsWorkBook.write(outputStream);

		return this;
	}

	/**
	 * 
	 * @Description: 关闭Excel相关对象
	 * @User: CPC
	 * @Date: 2015年8月24日 上午11:27:19
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (xlsWorkBook != null) {
			xlsWorkBook.close();
		}
	}

	/**
	 * 
	 * @Description: 创建一个单元格样式
	 * @return
	 */
	public ExcelUtil2003 createCellStyle() {

		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook is null");
		}

		headerStyle = xlsWorkBook.createCellStyle();
		headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle.setWrapText(true);

		HSSFFont headerFont = xlsWorkBook.createFont();
		headerFont.setFontName("黑体");
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);// 粗体显示
		headerFont.setFontHeightInPoints((short) 16);// 设置字体大小
		headerStyle.setFont(headerFont);

		attributeStyle = xlsWorkBook.createCellStyle();
		attributeStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
		attributeStyle.setAlignment(CellStyle.ALIGN_CENTER);
		attributeStyle.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		attributeStyle.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		attributeStyle.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		attributeStyle.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		HSSFFont CellFont = xlsWorkBook.createFont();
		CellFont.setFontName("仿宋_GB2312");
		CellFont.setFontHeightInPoints((short) 14);// 设置字体大小
		attributeStyle.setFont(CellFont);

		return this;
	}

	public ExcelUtil2003 mergedRegion(int size) {
		CellRangeAddress region = new CellRangeAddress(0, 0, (short) 0, (short) size);
		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}
		xlsSheet.addMergedRegion(region);
		return this;
	}

	public ExcelUtil2003 createSheet(String sheetName, Map<Integer, List<String>> xlsHeaderMap) {
		HSSFSheet xlsSheet = xlsWorkBook.createSheet(sheetName);
		if (xlsSheet == null) {
			throw new RuntimeException("The sheet of workbook is null.");
		}

		Iterator<Integer> rows = xlsHeaderMap.keySet().iterator();
		while (rows.hasNext()) {
			int rowNum = rows.next();
			List<String> attributes = xlsHeaderMap.get(rowNum);
			if (rowNum == 0 && attributes != null && attributes.size() > 0) {
				// HSSFRow xlsRow = xlsSheet.getRow(rowNum);
				CellRangeAddress region = new CellRangeAddress(0, 0, (short) 0, (short) (attributes.size() - 1));
				xlsSheet.addMergedRegion(region);
				HSSFCellStyle headerStyle = xlsWorkBook.createCellStyle();
				headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
				headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
				headerStyle.setWrapText(true);

				HSSFFont headerFont = xlsWorkBook.createFont();
				headerFont.setFontName("黑体");
				headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);// 粗体显示
				// headerFont.setFontHeightInPoints((short) 16);// 设置字体大小
				headerStyle.setFont(headerFont);
				this.createRow(xlsSheet, rowNum, attributes, headerStyle);
			}

			if (rowNum == 1 && attributes != null && attributes.size() > 0) {
				// HSSFRow xlsRow = xlsSheet.getRow(rowNum);
				HSSFCellStyle attributeStyle = xlsWorkBook.createCellStyle();
				attributeStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直
				attributeStyle.setAlignment(CellStyle.ALIGN_CENTER);
				attributeStyle.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
				attributeStyle.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
				attributeStyle.setBorderTop(CellStyle.BORDER_THIN);// 上边框
				attributeStyle.setBorderRight(CellStyle.BORDER_THIN);// 右边框

				HSSFFont CellFont = xlsWorkBook.createFont();
				CellFont.setFontName("仿宋_GB2312");
				// CellFont.setFontHeightInPoints((short) 14);// 设置字体大小
				attributeStyle.setFont(CellFont);
				this.createRow(xlsSheet, rowNum, attributes, attributeStyle);
			}
		}
		return this;
	}

	public ExcelUtil2003 createRow(HSSFSheet xlsSheet, int rowNum, List<String> attributes, HSSFCellStyle cellStyle) {
		HSSFRow xlsRow = xlsSheet.createRow(rowNum);

		if (xlsRow == null) {
			throw new RuntimeException("Get " + rowNum + " row failure.");
		}

		HSSFCell xlsCell = null;

		for (int i = 0; i < attributes.size(); i++) {
			xlsCell = xlsRow.createCell(i);
			xlsCell.setCellValue(attributes.get(i));
			xlsCell.setCellStyle(cellStyle);
		}

		return this;
	}

	/*
	 * 获得所有sheet
	 */
	public List<HSSFSheet> getXlsSheets() {
		if (xlsWorkBook == null) {
			throw new RuntimeException("The workbook is null");
		}

		List<HSSFSheet> xssfSheets = new ArrayList<HSSFSheet>();
		for (int i = 0; i < xlsWorkBook.getNumberOfSheets(); i++) {// 获取每个Sheet表
			xssfSheets.add(xlsWorkBook.getSheetAt(i));
		}
		return xssfSheets;
	}

}
