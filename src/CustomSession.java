import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomSession {

	ArrayList<String[]> list = new ArrayList<>();
	File file = new File("session.txt");

	public CustomSession() {
		try {
			readFile();
		} catch (IOException ex) {

		}
	}

	public void set(String key, String value) {
		for (String[] strArray : list) {
			if (strArray[0].equals(key)) {
				list.remove(strArray);
				break;
			}
		}
		list.add(new String[] { key, value });
		save();
	}

	public void clear() {
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.print("");
			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(CustomSession.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String get(String key) {
		for (String[] strArray : list) {
			if (strArray[0].equals(key)) {
				return strArray[1];
			}
		}
		return null;
	}

	private void save() {
		try {
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			writer.print("");
			for (String[] strArray : list) {
				writer.println(strArray[0] + "=" + strArray[1]);
			}
			writer.close();
		} catch (Exception ex) {

		}
	}

	private void readFile() throws FileNotFoundException, IOException {
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				String[] str = st.split("=");
				list.add(str);
			}

		} else {
			try {
				file.createNewFile();
			} catch (IOException ex) {
				Logger.getLogger(CustomSession.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
