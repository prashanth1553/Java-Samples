package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DuplicateLinesChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> paths = new ArrayList<String>();
		for (String path : paths) {
			checkDuplicates(path);
		}

	}

	public static void checkDuplicates(String path) {
		FileInputStream fis = null;
		String EQUALs = "=";
		BufferedReader br = null;
		try {
			fis = new FileInputStream(path);
			Map<String, String> map = new TreeMap<String, String>();

			br = new BufferedReader(new InputStreamReader(fis));
			String strLine;
			String keyValuePair[] = null;
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains(EQUALs)) {
					keyValuePair = strLine.split(EQUALs);
					String key = keyValuePair[0];
					key = key.trim();
					if (key.isEmpty() || key.startsWith("#")) {
						continue;
					}
					if (map.containsKey(key)) {
						System.out.println("File = " + path + " Key \"" + key + " \" Already exists with value "
								+ map.get(key) + " Current value " + keyValuePair[1]);
					} else {
						if (keyValuePair.length >= 2) {
							map.put(key, keyValuePair[1]);
						} else {
							System.out.println("No value for key : " + key);
						}

					}
				}

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				fis.close();
			} catch (Exception e) {
				// do nothing
			}
		}
	}

	public static void checkDuplicatesAndCreateNewFile(String path, String fileName) {
		File tempFile = new File(path + "new_" + fileName);
		FileInputStream fis = null;
		String EQUALs = "=";
		BufferedReader br = null;
		try {
			fis = new FileInputStream(path);
			Map<String, String> map = new LinkedHashMap<String, String>();

			br = new BufferedReader(new InputStreamReader(fis));
			String strLine;
			String keyValuePair[] = null;
			int lineNumber = 0;
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains(EQUALs)) {
					keyValuePair = strLine.split(EQUALs);
					String key = keyValuePair[0];
					key = key.trim();
					if (key.isEmpty()) {
						map.put("", "");
						continue;
					}
					if(key.startsWith("#")) {
						
					}
					if (map.containsKey(key)) {
						if (keyValuePair.length >= 2 && map.get(key).trim().equals(keyValuePair[1].trim())) {
							System.out.println("File = " + path + " Key \"" + key + " \" Already exists with value "
									+ map.get(key) + " Current value " + keyValuePair[1]);
						} else {
							map.put(key, keyValuePair[1]);
						}

					} else {
						if (keyValuePair.length >= 2) {
							map.put(key, keyValuePair[1]);
						} else {
							System.out.println("No value for key : " + key);
						}

					}
				}

			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				fis.close();
			} catch (Exception e) {
				// do nothing
			}
		}
	}
	
	static enum LineType{
		COMMENTED,
		
		
	}
}
