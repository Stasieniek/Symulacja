public class Simulation {

    public static void main(String[] args) {


        int counter = 2;
        IMapPlugin map = new Map(10);

        if(map instanceof Map) {
            map.addBase();


            for (int l = 0; l < counter; l++) {
                if (map.alive()) {
                    break;
                }
                map.addUnit();
                map.show();
                map.move();
                map.show();


            }
        }
    }
    public void showResults() {

    }
}




