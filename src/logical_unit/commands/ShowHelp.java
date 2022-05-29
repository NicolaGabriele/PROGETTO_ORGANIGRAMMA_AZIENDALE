package logical_unit.commands;

import presentation.others_graphic_component.HelpView;

public class ShowHelp implements Command{
    @Override
    public void execute() {
        new HelpView().config().createDialog("help").setVisible(true);
    }
}
