import java.util.ArrayList;
import java.util.Random;
public class Map implements IMapPlugin {




    private ArrayList<ArrayList<Unit>> list = new ArrayList<>();
    private Base [] list2 = new Base[3];

    private ArrayList<Unit> listA = new ArrayList<>();
    private ArrayList<Unit> listB = new ArrayList<>();
    private ArrayList<Unit> listC = new ArrayList<>();

    private int size;

    Map(int size){
        this.size = size;
    }
    Map(){;}



    private int[][] map = new int[10][10];


    private Base baseA = new Base();
    private Base baseB = new Base();
    private Base baseC = new Base();


    @Override
    public void addBase() {

        Random random2 = new Random();
        baseA.setName(4);
        baseB.setName(5);
        baseC.setName(6);
        list2[0]=baseA;
        list2[1]=baseB;
        list2[2]=baseC;
        boolean check;
        int xxx=0;
        int yyy=0;

        for (int i=0; i<3;i++) {
            if(list2[i]!=null)
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

                 list2[i].setX(xxx);
                 list2[i].setY(yyy);
                map[xxx][yyy] = list2[i].getName();

        }

        list.add(listA);
        list.add(listB);
        list.add(listC);
        }
        static int randomThrow()
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
            int random1;
            int random2;
            for (int i=0; i<3;i++) {

                counter =0;
                do
                {
                    xx=randomThrow();
                    yy=randomThrow();

                    xxx = list2[i].getX()+xx;
                    yyy = list2[i].getY()+yy;

                    if( xxx>0&&xxx<size-1&&yyy>0&&yyy<size-1)
                    {
                        if(map[xxx][yyy]==0)
                        {
                           break;
                        }
                    }
                    counter++;
                }while(counter<9);



                if(counter<9)
                {
                  list.get(i).add(list2[i].generateUnit());
                    if(!list.get(i).isEmpty())
                    {
                        list.get(i).get(list.get(i).size()-1).setX(xxx);
                        list.get(i).get(list.get(i).size()-1).setY(yyy);
                        list.get(i).get(list.get(i).size()-1).setName(i+1);
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
                            if(map[xxx][yyy]==0)
                            {
                                break;
                            }
                        }
                        counter++;
                    }while(counter<9);





                }
            }
        }


    }


    public boolean position()
    {

        return false;
    }


    @Override
    public boolean alive()
    {
        int a=0,b=0,c=0,d=0;
        if(list.get(0).isEmpty()&&list2[0]==null)
        {
            a=1;

        }
        else
        {
            a=0;
        }
        if(list.get(1).isEmpty()&&list2[1]==null)
        {
            b=1;

        }
        else
        {
            b=0;
        }
        if(list.get(2).isEmpty()&&list2[2]==null)
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
        int random1;
        int random2;
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
                    }while(counter<9);

                    if(counter<9)
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