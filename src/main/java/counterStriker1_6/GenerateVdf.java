package counterStriker1_6;

import java.io.*;

public class GenerateVdf {
	public static void main(String[] args) throws Exception {
		File file = new File("F:/Cs1.6全地图完美中文版Test/platform/config/ServerBrowser.vdf");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		new GenerateVdf().writeVdf(out, 101, 235);
		out.close();
		System.out.println("已生成vdf文件");
	}

	public void writeVdf(BufferedWriter out, int start, int end) throws Exception {
		int t = 1;
		out.write("\"Filters\"\n");
		out.write("{\n");
		out.write("	\"Favorites\"\n");
		out.write("	{\n");
		for (int i = start; i <= end; i++) {
			for (int j = 1; j <= 253; j++) {
				out.write("		\"" + t++ + "\"\n");
				out.write("		{\n");
				out.write("			\"name\"		\"zzzzzzzzzz\"\n");
				out.write("			\"gamedir\"		\"cstrike\"\n");
				out.write("			\"Players\"		\"1\"\n");
				out.write("			\"maxplayers\"		\"32\"\n");
				out.write("			\"map\"		\"17_iceworld\"\n");
				out.write("			\"address\"		\"" + "172.16." + i + "." + j + ":27015" + "\"\n");
				out.write("			\"lastplayed\"		\"0\"\n");
				out.write("			\"secure\"		\"0\"\n");
				out.write("			\"type\"		\"1\"\n");
				out.write("		}\n");
			}
		}
		out.write("	}\n");
		out.write("}\n");
	}
}
