import com.rs.cache.Cache;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Utils {
    static Object[] lastSpriteImage = null;

    public static ArrayList<String> getPageDetails(String URL2) {
        try {
            ArrayList<String> pageSource = new ArrayList<String>();
            Throwable throwable = null;
            Object var3_5 = null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(URL2).openStream()));){
                String line;
                while ((line = reader.readLine()) != null) {
                    pageSource.add(line);
                }
                reader.close();
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            return pageSource;
        }
        catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getPageSource(String URL2) {
        try {
            URL website = new URL(URL2);
            HttpURLConnection connection = (HttpURLConnection)website.openConnection();
            connection.setRequestMethod("GET");
            String out = "";
            Throwable throwable = null;
            Object var5_7 = null;
            try (InputStream input = connection.getInputStream();){
                Throwable throwable2 = null;
                Object var8_12 = null;
                try (ByteArrayOutputStream output = new ByteArrayOutputStream();){
                    byte[] buffer = new byte[1024];
                    int bytes = 0;
                    while ((bytes = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytes);
                        out = output.toString();
                    }
                    output.close();
                }
                catch (Throwable throwable3) {
                    if (throwable2 == null) {
                        throwable2 = throwable3;
                    } else if (throwable2 != throwable3) {
                        throwable2.addSuppressed(throwable3);
                    }
                    throw throwable2;
                }
                input.close();
            }
            catch (Throwable throwable4) {
                if (throwable == null) {
                    throwable = throwable4;
                } else if (throwable != throwable4) {
                    throwable.addSuppressed(throwable4);
                }
                throw throwable;
            }
            return out;
        }
        catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Image getImage(String path) {
        if (Constants.isJarFile()) {
            path = path.replace("./resources/", "");
            URL url = RSMapperClient.class.getClassLoader().getResource(path);
            return new ImageIcon(url).getImage();
        }
        return Toolkit.getDefaultToolkit().getImage(path);
    }

    public static Image getImage(String path, Dimension size) {
        if (Constants.isJarFile()) {
            path = path.replace("./", "");
            URL url = RSMapperClient.class.getClassLoader().getResource(path);
            return new ImageIcon(url).getImage().getScaledInstance(size.width, size.height, 4);
        }
        return Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(size.width, size.height, 4);
    }

    public static Image getImageFromSprite(int width, int height, int spriteId) {
        ByteBuffer buf;
        Sprite sprite;
        byte[] data;
        if (lastSpriteImage != null && lastSpriteImage.length == 4 && (Integer)lastSpriteImage[0] == spriteId && (Integer)lastSpriteImage[1] == width && (Integer)lastSpriteImage[2] == height) {
            return (Image)lastSpriteImage[3];
        }
        if (Cache.STORE.getIndexes()[8].getFile(spriteId) != null && (data = Cache.STORE.getIndexes()[8].getFile(spriteId)) != null && (sprite = Sprite.decode(buf = ByteBuffer.wrap(data))) != null && sprite.size() > 0) {
            int frame = 0;
            while (frame < sprite.size()) {
                File file = new File("resources/sprites/", String.valueOf(spriteId) + "_" + frame + ".png");
                if (file.exists()) {
                    lastSpriteImage = new Object[]{spriteId, width, height, new ImageIcon("resources/sprites/" + spriteId + "_" + frame + ".png").getImage().getScaledInstance(width, height, 4)};
                    return new ImageIcon("resources/sprites/" + spriteId + "_" + frame + ".png").getImage().getScaledInstance(width, height, 4);
                }
                BufferedImage image = sprite.getFrame(frame);
                try {
                    ImageIO.write((RenderedImage)image, "png", file);
                    Image img = new ImageIcon("resources/sprites/" + spriteId + "_" + frame + ".png").getImage();
                    lastSpriteImage = new Object[]{spriteId, width, height, img.getScaledInstance(width, height, 4)};
                    return img.getScaledInstance(width, height, 4);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    ++frame;
                }
            }
        }
        return null;
    }

    public static byte[] getDataFromFile(File file) {
        try {
            FileInputStream stream = new FileInputStream(file);
            ArrayList<Byte> dataList = new ArrayList<Byte>();
            int value = 0;
            while ((value = stream.read()) != -1) {
                dataList.add((byte)value);
            }
            stream.close();
            byte[] data = new byte[dataList.size()];
            int i2 = 0;
            while (i2 < dataList.size()) {
                data[i2] = (Byte)dataList.get(i2);
                ++i2;
            }
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getIntFromRGB(int red, int green, int blue) {
        red = red << 16 & 0xFF0000;
        green = green << 8 & 0xFF00;
        return 0xFF000000 | red | green | (blue &= 0xFF);
    }

    public static int[] getRGBFromInt(int color) {
        int red = new Color(color).getRed();
        int green = new Color(color).getGreen();
        int blue = new Color(color).getBlue();
        return new int[]{red, green, blue};
    }

    public static int getClosestColor(int red, int green, int blue) {
        double distance;
        Color col;
        int i2;
        Color color = new Color(red, green, blue);
        int[] nArray = Class85.colors;
        int n2 = Class85.colors.length;
        int n3 = 0;
        while (n3 < n2) {
            i2 = nArray[n3];
            col = new Color(i2);
            distance = (color.getRed() - col.getRed()) * (color.getRed() - col.getRed()) + (color.getGreen() - col.getGreen()) * (color.getGreen() - col.getGreen()) + (color.getBlue() - col.getBlue()) * (color.getBlue() - col.getBlue());
            if (distance <= 5.0) {
                System.out.println("(1) Looking for: " + Utils.getIntFromRGB(red, green, blue) + " Found color: " + i2 + " at distance: " + distance);
                return i2;
            }
            ++n3;
        }
        nArray = Class85.colors;
        n2 = Class85.colors.length;
        n3 = 0;
        while (n3 < n2) {
            i2 = nArray[n3];
            col = new Color(i2);
            distance = (color.getRed() - col.getRed()) * (color.getRed() - col.getRed()) + (color.getGreen() - col.getGreen()) * (color.getGreen() - col.getGreen()) + (color.getBlue() - col.getBlue()) * (color.getBlue() - col.getBlue());
            if (distance <= 15.0) {
                System.out.println("(2) Looking for: " + Utils.getIntFromRGB(red, green, blue) + " Found color: " + i2 + " at distance: " + distance);
                return i2;
            }
            ++n3;
        }
        return 0;
    }

    public static int getIntFromByte(byte b) {
        if (b < 256) {
            if (b < 0) {
                return 128 + (128 + b);
            }
            return b;
        }
        return 0;
    }

    public static int getChunkX(int x) {
        return x >> 3;
    }

    public static int getChunkY(int y) {
        return y >> 3;
    }

    public static int getCoordLocalX(int x) {
        return x - 8 * (Utils.getChunkX(x) - (Node_Sub54.GAME_SCENE_WDITH >> 4));
    }

    public static int getCoordLocalY(int y) {
        return y - 8 * (Utils.getChunkY(y) - (Class377_Sub1.GAME_SCENE_HEIGHT >> 4));
    }

    public static int getRegionX(int x) {
        return x >> 6;
    }

    public static int getRegionY(int y) {
        return y >> 6;
    }

    public static int getRegionBaseLocalX(int regionId) {
        return 64 * (regionId >> 8) - (Utils.getRegionCoordX(regionId) - 16);
    }

    public static int getRegionBaseLocalY(int regionId) {
        return 64 * (regionId & 0xFF) - (Utils.getRegionCoordY(regionId) - 16);
    }

    public static int getRegionId(int x, int y) {
        return (Utils.getRegionX(x) << 8) + Utils.getRegionY(y);
    }

    public static int getRegionCoordX(int regionId) {
        return (regionId >> 8) * 64;
    }

    public static int getRegionCoordY(int regionId) {
        return (regionId & 0xFF) * 64;
    }

    public static int getLocalX(int regionId) {
        return (Utils.getRegionCoordX(regionId) >> 3) / 8;
    }

    public static int getLocalY(int regionId) {
        return (Utils.getRegionCoordY(regionId) >> 3) / 8;
    }

    public static int getLocalXFromCoordX(int x, int regionId) {
        return Utils.getRegionCoordX(regionId) - (Utils.getRegionCoordX(regionId) - 16) - (Utils.getRegionCoordX(regionId) - x);
    }

    public static int getLocalYFromCoordY(int y, int regionId) {
        return Utils.getRegionCoordY(regionId) - (Utils.getRegionCoordY(regionId) - 16) - (Utils.getRegionCoordY(regionId) - y);
    }

    public static int get18BitsLocationHash(int x, int y, int plane) {
        return Utils.getRegionY(y) + (Utils.getRegionX(x) << 8) + (plane << 16);
    }

    public static int get30BitsLocationHash(int x, int y, int plane) {
        return y + (x << 14) + (plane << 28);
    }

    public static int getArchiveId(String type, int x, int y) {
        String file = String.valueOf(type) + Utils.getLocalX(Utils.getRegionId(x, y)) + "_" + Utils.getLocalY(Utils.getRegionId(x, y));
        return Cache.STORE.getIndexes()[5].getArchiveId(file);
    }
}

