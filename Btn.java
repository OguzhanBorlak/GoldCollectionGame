package javaapplication1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Btn extends JButton  {

    private int sutun, satir, altındeğeri;
    private boolean altın, gizlialtın;

    public Btn(int satir, int sutun) {
        this.sutun = sutun;
        this.satir = satir;
        this.altın = false;
        this.gizlialtın = false;
    }

    public int getAltındeğeri() {
        return altındeğeri;
    }

    public void setAltındeğeri(int altındegeri) {
        this.altındeğeri = altındegeri;
    }

    public int getSutun() {
        return sutun;
    }

    public int getSatir() {
        return satir;
    }

    public boolean isAltın() {
        return altın;
    }

    public boolean isGizlialtın() {
        return gizlialtın;
    }

    public void setSutun(int sutun) {
        this.sutun = sutun;
    }

    public void setSatir(int satir) {
        this.satir = satir;
    }

    public void setAltın(boolean altın) {
        this.altın = altın;
    }

    public void setGizlialtın(boolean gizlialtın) {
        this.gizlialtın = gizlialtın;
    }

  

}
