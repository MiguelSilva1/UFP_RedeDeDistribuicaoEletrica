package projeto;

import java.io.Serializable;
import projeto.imports.Date;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class HistoricoUtilizacao implements Serializable {

    private int idHistoricoUtilizacao;
    private Date dataLigado;
    private Date dataDesligado;
    private int equipamentoDomesticoAQuePertence;

    /**
     * @return the idHistoricoUtilizacao
     */
    public int getIdHistoricoUtilizacao() {
        return idHistoricoUtilizacao;
    }

    /**
     * @param idHistoricoUtilizacao the idHistoricoUtilizacao to set
     */
    public void setIdHistoricoUtilizacao(int idHistoricoUtilizacao) {
        this.idHistoricoUtilizacao = idHistoricoUtilizacao;
    }

    /**
     * @return the dataLigado
     */
    public Date getDataLigado() {
        return dataLigado;
    }

    /**
     * @param dataLigado the dataLigado to set
     */
    public void setDataLigado(Date dataLigado) {
        this.dataLigado = dataLigado;
    }

    /**
     * @return the dataDesligado
     */
    public Date getDataDesligado() {
        return dataDesligado;
    }

    /**
     * @param dataDesligado the dataDesligado to set
     */
    public void setDataDesligado(Date dataDesligado) {
        this.dataDesligado = dataDesligado;
    }

    /**
     * @return the equipamentoDomesticoAQuePertence
     */
    public int getEquipamentoDomesticoAQuePertence() {
        return equipamentoDomesticoAQuePertence;
    }

    /**
     * @param equipamentoDomesticoAQuePertence the
     * equipamentoDomesticoAQuePertence to set
     */
    public void setEquipamentoDomesticoAQuePertence(int equipamentoDomesticoAQuePertence) {
        this.equipamentoDomesticoAQuePertence = equipamentoDomesticoAQuePertence;
    }

    public HistoricoUtilizacao() {
    }

    /**
     * Construtor Historico Utilização
     *
     * @param idHistoricoUtilizacao
     * @param dataLigado
     * @param dataDesligado
     * @param equipamentoDomesticoAQuePertence
     */
    public HistoricoUtilizacao(int idHistoricoUtilizacao, Date dataLigado, Date dataDesligado, int equipamentoDomesticoAQuePertence) {
        this.idHistoricoUtilizacao = idHistoricoUtilizacao;
        this.dataLigado = dataLigado;
        this.dataDesligado = dataDesligado;
        this.equipamentoDomesticoAQuePertence = equipamentoDomesticoAQuePertence;
    }

    @Override
    public String toString() {
        return "Ligado: " + dataLigado.getYear()
                + "/" + dataLigado.getMonth()
                + "/" + dataLigado.getDay()
                + " - " + dataLigado.getHour()
                + ":" + dataLigado.getMinute()
                + ":" + dataLigado.getSecond()
                + "\nDesligado: " + dataDesligado.getYear() 
                + "/" + dataDesligado.getMonth()
                + "/" + dataDesligado.getDay()
                + " - " + dataDesligado.getHour()
                + ":" + dataDesligado.getMinute()
                + ":" + dataDesligado.getSecond();
    }
    
    
}
