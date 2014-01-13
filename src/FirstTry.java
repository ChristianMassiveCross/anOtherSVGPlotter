import FirstTry.FirstTrySVGCreator;
import SVG.Writer;

public class FirstTry {
	public static void main(String[] args) {
		boolean isMassPicture = false;
		String PictureName = "picture";
		String FolderName = "Session005";
		if (isMassPicture){
			int AmountOfPictures = 12*4;
			for (int i = 0; i < AmountOfPictures; i++) {
				FirstTrySVGCreator first = new FirstTrySVGCreator(1000,1000);
				first.setFieldFactor(i+1);
				String content = first.getSVGAsString();
				Writer mySVGWriter = new Writer(FolderName+"/"+PictureName+"_"+i+".svg");
				System.out.println(AmountOfPictures-i+"picturesLeft");
				mySVGWriter.write(content);
			}			
		}else{
			FolderName = "temp";
			FirstTrySVGCreator first = new FirstTrySVGCreator(200,200);
			first.setFieldFactor(4);
			String content = first.getSVGAsString();
			Writer mySVGWriter = new Writer(FolderName+"/"+PictureName+".svg");
			mySVGWriter.write(content);
		}
	}
} 