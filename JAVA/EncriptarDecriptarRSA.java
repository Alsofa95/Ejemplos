/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptardecriptarrsa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

/**
 *
 * @author DanielMoreno
 */
public class EncriptarDecriptarRSA {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
         

//Ahora generamos una pareja de claves RSA de 1024 bits
        KeyPairGenerator generador_clave_asimetrica=KeyPairGenerator.getInstance("RSA");
        generador_clave_asimetrica.initialize(1024);
        KeyPair par_claves = generador_clave_asimetrica.genKeyPair();
        System.out.println("Generada clave asimetrica");

//Creamos el cifrador        
        Cipher cifrador=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cifrador.init(Cipher.ENCRYPT_MODE,par_claves.getPublic());  
        
        
        //-----------------------------------------//
        String carpeta="D://CICLOS/Ficheros/";
        String documento=carpeta+"imagen.png";
        //-----------------------------------------//
        byte[] buffer = new byte[1000];
        byte[] bufferCifrado;
       
        FileInputStream in=new FileInputStream(documento);
        FileOutputStream out=new FileOutputStream(carpeta+"ImagenCifrada.png");
        
        
        int bytesLeidos = in.read(buffer,0,1000);
        
        while(bytesLeidos!=-1){
            bufferCifrado = cifrador.update(buffer, 0, bytesLeidos);
            out.write(bufferCifrado);
            bytesLeidos =in.read(buffer, 0, 1000);
        }
        bufferCifrado = cifrador.doFinal();
        out.write(bufferCifrado);
        in.close();
        
         
        cifrador.init(Cipher.DECRYPT_MODE,par_claves.getPublic());
        
      
        String imagenCifrado="ImagenCifrada.png";
        
        in=new FileInputStream(carpeta+imagenCifrado);
        out=new FileOutputStream(carpeta+"imagenFinal.png");
        
        bytesLeidos = in.read(buffer,0,1000);
        
        while(bytesLeidos!=-1){
            bufferCifrado = cifrador.update(buffer, 0, bytesLeidos);
            out.write(bufferCifrado);
            bytesLeidos =in.read(buffer, 0, 1000);
        }
        bufferCifrado = cifrador.doFinal();
        out.write(bufferCifrado);
        in.close();
 
    }
}
