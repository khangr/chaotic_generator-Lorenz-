package kaotik;

public class Lorenz {

    public Lorenz() {
    }
    
    public static String run(double x0, double y0, double z0, int iterasyon)
    {
        double sigma = 10.0;
        double r = 28.0;
        double b = 8 / 3;
        double h = 0.01;
        
        double x1 = 0; 
        double y1 = 0; 
        double z1 = 0;
        
        int i;
        int l;
        
        String str1;
        String str2;
        String str3;
        
        String str1t = "";
        String str2t = "";
        String str3t = "";
        
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        
        int p = 0;
        
        int ps = 0;
        int pt = 0;
        int pk = 0;
        int iz;
        
        int[] a = new int[16];
        String binary = "";
        
        for(int asd = 0; asd < iterasyon;asd++)
        {
            x1 = x0 + h * (-sigma * x0 + sigma * y0);
            y1 = y0 + h * (-x0 * z0 + r * x0 - y0);
            z1 = z0 + h * (x0 * y0 - b * z0);
            
            x0 = x1;
            y0 = y1;
            z0 = z1;
        }
         
        //*****************************************************************
            
        str1 = String.valueOf(x1); 
        l = str1.length()-1;
        for(;l < 20;l++) str1 += "0";
            
        char[] chr1 = str1.toCharArray();
        for(l = 0;chr1[l] != '.';l++);
        for(int z = 0;z < 10;l++, z++);
        str1t += chr1[l];
        str1t += chr1[l+1];
        str1t += chr1[l+2];
            
        //*****************************************************************
            
        str2 = String.valueOf(y1);
        l = str2.length()-1;
        for(;l < 20;l++) str2 += "0";
        char[] chr2 = str2.toCharArray();
        for(l = 0;chr2[l] != '.';l++);
        for(int z = 0;z < 10;l++, z++);
        str2t += chr2[l];
        str2t += chr2[l+1];
        str2t += chr2[l+2];
                        
        //*****************************************************************

        str3 = String.valueOf(z1);
        l = str3.length()-1;
        for(;l < 20;l++) str3 += "0";   
        char[] chr3 = str3.toCharArray();
        for(l = 0;chr3[l] != '.';l++);
        for(int z = 0;z < 10;l++, z++);
        str3t += chr3[l];
        str3t += chr3[l+1];
        str3t += chr3[l+2];            
            
        //*****************************************************************
            
        p1 = Double.parseDouble(str1t);
        p2 = Double.parseDouble(str2t);
        p3 = Double.parseDouble(str3t);
            
        p = ((int) (p1 + p2 + p3)) % 256;
                        
        for(l = p;l > 0;l = l / 2) binary = "" + (l % 2) + binary;
        for(l = binary.length();l < 8;l++) binary = "0" + binary;
        
        return binary;
    }
    
}
