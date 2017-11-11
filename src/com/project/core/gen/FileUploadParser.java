package com.project.core.gen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collections;

public class FileUploadParser {

	public FileUploadParser() {

	}

	int counter = 0;

	public String fileUpload(String fileFath, int key) {

		// The name of the file to open.
		// String fileName = "temp.txt";

		// This will reference one line at a time
		String line = null;
		String[] inLine = null;
		List<Integer> uniqueID= new ArrayList<>();
		ArrayList<String[]> records = new ArrayList<String[]>();
		Multimap<Integer, String[]> multimap = new ArrayListMultimap<Integer, String[]>();

		HashMap<Integer, ArrayList<String[]>> nMap = new HashMap<Integer, ArrayList<String[]>>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileFath);

			// wraps FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				inLine = line.split(" ");
				records.add(inLine);
				nMap.put(Integer.valueOf(inLine[1]), records);
				multimap.put(Integer.valueOf(inLine[1]), inLine);
				
				//get unique userID in a list
				if (!uniqueID.contains(Integer.valueOf(inLine[1]))){
					
					uniqueID.add(Integer.valueOf(inLine[1]));
				}
				
				counter++;
			}

			for(int k: uniqueID)
			split_in_string(specificUserRec(k, multimap), k); // generates List of
															// messages per User
															// ID.

			// ProducerGen(key, inLine, split_in_string(specificUserRec(3,
			// multimap));

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileFath + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileFath + "'");

			// ex.printStackTrace();
		}

		return "";

	}

	// Generate unique records for specific user
	public ArrayList<String[]> specificUserRec(int uID, Multimap<Integer, String[]> hs) {

		ArrayList<String[]> finalRec = new ArrayList<String[]>();

		if (!hs.isEmpty()) {

			for (Entry<Integer, String[]> entry : hs.entries()) {

				if (entry.getKey() == uID) {

					finalRec.add(entry.getValue());

				}

			}
		}

		return finalRec;

	}

	public HashMap<Integer, ArrayList<String[]>> treatDupRec(HashMap<Integer, ArrayList<String[]>> hs) {

		int i = 0;
		HashMap<Integer, ArrayList<String[]>> finalRec = new HashMap<Integer, ArrayList<String[]>>();

		if (!hs.isEmpty()) {

			for (Map.Entry<Integer, ArrayList<String[]>> entry : hs.entrySet()) {
				i++;
				if (finalRec.isEmpty()) {

					finalRec.put(entry.getKey(), entry.getValue());

				} else {

					if (finalRec.containsKey(entry.getKey())) {

						finalRec.get(entry.getKey()).add(entry.getValue().get(i));
					}

					else {

						if (!finalRec.containsKey(entry.getKey())) {

							finalRec.put(entry.getKey(), entry.getValue());

						}

					}

				}

			}

		}

		return finalRec;
	}

	// Method Arranges list of individual users records in a list i.e one
	// userID's Records
	public List<String> split_in_string(ArrayList<String[]> an, int k) {
		String[] ans;
		List<String> ansl = new ArrayList<String>();

		for (int i = 0; i < an.size(); i++) {

			String userID = null;

			for (int j = 0; j < an.get(i).length; j++) {
				ans = an.get(i);
				userID = String.join("-", ans);

			}
			ansl.add(userID);
			System.out.println("UserID value  " + k + "= "+ userID );

		}
		return ansl;
	}

	public String getElement(String[] arrayOfInts, int index) {

		return arrayOfInts[index];
	}

}
