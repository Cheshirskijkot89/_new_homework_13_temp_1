package chi;

import java.io.File;
import java.io.FilenameFilter;

public class MyFilter implements FilenameFilter{
	
	String ext;

	public MyFilter(String ext) {
		super();
		this.ext = ext.toLowerCase();
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.toLowerCase().endsWith(ext);
	}
	
	

}
