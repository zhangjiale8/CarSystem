package cn.car.manage.util.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriteUtil {

	public static void writePrintWriterFile(String file, String conent) {
		File f = new File(file);
		if (!f.exists()) {
			try {
				if (!f.createNewFile()) {
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(file, true));
			pw.println(conent);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	public static void writeBufferedWriterFile(String file, String conent) {
		File f = new File(file);
		if (!f.exists()) {
			try {
				if (!f.createNewFile()) {
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
