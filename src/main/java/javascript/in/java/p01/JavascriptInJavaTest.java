package javascript.in.java.p01;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavascriptInJavaTest {

	public static void main(String[] args) throws Exception {

		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByExtension("js");

//		String jsFilePath = JavascriptInJavaTest.class.getResource("/javascript/in/java/p01/encrypt.js").getFile();
		String jsFilePath = JavascriptInJavaTest.class.getResource("encrypt.js").getFile();
		se.eval(new FileReader(jsFilePath));
		String s = (String) se.eval("eval(\"encode32(bin216(Base32.encrypt('1111', 'ODQ5OTkw')))\")");
		System.out.println(s);

	}
}
