package fileTest.fileTest03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFileUtil {

	public void removeLineFromFile(String file) {

		try {

			File inFile = new File(file);

			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}

			// Construct the new file that will later be renamed to the original
			// filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {
				
				String reg = "(public class \\w+)(\\s*)(\\{)";
				Matcher m = Pattern.compile(reg).matcher(line);
				while (m.find()) {
					line = m.group(1) + " extends xxx " + m.group(3);
				}
				pw.println(line);
				pw.flush();
				
//				if (!line.trim().equals(lineToRemove)) {
//
//					pw.println(line);
//					pw.flush();
//				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyFileUtil util = new MyFileUtil();
		util.removeLineFromFile("C:/Users/Administrator/Desktop/temp.java");
	}
}
