package projeto;

import java.io.Serializable;
import projeto.imports.GraphNode;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class ProdutorEnergia extends GraphNode implements Serializable {

    private String tipoProdutorEnergia;
    private float potenciaProduzida;

    /**
     * @return the idProdutorEnergia
     */
    public int getIdProdutorEnergia() {
        return super.getId();
    }

    /**
     * @return the tipoProdutorEnergia
     */
    public String getTipoProdutorEnergia() {
        return tipoProdutorEnergia;
    }

    /**
     * @param tipoProdutorEnergia the tipoProdutorEnergia to set
     */
    public void setTipoProdutorEnergia(String tipoProdutorEnergia) {
        this.tipoProdutorEnergia = tipoProdutorEnergia;
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

    public ProdutorEnergia() {
    }

    /**
     * Quando insere um produtor energia manualmente, incrementar o ID
     * automaticamente
     *
     * @param tipoProdutorEnergia
     * @param potenciaProduzida
     */
    public ProdutorEnergia(String tipoProdutorEnergia, float potenciaProduzida) {
        super();
        this.tipoProdutorEnergia = tipoProdutorEnergia;
        this.potenciaProduzida = potenciaProduzida;
    }

    /**
     * Quando lê de um ficheiro, preencher o ID
     *
     * @param idProdutorEnergia
     * @param tipoProdutorEnergia
     * @param potenciaProduzida
     */
    ProdutorEnergia(int idProdutorEnergia, String tipoProdutorEnergia, float potenciaProduzida) {
        super();
        this.tipoProdutorEnergia = tipoProdutorEnergia;
        this.potenciaProduzida = potenciaProduzida;
    }

    @Override
    public String toString() {
        return "Produtor Energia " + getIdProdutorEnergia() + ":\n" 
                + "Tipo produtor energia = " + tipoProdutorEnergia
                + ",\n Potencia Produzida = " + potenciaProduzida;
    }
}
