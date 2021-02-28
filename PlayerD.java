package javaapplication1;

import java.awt.Color;

public class DOyuncusu extends Oyuncu {

    public DOyuncusu(int satir, int sutun, int baslangicaltını, int hedefmaliyet, int hamlemaliyet, int hareketpuanı) {
        super(satir, sutun, baslangicaltını, hedefmaliyet, hamlemaliyet, hareketpuanı);
    }
        int[] oyuncuyatay, oyuncudikey; 
        int adikey ;
        int ayatay ;
        int bdikey ;
        int byatay ;
        int cdikey;
        int cyatay;

    
    @Override
    void HamleÖngörme(int a, int b) {

       oyuncuyatay = new int[3];
        oyuncudikey = new int[3];
         adikey = oyuncudikey[0];
         ayatay = oyuncuyatay[0];
         bdikey = oyuncudikey[1];
         byatay = oyuncuyatay[1];
         cdikey = oyuncudikey[2];
         cyatay = oyuncuyatay[2];
      

    }

    @Override
    void hedefBelirleme(Btn[][] oyunpaneli, int satirsayisi, int sutunsayisi) {
        
        if (oyunpaneli[hedefsatir][hedefsutun].isAltın() == false) {
            hedefvarmı = false;

        }
        if (hedefvarmı == false) {
            int kar = 0;
            for (int i = 0; i < satirsayisi; i++) {
                for (int j = 0; j < sutunsayisi; j++) {
                    if (hedefvarmı == false && oyunpaneli[i][j].isAltın() == true) {
                        hedefsatir = i;
                        hedefsutun = j;
                        int satirfarkı = Math.abs(yataykonum - i);
                        int sutunfarkı = Math.abs(dikeykonum - j);
                        int aradakifark = satirfarkı + sutunfarkı;
                        int katsayı = 0;
                        if (aradakifark % 3 == 0) {
                            katsayı = aradakifark / 3;

                        } else if (aradakifark % 3 != 0) {
                            katsayı = (aradakifark / 3) + 1;
                        }
                        kar = oyunpaneli[i][j].getAltındeğeri() - hedefmaliyeti - (katsayı * hamlemaliyeti);
                        hedefvarmı = true;

                    } else if (hedefvarmı == true && oyunpaneli[i][j].isAltın() && oyunpaneli[i][j]!= oyunpaneli[ayatay][adikey] && oyunpaneli[i][j]!= oyunpaneli[byatay][bdikey] && oyunpaneli[i][j]!= oyunpaneli[cyatay][cdikey]) {
                        int satirfarkı = Math.abs(yataykonum - i);
                        int sutunfarkı = Math.abs(dikeykonum - j);
                        int aradakifark = satirfarkı + sutunfarkı;
                        int katsayı = 0;
                        if (aradakifark % 3 == 0) {
                            katsayı = aradakifark / 3;

                        } else if (aradakifark % 3 != 0) {
                            katsayı = (aradakifark / 3) + 1;
                        }
                        int kar2 = oyunpaneli[i][j].getAltındeğeri() - hedefmaliyeti - (katsayı * hamlemaliyeti);
                        if (kar2 > kar) {
                            kar = kar2;
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
                if (oyunpaneli[yataykonum][dikeykonum] == oyunpaneli[hedefsatir][hedefsutun]) {
                    mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                    oyunpaneli[yataykonum][dikeykonum].setText("");
                    oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                    oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);
                }

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
                if (oyunpaneli[yataykonum][dikeykonum] == oyunpaneli[hedefsatir][hedefsutun]) {
                    mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                    oyunpaneli[yataykonum][dikeykonum].setText("");
                    oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                    oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);
                }
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
                if (oyunpaneli[yataykonum][dikeykonum] == oyunpaneli[hedefsatir][hedefsutun]) {
                    mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                    oyunpaneli[yataykonum][dikeykonum].setText("");
                    oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                    oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);
                }
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
                if (oyunpaneli[yataykonum][dikeykonum] == oyunpaneli[hedefsatir][hedefsutun]) {
                    mevcutaltın += oyunpaneli[yataykonum][dikeykonum].getAltındeğeri();
                    oyunpaneli[yataykonum][dikeykonum].setText("");
                    oyunpaneli[yataykonum][dikeykonum].setAltın(false);
                    oyunpaneli[yataykonum][dikeykonum].setBackground(Color.white);
                }
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

}
