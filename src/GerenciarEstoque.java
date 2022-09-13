import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    public List<Estoque> lista = new ArrayList<>();
    public static void main(String[] args) {
        GerenciarEstoque gc = new GerenciarEstoque();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do{
            opc = construirMenu(gc, sc);
        } while(opc!=9);
    }

    private static int construirMenu(GerenciarEstoque gc, Scanner sc) {
        int opc;
        System.out.println("\nMenu");
        System.out.println("1. Cadastrar Produtos");
        System.out.println("2. Entrada de Produto");
        System.out.println("3. Saida de Produto");
        System.out.println("4. Estoque atual da Loja");
        System.out.println("5. Visualizar Lucros");
        System.out.println("9. Sair");
        System.out.print("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());

        switch(opc){
            case 1:
                gc.execCadastrar(sc);
                break;
            case 2:
                gc.execEntrada(sc);
                break;
            case 3:
                gc.execSaida(sc);
                break;
            case 4:
                gc.execMostrarEstoque();
                break;
            case 5:
                gc.execMostrarLucro();
                break;
            case 9:
                System.out.println("FIM!");
                break;
            default:
                System.out.println("Opção invalida!");
        }
        return opc;
    }

    public void execCadastrar(Scanner sc){
        //Cadastra uma nova e coloca na lista de contas
        Estoque est = new Estoque();
        System.out.print("Digite o id: ");
        est.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Digite a descricao do Produto: ");
        est.setDescricao(sc.nextLine());
        System.out.print("Digite a qtde estoque: ");
        est.setEstoque(Integer.parseInt(sc.nextLine()));
        System.out.print("Digite o preco unitario: ");
        est.setValor(Double.parseDouble(sc.nextLine()));
        est.setLucro(0.0);
        lista.add(est);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void execEntrada(Scanner sc){
        System.out.print("Digite o id do produto a ser reabastecido: ");
        int proc = Integer.parseInt(sc.nextLine());
        Estoque est = null;
        for(Estoque e : lista){
            if(e.getId()==proc){
                est = e;
                break;
            }
        }
        if(est!=null){
            System.out.print("Digite a quantidade para fazer reposicao: ");
            boolean ok = est.repor(Integer.parseInt(sc.nextLine()));
            if(ok){
                System.out.println("Produtos reabastecido!");
            } else{
                System.out.println("A quantidade precisa ser maior do que 0!");
            }
        } else{
            System.out.println("Produto não encontrado!");
        }

    }

    public void execSaida(Scanner sc){
        System.out.print("Digite o id do produto para realizar a saida: ");
        int proc = Integer.parseInt(sc.nextLine());
        Estoque est = null;
        for(Estoque e : lista){
            if(e.getId()==proc){
                est = e;
                break;
            }
        }
        if(est!=null){
            System.out.print("Digite a quantidade a ser retirada: ");
            int qtde = Integer.parseInt(sc.nextLine());
            boolean ok = est.retirar(qtde);
            if(ok){
                gerarLucro(proc,qtde);
                System.out.println("Produtos retirados com sucesso!");
            } else{
                System.out.println("Estoque insuficiente!");
            }
        } else{
            System.out.println("Produto não encontrado!");
        }
    }

    public void execMostrarEstoque(){
        for(Estoque e : lista){
            System.out.println(e);
        }
    }

    public void execMostrarLucro(){
        for(Estoque e : lista){
            System.out.println(e.getDescricao() + " - " + e.getLucro());
        }
    }

    public void gerarLucro(int id, int quantidade){
        for(Estoque e : lista){
            if(e.getId()==id){
                e.setLucro(e.getValor() * quantidade);
                break;
            }
        }
    }
}