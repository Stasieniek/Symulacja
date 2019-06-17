import java.util.ArrayList;
import java.util.Random;
public class Map implements IMapPlugin {


    private ArrayList<ArrayList<ISoldier>> list = new ArrayList<>(); //lista na listy jednostek 3 frakcji
    private IBase[] list2 = new IBase[3]; //tablica na bazy, ich liczba sie nie zwieksza ponad rozmiar tablicy

    private ArrayList<ISoldier> listA = new ArrayList<>(); //listy na jednostki 3 frakcji
    private ArrayList<ISoldier> listB = new ArrayList<>();
    private ArrayList<ISoldier> listC = new ArrayList<>();

    private int size; //rozmiar mapy (to kwadrat)
    private int patience; //parametr opisujacy ile maksymalnie prób akcji może podjąc jednostka tzn. jeśli
                            //nie uda jej się wykonać akcji w przewidziana przez patience liczbe prob, to jej tura przepada

    Map(int size, int patience) {
        this.size = size;
        this.patience = patience;
    }

    Map() {;}


    private int[][] map = new int[10][10]; //mapa


    private IBase baseA = new Base(65, 4); //utworzenie baz dla każdej frakcji
    private IBase baseB = new Base(65, 5);
    private IBase baseC = new Base(65, 6);


   public void showResults(int licznik) { //dowołuje się do obiektu klasy ShowResults by wyświetlić wyniki
        IResults show = new ShowResults();

        for(int i=0;i<3;i++)
        {
            show.print(list2[i].getName(), list2[i].getX(),list2[i].getY(),list2[i].getHP(),list2[i].getAP(),licznik);
            for(int l=0;l<list.get(i).size();l++)
            {
                if(!list.get(i).isEmpty())
                { show.print(list.get(i).get(l).getName(), list.get(i).get(l).getX(),
                        list.get(i).get(l).getY(),list.get(i).get(l).getHP(),list.get(i).get(l).getAP(),licznik);

                }
            }
        }
    }

    @Override
    public void addBase() { //metoda używana tylko raz, na początku symulacji, inicjalizuje bazy, przypisuje do tablicy baz, losuje pozycję na mapie

        Random random2 = new Random();
        list2[0]=baseA;
        list2[1]=baseB;
        list2[2]=baseC;
        boolean check;
        int xxx;
        int yyy;

        for (int i = 0; i < 3; i++) { //losowanie wolnego miejsca na mapie i przypisywanie do niego bazy, próbowanie do skutku
            do {
                check = true;

                xxx = random2.nextInt(size);
                yyy = random2.nextInt(size);

                if (xxx > 1 && xxx < (size - 2) && yyy > 1 && yyy < (size - 2)) {
                    if (map[xxx][yyy] == 0) {
                        check = false;
                    }
                }

            } while (check);

            list2[i].setX(xxx);
            list2[i].setY(yyy);
            map[xxx][yyy] = list2[i].getName();

        }

        list.add(listA);//dodanie do "listy na listy frakcji" list jednostek każdej z frakcji
        list.add(listB);
        list.add(listC);
    }

    private static int randomThrow() { //metoda pomocnicza przy losowaniu miejsca, zwraca przesunięcie maksymalnie o 1
        int z;
        int random1;
        Random random = new Random();
        random1 = random.nextInt(3);
        if (random1 == 1)
            z = 1;
        else if (random1 == 2)
            z = 0;
        else
            z = -1;
        return z;
    }


    @Override
    public void addUnit() { //metoda dodająca raz na turę jednostki
                            //każda baza spawni max 1 jednostkę na turę tuż obok siebie, o ile uda jej się wylosować wolne miejsca w odpowiedniej
                            //zadanym przez "patience" liczbie podejść
        int xxx;
        int yyy;
        int xx;
        int yy;
        int counter;
        for (int i = 0; i < 3; i++) {

            if(list2[i].getHP()>0)
            {
                counter = 0;
                do {
                    xx = randomThrow();
                    yy = randomThrow();

                    xxx = list2[i].getX() + xx;
                    yyy = list2[i].getY() + yy;

                    if (xxx > 0 && xxx < size - 1 && yyy > 0 && yyy < size - 1) {
                        if (map[xxx][yyy] == 0) {
                            break;
                        }
                    }
                    counter++;
                } while (counter < patience);


                if (counter < patience) {
                    list.get(i).add(list2[i].generateUnit());   //dodawanie stworzonej jednostki do mapy, przypisywanie jej, zgodnego z frakcją, imienia
                        list.get(i).get(list.get(i).size() - 1).setX(xxx);
                        list.get(i).get(list.get(i).size() - 1).setY(yyy);
                        list.get(i).get(list.get(i).size() - 1).setName(list2[i].getName() - 3);
                        map[xxx][yyy] = list.get(i).get(list.get(i).size() - 1).getName();

                }
            }
        }
    }

    @Override
    public void doFight() {//funkcja prowadząca raz na turę walkę
        int xx;
        int yy;
        int xxx;
        int yyy;
        double HP;
        double AP;
        int counter;
        int licz1;
        int licz2;

        for (int i = 0; i < 3; i++) {
            if (!list.get(i).isEmpty()) {
                for (int l = 0; l < list.get(i).size(); l++) {


                    counter = 0;
                    do {
                        xx = randomThrow();
                        yy = randomThrow();

                        xxx = list.get(i).get(l).getX() + xx;
                        yyy = list.get(i).get(l).getY() + yy;

                        if (xxx > 0 && xxx < size - 1 && yyy > 0 && yyy < size - 1) {
                            if (map[xxx][yyy] != 0 && map[xxx][yyy] != list.get(i).get(l).getName() && map[xxx][yyy] != list.get(i).get(l).getName() + 3) {
                                break;
                            }
                        }
                        counter++;
                    } while (counter < patience);


                    if (counter < patience) {
                        if (map[xxx][yyy] > 3) {                                                        //walka przebiega nieco odmiennie gdy atakuje się baze, a inaczej gdy atakuje sie jednostke
                            for (licz1 = 0; licz1 < 3; licz1++) {

                                if(list2[licz1].getHP()>0)
                                {
                                    if (xxx == list2[licz1].getX() && yyy == list2[licz1].getY()) {

                                        HP = list2[licz1].getHP();
                                        AP = list.get(i).get(l).getAP()+list.get(i).get(l).attack();
                                        list2[licz1].setHP(HP - AP);
                                        if (list2[licz1].getHP() <= 0) {    //pomniejszanie HP jednostki o wartość ataku atakującego
                                            map[xxx][yyy] = 0;
                                            list2[licz1].setX(0);       //usunięcie bazy z mapy
                                            list2[licz1].setY(0);
                                        }
                                        break;
                                    }
                                }
                            }

                        } else {
                            for (licz1 = 0; licz1 < 3; licz1++) {
                                for (licz2 = 0; licz2 < list.get(licz1).size(); licz2++) {
                                    if (xxx == list.get(licz1).get(licz2).getX() && yyy == list.get(licz1).get(licz2).getY())
                                    {
                                        HP = list.get(licz1).get(licz2).getHP();
                                        AP = list.get(i).get(l).getAP()+list.get(i).get(l).attack();
                                        list.get(licz1).get(licz2).setHP(HP - AP);

                                        if (list.get(licz1).get(licz2).getHP() <= 0) {
                                            list.get(licz1).remove(licz2); //w przeciewieństwie do baz, zniszczona jednostka jest usuwana z listy
                                            map[xxx][yyy] = 0;

                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    @Override
    public boolean alive() //funkcja sprawdzająca czy warunki zakonczenia symulacji zostały spełnione
                            //tj. na mapie zostali tylko reprezentanci jednej frakcji
    {
        int a,b,c;
        if(list.get(0).size()==0&&baseA.getHP()<=0)
        {
            a=1;

        }
        else
        {
            a=0;
        }
        if(list.get(1).size()==0&&baseB.getHP()<=0)
        {
            b=1;

        }
        else
        {
            b=0;
        }
        if(list.get(2).size()==0&&baseC.getHP()<=0)
        {
            c=1;

        }
        else
        {
            c=0;
        }

        if((a+b+c)>=2)
            return true;
        else
            return false;

    }
    public void show() {
        for (int l = 0; l < size; l++) {
            for (int i = 0; i < size; i++) {
                System.out.print(map[l][i] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    @Override
    public void move() //metoda odpowiedzialna za ruszanie kolejno wszystkimi dostepnymi jednostkami
    {

        int xx;
        int yy;
        int xxx;
        int yyy;
        int counter;

        for(int i=0; i<3;i++)
        {
            if(!list.get(i).isEmpty())
            {
                for(int l=0; l<list.get(i).size();l++)
                {
                    counter=0;
                    do
                    {
                     xx=randomThrow();
                     yy=randomThrow();

                        xxx= list.get(i).get(l).getX()+xx;
                        yyy= list.get(i).get(l).getY()+yy;

                        if( xxx>0&&xxx<size-1&&yyy>0&&yyy<size-1)
                        {
                            if(map[xxx][yyy]==0)
                            {
                                break;
                            }
                        }
                        counter++;
                    }while(counter<patience);

                    if(counter<patience)
                    {
                        map[list.get(i).get(l).getX()][list.get(i).get(l).getY()]=0;
                        list.get(i).get(l).setX(xxx);
                        list.get(i).get(l).setY(yyy);
                        map[xxx][yyy] = list.get(i).get(l).getName();
                    }
                }
            }
        }
    }
}