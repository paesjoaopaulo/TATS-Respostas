
public class Proposta {

    float total;
    int qtParcelas;
    float valorParcela;

    public Proposta() {
    }

    public Proposta(float total, int numeroParcelas) {
        this.total = total;
        this.qtParcelas = numeroParcelas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getNumeroParcelas() {
        return qtParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.qtParcelas = numeroParcelas;
    }

    public float getValorParcela() {
        return total / qtParcelas;
    }

    public void setValorParcela(float valorParcela) {
        this.valorParcela = valorParcela;
    }

}
