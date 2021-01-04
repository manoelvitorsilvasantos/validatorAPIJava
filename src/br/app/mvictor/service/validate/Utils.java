package br.app.mvictor.service.validate;

import br.app.mvictor.service.constantes.C;

/**
 *
 * @author manoel
 */
public class Utils implements C{
    
   private static Utils instancia;
   private Utils()
   {
   }
   
   public static synchronized Utils getIstancia()
   {
        if(instancia == null)
        {
            instancia = new Utils();
        }
        return instancia;
   }
   
   public String onlyCPF(String cpf)
   {
       return cpf.replaceAll("[^0-9]", "");
   }
   
   public String onlyStrings(String texto)
   {
       return texto.replaceAll("[^0-9]", "");
   }
   
   public String cpfValid(String cpf)
   {
       //variaveis
       
       int dig10, dig11;
       int primeiroVerificador, segundoVerificador;
       int somatoria = 0;
       String meuCpf = this.onlyCPF(cpf);
       
       for(int i = 0; i < C.listaA.length; i++)
       {
           int valor = Character.getNumericValue(meuCpf.charAt(i));
           somatoria += valor*C.listaA[i];
       }
       
       dig10 = somatoria%11;
       primeiroVerificador = 11-dig10;
       if(primeiroVerificador >= 10)
       {
           primeiroVerificador = 0;
       }
       
       somatoria = 0;
       for(int i = 0; i < C.listaB.length; i++)
       {
           int valor = Character.getNumericValue(meuCpf.charAt(i));
           somatoria += valor*C.listaB[i];
       }
       
       dig11 = somatoria%11;
       segundoVerificador = 11-dig11;
       if(segundoVerificador >= 10)
       {
           segundoVerificador = 0;
       }
       
       StringBuilder vetor = new StringBuilder(meuCpf);
       char d10 = Integer.toString(primeiroVerificador).charAt(0);
       char d11 = Integer.toString(segundoVerificador).charAt(0);
       vetor.setCharAt(9, d10);
       vetor.setCharAt(10, d11);
       
       return vetor.toString();
   }
   
   public boolean isInvalidDate(String data)
   {
       boolean estado = false;
       if(data.equals("00/00/0000"))
           return true;
       return estado;
   }
   
   public int isInvalidData(String data)
   {
       return data.compareTo("31/12/1900");
   }
   
    
}