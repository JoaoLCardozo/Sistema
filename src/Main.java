import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Cliente.Cliente;
import Cliente.ClienteDAO;
import DataBase.ConnectionFactory;
import Endereco.Endereco;
import Endereco.EnderecoDAO;
import Produto.Mercadoria;
import Produto.MercadoriaDAO;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Criação do Remetente
        Cliente remetente = new Cliente();
        System.out.print("Nome ou razão social do remetente: ");
        remetente.setNomeRazao(sc.nextLine().trim());
        System.out.print("Documento do remetente (CPF/CNPJ): ");
        remetente.setDocumento(sc.nextLine().trim());
        System.out.print("Tipo de documento do remetente (CPF/CNPJ): ");
        remetente.setTpDocumento(sc.nextLine().trim());

        
//chamar dao... e cadastrar
        
       

        //Criação do Destinatário
        Cliente destinatario = new Cliente();
        System.out.print("Nome ou razão social do destinatário: ");
        destinatario.setNomeRazao(sc.nextLine().trim());
        System.out.print("Documento do destinatário (CPF/CNPJ): ");
        destinatario.setDocumento(sc.nextLine().trim());
        System.out.print("Tipo de documento do destinatário (CPF/CNPJ): ");
        destinatario.setTpDocumento(sc.nextLine().trim());

        //Criação do endereço de envio
        Endereco endEnvio = new Endereco();
        System.out.println("\n-- Endereço de envio --");
        System.out.print("Rua: ");
        endEnvio.setRua(sc.nextLine().trim());
        System.out.print("Número: ");
        endEnvio.setNumero(sc.nextLine().trim());
        System.out.print("CEP: ");
        endEnvio.setCep(sc.nextLine().trim());
        System.out.print("Bairro: ");
        endEnvio.setBairro(sc.nextLine().trim());
        System.out.print("Cidade: ");
        endEnvio.setCidade(sc.nextLine().trim());
        System.out.print("Complemento: ");
        endEnvio.setComplemento(sc.nextLine().trim());
        System.out.print("UF: ");
        endEnvio.setUf(sc.nextLine().trim());

        //Criação do endereço de recebimento
        Endereco endEntrega = new Endereco();
        System.out.println("\n-- Endereço de entrega --");
        System.out.print("Rua: ");
        endEntrega.setRua(sc.nextLine().trim());
        System.out.print("Número: ");
        endEntrega.setNumero(sc.nextLine().trim());
        System.out.print("CEP: ");
        endEntrega.setCep(sc.nextLine().trim());
        System.out.print("Bairro: ");
        endEntrega.setBairro(sc.nextLine().trim());
        System.out.print("Cidade: ");
        endEntrega.setCidade(sc.nextLine().trim());
        System.out.print("Complemento: ");
        endEntrega.setComplemento(sc.nextLine().trim());
        System.out.print("UF: ");
        endEntrega.setUf(sc.nextLine().trim());

        //Criação de produtos via entrada do usuário
        ArrayList<Mercadoria> listaDeProdutos = new ArrayList<>();
        System.out.print("\nQuantos produtos deseja registrar? ");
        int qtdProdutos = 0;
        try {
            qtdProdutos = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, definindo 0 produtos.");
        }

        for (int i = 0; i < qtdProdutos; i++) {
            System.out.println("\n-- Produto " + (i+1) + " --");
            Mercadoria p = new Mercadoria();
            System.out.print("Nome: ");
            p.setNome(sc.nextLine().trim());
            System.out.print("Peso (kg) (use ponto para decimal): ");
            try { p.setPeso(Double.parseDouble(sc.nextLine().trim())); } catch (Exception ex) { p.setPeso(0); }
            System.out.print("Preço (R$) (use ponto para decimal): ");
            try { p.setPreco(Double.parseDouble(sc.nextLine().trim())); } catch (Exception ex) { p.setPreco(0); }
            System.out.print("Quantidade: ");
            try { p.setQuantidade(Integer.parseInt(sc.nextLine().trim())); } catch (Exception ex) { p.setQuantidade(1); }
            System.out.print("Volume (m3) (use ponto para decimal): ");
            try { p.setVolume(Double.parseDouble(sc.nextLine().trim())); } catch (Exception ex) { p.setVolume(0); }
            listaDeProdutos.add(p);
        }

        //Validações dos produtos
        for (Mercadoria prod : listaDeProdutos) {
            if (prod.getPreco() <= 0) {
                System.out.println("Erro: o produto cadastrado precisa ter preço.");
                sc.close();
                return;
            }
            if (prod.getPeso() <= 0) {
                System.out.println("Erro: o peso do produto não pode ser igual a 0.");
                sc.close();
                return;
            }
            if (prod.getNome() == null || prod.getNome().isEmpty()) {
                System.out.println("Erro: o nome do produto é inválido.");
                sc.close();
                return;
            }
        }

        //Printar
        System.out.println("Dados do Remetente: ");
        System.out.println("Nome ou Razão Social: " + remetente.getNomeRazao());
        System.out.println("Cnpj/CPF: " + remetente.getDocumento());
        System.out.println("Tipo de documento: " + remetente.getTpDocumento());
        System.out.println("------------------------------------------------");
        System.out.println("Dados do Destinatario: ");
        System.out.println("Nome ou razão Social: " + destinatario.getNomeRazao());
        System.out.println("Cnpj/CPF: " + destinatario.getDocumento());
        System.out.println("Tipo de documento: " + destinatario.getTpDocumento());
        System.out.println("------------------------------------------------");
        System.out.println("Endereço de envio ");
        System.out.println("Rua: " + endEnvio.getRua());
        System.out.println("Numero: " + endEnvio.getNumero());
        System.out.println("Cep: " + endEnvio.getCep());
        System.out.println("Bairro: " + endEnvio.getBairro());
        System.out.println("Cidade: " + endEnvio.getCidade());
        System.out.println("Complemento: " + endEnvio.getComplemento());
        System.out.println("UF: " + endEnvio.getUf());
        System.out.println("------------------------------------------------");
        System.out.println("Endereço de recebimento ");
        System.out.println("Rua: "+ endEntrega.getRua());
        System.out.println("Numero: " + endEntrega.getNumero());
        System.out.println("Cep: " + endEntrega.getCep());
        System.out.println("Bairro: " + endEntrega.getBairro());
        System.out.println("Cidade: " + endEntrega.getCidade());
        System.out.println("Complemento: " + endEntrega.getComplemento());
        System.out.println("UF: " + endEntrega.getUf());
        System.out.println("------------------------------------------------");

        //Calcular o valor total: 
        double valorTotalMercadoria = 0.0;

        System.out.println("Dados dos produtos: ");
        
        // Somar o valor de todos os produtos na lista listaDeProdutos
        for (Mercadoria produto : listaDeProdutos) {
            double subtotal = produto.getPreco() * produto.getQuantidade();
            valorTotalMercadoria += subtotal;
            
            System.out.printf("- %s: %d un. x R$ %.2f = R$ %.2f\n",produto.getNome(), produto.getQuantidade(),produto.getPreco(),subtotal);
        }
        
        System.out.println("------------------------------------------------");
        // Printa o resultado final

        System.out.printf("VALOR TOTAL DA MERCADORIA: R$ %.2f\n", valorTotalMercadoria);
                 
        remetente.setEndereco(endEnvio);
        destinatario.setEndereco(endEntrega);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        int idEnderecoRemetente = enderecoDAO.salvarEndereco(endEnvio);
        int idEnderecoDestinatario = enderecoDAO.salvarEndereco(endEntrega);
        remetente.getEndereco().setIdEndereco (idEnderecoRemetente);
        destinatario.getEndereco().setIdEndereco(idEnderecoDestinatario);

        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.salvarCliente(remetente);
        clienteDAO.salvarCliente(destinatario);

        MercadoriaDAO mercadoriaDAO = new MercadoriaDAO();
        int idProduto = 0;
        for (Mercadoria produto : listaDeProdutos) {
            idProduto = mercadoriaDAO.salvarMercadoria(produto);
            produto.setIdProduto(idProduto);
        }
        EntregaDAO entre

        
        sc.close();
    }
}
