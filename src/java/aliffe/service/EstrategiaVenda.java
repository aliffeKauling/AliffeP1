package aliffe.service;

import aliffe.Venda;

/**
 *
 * @author
 */
public interface EstrategiaVenda {

    //Aqui a estratégia pode ser criação de uma nova venda, atualização ou remoção...depende do contexto. 
    public void executa(Venda venda);

}
