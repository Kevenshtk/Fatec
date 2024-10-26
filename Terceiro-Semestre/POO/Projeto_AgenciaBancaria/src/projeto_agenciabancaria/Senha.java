package projeto_agenciabancaria;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Senha {
    private String idSenha;
    private String senhaCriptografia;

    public Senha(String idSenha, String senha) {
        this.idSenha = idSenha;
        this.senhaCriptografia = criptografia(senha);
    }
    
    public String criptografia(String senha){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //
            byte[] hash = md.digest(senha.getBytes()); // Armazena o tamanho da da senha
            StringBuilder hexString = new StringBuilder(); // Construindo uma String
            
            for(byte b: hash){
                hexString.append(String.format("%02x", b)); // converter um matrinz em hexadecimal
            }
            
            return hexString.toString();
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void redefinirSenha(String novaSenha){
        this.senhaCriptografia = criptografia(novaSenha);
        System.out.println("Senha redefinida com sucesso.\n");
    }
}
