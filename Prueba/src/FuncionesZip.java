import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FuncionesZip {
	
public void crearZip (String pDirectorio, ArrayList<String> pDatos, String pFicheroZipName){
		
		byte[] buffer = new byte[1024];
		
		try{
			
			FileOutputStream fos = new FileOutputStream(pDirectorio+"\\"+pFicheroZipName);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		
    		for (int i=0;i<pDatos.size();i++){
    			ZipEntry ze= new ZipEntry(pDatos.get(i));
    			zos.putNextEntry(ze);
    			FileInputStream in = new FileInputStream(pDirectorio+"\\"+pDatos.get(i));
   	   
    			int len;
    			while ((len = in.read(buffer)) > 0) {
    				zos.write(buffer, 0, len);
    			}

    			in.close();
    		}
    		zos.closeEntry();
    		zos.close();
		}catch(Exception e){e.printStackTrace();}
	}

}
