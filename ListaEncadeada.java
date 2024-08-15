
package listaencadeada;
import java.util.Scanner;
/**
 *
 * @author andrey
 */



public class ListaEncadeada {

    private Node Lista;
    public ListaEncadeada(){
        this.Lista = null;
    }

    //Inserindo elementos
    public void inserir (int informacao){
        //Declarando nosso novo nó
        Node no = new Node();

        no.setInformacao(informacao);
        if(Lista == null){
            Lista=no;
        }
        else{
           //Aqui se cria um apontador para a lista.
        Node atual =Lista;
        while(atual.getProximo()!=null){
            atual = atual.getProximo();
        }
        atual.setProximo(no);
        }
    }


    //Imprimindo elementos 
    public void imprime(){
        Node atual = Lista;
    while (atual != null) {
            System.out.print(atual.getInformacao()+ " -> ");
            atual= atual.getProximo();
        }
        System.out.println("Acabou");


    }
    //removendo elementos
    public void remove(int index){
        Node anterior = Lista;
        Node atual = anterior.getProximo();
        int position = 1;
        boolean find = false;
        do {
            if (position == index) {
                if (index != 0) {
                    if (atual.getProximo() != null) {
                        anterior.setProximo(atual.getProximo());
                        find = true;
                    } else if (atual.getProximo() == null) {
                        anterior.setProximo(null);
                        find = true;
                    }
                }

            }
            if (index == 0){
                Lista = atual;
                find = true;
            }

            position++;
            if (!find) {
                anterior = atual;

                atual = atual.getProximo();
            }
        } while (!find);
    }

    public static void showOpcoes(){
        System.out.print("[1] - Iserir \n[2] - Excluir \n[0] - Pare \n>>> ");
    }



    public static int choose(int minimo, int maximo){
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        try{
            do {
                opcao = scanner.nextInt();
            } while (opcao < minimo && opcao>maximo);

            return opcao;
        } catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }



    private static void selectedOption(int choose, ListaEncadeada lista){
        int item = 0;
        Scanner scanner = new Scanner(System.in);
        if (choose == 1) {
            System.out.print("Digite um numero para inserir \n>>> ");
        } else {
            lista.imprime();
            System.out.print("Digite o indice para remover \n>>>");
        }

        switch (choose){
            case 1:
                item = scanner.nextInt();
                lista.inserir(item);
                break;
            case 2:
                item = scanner.nextInt();
                lista.remove(item);
                break;

        }
    }

    public boolean chooseOption(ListaEncadeada lista){
        int choose = choose(0,2);
        switch (choose){
            case 0:
                return sair();
            case 1:
                selectedOption(choose,lista);
                return true;
            case 2:
                selectedOption(choose,lista);
                return true;
        }
        return true;
    }

    public static boolean sair(){
        return false;
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        boolean keepAssking= true;

        System.out.println("Digite os itens da lista (digite '0' para parar):");
        do {
            lista.showOpcoes();
            keepAssking= lista.chooseOption(lista);
        } while (keepAssking);
        System.out.println("Lista Encadeada:");
        lista.imprime();



    }

}
