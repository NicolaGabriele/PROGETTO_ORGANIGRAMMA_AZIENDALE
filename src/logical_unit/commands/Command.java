package logical_unit.commands;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute();
}
