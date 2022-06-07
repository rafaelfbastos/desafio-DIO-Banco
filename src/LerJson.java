import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LerJson {


    LerJson(JSONArray contasCorrentes, JSONArray contasPoupancas){

        contasCorrentes.forEach(obj->lerJsonCC((JSONObject) obj));
        contasPoupancas.forEach(obj->lerJsonCP((JSONObject) obj));

    }

    public void lerJsonCC(JSONObject object){

        JSONObject cliente = (JSONObject) object.get("cliente");
        String nome  = cliente.get("nome").toString();
        String endereco = cliente.get("endereco").toString();
        String telefone = cliente.get("telefone").toString();
        Double renda = Double.parseDouble(cliente.get("renda").toString());
        String cpf = cliente.get("cpf").toString();
        String senha = cliente.get("senha").toString();

        Cliente novo = new Cliente(nome,endereco,renda,telefone,cpf,senha);

        int numero = Integer.parseInt(object.get("numero").toString());
        double saldo = Double.parseDouble(object.get("saldo").toString());
        double limite = Double.parseDouble(object.get("limite").toString());
        double limiteUtilizado = Double.parseDouble(object.get("limite utilizado").toString());

        Banco.novaContaCorrente(novo);


        Banco.getContaCorrente(numero).setSaldo(saldo);
        Banco.getContaCorrente(numero).setLimite(limite);
        Banco.getContaCorrente(numero).setLimiteUtilizado(limiteUtilizado);

    }

    public void lerJsonCP(JSONObject object){

        JSONObject cliente = (JSONObject) object.get("cliente");
        String nome  = cliente.get("nome").toString();
        String endereco = cliente.get("endereco").toString();
        String telefone = cliente.get("telefone").toString();
        String cpf = cliente.get("cpf").toString();
        Double renda = Double.parseDouble(cliente.get("renda").toString());
        String senha = cliente.get("senha").toString();

        Cliente novo = new Cliente(nome,endereco,renda,telefone,cpf,senha);

        int numero = Integer.parseInt(object.get("numero").toString());
        double saldo = Double.parseDouble(object.get("saldo").toString());

        Banco.novaContaCorrente(novo);

        Banco.getContaCorrente(numero).setSaldo(saldo);

    }
}
