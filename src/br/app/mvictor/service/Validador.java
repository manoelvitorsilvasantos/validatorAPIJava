/**
 * @author Manoel Vitor Pau Ferro
 * @version 1.0
 * @since 2018-01-01
 */
package br.app.mvictor.service;

/**
 *
 * @author manoel
 */
public class Validador {
    private static Validador instancia;
    
    private Validador(){}
    
    /**
     * @return retorn intancia da classe.
     */
    public static synchronized Validador getInstancia()
    {
        if(instancia == null)
        {
            instancia = new Validador();
        }
        return instancia;
    }
    
    /**
     * Esta função verifica se o campos está vázio.
     * @param campo
     * @return isEmpty(String campo)
     */
    public boolean isEmpty(String campo)
    {
        return campo.isEmpty();
    }
    
    /**
     *  Esta função verifica se o campo está nulo.
     * @param campo
     * @return isNull(String campo)
     */
    public boolean isNull(String campo)
    {
        return campo == null;
    }
    
    /**
     * Esta função verifica se o CPF e igual a esses valores.
     * @param  cpf
     * @return cpfNotPermited(cpf)
     */
    public boolean cpfNotPermited(String cpf)
    {
        return cpf.equals("000.000.000-00") || 
                cpf.equals("111.111.111-11")||
                cpf.equals("222.222.222-22")||
                cpf.equals("333.333.333-33")||
                cpf.equals("444.444.444-44")||
                cpf.equals("555.555.555-55")||
                cpf.equals("666.666.666-66")||
                cpf.equals("777.777.777-77")||
                cpf.equals("888.888.888-88")||
                cpf.equals("999.999.999-99");
    }
    
    public boolean cpfIsValid(String cpf)
    {
        return cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
    }
    
    /**
     *
     * @param rg
     * @return
     */
    public boolean rgIsValid(String rg)
    {
        return rg.matches("[0-9]{2}.[0-9]{3}.[0-9]{3}-[0-9]{1}");
    }
    
    public boolean dateIsValid(String data)
    {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
    
    public boolean emailIsValid(String email)
    {
        return email.matches("^[a-z || A-Z ||._ || 0-9]+@[a-z || A-Z]{3,10}.[a-z]{3}");
    }
    
}
