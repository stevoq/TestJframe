import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

public class SimpleJButton {

    private JLabel labelClock;
    private void tickTock(){
        labelClock.setText(DateFormat.getTimeInstance().format(new Date()));
    }
    SimpleJButton(){

        JFrame f=new JFrame("Button Example");

        //clock
        labelClock = new JLabel();
        labelClock.setBounds(5,2,100,50);
        //labelClock.setText(DateFormat.getTimeInstance().format(new Date()));
        labelClock.setFont(UIManager.getFont("Label.font").deriveFont(Font.BOLD, 20f));
        Timer timer = new Timer(500, e -> tickTock());
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.start();



        //submit button
        JButton b=new JButton("Submit");
        b.setBounds(5,100,100, 25);
        //enter name label
        JLabel label = new JLabel();
        label.setText("Enter Time :");
        label.setBounds(5, 10, 100, 100);
        //empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        //textfield to enter time
        JTextField textfield= new JTextField();
        textfield.setBounds(110, 50, 180, 30);
        //add to frame
        f.add(label1);
        f.add(textfield);
        f.add(label);
        f.add(b);
        f.add(labelClock);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText("Time has been submitted.");
            }
        });
    }
}
