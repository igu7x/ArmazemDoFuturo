import java.util.Scanner;

public class ArmazemDoFuturo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //variáveis do sistema de login
        String usuarioCorreto = "vendedor";
        String senhaCorreta = "12345";
        
        //variáveis do sistema de cadastro de produtos
        String[] nomesProdutos = new String[10];
        double[] precosProdutos = new double[10];
        int numProdutos = 0; // controlar o número de produtos cadastrados

        //login
        System.out.print("Digite o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        //verificação do login
        if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
            System.out.println("Login realizado com sucesso!");
            
            //menu de opções
            int opcao;
            do {
                System.out.println("\n--- Bem vindo ao Armazém do Futuro! ---");
                System.out.println("1. Cadastrar Produto");
                System.out.println("2. Listar Produtos");
                System.out.println("3. Alterar Preço de Produto");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); //limpar o buffer do teclado

                //acoes de acordo com a opção escolhida
                if (opcao == 1) {
                    //cadastrar produto
                    if (numProdutos < 10) {
                        System.out.print("Digite o nome do produto: ");
                        nomesProdutos[numProdutos] = scanner.nextLine();
                        System.out.print("Digite o preço do produto (usando vírgula para valores não inteiros): ");
                        precosProdutos[numProdutos] = scanner.nextDouble();
                        numProdutos++; //aumentar o contador de produtos
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de produtos cadastrados atingido.");
                    }
                } else if (opcao == 2) {
                    //listar produtos
                    if (numProdutos == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        System.out.println("\nLista de Produtos:");
                        for (int i = 0; i < numProdutos; i++) {
                            System.out.println((i + 1) + ". " + nomesProdutos[i] + " | Preço: R$ " + precosProdutos[i]);
                        }
                    }
                } else if (opcao == 3) {
                    //alterar preço de um produto
                    if (numProdutos == 0) {
                        System.out.println("Nenhum produto cadastrado para alterar.");
                    } else {
                        System.out.println("Escolha o número do produto para alterar o preço:");
                        for (int i = 0; i < numProdutos; i++) {
                            System.out.println((i + 1) + ". " + nomesProdutos[i]);
                        }
                        int escolha = scanner.nextInt();
                        if (escolha > 0 && escolha <= numProdutos) {
                            System.out.print("Digite o novo preço para " + nomesProdutos[escolha - 1] + ": ");
                            precosProdutos[escolha - 1] = scanner.nextDouble();
                            System.out.println("Preço atualizado com sucesso!");
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                } else if (opcao == 4) {
                    //sair do sistema
                    System.out.println("Saindo do sistema...");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 4);
        } else {
            System.out.println("Nome de usuário ou senha inválidos.");
        }

    }
}
