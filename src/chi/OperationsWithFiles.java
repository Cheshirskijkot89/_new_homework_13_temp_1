package chi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import javafx.stage.FileChooser;

public class OperationsWithFiles {

	public static void COpyFiles(File folderFrom, File folderTo, String ext) throws IOException {

		if (!folderFrom.exists()) {
			System.out.println("папка \"from\" не существует!");
			return;
		}

		if (!folderTo.exists()) {
			System.out.println("папка \"to\" не существует!");
			return;
		}

		File[] list;

		if (ext.equals("")) {
			list = folderFrom.listFiles();
		} else {
			list = folderFrom.listFiles(new MyFilter(ext));
		}

		if (list.length == 0) {
			System.out.println("нет файлов для копирования");
			return;
		}
		;

		for (File file : list) {

			int readByte = 0;
			byte[] buff = new byte[1024 * 1024];

			String newName = file.getName().substring(0, file.getName().indexOf('.')) + "_copy" + ext;
			File fileTo = new File(folderTo.getAbsolutePath() + "/" + newName);

			try (FileInputStream fis = new FileInputStream(file); FileOutputStream fos = new FileOutputStream(fileTo)) {

				for (; (readByte = fis.read(buff)) > 0;) {
					fos.write(buff, 0, readByte);
				}

			} catch (IOException e) {
				throw e;
			}

		}

	}

}
