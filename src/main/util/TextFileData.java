package main.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileData {
	private static boolean isFirst = true;
	private static String[][] dataArray;
	private static int indexCounter;
	
	public String[][] getTxtFileData() {
		URL url = TextFileData.class.getClassLoader().getResource(
				"Resources/map.txt");
		try (Stream<String> stream = Files.lines(Paths.get(url.getPath()),
				Charset.defaultCharset())) {

			stream.forEach((data) -> {
				if (isFirst) {
					String[] size = data.split(" ");
					if (size.length == 2) {
						dataArray = new String[Integer.parseInt(size[0])][Integer
								.parseInt(size[1])];
						isFirst = false;
						System.out.println("is first here " + dataArray.length);
					} else {
						// TODO: Print out into a log viewer
						System.out.println("size length = " + size.length);
					}
				} else {
					if(indexCounter < dataArray.length){
						String[] information = data.split(" ");
						//to ensure no overbound for both arrays
						if(information.length==dataArray[indexCounter].length){
							for (int i=0;i<information.length;i++){
								//Copy the data in the line onto dataArray
								dataArray[indexCounter][i]=information[i];
							}
							System.out.println("lalala");
							System.out.println("is next here " + dataArray.length);
							indexCounter++;
						}
					} else {
						System.out.println("IndexCounter > dataArray.length");
					}
				}
			});
		} catch (IOException ex) {
			// TODO: Print out into a log viewer
			ex.printStackTrace();
		}
		return dataArray;
	}

}
