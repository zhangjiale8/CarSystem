package cn.car.manage.util.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static final String CELL_DATE_FORMAT = "yyyy-MM-dd";
	
	private Workbook workbook;
	private Sheet currentSheet;
	private Row currentRow;
	
	public Workbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	public Sheet getCurrentSheet() {
		return currentSheet;
	}
	public void setCurrentSheet(Sheet currentSheet) {
		this.currentSheet = currentSheet;
	}
	public Row getCurrentRow() {
		return currentRow;
	}


	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}
	
	
	public ExcelUtil openWorkBook(){
		this.workbook = new XSSFWorkbook();
		return this;
	}
	

	/**
	 * 打开工作薄
	 * @param is
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelUtil openWorkBook(InputStream is) throws Exception{
		this.workbook = WorkbookFactory.create(is);
		is.close();
		return this;
	}
	
	
	/**
	 * 打开工作薄
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 */
	public ExcelUtil openWorkBook(String fileName) throws IOException, EncryptedDocumentException, InvalidFormatException{
		FileInputStream fis = new FileInputStream(fileName.trim());
		this.workbook = WorkbookFactory.create(fis);
		return this;
	}
	
	
	/**
	 * 打开第index个sheet
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public ExcelUtil getSheet(int index) throws IndexOutOfBoundsException{
		if(index >= this.getSheetCount()){
			throw new IndexOutOfBoundsException("index必须在0-" + this.getSheetCount() + "之间");
		}
		
		validateWorkBook(this.workbook);
		
		this.currentSheet = this.workbook.getSheetAt(index);
		return this;
	}
	
	
	/**
	 * 根据sheet名称打开sheet
	 * @param name
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	public ExcelUtil getSheet(String name) throws IllegalArgumentException, IllegalStateException{
		if(name == null || name.trim().isEmpty()){
			throw new IllegalArgumentException("Sheet名称不能为null和空字符串");
		}
		
		validateWorkBook(this.workbook);
		
		this.currentSheet = this.workbook.getSheet(name.trim());
		if(this.currentSheet == null){
			throw new IllegalStateException("Sheet'" + name + "'不存在");
		}
		return this;
	}
	
	
	/**
	 * 新建一个sheet
	 * @param sheetName 新sheet的名称
	 * @return
	 */
	public ExcelUtil createSheet(String sheetName){
		if(sheetName == null || sheetName.trim().isEmpty()){
			throw new IllegalArgumentException("Sheet名称不能为null和空字符串");
		}
		
		validateWorkBook(this.workbook);
		
		this.currentSheet = this.workbook.getSheet(sheetName.trim());
		if(this.currentSheet == null){
			this.currentSheet = this.workbook.createSheet(sheetName.trim());
		}
		
		return this;
	}
	
	/**
	 * 创建一行信息, 如果该行已经有内容则定位到该行(不修改内容)
	 * @param rowNum
	 * @return
	 */
	public ExcelUtil createRow(int rowNum){
		validateSheet(this.currentSheet);
		if(rowNum < 0){
			throw new IndexOutOfBoundsException("行号必须不能小于0");
		}
		
		this.currentRow = this.currentSheet.getRow(rowNum);
		if(this.currentRow == null){
			this.currentRow = this.currentSheet.createRow(rowNum);
			
		}
		return this;
	}
	
	
	/**
	 * 修改指定行的内容
	 * @param rowNum 要修改的行号
	 * @param row 新内容
	 * @param startCell 新内容开始写入的列号
	 * @return
	 */
	public ExcelUtil setRow(int rowNum, List<Object> row, int startCell){
		if(row == null || startCell < 0){
			throw new IllegalArgumentException("无效的cells或startCell");
		}
		validateSheet(this.currentSheet);
		this.createRow(rowNum);
		for(int i=0,j=startCell, endCell=row.size(); i<endCell; i++, j++){
			this.setCell(this.currentRow.getRowNum(), j, row.get(i));
		}
		
		return this;
	}
	
	
	/**
	 * 定位到指定行
	 * @param rowNum
	 * @return
	 */
	public ExcelUtil getRow(int rowNum){
		validateSheet(this.currentSheet);
		this.currentRow = this.currentSheet.getRow(rowNum);
		return this;
	}
	
	
	/**
	 * 设置指定单元格的内容
	 * @param rowNum 单元格所在的行
	 * @param cellNum 单元格所在的列
	 * @param value 单元格的新内容
	 * @return
	 */
	public ExcelUtil setCell(int rowNum, int cellNum, Object value){
		this.getRow(rowNum);
		validateRow(this.currentRow);
		Cell cell = this.currentRow.getCell(cellNum);
		if(cell == null){
			cell = this.currentRow.createCell(cellNum);
		}
		cell.setCellValue(value.toString());
		return this;
	}
	
	/**
	 * 设置指定单元格的内容和样式
	 * @param rowNum 单元格所在的行
	 * @param cellNum 单元格所在的列
	 * @param value 单元格的新内容
	 * @param style 单元格的样式
	 * @return
	 */
	public ExcelUtil setCell(int rowNum, int cellNum, Object value, XSSFCellStyle style){
		this.getRow(rowNum);
		validateRow(this.currentRow);
		Cell cell = this.currentRow.getCell(cellNum);
		if(cell == null){
			throw new NullPointerException("未找到单元格");
		}
		cell.setCellValue(value.toString());
		cell.setCellStyle(style);
		return this;
	}
	
	
	/**
	 * 将更新的内容写入到文件中
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public ExcelUtil writeToFile(String fileName) throws IOException{
		if(fileName == null || fileName.trim().isEmpty()){
			throw new IOException("指定要写入的文件");
		}
		validateWorkBook(this.workbook);
		FileOutputStream fos = new FileOutputStream(fileName);
		this.workbook.write(fos);
		fos.close();
		return this;
	}
	
	
	/**
	 * 将更新的内容写入到文件中
	 * @param outputStream
	 * @return
	 * @throws IOException
	 */
	public ExcelUtil writeToOutputStream(OutputStream outputStream) throws IOException{
		if(outputStream == null){
			throw new IOException("错误的文件流");
		}
		validateWorkBook(this.workbook);
		this.workbook.write(outputStream);
		return this;
	}
	
	/**
	 * 关闭打开的工作薄
	 * @throws IOException
	 */
	public void close() throws IOException{
		if(this.workbook != null){
			this.workbook.close();
		}
	}
	
	/**
	 * 获取当前工作薄的sheet数量
	 * @return
	 */
	public int getSheetCount(){
		return this.workbook.getNumberOfSheets();
	}
	
	/**
	 * 获取sheet内的行数
	 * @return
	 */
	public int getRowCount(){
		validateSheet(this.currentSheet);
		return this.currentSheet.getLastRowNum();
	}
	
	/**
	 * 获取当前行的内容
	 * @return
	 */
	public List<Object> getCells(){
		return this.getCells(CELL_DATE_FORMAT);
	}
	
	/**
	 * 获取当前行的内容
	 * @param dateFormat
	 * @return
	 */
	public List<Object> getCells(String dateFormat){
		validateRow(this.currentRow);
		int startCellIndex = this.currentRow.getFirstCellNum();
		int endCellIndex = this.currentRow.getLastCellNum();
		if(endCellIndex <= 0){
			return new ArrayList<Object>();
		}
		dateFormat = dateFormat == null ? CELL_DATE_FORMAT : dateFormat;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		List<Object> cells = new ArrayList<Object>(endCellIndex);
		Cell cell = null;
		for (int i = startCellIndex; i < endCellIndex; i++) {
			cell = this.currentRow.getCell(i);
			if(cell == null){
				cell = this.currentRow.createCell(i);
			}
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				// 如果当前单元格内容这日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					cells.add(sdf.format(date));
				}else{
				    long longVal = Math.round(cell.getNumericCellValue()); 
				    double doubleVal = cell.getNumericCellValue();
				    Object value = null;
				    if(Double.parseDouble(longVal + ".0") == doubleVal){
				    	value = longVal;  
				    }else{
				    	value = doubleVal;  				    	
				    }
					cells.add(value);
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cells.add(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				break;
			case Cell.CELL_TYPE_STRING:
				cells.add(cell.getStringCellValue());
				break;
			default:
				cells.add(cell.getStringCellValue());
			}
		}
		return cells;
	}
	
	/**
	 * 获取行的内容
	 * @param rowNum
	 * @return
	 */
	public List<Object> getCells(int rowNum){
		validateSheet(this.currentSheet);
		this.getRow(rowNum);
		return this.getCells();
	}
	
	/**
	 * 获取sheet的所有行
	 * @return
	 */
	public List<List<Object>> getSheetCells(){
		return this.getSheetCells(0, -1) ;
	}
	
	/**
	 * 获取sheet指定行区间的所有内容
	 * @param startRow 
	 * @param endRow 如果<0则默认读取到最后一行
	 * @return
	 */
	public List<List<Object>> getSheetCells(int startRow, int endRow){
		validateSheet(this.currentSheet);
		int startRowIndex = this.currentSheet.getFirstRowNum();
		startRowIndex = startRow >= 0 ? startRow : startRowIndex;
		int endRowIndex = endRow > 0 ? endRow : this.currentSheet.getLastRowNum();
		
		if(endRowIndex <= 0){
			return new ArrayList<List<Object>>();
		}
		
		List<List<Object>> rows = new ArrayList<List<Object>>(endRowIndex - startRowIndex);
		for(int i=startRowIndex; i<=endRowIndex; i++){
			this.getRow(i);
			if(this.currentRow == null){
				continue;
			}
			rows.add(this.getCells());
		}
		return rows;
	}
	
	private void validateWorkBook(Workbook workbook) throws NullPointerException{
		if(workbook == null){
			throw new NullPointerException("未初始化的WorkBook, 请先调用openWorkBook方法");
		}
	}
	
	
	private void validateSheet(Sheet sheet) throws NullPointerException{
		if(sheet == null){
			throw new NullPointerException("未选择Sheet, 请先调用getSheet方法");
		}
	}
	
	private void validateRow(Row row) throws NullPointerException{
		validateSheet(this.currentSheet);
		if(row == null){
			throw new NullPointerException("未知的行");
		}
	}
}