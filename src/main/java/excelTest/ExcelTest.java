package excelTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelTest {

	public static void main(String[] args) {
		generateExcel();
	}

	private static void generateExcel() {
		try {
			File file_input = new File("F:\\DHCP_POOL_UTIL_BLK_NETWORK_1481164941668.xls");
			POIFSFileSystem fs_input = new POIFSFileSystem(new FileInputStream(file_input));
			HSSFWorkbook wb_input = new HSSFWorkbook(fs_input);

			File file_output = new File("F:\\result_template.xls");
			POIFSFileSystem fs_output = new POIFSFileSystem(new FileInputStream(file_output));
			HSSFWorkbook wb_output = new HSSFWorkbook(fs_output);

			HSSFSheet sheet_output = wb_output.getSheetAt(0);
			HSSFSheet sheet_input = wb_input.getSheetAt(0);

			Map<Integer, String> tree = new HashMap<Integer, String>();
			tree.put(0, "0");

			int row_output_index = 1;
			int lastRowNum = sheet_input.getLastRowNum();
			for (int r = 9; r <= lastRowNum; r++) {
				int level = 0;
				String father = "";
				HSSFRow row_input = sheet_input.getRow(r);
				HSSFRow rowAgent = null;
				rowAgent = sheet_output.getRow(row_output_index);
				rowAgent = sheet_output.createRow(row_output_index);
				for (Cell column_input : row_input) {
					int column_input_index = column_input.getColumnIndex();
					switch (column_input_index) {
					case 0:
						break;
					case 1:
						String node = column_input.getRichStringCellValue() + "";
						level = getNodeLevel(node);
						tree.put(level, node.trim());
						rowAgent.createCell(0).setCellValue(node.trim());
					case 2:
						break;
					case 3:
						rowAgent.createCell(2).setCellValue(column_input.getRichStringCellValue() + "");
					case 4:
						continue;
					case 5:
						String cellValue = column_input.getRichStringCellValue() + "";
						cellValue = cellValue.equals("Block") ? "否" : "是";
						rowAgent.createCell(5).setCellValue(cellValue);
						rowAgent.createCell(6).setCellValue(cellValue);
						break;
					}
				}
				father = tree.get(level - 1);
				rowAgent.createCell(1).setCellValue(father);
				rowAgent.createCell(3).setCellValue("省公司");
				rowAgent.createCell(4).setCellValue("IPV4");
				rowAgent.createCell(7).setCellValue("dwcaozhimin");
				row_output_index++;
			}
			FileOutputStream fout = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\result.xls"));
			wb_output.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getNodeLevel(String node) {
		int j = 0;
		String[] str = node.split("");
		for (int i = 0; i < node.length(); i++) {
			if (str[i].equals(" ")) {
				j++;
			} else {
				break;
			}

		}
		return (j / 4) + 1;
	}
}
