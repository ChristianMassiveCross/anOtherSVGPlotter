package SVG;
import java.io.File;
import java.io.FileWriter;

public class Writer {
	File FileToWrite;
	public Writer( String FileName ){
		System.out.println("will write to file: " + FileName);
		this.FileToWrite = new File(FileName);
	}
	public void write (String SVGContent){
		try {
			FileWriter fileWriter = new FileWriter(this.FileToWrite); 
			fileWriter.write(SVGContent);
			fileWriter.flush();
			fileWriter.close();
			System.out.println("wrote to file");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}