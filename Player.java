package javaapplication1;
public abstract class Oyuncu {

    int yataykonum, dikeykonum;
    int hedefsatir, hedefsutun;
    int hedefmaliyeti, hamlemaliyeti;
    int mevcutaltın;
    int hareketpuanı;
    boolean hedefvarmı;

    public Oyuncu(int satir, int sutun, int baslangicaltını, int hedefmaliyet, int hamlemaliyet,int hareketpuanı)  {
        yataykonum = satir;
        dikeykonum = sutun;
        mevcutaltın = baslangicaltını;
        this.hedefmaliyeti = hedefmaliyet;
        this.hamlemaliyeti = hamlemaliyet;
        this.hareketpuanı = hareketpuanı;
        hedefvarmı = false;

    }
    abstract void hedefBelirleme(Btn[][] oyunpaneli,int satirsayisi,int sutunsayisi);
    abstract void hareket(Btn[][] oyunpaneli,int satirsayisi,int sutunsayisi);
    abstract void GizliAltınAcma(Btn[][] oyunpaneli,int satirsayisi,int sutunsayisi);
    abstract void HamleÖngörme(int a , int b);
   
}
