package aliffe.service;

import aliffe.Venda;

/**
 *
 * @author
 */
public class AdicionarVenda implements EstrategiaVenda {

    public Venda venda;

    @Override
    public void executa(Venda venda) {
        /**
         * Aqui poderiamos adicionar recursos de persistência de dados etc...
         */
        this.venda = venda;
    }

    public Venda getVenda() {
        return venda;
    }

}
