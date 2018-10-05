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
	 * The readFromFile function. This function reads from a file.
	 * 
	 * @param fileName
	 *            - type String, the file's name.
	 * @return - type List<String>, the file's content.
	 */
	public List<String> readFromFile(String fileName) {
		BufferedReader bufferedReader = null;
		String type = null, size = null, board = null;

		List<String> list = new ArrayList<String>();
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			try {
				StringBuilder stringBuilder = new StringBuilder();
				type = bufferedReader.readLine();
				size = bufferedReader.readLine();

				board = bufferedReader.readLine();
				while (board != null) {
					stringBuilder.append(board);
					board = bufferedReader.readLine();
				}
				board = stringBuilder.toString();
				list.add(type);
				list.add(size);
				list.add(board);
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
	 * The writeToFile function. This function writes to a file.
	 * 
	 * @param fileName
	 *            - type String, the file's name.
	 * @param line
	 *            - type String, the line to write to the file.
	 */
	public void writeToFile(String fileName, String line) {
		BufferedWriter bufferedWriter = null;

		try {
			bufferedWriter = new BufferedWriter(new FileWriter(fileName));
			bufferedWriter.write(line);
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
