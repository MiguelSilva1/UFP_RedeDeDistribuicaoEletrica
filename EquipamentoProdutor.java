package projeto;

import java.io.Serializable;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class EquipamentoProdutor implements Serializable {

    private int idEquipamentoProdutor;
    private String tipoEquipamentoProdutor;
    private float potenciaProduzida;
    private int casaAQuePertence;

    /**
     * @return the idEquipamentoProdutor
     */
    public int getIdEquipamentoProdutor() {
        return idEquipamentoProdutor;
    }

    /**
     * @param idEquipamentoProdutor the idEquipamentoProdutor to set
     */
    public void setIdEquipamentoProdutor(int idEquipamentoProdutor) {
        this.idEquipamentoProdutor = idEquipamentoProdutor;
    }

    /**
     * @return the tipoEquipamentoProdutor
     */
    public String getTipoEquipamentoProdutor() {
        return tipoEquipamentoProdutor;
    }

    /**
     * @param tipoEquipamentoProdutor the tipoEquipamentoProdutor to set
     */
    public void setTipoEquipamentoProdutor(String tipoEquipamentoProdutor) {
        this.tipoEquipamentoProdutor = tipoEquipamentoProdutor;
    }

    /**
     * @return the potenciaProduzida
     */
    public float getPotenciaProduzida() {
        return potenciaProduzida;
    }

    /**
     * @param potenciaProduzida the potenciaProduzida to set
     */
    public void setPotenciaProduzida(float potenciaProduzida) {
        this.potenciaProduzida = potenciaProduzida;
    }

    /**
     * @return the casaAQuePertence
     */
    public int getCasaAQuePertence() {
        return casaAQuePertence;
    }

    /**
     * @param casaAQuePertence the casaAQuePertence to set
     */
    public void setCasaAQuePertence(int casaAQuePertence) {
        this.casaAQuePertence = casaAQuePertence;
    }

    public EquipamentoProdutor() {
    }

    /**
     * Construtor Equipamento Produtor
     *
     * @param idEquipamentoProdutor
     * @param tipoEquipamentoProdutor
     * @param potenciaProduzida
     * @param casaAQuePertence
     */
    public EquipamentoProdutor(int idEquipamentoProdutor, String tipoEquipamentoProdutor, float potenciaProduzida, int casaAQuePertence) {
        this.idEquipamentoProdutor = idEquipamentoProdutor;
        this.tipoEquipamentoProdutor = tipoEquipamentoProdutor;
        this.potenciaProduzida = potenciaProduzida;
        this.casaAQuePertence = casaAQuePertence;
    }

    @Override
    public String toString() {
        return "Equipamento Produtor " + getIdEquipamentoProdutor() + ":\n" 
                + "Tipo equipamento produtor = " + tipoEquipamentoProdutor
                + ",\n Potencia Produzida = " + potenciaProduzida
                + ",\n Id casa a que pertence = " + casaAQuePertence;
    }
}
