import gui.TextEncryptor;
import model.EncryptionProgram;

public class Main {

    public static void main(String[] args) {

        EncryptionProgram ep = new EncryptionProgram();
        new TextEncryptor(ep);
    }

}