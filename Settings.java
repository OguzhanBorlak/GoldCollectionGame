package javaapplication1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GirişEkranı extends JPanel implements ActionListener {

    JLabel tahtaboyutsor = new JLabel("AYARLAR");
    JLabel satirsor = new JLabel("Satır sayısı = ");
    JLabel sutunsor = new JLabel("Sütun sayısı = ");
    JLabel baslangıcaltınısor = new JLabel("Başlangıç Altını = ");
    JLabel hareketmesafesisor = new JLabel("Hareket Mesafesi = ");
    JLabel ahedefmaliyetsor = new JLabel("A'nın Hedef Maliyeti = ");
    JLabel ahamlemaliyetsor = new JLabel("A'nın Hamle Maliyeti = ");
    JLabel bhedefmaliyetsor = new JLabel("B'nın Hedef Maliyeti = ");
    JLabel bhamlemaliyetsor = new JLabel("B'nın Hamle Maliyeti =");
    JLabel chedefmaliyetsor = new JLabel("C'nin Hedef Maliyeti = ");
    JLabel chamlemaliyetsor = new JLabel("C'nin Hamle Maliyeti = ");
    JLabel dhedefmaliyetsor = new JLabel("D'nin Hedef Maliyeti = ");
    JLabel dhamlemaliyetsor = new JLabel("D'nin Hamle Maliyeti = ");

    JButton oyunagecis = new JButton("OYNA");
    JTextField satir = new JTextField();
    JTextField sutun = new JTextField();
    JTextField altınmiktarı = new JTextField();
    JTextField hareketmesafeleri = new JTextField();
    JTextField anınhedefmaliyeti = new JTextField();
    JTextField anınhamlemaliyeti = new JTextField();
    JTextField bninhedefmaliyeti = new JTextField();
    JTextField bninhamlemaliyeti = new JTextField();
    JTextField cninhedefmaliyeti = new JTextField();
    JTextField cninhamlemaliyeti = new JTextField();
    JTextField dninhedefmaliyeti = new JTextField();
    JTextField dninhamlemaliyeti = new JTextField();
    ImageIcon img1 = new ImageIcon(new ImageIcon("H:\\masaüstü\\yazlab\\background.jpg").getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH));
    JLabel arkaplan;
    JPanel ayarlar;
    JButton ayarlaragir, ayarkaydet;

    JFrame pencere = new JFrame();
    int a;
    int b;
    int baslangiçaltini, hareketmesafesi, ahedefmaliyet, ahamlemaliyet, bhedefmaliyet, bhamlemaliyet;
    int chedefmaliyet, chamlemaliyet;
    int dhedefmaliyet, dhamlemaliyet;

    public GirişEkranı(JFrame pencere) {
        this.pencere = pencere;
        oyunagecis.setBounds(775, 500, 150, 75);
        oyunagecis.setBackground(Color.white);
        oyunagecis.setFont(new Font("Snap ITC", Font.PLAIN, 30));
        ayarlaragir = new JButton("AYARLAR");

        ayarlaragir.setBounds(960, 500, 250, 75);
        ayarlaragir.setFont(new Font("Snap ITC", Font.PLAIN, 30));
        ayarlaragir.setBackground(Color.white);

        pencere.add(ayarlaragir);
        ayarlaragir.addActionListener(this);

        arkaplan = new JLabel();
        arkaplan.setIcon(img1);

        tahtaboyutsor.setBounds(1450, 45, 300, 75);
        tahtaboyutsor.setFont(new Font("Snap ITC", Font.PLAIN, 30));
        tahtaboyutsor.setVisible(false);

        sutunsor.setBounds(1300, 125, 125, 50);
        sutunsor.setBackground(Color.red);
        sutunsor.setFont(new Font("Serif", Font.PLAIN, 20));
        sutunsor.setForeground(Color.white);
        sutunsor.setOpaque(true);
        sutunsor.setBackground(Color.black);
        sutunsor.setVisible(false);

        satirsor.setBounds(1300, 185, 125, 50);
        satirsor.setForeground(Color.white);
        satirsor.setFont(new Font("Serif", Font.PLAIN, 20));
        satirsor.setOpaque(true);
        satirsor.setBackground(Color.black);
        satirsor.setVisible(false);

        baslangıcaltınısor.setBounds(1300, 245, 125, 50);
        baslangıcaltınısor.setForeground(Color.white);
        baslangıcaltınısor.setFont(new Font("Serif", Font.PLAIN, 15));
        baslangıcaltınısor.setOpaque(true);
        baslangıcaltınısor.setBackground(Color.black);
        baslangıcaltınısor.setVisible(false);

        hareketmesafesisor.setBounds(1300, 305, 125, 50);
        hareketmesafesisor.setForeground(Color.white);
        hareketmesafesisor.setFont(new Font("Serif", Font.PLAIN, 15));
        hareketmesafesisor.setOpaque(true);
        hareketmesafesisor.setBackground(Color.black);
        hareketmesafesisor.setVisible(false);

        ahedefmaliyetsor.setBounds(1300, 365, 125, 50);
        ahedefmaliyetsor.setForeground(Color.white);
        ahedefmaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        ahedefmaliyetsor.setOpaque(true);
        ahedefmaliyetsor.setBackground(Color.black);
        ahedefmaliyetsor.setVisible(false);

        ahamlemaliyetsor.setBounds(1300, 425, 125, 50);
        ahamlemaliyetsor.setForeground(Color.white);
        ahamlemaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        ahamlemaliyetsor.setOpaque(true);
        ahamlemaliyetsor.setBackground(Color.black);
        ahamlemaliyetsor.setVisible(false);

        bhedefmaliyetsor.setBounds(1600, 125, 125, 50);
        bhedefmaliyetsor.setForeground(Color.white);
        bhedefmaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        bhedefmaliyetsor.setOpaque(true);
        bhedefmaliyetsor.setBackground(Color.black);
        bhedefmaliyetsor.setVisible(false);

        bhamlemaliyetsor.setBounds(1600, 185, 125, 50);
        bhamlemaliyetsor.setForeground(Color.white);
        bhamlemaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        bhamlemaliyetsor.setOpaque(true);
        bhamlemaliyetsor.setBackground(Color.black);
        bhamlemaliyetsor.setVisible(false);

        chedefmaliyetsor.setBounds(1600, 245, 125, 50);
        chedefmaliyetsor.setForeground(Color.white);
        chedefmaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        chedefmaliyetsor.setOpaque(true);
        chedefmaliyetsor.setBackground(Color.black);
        chedefmaliyetsor.setVisible(false);

        chamlemaliyetsor.setBounds(1600, 305, 125, 50);
        chamlemaliyetsor.setForeground(Color.white);
        chamlemaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        chamlemaliyetsor.setOpaque(true);
        chamlemaliyetsor.setBackground(Color.black);
        chamlemaliyetsor.setVisible(false);

        dhedefmaliyetsor.setBounds(1600, 365, 125, 50);
        dhedefmaliyetsor.setForeground(Color.white);
        dhedefmaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        dhedefmaliyetsor.setOpaque(true);
        dhedefmaliyetsor.setBackground(Color.black);
        dhedefmaliyetsor.setVisible(false);

        dhamlemaliyetsor.setBounds(1600, 425, 125, 50);
        dhamlemaliyetsor.setForeground(Color.white);
        dhamlemaliyetsor.setFont(new Font("Serif", Font.PLAIN, 13));
        dhamlemaliyetsor.setOpaque(true);
        dhamlemaliyetsor.setBackground(Color.black);
        dhamlemaliyetsor.setVisible(false);

        sutun.setBounds(1450, 135, 50, 30);
        sutun.setText("20");
        sutun.setVisible(false);

        satir.setBounds(1450, 195, 50, 30);
        satir.setText("20");
        satir.setVisible(false);

        altınmiktarı.setBounds(1450, 255, 50, 30);
        altınmiktarı.setText("200");
        altınmiktarı.setVisible(false);

        hareketmesafeleri.setBounds(1450, 315, 50, 30);
        hareketmesafeleri.setText("3");
        hareketmesafeleri.setVisible(false);

        anınhedefmaliyeti.setBounds(1450, 375, 50, 30);
        anınhedefmaliyeti.setText("5");
        anınhedefmaliyeti.setVisible(false);

        anınhamlemaliyeti.setBounds(1450, 435, 50, 30);
        anınhamlemaliyeti.setText("5");
        anınhamlemaliyeti.setVisible(false);

        bninhedefmaliyeti.setBounds(1750, 135, 50, 30);
        bninhedefmaliyeti.setText("10");
        bninhedefmaliyeti.setVisible(false);

        bninhamlemaliyeti.setBounds(1750, 195, 50, 30);
        bninhamlemaliyeti.setText("5");
        bninhamlemaliyeti.setVisible(false);

        cninhedefmaliyeti.setBounds(1750, 255, 50, 30);
        cninhedefmaliyeti.setText("15");
        cninhedefmaliyeti.setVisible(false);

        cninhamlemaliyeti.setBounds(1750, 315, 50, 30);
        cninhamlemaliyeti.setText("5");
        cninhamlemaliyeti.setVisible(false);

        dninhedefmaliyeti.setBounds(1750, 375, 50, 30);
        dninhedefmaliyeti.setText("20");
        dninhedefmaliyeti.setVisible(false);

        dninhamlemaliyeti.setBounds(1750, 435, 50, 30);
        dninhamlemaliyeti.setText("5");
        dninhamlemaliyeti.setVisible(false);

        satir.addActionListener(this);
        sutun.addActionListener(this);
        altınmiktarı.addActionListener(this);
        hareketmesafeleri.addActionListener(this);
        anınhedefmaliyeti.addActionListener(this);
        anınhamlemaliyeti.addActionListener(this);
        bninhedefmaliyeti.addActionListener(this);
        bninhamlemaliyeti.addActionListener(this);
        cninhedefmaliyeti.addActionListener(this);
        cninhamlemaliyeti.addActionListener(this);
        dninhedefmaliyeti.addActionListener(this);
        dninhamlemaliyeti.addActionListener(this);

        oyunagecis.addActionListener(this);

        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pencere.add(tahtaboyutsor);
        pencere.add(satir);
        pencere.add(sutun);
        pencere.add(sutunsor);
        pencere.add(satirsor);
        pencere.add(baslangıcaltınısor);
        pencere.add(hareketmesafesisor);
        pencere.add(ahedefmaliyetsor);
        pencere.add(ahamlemaliyetsor);
        pencere.add(bhedefmaliyetsor);
        pencere.add(bhamlemaliyetsor);
        pencere.add(chedefmaliyetsor);
        pencere.add(chamlemaliyetsor);
        pencere.add(dhedefmaliyetsor);
        pencere.add(dhamlemaliyetsor);

        pencere.add(altınmiktarı);
        pencere.add(hareketmesafeleri);
        pencere.add(anınhedefmaliyeti);
        pencere.add(anınhamlemaliyeti);
        pencere.add(bninhedefmaliyeti);
        pencere.add(bninhamlemaliyeti);
        pencere.add(cninhedefmaliyeti);
        pencere.add(cninhamlemaliyeti);
        pencere.add(dninhedefmaliyeti);
        pencere.add(dninhamlemaliyeti);

        pencere.add(oyunagecis);
        pencere.setSize(1920, 1080);
        pencere.add(this);
        pencere.add(arkaplan);

        pencere.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "AYARLAR") {
            tahtaboyutsor.setVisible(true);
            satirsor.setVisible(true);
            sutunsor.setVisible(true);
            baslangıcaltınısor.setVisible(true);
            hareketmesafesisor.setVisible(true);
            ahedefmaliyetsor.setVisible(true);
            ahamlemaliyetsor.setVisible(true);
            bhamlemaliyetsor.setVisible(true);
            bhedefmaliyetsor.setVisible(true);
            chamlemaliyetsor.setVisible(true);
            chedefmaliyetsor.setVisible(true);
            dhamlemaliyetsor.setVisible(true);
            dhedefmaliyetsor.setVisible(true);
            sutun.setVisible(true);
            satir.setVisible(true);
            altınmiktarı.setVisible(true);
            hareketmesafeleri.setVisible(true);
            anınhedefmaliyeti.setVisible(true);
            anınhamlemaliyeti.setVisible(true);
            bninhedefmaliyeti.setVisible(true);
            bninhamlemaliyeti.setVisible(true);
            cninhedefmaliyeti.setVisible(true);
            cninhamlemaliyeti.setVisible(true);
            dninhedefmaliyeti.setVisible(true);
            dninhamlemaliyeti.setVisible(true);
        }

        if (e.getActionCommand() == "OYNA") {

            try {
                a = Integer.parseInt(satir.getText());
                b = Integer.parseInt(sutun.getText());
                baslangiçaltini = Integer.parseInt(altınmiktarı.getText());
                hareketmesafesi = Integer.parseInt(hareketmesafeleri.getText());
                ahedefmaliyet = Integer.parseInt(anınhedefmaliyeti.getText());
                ahamlemaliyet = Integer.parseInt(anınhamlemaliyeti.getText());
                bhedefmaliyet = Integer.parseInt(bninhedefmaliyeti.getText());
                bhamlemaliyet = Integer.parseInt(bninhamlemaliyeti.getText());
                chedefmaliyet = Integer.parseInt(cninhedefmaliyeti.getText());
                chamlemaliyet = Integer.parseInt(cninhamlemaliyeti.getText());
                dhedefmaliyet = Integer.parseInt(dninhedefmaliyeti.getText());
                dhamlemaliyet = Integer.parseInt(dninhamlemaliyeti.getText());
                pencere.setVisible(false);
                AltınToplama tutma = new AltınToplama(pencere, a, b, baslangiçaltini, hareketmesafesi, ahedefmaliyet, ahamlemaliyet, bhedefmaliyet, bhamlemaliyet, chedefmaliyet, chamlemaliyet, dhedefmaliyet, dhamlemaliyet);
            } catch (IOException ex) {
                Logger.getLogger(GirişEkranı.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
