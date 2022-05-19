package presentation.others_graphic_component;

import logical_unit.commands.Command;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuItem extends JMenuItem{

    private Command command;
    public MyMenuItem(String title,Command command){
        super(title);
        this.command = command;
        addActionListener(e -> {
            command.execute();
        });

    }

}
