package aliffe.web;

import aliffe.Venda;
import aliffe.service.AdicionarVenda;
import aliffe.service.EstrategiaVendaContexto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author
 */
public class Inicial extends WebPage implements Serializable {

    final private WebMarkupContainer tabela = new WebMarkupContainer("tabela");
    private List<Venda> vendas = new ArrayList();

    public Inicial() {
        
        adicionaTabela();

        AjaxLink botaoAdicionar = new AjaxLink("botao-adicionar") {
            @Override
            public void onClick(AjaxRequestTarget target) {

                /**
                 * Aqui poderiamos inserir os dados a partir de um formulário,
                 * porém simplificamos para não extender o projeto. O objetivo é
                 * aplicar o conceito.
                 */
                Venda venda = new Venda();

                EstrategiaVendaContexto contexto = new EstrategiaVendaContexto();
                AdicionarVenda adicionar = new AdicionarVenda();
                contexto.setEstrategia(adicionar);
                contexto.executaEstrategia(venda);
                atualizaTabela(adicionar.getVenda());
                target.add(tabela);

            }

        };
        botaoAdicionar.setMarkupId("botao-adicionar");
        botaoAdicionar.setOutputMarkupId(true);
        add(botaoAdicionar);

    }

    private void atualizaTabela(Venda venda) {
        vendas.add(venda);
    }
    
    
      private void adicionaTabela() {

        IDataProvider dataProvider = new IDataProvider<Venda>() {
            @Override
            public Iterator<? extends Venda> iterator(long first, long count) {
                return vendas.subList((int) first, (int) (first + count)).iterator();
            }

            @Override
            public long size() {
                return vendas.size();
            }

            @Override
            public IModel model(final Venda object) {
                return new LoadableDetachableModel() {
                    @Override
                    protected Venda load() {
                        return (Venda) object;
                    }
                };
            }

            @Override
            public void detach() {
            }
        };

        DataView dataView = new DataView<Venda>("linhas", dataProvider) {
            @Override
            protected void populateItem(Item<Venda> item) {
                Venda v = (Venda) item.getModelObject();
              
               // item.add(new Label());              
               
               

               
            }
        };

        tabela.setOutputMarkupId(true);
        tabela.add(dataView);
        add(tabela);
    }

}
