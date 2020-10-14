package counterStriker1_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteVdfAccordingToTxt {

	public static void main(String[] args) throws Exception {
		File file = new File("F:/Cs1.6全地图完美中文版Test/platform/config/ServerBrowser.vdf");
		File source = new File("C:/Users/Administrator/Desktop/ip.txt");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		new WriteVdfAccordingToTxt().writeVdfAccordingToTxt(out, source);
		out.close();
		System.out.println("已根据ip生成vdf文件");
	}

	public void writeVdfAccordingToTxt(BufferedWriter out, File source) throws Exception {
		String str = "";
		int count = 1;
		int t = 1;
		out.write("\"Filters\"\n");
		out.write("{\n");
		out.write("	\"Favorites\"\n");
		out.write("	{\n");
		BufferedReader in = new BufferedReader(new FileReader(source));
		Scanner s = new Scanner(in);
		while (s.hasNextLine()) {
			str = s.nextLine();
			if (count++ >= 10) {
				str = str.substring(0, str.indexOf(" "));
				out.write("		\"" + t++ + "\"\n");
				out.write("		{\n");
				out.write("			\"name\"		\"zzzzzzzzzz\"\n");
				out.write("			\"gamedir\"		\"cstrike\"\n");
				out.write("			\"Players\"		\"1\"\n");
				out.write("			\"maxplayers\"		\"32\"\n");
				out.write("			\"map\"		\"17_iceworld\"\n");
				out.write("			\"address\"		\"" + str + ":27015" + "\"\n");
				out.write("			\"lastplayed\"		\"0\"\n");
				out.write("			\"secure\"		\"0\"\n");
				out.write("			\"type\"		\"1\"\n");
				out.write("		}\n");
			}
		}
		out.write("	}\n");
		out.write("}\n");
		s.close();
		in.close();
	}

}
