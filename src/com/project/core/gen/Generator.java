package com.project.core.gen;

public class Generator {

	public static void main(String[] args) {
		
		String fl = "transactions.txt";
	
		
		FileUploadParser file = new FileUploadParser();
		file.fileUpload(fl);
	}

}
