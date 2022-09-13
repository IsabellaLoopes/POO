public class Estoque {
    private int id;
    private String descricao;
    private Double valor;
    private int estoque;
    private Double lucro;

    public Double getLucro(){
        return lucro;
    }

    public void setLucro(Double lucro){
        this.lucro = lucro;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Id: " + id + "\nProduto: " + descricao + "\nValor: " + valor + "\nQtde disponivel: " + estoque + "\n";
    }

    public boolean retirar(int quantidade){
        if(quantidade<=estoque){
            estoque -=valor;
            return true;
        }
        return false;
    }

    public boolean repor(int quantidade){
        if(quantidade>0){
            estoque += quantidade;
            return true;
        }
        return false;
    }
}
