import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GravarJson {

    private List<ContaCorrente> contaCorrentes;
    private List<ContaPoupanca> contaPoupancas;

    public void gravar(List<ContaCorrente> contaCorrentes, List<ContaPoupanca> contaPoupancas) {
        this.contaCorrentes = contaCorrentes;
        this.contaPoupancas = contaPoupancas;
        JSONArray listaJsonCorrentes = new JSONArray();
        JSONArray listaJsonPoupancas = new JSONArray();

        for (ContaCorrente conta : contaCorrentes) {

            JSONObject contaJson = new JSONObject();
            JSONObject cliente = new JSONObject();

            contaJson.put("agencia", 1);
            contaJson.put("numero", conta.getNumero());
            contaJson.put("saldo", conta.getSaldo());
            contaJson.put("limite", conta.getLimite());
            contaJson.put("limite utilizado", conta.getLimiteUtilizado());

            cliente.put("nome",conta.getCliente().getNome());
            cliente.put("endereco",conta.getCliente().getEndereco());
            cliente.put("renda",conta.getCliente().getRenda());
            cliente.put("telefone",conta.getCliente().getTelefone());
            cliente.put("cpf",conta.getCliente().getCpf());
            cliente.put("senha",conta.getCliente().getSenha());

            contaJson.put("cliente", cliente);


            listaJsonCorrentes.add(contaJson);
        }

        for (ContaPoupanca conta : contaPoupancas) {

            JSONObject contaJson = new JSONObject();
            JSONObject cliente = new JSONObject();

            contaJson.put("agencia", 1);
            contaJson.put("numero", conta.getNumero());
            contaJson.put("saldo", conta.getSaldo());

            cliente.put("nome",conta.getCliente().getNome());
            cliente.put("endereco",conta.getCliente().getEndereco());
            cliente.put("renda",conta.getCliente().getRenda());
            cliente.put("telefone",conta.getCliente().getTelefone());
            cliente.put("cpf",conta.getCliente().getCpf());
            cliente.put("senha",conta.getCliente().getSenha());

            contaJson.put("cliente", cliente);


            listaJsonPoupancas.add(contaJson);
        }

        try (FileWriter writer = new FileWriter("contasCorrentes.json")) {
            writer.write(listaJsonCorrentes.toJSONString());

        } catch (IOException e) {
            System.err.print("Erro ao gravar arquivo");
        }
        try (FileWriter writer = new FileWriter("contasPoupacas.json")) {
            writer.write(listaJsonPoupancas.toJSONString());

        } catch (IOException e) {
            System.err.print("Erro ao gravar arquivo");
        }
    }

}
