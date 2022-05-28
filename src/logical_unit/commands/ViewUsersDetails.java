package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.MainFrame;
import presentation.others_graphic_component.UsersDetails;

public class ViewUsersDetails implements Command{

    private MainFrame mainFrame;
    private OrganizzationChart o;
    public ViewUsersDetails(OrganizzationChart o, MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.o = o;
    }
    @Override
    public void execute() {
        UsersDetails u = new UsersDetails(mainFrame);
        mainFrame.getPannelloPrincipale().add(u);
        mainFrame.getLayoutManager().addLayoutComponent(u,"users details");
        u.config(o.getEmployees());
    }
}
