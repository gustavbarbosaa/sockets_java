import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);

        OutputStream outputStream = socket.getOutputStream();
        BufferedImage image = ImageIO.read(new File("src/imagem.png"));

        ByteArrayOutputStream arrayImage = new ByteArrayOutputStream();

        ImageIO.write(image, "png", arrayImage);
        outputStream.write(arrayImage.toByteArray());

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String pathImage = reader.readLine();
        System.out.println("Imagem salva em: " + pathImage);

        socket.close();
    }
}
