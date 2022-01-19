package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class MyBase64 {

	public static void main(String args[]) throws IOException {

		File file = new File("/home/ggk/Downloads/HDFC Bank Credit Card_dec.pdf");

		
		String filePath = "C:\\Users\\xyz\\Desktop\\";
		String originalFileName = "96172560100_copy2.pdf";
		String newFileName = "test.pdf";

		byte[] input_file = Files.readAllBytes(Paths.get("/home/ggk/Downloads/HDFC Bank Credit Card_dec.pdf"));

		byte[] encodedBytes = Base64.getEncoder().encode(input_file);
		String encodedString = new String(encodedBytes);
	//	System.out.println(encodedString);
		
		byte[] decoded = Base64.getDecoder().decode(encodedString);
		File dir = new File("/home/ggk/Downloads");
		File pdf = new File(dir.getAbsolutePath() + File.separator + "HDFC Bank" + ".pdf");
		pdf.createNewFile();
		FileOutputStream fos = new FileOutputStream(pdf);
		fos.write(decoded);
		fos.flush();
		fos.close();
	}
	
	
	
	


}
