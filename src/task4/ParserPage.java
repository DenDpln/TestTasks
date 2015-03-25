package task4;

import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParserPage {
    private static final String indexFilePathFileName = "C:/test/webPage/" + "index.html";
    private static final String folderSave = "C:/test/webPage/";
    private static final String urlPage = "https://ru.wikipedia.org/wiki/";
    private static final File file = new File(indexFilePathFileName);
    public static void main(String args[]) throws IOException{


        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(file));
        Document doc = Jsoup.connect(urlPage).get();
        String textHtml = doc.html();
        osr.write(doc.html());
        osr.close();
        Elements img = doc.getElementsByTag("img");
        for (org.jsoup.nodes.Element el : img){
           String src = el.absUrl("src");
           getImg(src);
        }
    }
    private static void getImg(String src) throws IOException {
        int indexBegin = src.lastIndexOf("/");
        int indexTreeFolderFirst = src.lastIndexOf("//");
        String nameImg = src.substring(indexBegin + 1, src.length());
        System.out.println("---------------------------------------------------");
        String dirTree = src.substring(indexTreeFolderFirst+ 2,indexBegin + 1);
        System.out.println("дирректория для хранения-  " + dirTree);
        System.out.println("имя картинки-  " + nameImg);
       // String dirTreeWIN = dirTree.replace("/","\\");
        System.out.println("полный путь хранения на диске-  " + folderSave + dirTree + nameImg);
        File folderTree = new File(folderSave+dirTree);
        folderTree.mkdirs();
        URL url = null;
        try {
            url = new URL(src);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
      //  String[] winSymbol = {":","*","?","<",">","|","\""};
        InputStream in = url.openStream();
       // for (String aWinSymbol : winSymbol) {
            if (!dirTree.contains(":") && !nameImg.contains("?")) {
               // System.out.println(aWinSymbol);
                OutputStream out = new BufferedOutputStream(new FileOutputStream(folderSave + dirTree + nameImg));
                for (int b; (b = in.read()) != -1; ) {
                    out.write(b);
                }
                out.close();
            }
      //  }
        in.close();
    }
}