package qrcode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HuToolQr {

    public static final String path = "d:/Sc/Sc/Sc/practice/src/main/java/qrcode/foo1.jpg";

    public static final String WIDTH_IMAGE_URL_HTTP = "";

    public static final String s = "";

    @Test
    public void test1() throws MalformedURLException {
    /*    BufferedImage generate = QrCodeUtil.generate(//
                "http://hutool.cn/", //二维码内容
                QrConfig.create().setImg("")
        );*/


        QrConfig config = new QrConfig(300, 300);
// 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
// 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
// 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());

        BufferedImage bufferImaged = getBufferImaged(s);

        QrCodeUtil.generate(//
                "http://hutool.cn/", //二维码内容
                config.setImg(bufferImaged), //附带logo
                FileUtil.file("d:/Sc/Sc/Sc/practice/src/main/java/qrcode/foo3.jpg")//写出到的文件
        );


    }

    @Test
    public void test2() {
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file(path));
    }

    @Test
    public void test3() throws IOException {

        BufferedImage bufferImaged = getBufferImaged(s);
        ImageIO.write(bufferImaged, "JPEG", new File("d:/Sc/Sc/Sc/practice/src/main/java/qrcode/foo2.jpg"));
    }

    public static BufferedImage getBufferImaged(String url) {
        // URL url = new URL();
        try {
            Image src = Toolkit.getDefaultToolkit().getImage(new URL(url));
            return toBufferedImage(src);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage toBufferedImage(Image image) {

        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        // Copy image to buffered image
        Graphics g = bimage.createGraphics();
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

}
