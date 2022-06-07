import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static Banco instance;
    private static List<ContaCorrente> contaCorrentes;
    private static List<ContaPoupanca> contaPoupancas;

    public static Banco getInstance(){

        if(instance==null); instance = new Banco();gerarContas();

        return instance;
    }

    public static void gerarContas(){
        contaCorrentes = new ArrayList<>();
        contaPoupancas = new ArrayList<>();
    }

    public static void novaContaCorrente(Cliente cliente){
        ContaCorrente nova = new ContaCorrente(contaCorrentes.size()+1,cliente);
        contaCorrentes.add(nova);

    }

    public static void novaContaPoupanca(Cliente cliente){
        ContaPoupanca nova = new ContaPoupanca(contaPoupancas.size()+1,cliente);
        contaPoupancas.add(nova);

    }

    public static ContaCorrente getContaCorrente(int numero){
        return contaCorrentes.get(numero - 1);
    }
    public static ContaPoupanca getContaPoupanca(int numero){
        return contaPoupancas.get(numero - 1);
    }

    public static List<ContaCorrente> getContasCorrentes(){
        return contaCorrentes;
    }
    public static List<ContaPoupanca> getContasPoupancas(){
        return contaPoupancas;
    }
}
