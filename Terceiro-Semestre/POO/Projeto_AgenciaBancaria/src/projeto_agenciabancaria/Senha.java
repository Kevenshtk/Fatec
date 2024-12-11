package projeto_agenciabancaria;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Senha {
    private int idSenha;
    //private String senhaCriptografia;
    private String hashSenha;

    public Senha(int idSenha, String senha) {
        this.idSenha = idSenha;
        //this.senhaCriptografia = criptografia(senha);
        this.hashSenha = criptografia(senha);
    }
    
    public String criptografia(String senha){
        try{
            //MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest md = MessageDigest.getInstance("MD5");
            //byte[] hash = md.digest(senha.getBytes()); // Armazena o tamanho da da senha
            byte[] bytes = md.digest();
            StringBuilder hexString = new StringBuilder(); // Construindo uma String
            
            for(byte b: bytes){
                hexString.append(String.format("%02x", b)); // converter um matrinz em hexadecimal
            }
            
            return hexString.toString();
            
        } catch(NoSuchAlgorithmException e) {
            /*e.printStackTrace();
            return null;*/
            throw new RuntimeException(e);
        }
    }
    
    //public void redefinirSenha(String novaSenha){
    public boolean validarSenha(String novaSenha){
        //this.hashSenha = criptografia(novaSenha);
        //System.out.println("Senha redefinida com sucesso.");
        String hashNovaSenha= criptografia(novaSenha);
        return hashNovaSenha.equals(hashSenha);
    }
    
    public String redefinirSenha(String novasenha, boolean validaSenha){
        if (validaSenha){
            this.hashSenha = criptografia(novasenha);
            return "Senha redefinida com sucesso: "+novasenha;
        }else{
            return "Senha igual a anterior";
        }
    }

    public int getIdSenha() {
        return idSenha;
    }

    public void setIdSenha(int idSenha) {
        this.idSenha = idSenha;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }
    
    
}
