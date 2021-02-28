package javaapplication1;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AOyuncusu extends Oyuncu {



    public AOyuncusu(int satir, int sutun, int baslangicaltını, int hedefmaliyet, int hamlemaliyet, int hareketpuanı)  {
        super(satir, sutun, baslangicaltını, hedefmaliyet, hamlemaliyet, hareketpuanı);    
    }

    @Override
    void hedefBelirleme(Btn[][] oyunpaneli, int satirsayisi, int sutunsayisi) {

        if (oyunpaneli[hedefsatir][hedefsutun].isAltın() == false) {
            hedefvarmı = false;
        }
        if (hedefvarmı == false) {
            double uzaklık = 0;

            for (int i = 0; i < satirsayisi; i++) {
                for (int j = 0; j < sutunsayisi; j++) {
                    if (hedefvarmı == false && oyunpaneli[i][j].isAltın() == true) {
                        hedefsatir = i;
                        hedefsutun = j;
                        uzaklık = Math.sqrt(Math.pow(Math.abs(i - yataykonum), 2) + Math.pow(Math.abs(j - dikeykonum), 2));
                        hedefvarmı = true;

                    } else if (hedefvarmı == true && oyunpaneli[i][j].isAltın() == true) {
                        double yeniuzaklık = Math.sqrt(Math.pow(Math.abs(i - yataykonum), 2) + Math.pow(Math.abs(j - dikeykonum), 2));
                        if (yeniuzaklık < uzaklık) {
                            uzaklık = yeniuzaklık;
                            hedefsatir = i;
                            hedefsutun = j;

                        }
                    }

                }

            }
            if (hedefvarmı == true) {

                mevcutaltın -= hedefmaliyeti;
          
            }

        }

    
}

    @Override
    void hareket(Btn[][] oyunpaneli, int satirsayisi, int sutunsayisi) {
        int adımsayısı = hareketpuanı;

        if (yataykonum == hedefsatir && dikeykonum == hedefsatir) {
            mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
            oyunpaneli[yataykonum][dikeykonum].setText("");
            oyunpaneli[yataykonum][dikeykonum].setAltın(false);
            oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);

        }
        while (yataykonum < hedefsatir && hareketpuanı > 0) {
            yataykonum++;
            if (oyunpaneli[yataykonum][dikeykonum].isGizlialtın()) {
                oyunpaneli[yataykonum][dikeykonum].setGizlialtın(false);
                oyunpaneli[yataykonum][dikeykonum].setAltın(true);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.yellow);

            } else if (oyunpaneli[yataykonum][dikeykonum].isAltın()) {
                mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                oyunpaneli[yataykonum][dikeykonum].setText("");
                oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);

            }
            hareketpuanı--;
        }
        while (yataykonum > hedefsatir && hareketpuanı > 0) {
            yataykonum--;
            if (oyunpaneli[yataykonum][dikeykonum].isGizlialtın()) {
                oyunpaneli[yataykonum][dikeykonum].setGizlialtın(false);
                oyunpaneli[yataykonum][dikeykonum].setAltın(true);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.yellow);

            } else if (oyunpaneli[yataykonum][dikeykonum].isAltın()) {
                mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                oyunpaneli[yataykonum][dikeykonum].setText("");
                oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);

            }
            hareketpuanı--;

        }
        while (dikeykonum < hedefsutun && hareketpuanı > 0) {
            dikeykonum++;
            if (oyunpaneli[yataykonum][dikeykonum].isGizlialtın()) {
                oyunpaneli[yataykonum][dikeykonum].setGizlialtın(false);
                oyunpaneli[yataykonum][dikeykonum].setAltın(true);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.yellow);

            } else if (oyunpaneli[yataykonum][dikeykonum].isAltın()) {
                mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                oyunpaneli[yataykonum][dikeykonum].setText("");
                oyunpaneli[yataykonum][dikeykonum].setAltın(false);

                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);

            }
            hareketpuanı--;

        }
        while (dikeykonum > hedefsutun && hareketpuanı > 0) {
            dikeykonum--;
            if (oyunpaneli[yataykonum][dikeykonum].isGizlialtın()) {
                oyunpaneli[yataykonum][dikeykonum].setGizlialtın(false);
                oyunpaneli[yataykonum][dikeykonum].setAltın(true);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.yellow);

            } else if (oyunpaneli[yataykonum][dikeykonum].isAltın()) {
                mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                oyunpaneli[yataykonum][dikeykonum].setText("");
                oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                oyunpaneli[yataykonum][dikeykonum].setAltındeğeri(0);
                oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);

            }
            hareketpuanı--;

        }

        hareketpuanı = adımsayısı;
        mevcutaltın -= hamlemaliyeti;
       
    }

    @Override
    void GizliAltınAcma(Btn[][] oyunpaneli, int satirsayisi, int sutunsayisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void HamleÖngörme(int a,int b) {
         HamleÖngörme(hedefsatir,hedefsutun); 
    }

}
