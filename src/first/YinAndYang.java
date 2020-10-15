package first;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class YinAndYang {

    private JFrame frame;
    private DrawPanel3 drawPanel = new DrawPanel3();

    private int oneX = 7;
    private int oneY = 7;

    private int ovalX = 300;
    private int ovalY = 120;

    private int oval2X = 1;
    private int oval2Y = 120;

    private int sizeoval = 60;
    private int pillarOval = 1;
    private boolean increase = true;

    boolean goToRight = true;

    int a = 0;
    private int numOfFlakes = 10;
    private SnowBall[] Drops = new SnowBall[numOfFlakes];
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    Random rand = new Random();

    public static void main(String... args)
    {
        new YinAndYang().go();
    }

    private void go()
    {
        frame = new JFrame("Test2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new AnimTest2().drawPanel;

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setResizable(true);
        frame.setSize(360, 360);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        initArray();
        moveIt();
        //heartanim();
    }
    public void initArray(){




        for (int o = 0; o<numOfFlakes; o++){
            //Also init all the drops
            hashMap.put(rand.nextInt(300), 10);

            //Drops[o].setSnowX(rand.nextInt(500));
        }
        System.out.println(hashMap.toString());
    }




    class DrawPanel3 extends JPanel
    {
        private static final long serialVersionUID = 1L;
        public void paintComponent(Graphics g) {
           /*
           Parameters:
              x - the x coordinate of the rectangle to be filled.
              y - the y coordinate of the rectangle to be filled.
              width - the width of the rectangle to be filled.
              height - the height of the rectangle to be filled.
            */
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
//            g.setColor(Color.RED);
//            g.fillRect(3, 3, this.getWidth() - 6, this.getHeight() - 6);
//            g.setColor(Color.WHITE);
//            g.fillRect(6, 6, this.getWidth() - 12, this.getHeight() - 12);

            // Black is cubic
            g.setColor(Color.BLACK);
            //XY upper , XY downer


            if (sizeoval>60){
                sizeoval =60;
            }
            for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
                Integer key = e.getKey();
                Integer value = e.getValue();
                g.setColor(Color.YELLOW);
                g.fillOval(key,value,40,40);
                e.setValue(value+rand.nextInt(2));

                if (value>400){ e.setValue(1); }
            }


            g.setColor(Color.RED);
            g.fillOval(ovalX-sizeoval/2,ovalY-sizeoval/2,sizeoval,sizeoval);
            if (a ==0){
                g.setColor(Color.BLACK);
                g.fillOval(ovalX-300-sizeoval/2,ovalY-sizeoval/2,sizeoval,sizeoval);
                a++;
            }else{
                g.setColor(Color.BLACK);
                g.fillOval(ovalX+sizeoval/2,ovalY+sizeoval/2,sizeoval,sizeoval);
            }

        }
    }

    private void moveIt() {


        for (int turn = 0; turn<360;turn++ ){
//            for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
//                Integer key = e.getKey();
//                Integer value = e.getValue();
//
//                e.setValue(value+1);
//                if (value>400){
//                    e.setValue(1);
//                }
//            }
//            hashMap.replace(25,hashMap.get(25)+1);

            if (goToRight){
                rightGo();
            }else {
                leftGo();
                turn = 0;
            }


            if (ovalX>288 | ovalX < 12){
                try
                { Thread.sleep(20); }
                catch (Exception e) { e.printStackTrace(); }
            }else if (ovalX >280| ovalX < 20){
                try
                { Thread.sleep(15); }
                catch (Exception e) { e.printStackTrace(); }
            }else{
                try
                { Thread.sleep(10); }
                catch (Exception e) { e.printStackTrace(); }
            }


            frame.repaint();
        }


    }

    private void rightGo(){
        if (ovalX < 300){
            ovalX++;
            if (ovalX%5==0 & ovalX>180){
                sizeoval--;
            }else if (ovalX%5==0 & ovalX <180){
                sizeoval++;
            }

        }else {
            goToRight = false;

        }


    }

    public void leftGo(){
        if (ovalX > 1){
            ovalX--;
            if (ovalX%5==0 & ovalX>180){
                sizeoval--;
            }else if (ovalX%10==0 & ovalX <180){
                sizeoval++;
            }

        }else {
            goToRight = true;
        }
    }



}
