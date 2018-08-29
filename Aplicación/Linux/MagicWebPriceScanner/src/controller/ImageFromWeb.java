package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import model.AlmacenVersiones;
import view.GlobalAnalyzePanel;

public class ImageFromWeb {
	private static final String REGEXPURLIMG = "img\\ssrc\\=\"\\/\\/(\\w|\\.)*\\/img\\/(\\d|\\w)*\\/items\\/([\\+\\w\\d\\s\\=\\\\\\\\/\\_\\:\\;\\'\\(\\)\\.\\-\\%\\,\\p{L}])*\"";
	private ImageFromWeb() { throw new IllegalStateException("Utility class"); }
	public static void getImageFW(AlmacenVersiones actualCard,  GlobalAnalyzePanel father) throws IOException {
		Document doc = Jsoup.connect(actualCard.getGeneralUrl()).get();
        String line = doc.toString();
        Pattern numVersionsPattern = Pattern.compile(REGEXPURLIMG);
        if(line != null) {
        	line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
        	line = Normalizer.normalize(line, Normalizer.Form.NFD);
        	line = line.replaceAll("\\p{M}", "");
        	line = line.replaceAll("\\s\\s+", "");
        	Matcher matcher = numVersionsPattern.matcher(line);
        	if(matcher.find()) {
        		try {
                    BufferedImage img = ImageIO.read(new URL(getUrl(matcher.group())));
                    father.setIcon(new ImageIcon(img));
        		}
        		catch(Exception ex) { JOptionPane.showMessageDialog(null,"Error al buscar la imagen de la carta"); }
        	}
        }
	}
	public static String getUrl(String urlToFilter) {
		String toReturn = urlToFilter.replaceAll("img\\ssrc\\=\"", "");
		toReturn = toReturn.replaceAll("\"", "");
		toReturn = "http:" + toReturn;
		return toReturn;
	}
}
