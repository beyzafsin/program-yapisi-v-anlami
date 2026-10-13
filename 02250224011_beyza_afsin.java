import java.io.*;
import javax.swing.*;

class beyza_afsin {
    public static void main(String[] args){
        String path="ornek.html";

        JFrame pencere=null;
        JPanel panel=null;

    try{
        BufferedReader oku= new BufferedReader(new FileReader(path));
        String satir;

        while((satir= oku.readLine())!=null) {
            int ilktag=satir.indexOf("<");
            int sontag=satir.indexOf(">");

            if(ilktag!=-1 && sontag!=-1){
                String etiket=satir.substring(ilktag +1,sontag);
                System.out.println("etiket bulundu: "+ etiket);

                if(etiket.equalsIgnoreCase("!DOCTYPE html") || etiket.equalsIgnoreCase("html")){
                    if(pencere==null){
                        pencere=new JFrame("web sayfasi");
                        pencere.setSize(400,400);
                        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        panel=new JPanel();
                        pencere.add(panel);

                        pencere.setVisible(true);
                        System.out.println("pencere olusturuldu");

                    }
                }

                else if(etiket.toLowerCase().startsWith("label")){
                    if(panel!=null){
                        JLabel etiketYazi=new JLabel("sabit metin");
                        panel.add(etiketYazi);
                    }
                }
                else if(etiket.toLowerCase().startsWith("input") || etiket.toLowerCase().startsWith("textfield")){
                    if(panel!=null){
                        JTextField metinKutusu=new JTextField(15);
                        panel.add(metinKutusu);
                    }
                }
            }
        }

        if(pencere!=null){
            pencere.setVisible(true);
        }

        oku.close();

    }catch (Exception e){
        System.out.println("hata var");
    }
  }
    
}
