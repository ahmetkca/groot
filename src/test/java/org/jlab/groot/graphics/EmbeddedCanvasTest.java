package org.jlab.groot.graphics;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class EmbeddedCanvasTest {

    @Test
    public void test_embeddedcanvas() {
        Dimension screensize  = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("GROOT TEST");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int)(screensize.getHeight()*.75*1.618), (int) (screensize.getHeight()*.75));
        JTabbedPane tabbedPane = new JTabbedPane();
        EmbeddedCanvas can1 = new EmbeddedCanvas();
        EmbeddedCanvas can2 = new EmbeddedCanvas();
        can1.divide(4, 4);
        can2.divide(2, 2);

        tabbedPane.add("H1D TEST1", can1);

        tabbedPane.add("H1D TEST2", can2);

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        assertNotNull(tabbedPane);
        assertNotNull(can1);
        assertNotNull(can2);
        assertTrue(tabbedPane.getTabCount() == 2);
        assertFalse(tabbedPane.getTabCount() == 3);
    }
}