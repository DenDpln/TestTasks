package task4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * метод: Входной параметр – строка с URL страницы.
 * Страница статическая, без яваскрипта, только html+css.
 * Необходимо сохранить эту страницу в файл, сохранить все стили и изображения,
 * встречающиеся на странице с сохранением структуры файлов и путей
 */

public class ParserPage {
    private static final String folderSave = "C:/test/webPage/";
    private static final String indexFilePathFileName = folderSave + "index.html";
    private static final String urlPage = "https://ru.wikipedia.org/wiki/";
    private static final File file = new File(indexFilePathFileName);

    public static void main(String args[]) throws IOException {
        Document doc = saveIndexFile(urlPage, file);
        Elements img = doc.getElementsByTag("img");
        Elements css = doc.select("rel");
        for (org.jsoup.nodes.Element el : css){
            String stylesheet = el.attr("href");
            getCSS(stylesheet);
        }
        for (org.jsoup.nodes.Element el : img) {
            String src = el.absUrl("src");
            getImg(src);

        }
    }

    private static String findNameImg(String src) {  //имя изображения
        int indexBegin = src.lastIndexOf("/");
        String nameImg = src.substring(indexBegin + 1, src.length());
        return nameImg;
    }

    private static String findPathImg(String src) {   //относительный путь к картинке
        int indexBegin = src.lastIndexOf("/");
        int indexTreeFolderFirst = src.lastIndexOf("//");
        String dirTree = src.substring(indexTreeFolderFirst + 2, indexBegin + 1);
        return dirTree;
    }

    private static Document saveIndexFile(String urlPage, File file) throws IOException {  //пишем на диск
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(file));
        Document doc = Jsoup.connect(urlPage).get();
        osr.write(doc.html());
        osr.close();
        return doc;
    }

    private static void changeLineInFile(String orignePath, String newPath) {     //меняем относительный путь на абсолютный
        try {
            File file = new File(indexFilePathFileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line, oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            String newtext = oldtext.replaceAll(orignePath, newPath);
            FileWriter writer = new FileWriter(file);
            writer.write(newtext);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getImg(String src) throws IOException {  // метод сохраняет все изображения с сохранением дерева папок
        String nameImg = findNameImg(src);
        String dirTree = findPathImg(src);
        File folderTree = new File(folderSave + dirTree);
        folderTree.mkdirs();
        URL url = null;
        try {
            url = new URL(src);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //  String[] winSymbol = {":","*","?","<",">","|","\""};
        InputStream in = url.openStream();
        //TODO проверка остальных знаков, которые не могут быть в имени дирректории или файла
        // for (String aWinSymbol : winSymbol) {
        if (!dirTree.contains(":") && !nameImg.contains("?")) {
            System.out.println("полный путь хранения на диске-  " + folderSave + findPathImg(src) + findNameImg(src));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(folderSave + dirTree + nameImg));
            for (int b; (b = in.read()) != -1; ) {
                out.write(b);

            }
            out.close();
        }
        //  }
    in.close();
    changeLineInFile("//" + findPathImg(src), folderSave + findPathImg(src));
    }

    private static void getCSS(String stylesheet){
        System.out.println(stylesheet);

    }
}