public interface ContaInterface {

    public void sacar(double valor);

    public void transferir(double valor, int nConta, int operacao);

    public void depositar(double valor);

    public void mostrarSaldo();
}
