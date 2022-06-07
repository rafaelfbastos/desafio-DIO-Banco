public class Conta implements ContaInterface{

    private final int agencia=1;
    private int numero;
    private Cliente cliente;
    protected double saldo;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        saldo = 0;
    }

    @Override
    public void sacar(double valor) {

        if(valor<=saldo){
            saldo-=valor;
            System.out.println("\nR$ "+valor+"sacado com sucesso.\nSaldo atual: R$ "+saldo);
            System.out.println("\n");
        }
        else{
            System.out.println("\nSaldo insuficiente");
            System.out.println("\n");
        }

    }

    @Override
    public void transferir(double valor, int nConta, int operacao) {
        if(operacao==1){
            try {
                ContaCorrente destino = Banco.getContaCorrente(nConta);
                if(saldo>=valor){
                    saldo-=valor;
                    destino.saldo+=valor;
                    System.out.println("\nR$ "+valor+" Transferido com sucesso para: "+destino.getCliente().getNome()+"\nSaldo atual: R$ "+saldo);
                    System.out.println("\n");

                }
            }catch (IndexOutOfBoundsException E){
                System.out.println("\nConta destino não encontrada");
                System.out.println("\n");
            }
        }
        if(operacao==2){
            try {
                ContaPoupanca destino = Banco.getContaPoupanca(nConta);
                if(saldo>=valor){
                    saldo-=valor;
                    destino.saldo+=valor;
                    System.out.println("\nR$ "+valor+" Transferido com sucesso para: "+destino.getCliente().getNome()+"\nSaldo atual: R$ "+saldo);
                    System.out.println("\n");

                }
            }catch (IndexOutOfBoundsException E){
                System.out.println("\nConta destino não encontrada");
                System.out.println("\n");
            }
        }
    }

    @Override
    public void depositar(double valor) {
        saldo+=valor;
        System.out.println("\nR$ "+valor+" depositado com sucesso.\nSaldo atual: R$ "+saldo);
        System.out.println("\n");


    }

    @Override
    public void mostrarSaldo() {
        System.out.println("\nSaldo da Conta: R$ "+saldo);
        System.out.println("\n");

    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumero(){
        return numero;
    }


}
