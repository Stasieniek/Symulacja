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
            if(licznik==-1)
            {
                writer1.append("Licznik"+","+"Imię"+","+"X"+","+"Y"+","+"HP"+","+"AP"+"\r\n");
                writer1.flush();
                writer1.close();
            }
            else
            {

                writer1.append(licznik+","+name+","+x+","+y+","+HP+","+AP+"\r\n");

                writer1.flush();
                writer1.close();
            }

        }
        catch(Exception z)
        {
            JOptionPane.showMessageDialog(null,"Nie");
        }

    }

}
