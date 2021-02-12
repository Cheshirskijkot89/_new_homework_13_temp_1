package chi;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		File foldFrom;
		File foldTo;

		fc.setDialogTitle("�������� ������� ��������.");
		int resultFrom = fc.showOpenDialog(null);
		if (resultFrom == JFileChooser.APPROVE_OPTION) {
			foldFrom = fc.getSelectedFile();
		} else {
			return;
		}

		fc.setDialogTitle("�������� ������� ��������.");
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			foldTo = fc.getSelectedFile();
		} else {
			return;
		}
		
		String ext = JOptionPane.showInputDialog("������� ����������, ������� .txt", ".txt");
		

		if (ext.equals("")) {
			return;
		}
		
		try {
			OperationsWithFiles.COpyFiles(foldFrom, foldTo, ext);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
