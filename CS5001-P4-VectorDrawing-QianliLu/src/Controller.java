import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Controller extends Thread {
    private View userView;
    private Model model;
    private String currentButton ;    //当前选中的按钮
    private Color currentColor;  //当前选中的颜色
    private int lastX = -1;
    private int lastY = -1;
    private int lastX2 = -1;
    private int lastY2 = -1;

    public Controller(){
        userView=new View();
        model=userView.model;
        userView.lineButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                currentButton = "LineButton";
                System.out.println("LineButton pressed");
            }

        });

    userView.addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent event) {
        System.out.println("mousePressed");
        //初始化各选择项

        lastX = -1; //开始点击的坐标
        lastY = -1;

        lastX2 = lastX = event.getX();	//点击过程中的临时坐标
        lastY2 = lastY = event.getY();
        //选择图像，做出改变
        if(currentButton.equals("LineButton")) {
            model.setX(lastX2);
            model.setY(lastY2);

            userView.repaint();

        }
    }});

    }
    public static void main(String[] args) throws InterruptedException {
        Controller frame = new Controller();
        frame.userView.setVisible(true);



    }
}
