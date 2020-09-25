import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    int x, y;
    boolean mb1, mb2, mb3;

    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mousePressed(MouseEvent e) {
      if(e.getButton() == MouseEvent.BUTTON1) mb1 = true;
      if(e.getButton() == MouseEvent.BUTTON2) mb2 = true;
      if(e.getButton() == MouseEvent.BUTTON3) mb3 = true;
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) mb1 = false;
        if(e.getButton() == MouseEvent.BUTTON2) mb2 = false;
        if(e.getButton() == MouseEvent.BUTTON3) mb3 = false;
    }
}
