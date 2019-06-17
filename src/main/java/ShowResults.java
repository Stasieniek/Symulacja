import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class ShowResults implements IResults {
    private String plik = "Wyniki.txt";


    public void print(int name, int x, int y, double HP, double AP,int licznik )//drukowanie zadanych danych w pliku
    {
        try
        {
            FileWriter writer1 = new FileWriter(plik, true);
            writer1.append("Runda,"+licznik+",Nazwa:,"+name+",X:,"+x+",Y:,"+y+",HP:,"+HP+",AP:,"+AP+"\r\n");

            writer1.flush();
            writer1.close();
        }
        catch(Exception z)
        {
            JOptionPane.showMessageDialog(null,"Nie");
        }

    }

}
