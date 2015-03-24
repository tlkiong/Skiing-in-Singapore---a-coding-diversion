package main.util;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileData {
	private static boolean isFirst = true;
	private static String [][] dataArray;
	public void getTxtFileData() {
		URL url = TextFileData.class.getClassLoader().getResource(
				"Resources/map.txt");
		
		try (Stream<String> stream = Files.lines(Paths.get(url.getPath()),
				Charset.defaultCharset())) {
			
			stream.forEach((data) -> {
				if (isFirst) {
					String[] size = data.split(" ");
					if(size.length==2){
						dataArray = new String[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
						isFirst = false;
						System.out.println("is first here "+dataArray.length);
					} else {
						//TODO: print error
						System.out.println("size length = "+size.length);
					}
				} else {
					System.out.println("lalala");
					System.out.println("is next here "+dataArray.length);
				}
				System.out.println("data: " + data);
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException ex) {
			// TODO: Print out into a log viewer
			ex.printStackTrace();
		}
	}

}
