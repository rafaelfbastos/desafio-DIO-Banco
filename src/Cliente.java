public class Cliente {

    private String nome;
    private String endereco;
    private double renda;
    private String telefone;
    private String senha;


    private String cpf;

    public Cliente(String nome, String endereco, double renda, String telefone, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.renda = renda;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf(){
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
