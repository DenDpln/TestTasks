package task4;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParserPage {
    private static final String indexFilePath = "C:\\test\\webPage\\index.html";
    private static final String folderSave = "C:\\test\\webPage\\";
    private static final String urlPage = "https://www.wikipedia.org/";
    private static final String domenName = ".org";
    public static void main(String args[]) throws IOException{

        File file = new File(indexFilePath);
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(file),"cp1251");
        Document doc = Jsoup.connect(urlPage).get();
        String textHtml = doc.html();
        osr.write(doc.html());
        osr.close();
        //System.out.print(textHtml);

        Elements img = doc.getElementsByTag("img");
        for (org.jsoup.nodes.Element el : img){
           String src = el.absUrl("src");
           System.out.println("src attribute is : "+src);
           getImg(src);
        }
    }
    private static void getImg(String src){
        int indexBegin = src.lastIndexOf("/");
        int indexTreeFolderFirst = src.lastIndexOf(domenName)+ domenName.length();
        System.out.println(indexBegin);
        System.out.println(indexTreeFolderFirst );
        System.out.println(src.substring(indexTreeFolderFirst,indexBegin +1));
    }
}