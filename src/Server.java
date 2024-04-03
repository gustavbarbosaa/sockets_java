import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();

        BufferedImage image = ImageIO.read(accept.getInputStream());

        File path = new File(new File("imagem_" + System.currentTimeMillis() + ".png").getAbsolutePath());

        ImageIO.write(image, "png", path);

        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        printWriter.println(path);
        printWriter.flush();

        serverSocket.close();
        accept.close();
    }
}
