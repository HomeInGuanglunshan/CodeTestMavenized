package excelTest;

import java.io.File;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

public class POITest {
	public static void main(String[] args) throws Exception {
//		File inputFile = new File("F:\\DHCP_POOL_UTIL_BLK_NETWORK_1481164941668.xls");
//		InputStream is = new FileInputStream(inputFile);
		Workbook wb = WorkbookFactory.create(new File("F:\\DHCP_POOL_UTIL_BLK_NETWORK_1481164941668.xls"));
		Sheet sheet = wb.getSheetAt(0);

		// 遍历合并区域
		for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
			CellRangeAddress region = sheet.getMergedRegion(i); //
			int colIndex = region.getFirstColumn(); // 合并区域首列位置
			int rowNum = region.getFirstRow(); // 合并区域首行位置
			System.out.println("第[" + i + "]个合并区域：" + sheet.getRow(rowNum).getCell(colIndex).getStringCellValue());
		}

		// 直接调用，我知道合并单元格的位置：
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

		System.out.println(sheet.getRow(5).getCell(2).getStringCellValue());

//		((FileInputStream) wb).close();
//		is.close();
	}
}
