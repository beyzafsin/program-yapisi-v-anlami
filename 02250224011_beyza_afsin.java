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
            char[] harfler=satir.toCharArray();
            boolean etiketIcinde=false;
            String etiket="";

            for(int i=0;i<harfler.lenght;i++){
                char c=harfler[i];

                if(c=='<'){
                    etiketIcinde=true;
                    etiket="";
                }else if(c=='>'){
                    etiketIcinde=false;

                    if(etiket.length()>0){
                        System.out.println("bulunan etiket: " + etiket);

                        if(pencere==null){
                            pencere= new JFrame("web sayfasi");
                            pencere.setSize(400,500);
                            pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                            panel= new JPanel();

                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                            pencere.add(panel);

                        }
                    }
                    else if(etiket.charAt(0)=='/'){

                    }

                    else if(etiket.startsWith("h1") || etiket.startsWith("h2") || etiket.startsWith("h3") || etiket.startsWith("h4")|| etiket.startsWith("h5")|| etiket.startsWith("h6")){
                        if(panel!=null){
                            JLabel baslik= new JLabel("baslik metni ("+etiket+")");
                            panel.add(baslik);
                        }
                    }
                    else if(etiket.startsWith("button")){
                        
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
