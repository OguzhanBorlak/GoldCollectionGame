package javaapplication1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AltınToplama extends JPanel implements ActionListener {

    JPanel oyunpaneli, sonpanel, büyükpanel;
    JFrame frame, frame2;
    JButton devam;
    int sırakimde = 1;
    int satirsayisi, sutunsayisi;
    Btn[][] tahta;
    int baslangiçaltini = 200, hareketmesafesi = 3, ahedefmaliyet = 5, ahamlemaliyet = 5;
    int bhedefmaliyet = 10, bhamlemaliyet = 5;
    int chedefmaliyet = 15, chamlemaliyet = 5;
    int dhedefmaliyet = 20, dhamlemaliyet = 5;
    File adosyası, bdosyası, cdosyası, ddosyası;
    FileWriter afilewriter, bfilewriter, cfilewriter, dfilewriter;
    BufferedWriter abufferedwriter, bbufferedwriter, cbufferedwriter, dbufferedwriter;
    
    Oyuncu aoyuncusu;
    Oyuncu boyuncusu;
    Oyuncu coyuncusu;
    Oyuncu doyuncusu;
    int aadım = 0, badım = 0, cadım = 0, dadım = 0;
    
    ImageIcon img2 = new ImageIcon(new ImageIcon("H:\\masaüstü\\yazlab\\TABLO2.png").getImage().getScaledInstance(1500, 720, Image.SCALE_SMOOTH));
    JLabel sontablo;

    public AltınToplama(JFrame frame, int satirsayisi, int sutunsayisi, int baslangiçaltini, int hareketmesafesi, int ahedefmaliyet, int ahamlemaliyet, int bhedefmaliyet, int bhamlemaliyet, int chedefmaliyet, int chamlemaliyet, int dhedefmaliyet, int dhamlemaliyet) throws IOException {
        this.satirsayisi = satirsayisi;
        this.sutunsayisi = sutunsayisi;
        this.baslangiçaltini = baslangiçaltini;
        this.hareketmesafesi = hareketmesafesi;
        this.ahedefmaliyet = ahedefmaliyet;
        this.ahamlemaliyet = ahamlemaliyet;
        this.bhamlemaliyet = bhamlemaliyet;
        this.bhedefmaliyet = bhedefmaliyet;
        this.chamlemaliyet = chamlemaliyet;
        this.chedefmaliyet = chedefmaliyet;
        this.dhamlemaliyet = dhamlemaliyet;
        this.dhedefmaliyet = dhedefmaliyet;
        tahta = new Btn[satirsayisi][sutunsayisi];

        adosyası = new File("A.txt");
        afilewriter = new FileWriter(adosyası.getAbsoluteFile());
        abufferedwriter = new BufferedWriter(afilewriter);

        bdosyası = new File("B.txt");
        bfilewriter = new FileWriter(bdosyası.getAbsoluteFile());
        bbufferedwriter = new BufferedWriter(bfilewriter);

        cdosyası = new File("C.txt");
        cfilewriter = new FileWriter(cdosyası.getAbsoluteFile());
        cbufferedwriter = new BufferedWriter(cfilewriter);

        ddosyası = new File("D.txt");
        dfilewriter = new FileWriter(ddosyası.getAbsoluteFile());
        dbufferedwriter = new BufferedWriter(dfilewriter);

        aoyuncusu = new AOyuncusu(0, 0, baslangiçaltini, ahedefmaliyet, ahamlemaliyet, hareketmesafesi);
        boyuncusu = new BOyuncusu(0, sutunsayisi - 1, baslangiçaltini, bhedefmaliyet, bhamlemaliyet, hareketmesafesi);
        coyuncusu = new COyuncusu(satirsayisi - 1, 0, baslangiçaltini, chedefmaliyet, chamlemaliyet, hareketmesafesi);
        doyuncusu = new DOyuncusu(satirsayisi - 1, sutunsayisi - 1, baslangiçaltini, dhedefmaliyet, dhamlemaliyet, hareketmesafesi);
        this.frame = frame;
        devam = new JButton("DEVAM");
        frame = new JFrame();
        büyükpanel = new JPanel();
        oyunpaneli = new JPanel();
        frame.setBounds(0, 0, 1920, 1000);
        büyükpanel.setBounds(0, 0, 1920, 950);
        oyunpaneli.setBounds(0, 0, 1600, 950);
        devam.setBounds(1600, 0, 320, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oyunpaneli.setLayout(new GridLayout(satirsayisi, sutunsayisi, 2, 2));

        for (int satir = 0; satir < tahta.length; satir++) {
            for (int sutun = 0; sutun < tahta[0].length; sutun++) {
                Btn b = new Btn(satir, sutun);
                oyunpaneli.add(b);
                tahta[satir][sutun] = b;
                b.setBackground(java.awt.Color.white);

            }
        }

        AltınUret();
        AltınBas();

        tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setBackground(java.awt.Color.magenta);
        tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setText("A-" + aoyuncusu.mevcutaltın);

        tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setBackground(java.awt.Color.green);
        tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setText("B-" + boyuncusu.mevcutaltın);

        tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setBackground(java.awt.Color.red);
        tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setText("C-" + coyuncusu.mevcutaltın);

        tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setBackground(java.awt.Color.CYAN);
        tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setText("D-" + doyuncusu.mevcutaltın);

        büyükpanel.setLayout(null);
        devam.setBackground(java.awt.Color.white);
        devam.addActionListener(this);
        frame.add(büyükpanel);
        büyükpanel.add(oyunpaneli);
        büyükpanel.add(devam);

        büyükpanel.setVisible(true);
        oyunpaneli.setVisible(true);
        frame.setVisible(true);

    }

    public void AltınUret() {

        int i = 0, j = 0;

        while (i < (satirsayisi * sutunsayisi) * 20 / 100) {
            int randsatir = (int) (Math.random() * tahta.length);
            int randsutun = (int) (Math.random() * tahta[0].length);
           if ( tahta[randsatir][randsutun] != tahta[0][0] &&tahta[randsatir][randsutun] != tahta[0][sutunsayisi - 1]&& tahta[randsatir][randsutun] != tahta[satirsayisi - 1][0] && tahta[randsatir][randsutun] != tahta[satirsayisi - 1][sutunsayisi - 1]) {
                while (tahta[randsatir][randsutun].isAltın()) {

                    randsatir = (int) (Math.random() * tahta.length);
                    randsutun = (int) (Math.random() * tahta[0].length);

                }

                tahta[randsatir][randsutun].setAltın(true);
                i++;
          }

        }  

        while (j < (satirsayisi * sutunsayisi) * 20 / 1000) {
            int randsatir = (int) (Math.random() * tahta.length);
            int randsutun = (int) (Math.random() * tahta[0].length);
            if ( tahta[randsatir][randsutun] != tahta[0][0] &&tahta[randsatir][randsutun] != tahta[0][sutunsayisi - 1]&&  tahta[randsatir][randsutun] != tahta[satirsayisi - 1][0] && tahta[randsatir][randsutun] != tahta[satirsayisi - 1][sutunsayisi - 1]) {
                while (tahta[randsatir][randsutun].isAltın()) {
                    randsatir = (int) (Math.random() * tahta.length);
                    randsutun = (int) (Math.random() * tahta[0].length);
                }
                tahta[randsatir][randsutun].setGizlialtın(true);
                j++;
            }

        }

    }

    public void AltınBas() {
        int gizlisatir = 0, gizlisutun = 0;

        for (int satir = 0; satir < tahta.length; satir++) {
            for (int sutun = 0; sutun < tahta[0].length; sutun++) {
                if (tahta[satir][sutun].isAltın()) {
                    int miktar = (int) ((1 + Math.random() * 4));
                    int altınmiktarı = miktar * 5;
                    String altınmiktar = Integer.toString(altınmiktarı);
                    tahta[satir][sutun].setBackground(java.awt.Color.yellow);
                    tahta[satir][sutun].setText(altınmiktar);
                    tahta[satir][sutun].setAltındeğeri(altınmiktarı);
                }
            }
        }
        for (int satir = 0; satir < tahta.length; satir++) {
            for (int sutun = 0; sutun < tahta[0].length; sutun++) {
                if (tahta[satir][sutun].isGizlialtın()) {
                    int miktar = (int) ((1 + Math.random() * 4));
                    int altınmiktarı = miktar * 5;
                    String altınmiktar = Integer.toString(altınmiktarı);
                    tahta[satir][sutun].setBackground(java.awt.Color.orange);
                    tahta[satir][sutun].setText(altınmiktar);
                    tahta[satir][sutun].setAltındeğeri(altınmiktarı);

                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "DEVAM") {

            if (sırakimde % 4 == 1) {

                if (aoyuncusu.mevcutaltın >= (aoyuncusu.hedefmaliyeti+aoyuncusu.hamlemaliyeti)) {
                    aoyuncusu.hedefBelirleme(tahta, satirsayisi, sutunsayisi);

                    if (aoyuncusu.hedefvarmı == true) {
                        if (tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].isAltın() == false) {
                            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setBackground(java.awt.Color.white);
                            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setText("");
                        } else if (tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].isAltın() == true) {
                            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setBackground(java.awt.Color.yellow);
                            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setText(Integer.toString(tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].getAltındeğeri()));
                        }
                        aoyuncusu.hareket(tahta, satirsayisi, sutunsayisi);
                        aadım++;
                    }
                }

            }
            if (sırakimde % 4 == 2) {

                if (boyuncusu.mevcutaltın >= (boyuncusu.hedefmaliyeti+boyuncusu.hamlemaliyeti)) {
                    boyuncusu.hedefBelirleme(tahta, satirsayisi, sutunsayisi);
                    if (boyuncusu.hedefvarmı == true) {
                        if (tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].isAltın() == false) {
                            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setBackground(java.awt.Color.white);
                            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setText("");
                        } else if (tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].isAltın() == true) {
                            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setBackground(java.awt.Color.yellow);
                            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setText(Integer.toString(tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].getAltındeğeri()));
                        }
                        boyuncusu.hareket(tahta, satirsayisi, sutunsayisi);
                        badım++;
                    }
                }

            }
            if (sırakimde % 4 == 3) {

                if (coyuncusu.mevcutaltın >= (coyuncusu.hedefmaliyeti+coyuncusu.hamlemaliyeti)) {
                    coyuncusu.GizliAltınAcma(tahta, satirsayisi, sutunsayisi);

                    coyuncusu.hedefBelirleme(tahta, satirsayisi, sutunsayisi);

                    if (coyuncusu.hedefvarmı == true) {
                        if (tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].isAltın() == false) {
                            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setBackground(java.awt.Color.white);
                            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setText("");
                        } else if (tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].isAltın() == true) {
                            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setBackground(java.awt.Color.yellow);
                            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setText(Integer.toString(tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].getAltındeğeri()));
                        }
                        coyuncusu.hareket(tahta, satirsayisi, sutunsayisi);
                        cadım++;
                    }
                }

            }
            if (sırakimde % 4 == 0) {
                if (doyuncusu.mevcutaltın >= (doyuncusu.hedefmaliyeti+doyuncusu.hamlemaliyeti)) {
                    doyuncusu.hedefBelirleme(tahta, satirsayisi, sutunsayisi);
                    if (doyuncusu.hedefvarmı == true) {
                        if (tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].isAltın() == false) {
                            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setBackground(java.awt.Color.white);
                            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setText("");
                        } else if (tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].isAltın() == true) {
                            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setBackground(java.awt.Color.yellow);
                            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setText(Integer.toString(tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].getAltındeğeri()));
                        }
                        doyuncusu.hareket(tahta, satirsayisi, sutunsayisi);
                        dadım++;
                    }
                }

            }

            sırakimde++;
            guncelle();

            if ((aoyuncusu.mevcutaltın <= 0 && boyuncusu.mevcutaltın <= 0 && coyuncusu.mevcutaltın <= 0 && doyuncusu.mevcutaltın <= 0) || ((aoyuncusu.hedefvarmı == false))) {
                frame.setVisible(false);
                try {
                    abufferedwriter.close();
                    bbufferedwriter.close();
                    cbufferedwriter.close();
                    dbufferedwriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(AOyuncusu.class.getName()).log(Level.SEVERE, null, ex);
                }

                frame2 = new JFrame();
                int[] sıralamalar = new int[4];
                sonpanel = new JPanel();
                sontablo = new JLabel();
                sontablo.setIcon(img2);
                sonpanel.setBounds(0, 0, 1500, 720);
                frame2.setBounds(0, 0, 1500, 720);
                sıralamalar[0] = (aoyuncusu.mevcutaltın+((aoyuncusu.mevcutaltın - baslangiçaltini) + (aadım * (ahamlemaliyet + ahedefmaliyet))));
                sıralamalar[1] = (boyuncusu.mevcutaltın+((boyuncusu.mevcutaltın - baslangiçaltini) + (badım * (bhamlemaliyet + bhedefmaliyet))));
                sıralamalar[2] = (coyuncusu.mevcutaltın+((coyuncusu.mevcutaltın - baslangiçaltini) + (cadım * (chamlemaliyet + chedefmaliyet))));
                sıralamalar[3] = (doyuncusu.mevcutaltın+((doyuncusu.mevcutaltın - baslangiçaltini) + (dadım * (dhamlemaliyet + dhedefmaliyet))));
                JLabel asıralama = new JLabel("");
                JLabel bsıralama = new JLabel("");
                JLabel csıralama = new JLabel("");
                JLabel dsıralama = new JLabel("");

                for (int i = 0; i < 3; i++) {
                    for (int j = i + 1; j < 4; j++) {
                        if (sıralamalar[j] > sıralamalar[i]) {
                            int temp = sıralamalar[i];
                            sıralamalar[i] = sıralamalar[j];
                            sıralamalar[j] = temp;
                        }
                    }
                }
                for (int m = 0; m < 4; m++) {
                    if (sıralamalar[m] == (aoyuncusu.mevcutaltın+((aoyuncusu.mevcutaltın - baslangiçaltini) + (aadım * (ahamlemaliyet + ahedefmaliyet))))) {
                        asıralama.setText("" + (m + 1));
                        asıralama.setBounds(350, 170, 100, 80);
                        asıralama.setFont(new Font("Serif", Font.PLAIN, 55));
                    }
                }
                for (int m = 0; m < 4; m++) {
                    if (sıralamalar[m] == (boyuncusu.mevcutaltın+((boyuncusu.mevcutaltın - baslangiçaltini) + (badım * (bhamlemaliyet + bhedefmaliyet))))) {
                        bsıralama.setText("" + (m + 1));
                        bsıralama.setBounds(600, 170, 100, 80);
                        bsıralama.setFont(new Font("Serif", Font.PLAIN, 55));
                    }
                }
                for (int m = 0; m < 4; m++) {
                    if (sıralamalar[m] == (coyuncusu.mevcutaltın+((coyuncusu.mevcutaltın - baslangiçaltini) + (cadım * (chamlemaliyet + chedefmaliyet))))) {
                        csıralama.setText("" + (m + 1));
                        csıralama.setBounds(850, 170, 100, 80);
                        csıralama.setFont(new Font("Serif", Font.PLAIN, 55));
                    }
                }
                for (int m = 0; m < 4; m++) {
                    if (sıralamalar[m] == (doyuncusu.mevcutaltın+((doyuncusu.mevcutaltın - baslangiçaltini) + (dadım * (dhamlemaliyet + dhedefmaliyet))))) {
                        dsıralama.setText("" + (m + 1));
                        dsıralama.setBounds(1100, 170, 100, 80);
                        dsıralama.setFont(new Font("Serif", Font.PLAIN, 55));
                    }
                }

                JLabel atoplamadım = new JLabel("" + aadım);
                atoplamadım.setBounds(350, 250, 100, 80);
                atoplamadım.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel aharcananaltın = new JLabel("" + (aadım * (ahamlemaliyet + ahedefmaliyet)));
                aharcananaltın.setBounds(350, 350, 100, 80);
                aharcananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel atoplananaltın = new JLabel("" + ((aoyuncusu.mevcutaltın - baslangiçaltini) + (aadım * (ahamlemaliyet + ahedefmaliyet))));
                atoplananaltın.setBounds(350, 440, 100, 80);
                atoplananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel aoyunsonualtın = new JLabel("" + aoyuncusu.mevcutaltın);
                aoyunsonualtın.setBounds(350, 540, 100, 80);
                aoyunsonualtın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel btoplamadım = new JLabel("" + badım);
                btoplamadım.setBounds(600, 250, 100, 80);
                btoplamadım.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel bharcananaltın = new JLabel("" + (badım * (bhamlemaliyet + bhedefmaliyet)));
                bharcananaltın.setBounds(600, 350, 100, 80);
                bharcananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel btoplananaltın = new JLabel("" + ((boyuncusu.mevcutaltın - baslangiçaltini) + (badım * (bhamlemaliyet + bhedefmaliyet))));
                btoplananaltın.setBounds(600, 440, 100, 80);
                btoplananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel boyunsonualtın = new JLabel("" + boyuncusu.mevcutaltın);
                boyunsonualtın.setBounds(600, 540, 100, 80);
                boyunsonualtın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel ctoplamadım = new JLabel("" + cadım);
                ctoplamadım.setBounds(850, 250, 100, 80);
                ctoplamadım.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel charcananaltın = new JLabel("" + (cadım * (chamlemaliyet + chedefmaliyet)));
                charcananaltın.setBounds(850, 350, 100, 80);
                charcananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel ctoplananaltın = new JLabel("" + ((coyuncusu.mevcutaltın - baslangiçaltini) + (cadım * (chamlemaliyet + chedefmaliyet)) - 15));
                ctoplananaltın.setBounds(850, 440, 100, 80);
                ctoplananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel coyunsonualtın = new JLabel("");
                if (coyuncusu.mevcutaltın >= 0) {
                    coyunsonualtın.setText("" + coyuncusu.mevcutaltın);
                } else {
                    coyunsonualtın.setText("0");
                }
                coyunsonualtın.setBounds(850, 540, 100, 80);
                coyunsonualtın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel dtoplamadım = new JLabel("" + dadım);
                dtoplamadım.setBounds(1100, 250, 100, 80);
                dtoplamadım.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel dharcananaltın = new JLabel("" + (dadım * (dhamlemaliyet + dhedefmaliyet)));
                dharcananaltın.setBounds(1100, 350, 100, 80);
                dharcananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel dtoplananaltın = new JLabel("" + ((doyuncusu.mevcutaltın - baslangiçaltini) + (dadım * (dhamlemaliyet + dhedefmaliyet)) - 20));
                dtoplananaltın.setBounds(1100, 440, 100, 80);
                dtoplananaltın.setFont(new Font("Serif", Font.PLAIN, 55));

                JLabel doyunsonualtın = new JLabel("");
                if (doyuncusu.mevcutaltın >= 0) {
                    doyunsonualtın.setText("" + doyuncusu.mevcutaltın);
                } else {
                    doyunsonualtın.setText("0");
                }
                doyunsonualtın.setBounds(1100, 540, 100, 80);
                doyunsonualtın.setFont(new Font("Serif", Font.PLAIN, 55));

                frame2.add(asıralama);
                frame2.add(bsıralama);
                frame2.add(csıralama);
                frame2.add(dsıralama);

                frame2.add(atoplamadım);
                frame2.add(aharcananaltın);
                frame2.add(atoplananaltın);
                frame2.add(aoyunsonualtın);

                frame2.add(btoplamadım);
                frame2.add(bharcananaltın);
                frame2.add(btoplananaltın);
                frame2.add(boyunsonualtın);

                frame2.add(ctoplamadım);
                frame2.add(charcananaltın);
                frame2.add(ctoplananaltın);
                frame2.add(coyunsonualtın);

                frame2.add(dtoplamadım);
                frame2.add(dharcananaltın);
                frame2.add(dtoplananaltın);
                frame2.add(doyunsonualtın);

                frame2.add(sonpanel);
                sonpanel.add(sontablo);
                sonpanel.setVisible(true);
                frame2.setVisible(true);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        }

    }

    void guncelle() {
        if (aoyuncusu.mevcutaltın > 0) {
            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setText("A-" + aoyuncusu.mevcutaltın);
            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setBackground(java.awt.Color.magenta);
            if (sırakimde % 4 == 1) {
                try {
                    abufferedwriter.write("A oyuncusu " + aoyuncusu.yataykonum + "," + aoyuncusu.dikeykonum + " konumundadır. Mevcut altın: " + aoyuncusu.mevcutaltın);
                    abufferedwriter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(AOyuncusu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setText("A-0");
            tahta[aoyuncusu.yataykonum][aoyuncusu.dikeykonum].setBackground(java.awt.Color.magenta);
        }
        if (boyuncusu.mevcutaltın > 0) {
            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setText("B-" + boyuncusu.mevcutaltın);
            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setBackground(java.awt.Color.green);
            if (sırakimde % 4 == 2) {
                try {
                    bbufferedwriter.write("B oyuncusu " + boyuncusu.yataykonum + "," + boyuncusu.dikeykonum + " konumundadır. Mevcut altın: " + boyuncusu.mevcutaltın);
                    bbufferedwriter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(AOyuncusu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setText("B-0");
            tahta[boyuncusu.yataykonum][boyuncusu.dikeykonum].setBackground(java.awt.Color.green);

        }
        if (coyuncusu.mevcutaltın > 0) {
            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setBackground(java.awt.Color.red);
            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setText("C-" + coyuncusu.mevcutaltın);
            if (sırakimde % 4 == 3) {
                try {
                    cbufferedwriter.write("C oyuncusu " + coyuncusu.yataykonum + "," + coyuncusu.dikeykonum + " konumundadır. Mevcut altın: " + coyuncusu.mevcutaltın);
                    cbufferedwriter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(AOyuncusu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setBackground(java.awt.Color.red);
            tahta[coyuncusu.yataykonum][coyuncusu.dikeykonum].setText("C-0");

        }
        if (doyuncusu.mevcutaltın > 0) {
            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setBackground(java.awt.Color.cyan);
            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setText("D-" + doyuncusu.mevcutaltın);
            if(sırakimde%4==1){try {
                    dbufferedwriter.write("D oyuncusu " + doyuncusu.yataykonum + "," + doyuncusu.dikeykonum + " konumundadır. Mevcut altın: " + doyuncusu.mevcutaltın);
                    dbufferedwriter.newLine();
                } catch (IOException ex) {
                    Logger.getLogger(AOyuncusu.class.getName()).log(Level.SEVERE, null, ex);
                }}
        } else {
            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setBackground(java.awt.Color.cyan);
            tahta[doyuncusu.yataykonum][doyuncusu.dikeykonum].setText("D-0");

        }

    }

}
