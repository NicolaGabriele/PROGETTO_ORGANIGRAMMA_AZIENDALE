package logical_unit.organizzation_charts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeOrganizzationChartTest {

    @Test
    void add() {
        CompositeOrganizzationChart o = new CompositeOrganizzationChart("test");
        o.add(new CompositeOrganizzationChart("child1"));
        o.add(new CompositeOrganizzationChart("child2"));
        assertEquals(2,o.getChildren().size());
    }

    @Test
    void remove() {
        CompositeOrganizzationChart o = new CompositeOrganizzationChart("test");
        o.add(new CompositeOrganizzationChart("child1"));
        o.add(new CompositeOrganizzationChart("child2"));
        o.remove(new CompositeOrganizzationChart("child1"));
        assertEquals(1,o.getChildren().size());
        o.remove(new CompositeOrganizzationChart("child2"));
        assertEquals(0,o.getChildren().size());
    }

    @Test
    void contain() {
        CompositeOrganizzationChart o = new CompositeOrganizzationChart("test");
        o.add(new CompositeOrganizzationChart("child1"));
        assertEquals(true, o.contain(new CompositeOrganizzationChart("child1")));
        assertEquals(false, o.contain(new CompositeOrganizzationChart("child2")));
    }
}