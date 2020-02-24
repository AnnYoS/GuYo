package gui.panel.container;

import static util.Constant.*;

public class FitPanel extends MainContainer {

    public FitPanel(int width, int height, boolean dark, boolean withtitlebar){
        super(width, height, dark, withtitlebar);
        if(dark){
            setBackground(DEFAULT_BLACK);
        } else {
            setBackground(DEFAULT_WHITE);
        }
    }
}
