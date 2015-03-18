package task1;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by den on 17.03.2015.
 */
public class ReaderWriterEncoding {
    public static void main(String[] args) {
        String fileOrigPath = "C:\\test\\text12511.txt";
        String fileEndPath = "C:\\test\\textUtf8.txt";
        String fileGZIP = "C:\\test\\textUtf8.txt.gz";
        File file = new File(fileOrigPath);
        File newFile = new File(fileEndPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osr = null;
        BufferedReader reader = null;
        BufferedOutputStream writer = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis,"cp1251");
            reader = new BufferedReader(isr);
            fos = new FileOutputStream(newFile);
            writer = new BufferedOutputStream(fos);
            osr = new OutputStreamWriter(writer,"utf-8");
            while (reader.ready()) {
                String s = reader.readLine();
                osr.write(s);
                osr.write('\n');
            }
            osr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fis.close();
                isr.close();
                reader.close();
                fos.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (newFile.length()>10*1024*1024)
        {
            try {
                fis = new FileInputStream(fileEndPath);
                fos = new FileOutputStream(fileGZIP);
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
                byte[] buffer = new byte[1024];
                int len;
                while((len=fis.read(buffer)) != -1){
                    gzipOS.write(buffer, 0, len);
                }
                gzipOS.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
