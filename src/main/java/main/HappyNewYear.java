package main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MuhammaD on 21.12.2014.
 */
public class HappyNewYear extends JFrame {
    private JPanel panel1;
    private JTabbedPane rootPanel;
    private JCheckBox ONLINE;
    private JCheckBox AWAY;
    private JCheckBox DND;
    private JCheckBox INVISIBLE;
    private JSlider slider1;
    private JButton Start;
    private JButton Stop;

    public HappyNewYear() {
        super("MainLable");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        final Thread[] secondThread = new Thread[1];
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logic logic = new Logic(DND.isSelected(),AWAY.isSelected(),ONLINE.isSelected(),INVISIBLE.isSelected());
                secondThread[0] = new Thread(logic);
                secondThread[0].start();
            }
        });
        Stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logic();
            }
        });


        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                new Logic(slider1.getValue());
            }
        });
    }


}
