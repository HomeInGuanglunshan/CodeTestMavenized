package generateCode.p01_util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class GenerateCodes {
	
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;

	public String templateFilePath = "C:/Users/Administrator/Desktop/workspace/存量自改_导入.xls";
	
	public String mappingFilePath = "C:/Users/Administrator/Desktop/workspace/mapping.txt";
	
	public String generatedFilePath = "C:/Users/Administrator/Desktop/workspace/generatedCodes.java";
	
	public String productFilePath = "C:/Users/Administrator/Desktop/workspace/站点及起租表信息_总.xls";
	
	ExcelReader excelReader = new ExcelReader();
	
	public void generateCodes() {
		
		Map<Integer, String> excelHeader = new HashMap<Integer, String>();
		
		Map<String, String> commentAndCode = new HashMap<String, String>();
		
		try {
			// 对读取Excel表格标题测试
			InputStream is = new FileInputStream(templateFilePath);
			ExcelReader excelReader = new ExcelReader();
			String[] title = excelReader.readExcelTitle(is);
			for (int i = 0; i < title.length; i++) {
				excelHeader.put(i, title[i].trim());
			}
			
			
			// 读入原始的“comment - code”映射
			FileInputStream fis = new FileInputStream(mappingFilePath);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = "";
			while ((line = br.readLine()) != null) {
				Matcher m = Pattern.compile("(\\S+)\\s*(\\S*)").matcher(line);
				while (m.find()) {
					commentAndCode.put(m.group(1), CamelAndUnderline.underline2Camel(m.group(2)));
				}
			}
			
			// 开始生成代码
			is = new FileInputStream(productFilePath);
			try {
				fs = new POIFSFileSystem(is);
				wb = new HSSFWorkbook(fs);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = wb.getSheetAt(0);
			
			FileOutputStream fos=new FileOutputStream(new File(generatedFilePath));
	        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
	        BufferedWriter  bw=new BufferedWriter(osw);
	        
	        String attr = "";
			String isNull = "";
	        
	        int index = 0;
			for (Map.Entry<Integer, String> m : excelHeader.entrySet()) {
				
				for (int i = 2; i < 92; i++) {
					row = sheet.getRow(i);
					String capturedField = excelReader.getCellFormatValue(row.getCell(1)).trim();
					if (!m.getValue().equals(capturedField)) {
						continue;
					} else {
						attr = excelReader.getCellFormatValue(row.getCell(13)).trim();
						isNull = excelReader.getCellFormatValue(row.getCell(15)).trim();
						break;
					}
				}
				
				String attrStrPrefix = "";
				String attrStrSuffix = "";
				if ("数值".equals(attr)) {
					attrStrPrefix = "new BigDecimal(";
					attrStrSuffix = ")";
				} else if ("日期".equals(attr)) {
					attrStrPrefix = "getDateByDateTime(";
					attrStrSuffix = ")";
				}
				
				String isNullStrPrefix = "";
				String isNullStrSuffix = "";
				if ("是".equals(isNull)) {
					isNullStrPrefix = "\tif (StringUtils.isBlank(list.get(i))) {\n\t";
					isNullStrSuffix = "\t}\n";
				}
				
				if (index == 0) {
					bw.write("if (i == " + index + ") {\n");
				} else {
					bw.write("else if (i == " + index + ") {\n");
				}
				bw.write(isNullStrPrefix);
				bw.write("\tstartingRentingInfo.set" + commentAndCode.get(m.getValue()) + "(" + attrStrPrefix + "list.get(i)" + attrStrSuffix + ");\n");
				bw.write(isNullStrSuffix);
				bw.write("}\n");
				index++;
			}
			
			br.close();
			isr.close();
			fis.close();
			
			bw.close();
	        osw.close();
	        fos.close();
	        
	        is.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GenerateCodes().generateCodes();
	}
	
}
