package com.project.core.gen;

public class Generator {

	public static void main(String[] args) {
		
		String fl = "transactions.txt";
		int key = 0;
		
		FileUploadParser file = new FileUploadParser();
		file.fileUpload(fl, key);
	}

}
