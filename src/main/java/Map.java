import java.util.ArrayList;
import java.util.Random;
public class Map implements IMapPlugin {




    private ArrayList<ArrayList<ISoldier>> list = new ArrayList<>();
    private ArrayList<IBase> list2 = new ArrayList<>();

    private ArrayList<ISoldier> listA = new ArrayList<>();
    private ArrayList<ISoldier> listB = new ArrayList<>();
    private ArrayList<ISoldier> listC = new ArrayList<>();

    private int size;
    private int patience;
    Map(int size, int patience){
        this.size = size;
        this.patience = patience;
    }
    Map(){;}

    public ArrayList getList2()
    {
        return list2;
    }

    private int[][] map = new int[10][10];


    IBase baseA = new Base(50,4);
    IBase baseB = new Base(50,5);
    IBase baseC = new Base(50,6);



    public void showResults()
    {
        for(int i=0;i<list2.size();i++)
            System.out.println("Baza "+(i+1)+" to: "+list2.get(i).getName()+" "+list2.get(i).getHP()+" "+list2.get(i).getX()+" "+list2.get(i).getY());

    }
    @Override
    public void addBase() {

        Random random2 = new Random();
        list2.add(baseA);
        list2.add(baseB);
        list2.add(baseC);
        boolean check;
        int xxx;
        int yyy;

        for (int i=0; i<3;i++) {
            do {
                check = true;

                xxx = random2.nextInt(size);
                yyy = random2.nextInt(size);

                if (xxx >1&&xxx<(size-2)  && yyy >1&&yyy<(size-2)  ) {
                    if (map[xxx][yyy] == 0) {
                        check = false;
                    }
                }

            } while (check);

                 list2.get(i).setX(xxx);
                 list2.get(i).setY(yyy);
                map[xxx][yyy] = list2.get(i).getName();

        }

        list.add(listA);
        list.add(listB);
        list.add(listC);
        }
        private static int randomThrow()
        {
          int z;
          int random1;
          Random random = new Random();
          random1 =random.nextInt(3);
            if(random1==1)
                z=1;
            else if(random1==2)
                z=0;
            else
                z=-1;
          return z;
        }


    @Override
        public void addUnit()
        {
            int xxx;
            int yyy;
            int xx;
            int yy;
            int counter;
            for (int i=0; i<list2.size();i++) {

                counter =0;
                do
                {
                    xx=randomThrow();
                    yy=randomThrow();

                    xxx = list2.get(i).getX()+xx;
                    yyy = list2.get(i).getY()+yy;

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
                  list.get(i).add(list2.get(i).generateUnit());
                    if(!list.get(i).isEmpty())
                    {
                        list.get(i).get(list.get(i).size()-1).setX(xxx);
                        list.get(i).get(list.get(i).size()-1).setY(yyy);
                        list.get(i).get(list.get(i).size()-1).setName(list2.get(i).getName()-3);
                        map[xxx][yyy] = list.get(i).get(list.get(i).size()-1).getName();
                    }
                }
            }
        }

    @Override
    public void doFight() {
        int xx;
        int yy;
        int xxx;
        int yyy;
        double HP;
        double AP;
        int counter;

        for(int i=0;i<3;i++)
        {
            if(!list.get(i).isEmpty()) {
                for (int l = 0; l < list.get(i).size(); l++) {
                    counter=0;
                    do
                    {
                        xx=randomThrow();
                        yy=randomThrow();

                        xxx= list.get(i).get(l).getX()+xx;
                        yyy= list.get(i).get(l).getY()+yy;

                        if( xxx>0&&xxx<size-1&&yyy>0&&yyy<size-1)
                        {
                            if(map[xxx][yyy]!=0&&map[xxx][yyy]!=list.get(i).get(l).getName()&&map[xxx][yyy]!=list.get(i).get(l).getName()+3)
                            {
                                break;
                            }
                        }
                        counter++;
                    }while(counter<patience);

                    if(counter<patience)
                    {
                        if(map[xxx][yyy]>3)
                        {
                            for(int licz1=0;licz1<list2.size();licz1++)
                            {
                                if(xxx==list2.get(licz1).getX()&&yyy==list2.get(licz1).getY())
                                {
                                   HP = list2.get(licz1).getHP();
                                   AP = list.get(i).get(l).getAP();
                                   list2.get(licz1).setHP(HP-AP);
                                    if(list2.get(licz1).getHP()<=0)
                                    {
                                        list2.remove(licz1);
                                        map[xxx][yyy]=0;

                                    }
                                    break;
                                }
                            }
                        }
                        else
                        {
                            for(int licz1=0;licz1<3;licz1++)
                            {
                                if(!list.get(licz1).isEmpty())
                                {
                                    if(list.get(i).get(l).getName()!=licz1)
                                    {
                                        for(int licz2=0;licz2<list.get(licz1).size();licz2++)
                                        {
                                            if(xxx==list.get(licz1).get(licz2).getX()&&yyy==list.get(licz1).get(licz2).getY())
                                            {
                                                System.out.println("HP to: "+list.get(licz1).get(licz2).getHP());
                                                System.out.println("Rozmiar tablicy to: "+list.get(licz1).size());
                                                System.out.println(list.get(licz1).get(licz2).getX()+" "+list.get(licz1).get(licz2).getY());
                                                System.out.println("Numer indeksu to: "+licz2);
                                                HP = list.get(licz1).get(licz2).getHP();
                                                AP = list.get(i).get(l).getAP();
                                                list.get(licz1).get(licz2).setHP(HP-AP);
                                                System.out.println("HP po walce to: "+list.get(licz1).get(licz2).getHP());
                                                if(list.get(licz1).get(licz2).getHP()<=0)
                                                {
                                                    list.get(licz1).remove(licz2);
                                                    System.out.println("Rozmiar tablicy po walce to: "+list.get(licz1).size());
                                                    map[xxx][yyy]=0;
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
        }
    }



    @Override
    public boolean alive()
    {
        int a,b,c,d=0;
        if(list.get(0).isEmpty()&&baseA.getHP()<0)
        {
            a=1;

        }
        else
        {
            a=0;
        }
        if(list.get(1).isEmpty()&&baseB.getHP()<0)
        {
            b=1;

        }
        else
        {
            b=0;
        }
        if(list.get(2).isEmpty()&&baseC.getHP()<0)
        {
            c=1;

        }
        else
        {
            c=0;
        }

        if(a+b+c==2)
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
    public void move()
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