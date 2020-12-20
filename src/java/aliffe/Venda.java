package aliffe;

import java.io.Serializable;

/**
 *
 * @author
 */
public class Venda implements Serializable {

    private Integer id;
    private Integer funcionario;
    private Integer regiao;
    //private LocalDateTime trimestre; 
    private String trimestre; //Por convenção, vamos usar String ao invés de LocalDateTime;

    public Venda() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getRegiao() {
        return regiao;
    }

    public void setRegiao(Integer regiao) {
        this.regiao = regiao;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }
}
