/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.mvictor.service.validate;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author manoel
 */
public class Validade {
    
    private static Validade instancia;
    
    private Validade(){}
    
    public static synchronized  Validade getInstancia()
    {
        if(instancia == null)
        {
            instancia = new Validade();
        }
        return instancia;
    }
    
    /**
     * @param campo - string 
     * @return isEmpty(campo) - Verifica se o campo está vázio.
     */
    public boolean isEmpty(String campo)
    {
        return campo.isEmpty();
    }
  
    /**
    *
    * @param campo
    * @return
    */
    public boolean isEmpty(JTextField campo)
    {
        return campo.getText().isEmpty();
    }
    
    /**
    *
    * @param campo - string
    * @return isNull(campo) - verifica se o campo está nulo.
    */
    public boolean isNull(String campo)
    {
        return campo == null;
    }
    
    public boolean isNull(JTextField campo)
    {
        return campo.getText() == null;
    }
    
    public boolean isNull(JFormattedTextField campo)
    {
        return campo.getValue() == null;
    }
    
    public boolean valueInvalid(JSpinner  campo)
    {
       int numero = Integer.parseInt(campo.getValue().toString());
       return (numero == 0);
    }
    
    
    
    
}
