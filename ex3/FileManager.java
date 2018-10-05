import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileManager class.
 * This class reads and writes from a file.
 */
public class FileManager {

	/**
	 * The readFromFile function.
	 * This function reads from a file.
	 * 
	 * @param fileName
	 *            - type String, the file's name.
	 * @return - type List<String>, the file's content.
	 */
	public List<String> readFromFile(String fileName) {
		List<String> list = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		String type = null, number = null, point = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			try {
				type = bufferedReader.readLine();
				number = bufferedReader.readLine();
				
				list.add(type);
				list.add(number);
				
				point = bufferedReader.readLine();
				while (point != null) {
					list.add(point);
					point = bufferedReader.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * The writeToFile function.
	 * This function writes to a file.
	 * 
	 * @param fileName
	 *            - type String, the file's name.
	 * @param list
	 *            - type List<Integer>, the content to write to the file.
	 */
	public void writeToFile(String fileName, List<Integer> list) {
		BufferedWriter bufferedWriter = null;

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < list.size() - 1; i++) {
				bufferedWriter.write(list.get(i).toString() + '\n');
			}
			
			bufferedWriter.write(list.get(list.size() - 1).toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
