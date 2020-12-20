package aliffe.service;

import aliffe.Venda;

/**
 *
 * @author
 */
public class EstrategiaVendaContexto {

    public EstrategiaVenda estrategiaVenda;

    public EstrategiaVenda getEstrategiaVenda() {
        return estrategiaVenda;
    }

    public void setEstrategia(EstrategiaVenda estrategiaVenda) {
        this.estrategiaVenda = estrategiaVenda;
    }

    public void executaEstrategia(Venda venda) {
        estrategiaVenda.executa(venda);
    }

}
