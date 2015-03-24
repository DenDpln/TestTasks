package task4;

import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ParserPage {
    private static final String indexFilePathFileName = "C:\\test\\webPage\\" + "index.html";
    private static final String folderSave = "C:\\test\\webPage\\";
    private static final String urlPage = "https://www.wikipedia.org/";
    private static final String domenName = ".org";
    private static final File file = new File(indexFilePathFileName);
    public static void main(String args[]) throws IOException{


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
        String nameImg = src.substring(indexBegin +1,src.length());
       // System.out.println(indexBegin);
       // System.out.println(indexTreeFolderFirst );

        String dirTree = src.substring(indexTreeFolderFirst,indexBegin +1);
        System.out.println(dirTree);
        System.out.println(nameImg);
        File folderTree = new File(folderSave+dirTree);
        if (folderTree.mkdirs()){
            System.out.println("Директории для images созданы");
        }
    }
}