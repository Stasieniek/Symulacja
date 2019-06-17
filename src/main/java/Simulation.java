public class Simulation
{

    public static void main(String[] args)
    {


        int counter = 50 ;/** @param counter - licznik tur ile będzie toczyć się symulacja */
        IMapPlugin map = new Map(10,9);

            map.addBase();
            for (int l = 0; l < counter; l++) /**głowna pętla programu*/
            {
                if (map.alive()) { /**kończy symulacje przed upływem wszystkich tur gdy któraś frakcja wygra */
                    break;
                }
                map.addUnit();
               // map.show();
                map.move();
                //map.show();
                map.doFight();
               // map.show();
                map.showResults(l+1);
            }
    }

}




